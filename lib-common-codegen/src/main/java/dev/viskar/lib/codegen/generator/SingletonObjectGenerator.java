package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import dev.viskar.lib.codegen.generator.utils.ClassNames;
import dev.viskar.lib.codegen.generator.utils.GeneratorUtils;

import javax.lang.model.element.Modifier;
import java.lang.reflect.Method;

public class SingletonObjectGenerator extends CommonSingletonGenerator {

    protected static final String SUFFIX = "Singleton";

    protected Modifier[] _staticInstanceModifiers = {Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL};
    protected Modifier[] _getInstanceModifiers = {Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL};
    protected String _singletonInitializer = "new $T()";

    public SingletonObjectGenerator(GeneratorConfig config) {
        this(config, "", SUFFIX);
    }

    public SingletonObjectGenerator(GeneratorConfig config, String prefix, String suffix) {
        super(config, prefix, suffix);
    }

    @Override
    protected void addConstructors() {

        _class.addSuperinterface(_singletonInterfaceType);
        _addOverrideToVirtualMethods = true;

        // private Instance() {}
        _constructor.addModifiers(Modifier.PRIVATE);
        _constructor.addComment("Singleton constructor");

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
    protected boolean addVirtualMethod(Class<?> virtualMethodInterface, Method signature, String methodName) {
        // Our public signature (hiding the MemorySegment param[0])
        addMethod(newVirtualMethod(methodName, signature, 1)
                .addModifiers(_memberMethodModifiers)
                .addCode("return $T.$L($L);", _staticType, methodName, GeneratorUtils.proxyArgsList(signature, 1, false)));
        return true;
    }

    @Override
    protected void addDefaultMethods() {
        // public final MemoryAddress address() { return Static.address(); }
        addMethod(MethodSpec
                .methodBuilder("address")
                .addModifiers(_memberMethodModifiers)
                .returns(ClassNames.MEMORY_ADDRESS)
                .addCode("return $T.address();", _staticType));

        // public final MemorySegment self() { return Static.self(); }
        addMethod(MethodSpec
                .methodBuilder("self")
                .addModifiers(_memberMethodModifiers)
                .returns(ClassNames.MEMORY_SEGMENT)
                .addCode("return $T.self();", _staticType));
    }

}
