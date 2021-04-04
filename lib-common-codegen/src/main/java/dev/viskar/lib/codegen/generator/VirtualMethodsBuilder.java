package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import dev.viskar.lib.codegen.generator.utils.ClassNames;
import dev.viskar.lib.codegen.generator.utils.GeneratorUtils;

import javax.lang.model.element.Modifier;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class VirtualMethodsBuilder {

    protected static final String VTABLE = "$vtable";

    protected final GeneratorConfig _cfg;
    protected final ClassName _className;
    protected final TypeSpec.Builder _class;
    protected final List<Method> allMethodSignatures = new ArrayList<>();

    private boolean empty = true;

    public VirtualMethodsBuilder(GeneratorConfig config, ClassName outerClass, ClassName vtblProvider, String vtblField) {
        _cfg = config;
        _className = outerClass.nestedClass("VTable");

        // static final class VTable {
        //    private static final MemorySegment $vtable = VtblProviderClass.$vtable;
        // }
        _class = TypeSpec
                .classBuilder(_className)
                .addAnnotation(AnnotationSpec
                        .builder(ClassNames.GENERATED)
                        .addMember("value", "{ $S, $S }", Generator.class.getName(), getClass().getName())
                        .build())
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);

        _class.addField(FieldSpec
                .builder(ClassNames.MEMORY_SEGMENT, VTABLE, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer("$T.$L", vtblProvider, vtblField)
                .build());

        String structLayout = GeneratorUtils.printStructLayout(config.vtblType);
        if (!structLayout.isEmpty()) {
            _class.addJavadoc("""
                    <div id="struct">
                    <h1>Struct</h1>
                    <pre>
                    $L
                    </pre></div>
                    """, structLayout);
        }
    }

    public TypeSpec build() {
        return empty ? null : _class.build();
    }

    public void addVirtualMethod(Class<?> virtualMethodInterface, Method signature, String methodName) {

        allMethodSignatures.add(signature);

        String fieldName = "$" + methodName;
        MethodType nativeSignature = MethodType.methodType(signature.getReturnType(), signature.getParameterTypes());

        // This is the naming convention used by jextract.
        String funcMethod = virtualMethodInterface.getSimpleName() + "$FUNC";

        //     static final class VTable {
        //
        //         static final MethodHandle $MyMethod = RuntimeHelper.downcallHandle(..);
        //
        //         static int MyMethod(MemoryAddress p1, ...) {
        //            return (int)$MyMethod.invokeExact(p1, ...);
        //         }
        //     }
        _class.addField(FieldSpec
                .builder(MethodHandle.class, fieldName, Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .initializer("""
                                $T.downcallHandle(
                                    $T.$L($L),
                                    $T.$L(),
                                    $S,
                                    false)
                                """,
                        ClassName.get(_cfg.packageName, "RuntimeHelper"),
                        _cfg.vtblType, methodName + "$get", VTABLE,
                        _cfg.headerConstantsClass, funcMethod,
                        nativeSignature.descriptorString())
                .build());

        MethodSpec.Builder method = GeneratorUtils
                .newMethod(methodName, signature, 0)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);
        GeneratorUtils.tryCatch(
                _cfg,
                method,
                "return ($T)$L.invokeExact($L);",
                signature.getReturnType(), fieldName, GeneratorUtils.proxyArgsList(signature, 0, false));
        _class.addMethod(method.build());

        empty = false;
    }

}
