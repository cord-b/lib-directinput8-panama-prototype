package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Method;

public class SingletonGenerator extends CommonGenerator {

    protected static final String SUFFIX = "Singleton";
    protected final ClassName _staticInstanceType;

    public SingletonGenerator(Builder config) {
        super(config, "", SUFFIX);
        _staticInstanceType = ClassName.get(config.packageName, config.baseName + StaticGenerator.SUFFIX);
    }

    @Override
    protected void addConstructors() {

        // private Instance() {}
        _constructor.addModifiers(Modifier.PRIVATE);

        // private static final Instance INSTANCE = new Instance(); }
        addField(FieldSpec.builder(_className, "INSTANCE", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer("new $T()", _className));

        // public static final Instance getInstance(); }
        addMethod(MethodSpec
                .methodBuilder("getInstance")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .returns(_className)
                .addCode("return INSTANCE;"));
    }

    @Override
    protected void addVTable() {
        //
    }

    @Override
    protected void addVirtualMethod(Class<?> virtualMethodInterface, Method signature, String methodName) {
        // Our public signature (hiding the MemorySegment param[0])
        addMethod(newMethod(methodName, signature, 1)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addCode("""
                        return $T.$L($L);
                        """, _staticInstanceType, methodName, proxyArgsList(signature, 1, false)));
    }

    @Override
    protected void addDefaultMethods() {
        // public final MemoryAddress address() { return Static.address(); }
        addMethod(MethodSpec
                .methodBuilder("address")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .returns(ClassNames.MEMORY_ADDRESS)
                .addCode("return $T.address();", _staticInstanceType));

        // public final MemorySegment self() { return Static.self(); }
        addMethod(MethodSpec
                .methodBuilder("self")
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .returns(ClassNames.MEMORY_SEGMENT)
                .addCode("return $T.self();", _staticInstanceType));
    }

}
