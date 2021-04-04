package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import dev.viskar.lib.codegen.generator.utils.ClassNames;
import dev.viskar.lib.codegen.generator.utils.GeneratorUtils;
import dev.viskar.lib.codegen.generator.utils.JExtractUtils;
import jdk.jfr.Frequency;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class CommonGenerator {

    protected final GeneratorConfig _cfg;
    protected final ClassName _className;
    protected final String _simpleName;
    protected final ClassName _runtimeHelper;
    protected final MethodSpec.Builder _constructor = MethodSpec.constructorBuilder();

    // instance fields
    protected String FINAL_SELF = "_self";
    protected static final String SELF = "self()";
    protected static final String STATIC_VTABLE = "$vtable";

    protected TypeSpec.Builder _class;

    protected VirtualMethodsBuilder _virtualMethodHandles;
    protected Map<String, List<Method>> documentedMethods = new TreeMap<>();
    protected Modifier[] _classModifiers = {Modifier.PUBLIC, Modifier.FINAL};
    protected Modifier[] _memberMethodModifiers = {Modifier.PUBLIC, Modifier.FINAL};
    protected Modifier[] _staticObjectMethodModifiers = {Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL};
    protected boolean _addSetters = true;
    protected boolean _addGetters = true;
    protected boolean _isInterface = false;
    protected boolean _addOverrideToVirtualMethods = false;

    protected CommonGenerator(GeneratorConfig config, String defaultPrefix, String prefix, String suffix) {
        String baseName = config.baseName;

        boolean modified = true;
        while (modified) {
            modified = false;
            for (Entry<String, Object> rename : config.args.getRename().entrySet()) {
                Pattern pattern = Pattern.compile(rename.getKey());
                String value = rename.getValue().toString();
                String result = pattern.matcher(baseName).replaceAll(value);
                if (!result.equals(baseName)) {
                    modified = true;
                    baseName = result;
                }
            }
        }

        _simpleName = prefix + baseName + suffix;
        _cfg = config;
        _className = ClassName.get(config.packageName, _simpleName);
        _runtimeHelper = ClassName.get(config.packageName, "RuntimeHelper");
    }

    public final void initClass() {
        _class = _isInterface
                ? TypeSpec.interfaceBuilder(_simpleName)
                : TypeSpec.classBuilder(_simpleName);
        _class.addModifiers(_classModifiers);
        _class.addAnnotation(AnnotationSpec
                .builder(ClassNames.GENERATED)
                .addMember("value", "{ $S, $S }", Generator.class.getName(), getClass().getName())
                .addMember("comments", "\"\"\"\n$L\n\"\"\"", _cfg.args.toString(_cfg.cType).trim())
                .build());
    }

    public void addJavadoc() {
        addInfoJavadoc();
        for (List<Method> list : documentedMethods.values()) {
            list.sort(Comparator.comparing(Method::getParameterCount));
        }
        addMethodsJavadoc();
        addStructJavadoc();
        addExtraJavadoc();
    }

    protected void addInfoJavadoc() {
        _class.addJavadoc("""
                <div id="info">
                <h1>Info</h1>
                Generated from {@link $L $L.$L}
                <p>
                """, _cfg.cType.getCanonicalName(), _cfg.headerClass.getSimpleName(), _cfg.cType.getSimpleName());
    }

    protected void addMethodsJavadoc() {
        if (documentedMethods.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder(256).append("""
                <div id="methods">
                <h1>Methods</h1>
                <pre><small>""");

        for (Map.Entry<String, List<Method>> entry : documentedMethods.entrySet()) {
            String methodName = entry.getKey();
            for (Method method : entry.getValue()) {
                sb.append("\n").append(method.getReturnType().getSimpleName()).append(' ').append(methodName).append("(");
                Parameter[] params = method.getParameters();
                for (int i = 1; i < params.length; i++) {
                    Parameter param = params[i];
                    if (i != 1) {
                        sb.append(", ");
                    }
                    sb.append(param.getType().getSimpleName()).append(' ').append(param.getName());
                }
                sb.append(")");
            }
        }
        sb.append("</small></pre></div>");
        _class.addJavadoc("$L", sb.toString());
    }

    protected void addStructJavadoc() {
        String structLayout = GeneratorUtils.printStructLayout(_cfg.cType);
        if (!structLayout.isEmpty()) {
            _class.addJavadoc("""
                    <div id="struct">
                    <h1>Struct</h1>
                    <pre><small>
                    $L
                    </small></pre></div>
                    """, structLayout);
        }
    }

    protected void addExtraJavadoc() {

    }

    public void addInterfaces() {
        for (ClassName iface : _cfg.interfaces) {
            _class.addSuperinterface(iface);
        }
    }

    public void build(Consumer<JavaFile> spec) {
        initClass();
        addInterfaces();
        addConstructors();
        addVirtualMethods();
        addDefaultMethods();
        addObjectMethods();
        addAccessors();
        addJavadoc();
        finish();

        if (_virtualMethodHandles != null) {
            TypeSpec vtable = _virtualMethodHandles.build();
            if (vtable != null) {
                _class.addType(vtable);
            }
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

    protected MethodSpec.Builder newVirtualMethod(String name, Method signature, int paramOffset) {
        MethodSpec.Builder builder = GeneratorUtils.newMethod(name, signature, paramOffset);
        if (_addOverrideToVirtualMethods) {
            builder.addAnnotation(Override.class);
        }
        return builder;
    }

    protected void finish() {
        finishConstructor();
    }

    protected void finishConstructor() {
        _class.addMethod(_constructor.build());
    }

    protected void addVirtualMethods() {
        if (_cfg.vtblType == null || _cfg.typeVtblField == null || _cfg.typeVtblField.isEmpty()) {
            return;
        }
        addVTable();
        scanVirtualMethods();
    }

    protected abstract void addVTable();

    protected void scanVirtualMethods() {
        for (Class<?> virtualMethodInterface : _cfg.vtblType.getDeclaredClasses()) {
            if (virtualMethodInterface.isInterface()) {
                Method[] methods = virtualMethodInterface.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.getName().equals("apply")) {
                        String methodName = JExtractUtils.getVirtualMethodNameFromGeneratedInterfaceMethod(method);
                        if (addVirtualMethod(virtualMethodInterface, method, methodName)) {
                            documentedMethods.computeIfAbsent(methodName, it -> new ArrayList<>()).add(method);
                        }
                    }
                }
            }
        }
    }

    protected boolean addVirtualMethod(Class<?> virtualMethodInterface, Method signature, String methodName) {

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

        if (_virtualMethodHandles == null) {
            return false;
        }

        _virtualMethodHandles.addVirtualMethod(virtualMethodInterface, signature, methodName);

        // Our public method, delegating to Vtable.Method(address(), args);
        addMethod(newVirtualMethod(methodName, signature, 1)
                .addModifiers(_memberMethodModifiers)
                .addCode("""
                                return $T.$L(address()$L);
                                """,
                        _virtualMethodHandles._className, methodName,
                        GeneratorUtils.proxyArgsList(signature, 1, true)));
        return true;
    }

    protected void addAccessors() {
        for (Method method : _cfg.cType.getDeclaredMethods()) {
            if (_addGetters && JExtractUtils.isGetter(method) || _addSetters && JExtractUtils.isSetter(method)) {
                String accessorName = JExtractUtils.normalizeAccessorMethodName(method);
                if (addAccessor(method, accessorName)) {
                    documentedMethods.computeIfAbsent(accessorName, it -> new ArrayList<>()).add(method);
                }
            }
        }
    }

    protected boolean addAccessor(Method method, String accessorName) {

        MethodSpec.Builder methodSpec = GeneratorUtils
                .newMethod(accessorName, method, 1)
                .addModifiers(_memberMethodModifiers);

        // return FooStatics.foo$get(self(), ...);
        String ret = method.getReturnType() == void.class ? "" : "return ";
        methodSpec.addCode("""
                        $L$T.$L($L$L);
                        """,
                ret, _cfg.cType, method.getName(), SELF,
                GeneratorUtils.proxyArgsList(method, 1, true));
        addMethod(methodSpec);
        return true;
    }

    protected MethodSpec.Builder tryCatch(MethodSpec.Builder method, String format, Object... args) {
        return GeneratorUtils.tryCatch(_cfg, method, format, args);
    }

    protected Method findMethod(String methodName) {
        return GeneratorUtils.findMethod(_cfg.cType, methodName);
    }

    protected boolean hasMethod(String methodName) {
        return GeneratorUtils.hasMethod(_cfg.cType, methodName);
    }

    /**
     * Add self() and address()
     */
    protected void addDefaultMethods() {

        // public final MemoryAddress address() { return _self.address(); }
        addMethod(MethodSpec
                .methodBuilder("address")
                .addModifiers(_memberMethodModifiers)
                .returns(ClassNames.MEMORY_ADDRESS)
                .addCode("return self().address();"));

        // public final MemorySegment self() { return _self; }
        addMethod(MethodSpec
                .methodBuilder("self")
                .addModifiers(_memberMethodModifiers)
                .returns(ClassNames.MEMORY_SEGMENT)
                .addCode("return $L;", FINAL_SELF));
    }

    protected void addObjectMethods() {
        if (hasMethod("$LAYOUT")) {
            // public static final MemoryLayout layout() { return MyInterface.$LAYOUT(); }
            addMethod(MethodSpec
                    .methodBuilder("layout")
                    .addModifiers(_staticObjectMethodModifiers)
                    .returns(ClassNames.MEMORY_LAYOUT)
                    .addCode("return $T.$L();", _cfg.cType, "$LAYOUT"));
        }

        if (hasMethod("sizeof")) {
            // public static final long sizeof() { return MyInterface.sizeof(); }
            addMethod(MethodSpec
                    .methodBuilder("sizeof")
                    .addModifiers(_staticObjectMethodModifiers)
                    .returns(long.class)
                    .addCode("return $T.sizeof();", _cfg.cType));
        }
    }
}
