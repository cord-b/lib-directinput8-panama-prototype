package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;
import dev.viskar.lib.codegen.runtime.RuntimeHelper;

import javax.lang.model.element.Modifier;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class VirtualMethodsBuilder {

    protected static final String VTABLE = "$vtable";

    protected final StubGenerators.Builder _cfg;
    protected final ClassName _className;
    protected final TypeSpec.Builder _class;

    private boolean empty = true;

    public VirtualMethodsBuilder(StubGenerators.Builder config, ClassName parent, String parentStaticVTableField) {
        _cfg = config;
        _className = parent.nestedClass("VTable");

        // static final class VTable {
        //    private static final MemorySegment $vtable = Outer.$vtable;
        // }
        _class = TypeSpec
                .classBuilder(_className)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);

        _class.addField(FieldSpec
                .builder(ClassNames.MEMORY_SEGMENT, VTABLE, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer("$T.$L", parent, parentStaticVTableField)
                .build());
    }

    public TypeSpec build() {
        return empty ? null : _class.build();
    }

    public void addVirtualMethod(Class<?> virtualMethodInterface, Method signature, String methodName) {

        String fieldName = "$" + methodName;

        empty = false;
        MethodType nativeSignature = MethodType.methodType(signature.getReturnType(), signature.getParameterTypes());
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
                        RuntimeHelper.class,
                        _cfg.linkedVtableClass, methodName + "$get", VTABLE,
                        _cfg.linkedConstantsClass, funcMethod,
                        nativeSignature.descriptorString())
                .build());

        _class.addMethod(StubGenerators
                .newMethod(methodName, signature, 0)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .addCode("""
                        try {
                            return ($T)$L.invokeExact($L);
                        } catch (Throwable t) {
                            throw new IllegalStateException(t);
                        }
                        """, signature.getReturnType(), fieldName, StubGenerators.proxyArgsList(signature, 0, false))
                .build());

    }

}
