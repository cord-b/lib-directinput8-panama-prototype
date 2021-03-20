package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Method;

public class SingletonGenerator extends CommonGenerator {

    protected static final String SUFFIX = "Singleton";
    protected final ClassName _staticInstanceType;

    protected Modifier[] _staticInstanceModifiers = {Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL};
    protected Modifier[] _getInstanceModifiers = {Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL};
    protected String _singletonInitializer = "new $T()";

    public SingletonGenerator(Builder config) {
        this(config, "", SUFFIX);
    }

    public SingletonGenerator(Builder config, String prefix, String suffix) {
        super(config, prefix, suffix);
       _staticInstanceType = ClassName.get(config.packageName, config.baseName + StaticGenerator.SUFFIX);
       _addGetters = false;
       _addSetters = false;
    }

    @Override
    protected void addConstructors() {

        // private Instance() {}
        _constructor.addModifiers(Modifier.PRIVATE);

        // private static final Instance INSTANCE = new Instance(); }
        addField(FieldSpec
                .builder(_className, "INSTANCE", _staticInstanceModifiers)
                .initializer(_singletonInitializer, _className));

        // public static final Instance getInstance(); }
        addMethod(MethodSpec
                .methodBuilder("getInstance")
                .addModifiers(_getInstanceModifiers)
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
                .addModifiers(_memberMethodModifiers)
                .addCode("""
                        return $T.$L($L);
                        """, _staticInstanceType, methodName, proxyArgsList(signature, 1, false)));
    }

    @Override
    protected void addDefaultMethods() {
        // public final MemoryAddress address() { return Static.address(); }
        addMethod(MethodSpec
                .methodBuilder("address")
                .addModifiers(_memberMethodModifiers)
                .returns(ClassNames.MEMORY_ADDRESS)
                .addCode("return $T.address();", _staticInstanceType));

        // public final MemorySegment self() { return Static.self(); }
        addMethod(MethodSpec
                .methodBuilder("self")
                .addModifiers(_memberMethodModifiers)
                .returns(ClassNames.MEMORY_SEGMENT)
                .addCode("return $T.self();", _staticInstanceType));
    }

}
