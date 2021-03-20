package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Method;
import java.util.function.Consumer;

public abstract class CommonGenerator extends StubGenerators {

    protected final Builder _cfg;
    protected final ClassName _className;
    protected final String _simpleName;
    protected final TypeSpec.Builder _class;
    protected final MethodSpec.Builder _constructor = MethodSpec.constructorBuilder();

    // instance fields
    protected String FINAL_SELF = "_self";
    protected static final String SELF = "self()";
    protected static final String STATIC_VTABLE = "$vtable";

    protected VirtualMethodsBuilder _virtualMethodHandles;

    protected CommonGenerator(Builder config, String prefix, String suffix) {
        _simpleName = prefix + config.baseName + suffix;
        _cfg = config;
        _className = ClassName.get(config.packageName, _simpleName);
        _class = TypeSpec
                .classBuilder(_simpleName)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL);
        _virtualMethodHandles = new VirtualMethodsBuilder(config, _className, STATIC_VTABLE);
    }

    public void addInterfaces() {
        for (ClassName iface : _cfg.interfaces) {
            _class.addSuperinterface(iface);
        }
    }

    @Override
    public void build(Consumer<JavaFile> spec) {
        addInterfaces();
        addConstructors();
        addVirtualMethods();
        addDefaultMethods();
        addObjectMethods();
        addGettersSetters();
        finish();

        TypeSpec vtable = _virtualMethodHandles.build();
        if (vtable != null) {
            _class.addType(vtable);
        }

        TypeSpec typeSpec = _class.build();
        JavaFile javaFile = JavaFile.builder(_cfg.packageName, typeSpec).build();

        spec.accept(javaFile);
    }

    protected abstract void addConstructors();

    protected void addField(FieldSpec.Builder field) {
        _class.addField(field.build());
    }

    protected void addMethod(MethodSpec.Builder method) {
        _class.addMethod(method.build());
    }

    protected void finish() {
        finishConstructor();
    }

    protected void finishConstructor() {
        _class.addMethod(_constructor.build());
    }

    protected void addVirtualMethods() {
        if (_cfg.linkedVtableClass == null || _cfg.linkedVtableName == null || _cfg.linkedVtableName.isEmpty()) {
            return;
        }
        addVTable();
        scanVirtualMethods();
    }

    protected abstract void addVTable();

    protected void scanVirtualMethods() {
        for (Class<?> virtualMethodInterface : _cfg.linkedVtableClass.getDeclaredClasses()) {
            if (virtualMethodInterface.isInterface()) {
                Method[] methods = virtualMethodInterface.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.getName().equals("apply")) {
                        addVirtualMethod(virtualMethodInterface, method, prettyName(virtualMethodInterface));
                    }
                }
            }
        }
    }

    protected void addVirtualMethod(Class<?> virtualMethodInterface, Method signature, String methodName) {

        // public class MyObject {
        //     static MemorySegment $vtable;
        //
        //     static final class VTable {
        //         static final MemorySegment $vtable = MyObject.$vtable;
        //         static final MethodHandle $MyMethod = RuntimeHelper.downcallHandle(..);
        //
        //         public static int MyMethod(MemoryAddress p1, int p2) {
        //            return (int)$MyMethod.invokeExact(p1, p2);
        //         }
        //     }
        //
        //     public int MyMethod(int p2) {
        //         return VTable.MyMethod(address(), p2);
        //     }
        // }

        _virtualMethodHandles.addVirtualMethod(virtualMethodInterface, signature, methodName);

        // Our public method, delegating to Vtable.Method(address(), args);
        addMethod(newMethod(methodName, signature, 1)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addCode("""
                        return $T.$L(address()$L);
                        """, _virtualMethodHandles._className, methodName, proxyArgsList(signature, 1, true)));
    }

    protected void addGettersSetters() {
        for (Method method : _cfg.linkedInterfaceClass.getDeclaredMethods()) {
            try {
                String rawMethodName = method.getName();
                String prefix;
                if (rawMethodName.endsWith("$get") || rawMethodName.endsWith("$slice")) {
                    prefix = "get";
                } else if (rawMethodName.endsWith("$set")) {
                    prefix = "set";
                } else {
                    continue;
                }
                String simpleName = prettyName(rawMethodName);
                String localMethodName = prefix + Character.toUpperCase(simpleName.charAt(0)) + simpleName.substring(1);

                MethodSpec.Builder methodSpec = this
                        .newMethod(localMethodName, method, 1)
                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL);

                String ret = method.getReturnType() == void.class ? "" : "return ";

                // return FooStatics.foo$get(self(), ...);
                methodSpec.addCode("""
                        $L$T.$L($L$L);
                        """, ret, _cfg.linkedInterfaceClass, rawMethodName, SELF, proxyArgsList(method, 1, true));
                addMethod(methodSpec);
            } catch (Throwable t) {
                throw new IllegalStateException(method + " " + t.toString(), t);
            }
        }
    }

    protected boolean hasMethod(String methodName) {
        for (Method method : _cfg.linkedInterfaceClass.getDeclaredMethods()) {
            if (methodName.equals(method.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add self() and address()
     */
    protected void addDefaultMethods() {

        // public final MemoryAddress address() { return _self.address(); }
        addMethod(MethodSpec
                .methodBuilder("address")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .returns(ClassNames.MEMORY_ADDRESS)
                .addCode("return self().address();"));

        // public final MemorySegment self() { return _self; }
        addMethod(MethodSpec
                .methodBuilder("self")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .returns(ClassNames.MEMORY_SEGMENT)
                .addCode("return $L;", FINAL_SELF));
    }

    protected void addObjectMethods() {
        if (hasMethod("$LAYOUT")) {
            // public static final MemoryLayout layout() { return MyInterface.$LAYOUT(); }
            addMethod(MethodSpec
                    .methodBuilder("layout")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                    .returns(ClassNames.MEMORY_LAYOUT)
                    .addCode("return $T.$L();", _cfg.linkedInterfaceClass, "$LAYOUT"));
        }

        if (hasMethod("sizeof")) {
            // public static final long sizeof() { return MyInterface.sizeof(); }
            addMethod(MethodSpec
                    .methodBuilder("sizeof")
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                    .returns(long.class)
                    .addCode("return $T.sizeof();", _cfg.linkedInterfaceClass));
        }
    }
}
