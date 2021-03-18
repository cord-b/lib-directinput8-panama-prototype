package net.viskar.stubs;

import com.squareup.javapoet.*;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;
import net.viskar.library.dinput8.internal.RuntimeHelper;

import javax.lang.model.element.Modifier;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.function.Consumer;

public class InstanceGenerator extends StubGenerators {

    protected static final String SELF = "_self";
    protected static final String VTABLE = "_vtable";

    protected final Builder _cfg;
    protected final ClassName _className;
    protected final TypeSpec.Builder _typeSpec;
    protected final CodeBlock.Builder _initializer = CodeBlock.builder();
    protected final MethodSpec.Builder _constructor = MethodSpec.constructorBuilder();

    public InstanceGenerator(Builder config) {
        this(config, "Instance");
    }

    protected InstanceGenerator(Builder config, String suffix) {
        String simpleName = config.baseName + suffix;
        this._cfg = config;
        this._className = ClassName.get(config.packageName, simpleName);
        this._typeSpec = TypeSpec
                .classBuilder(simpleName)
                .addModifiers(Modifier.PUBLIC);
    }

    public void addInterfaces() {
        for (Class<?> iface : _cfg.interfaces) {
            _typeSpec.addSuperinterface(iface);
        }
    }

    @Override
    public void build(Consumer<JavaFile> spec) {
        addInterfaces();
        addConstructors();
        addVirtualMethods();
        addObjectMethods();
        addGettersSetters();
        finish();

        TypeSpec typeSpec = _typeSpec.build();
        JavaFile javaFile = JavaFile.builder(_cfg.packageName, typeSpec).build();

        spec.accept(javaFile);
    }

    protected void addConstructors() {
        addField(FieldSpec.builder(MemorySegment.class, SELF, Modifier.PRIVATE, Modifier.FINAL));
        _constructor.addModifiers(Modifier.PUBLIC);
        _constructor.addParameter(MemorySegment.class, "instanceStruct");
        _initializer.add("""
                $L = instanceStruct;
                """, SELF);

        _typeSpec.addMethod(MethodSpec
                .constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(MemoryAddress.class, "instanceAddr")
                .addCode("this(instanceAddr.asSegmentRestricted(sizeof()));")
                .build());
    }

    protected void addField(FieldSpec.Builder field) {
        _typeSpec.addField(field.build());
    }

    protected void addMethod(MethodSpec.Builder method) {
        _typeSpec.addMethod(method.build());
    }

    protected void finish() {
        finishInitializer();
        finishConstructor();
    }

    protected void finishInitializer() {
        _constructor.addCode(_initializer.build());
    }

    protected void finishConstructor() {
        _typeSpec.addMethod(_constructor.build());
    }

    protected void addVirtualMethods() {
        addVTable();
        try {
            scanVirtualMethods();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    protected void addVTable() {
        if (_cfg.linkedVtableClass == null || _cfg.linkedVtableName == null || _cfg.linkedVtableName.isEmpty()) {
            return;
        }

        // private final MemorySegment vtable;
        addField(FieldSpec.builder(MemorySegment.class, VTABLE, Modifier.PRIVATE, Modifier.FINAL));

        // _vtable = Inteface.lpVtbl$get(_self).asSegmentRestricted(sizeof());
        _initializer.add("""
                $L = $T.$L($L)
                    .asSegmentRestricted($T.sizeof());
                """, VTABLE, _cfg.linkedInterfaceClass, _cfg.linkedVtableName + "$get", SELF, _cfg.linkedVtableClass);
    }

    protected final void scanVirtualMethods() throws Exception {
        if (_cfg.linkedVtableClass == null || _cfg.linkedVtableName == null || _cfg.linkedVtableName.isEmpty()) {
            return;
        }
        for (Class<?> virtualMethodInterface : _cfg.linkedVtableClass.getDeclaredClasses()) {
            if (virtualMethodInterface.isInterface()) {
                Method[] methods = virtualMethodInterface.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.getName().equals("apply")) {
                        addVirtualMethod(virtualMethodInterface, method);
                    }
                }
            }
        }
    }

    protected void addVirtualMethod(Class<?> virtualMethodInterface, Method signature) throws Exception {

        // Our prettied up name to use
        String ProxyMethod_Name = prettyName(virtualMethodInterface);
        // Field for generated metod handle
        String MethodHandle_Field = "_" + ProxyMethod_Name;

        // Our public signature (hiding the MemorySegment param[0])
        addMethod(newMethod(ProxyMethod_Name, signature, 1)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addCode("""
                        try {
                            return ($T)$L.invokeExact(address()$L);
                        } catch (Throwable t) {
                            throw new IllegalStateException(t);
                        }
                        """, signature.getReturnType(), MethodHandle_Field, proxyArgsList(signature, 1, true)));

        // private final MethodHandle _MyFunction;
        addField(FieldSpec.builder(MethodHandle.class, MethodHandle_Field, Modifier.PRIVATE, Modifier.FINAL));

        // _MyFunction = RuntimeHelper.downcallHandle(...);
        // MethodType MethodHandle_Type = LOOKUP.unreflect(method).type().dropParameterTypes(0, 1);
        MethodType nativeSignature = MethodType.methodType(signature.getReturnType(), signature.getParameterTypes());
        String funcMethod = virtualMethodInterface.getSimpleName() + "$FUNC";
        _initializer.add("""
                        $L = $T.downcallHandle(
                            $T.$L($L),
                            $T.$L(),
                            $S,
                            false);
                        """,
                MethodHandle_Field, RuntimeHelper.class,
                _cfg.linkedVtableClass, ProxyMethod_Name + "$get", VTABLE,
                _cfg.linkedConstantsClass, funcMethod,
                nativeSignature.descriptorString());
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

                methodSpec.addCode("""
                        $L$T.$L($L$L);
                        """, ret, _cfg.linkedInterfaceClass, rawMethodName, SELF, proxyArgsList(method, 1, true));
                addMethod(methodSpec);
            } catch (Throwable t) {
                throw new IllegalStateException(method + " " + t.toString(), t);
            }
        }
    }

    protected void addObjectMethods() {
        // public static final MemoryLayout layout() { return MyInterface.$LAYOUT(); }
        addMethod(MethodSpec
                .methodBuilder("layout")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .returns(MemoryLayout.class)
                .addCode("return $T.$L();", _cfg.linkedInterfaceClass, "$LAYOUT"));

        // public static final long sizeof() { return MyInterface.sizeof(); }
        addMethod(MethodSpec
                .methodBuilder("sizeof")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .returns(long.class)
                .addCode("return $T.sizeof();", _cfg.linkedInterfaceClass));

        // public final MemoryAddress address() { return self.address(); }
        addMethod(MethodSpec
                .methodBuilder("address")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .returns(MemoryAddress.class)
                .addCode("return $L.address();", SELF));

        // public final MemorySegment self() { return self; }
        addMethod(MethodSpec
                .methodBuilder("self")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .returns(MemorySegment.class)
                .addCode("return $L;", SELF));
    }

}
