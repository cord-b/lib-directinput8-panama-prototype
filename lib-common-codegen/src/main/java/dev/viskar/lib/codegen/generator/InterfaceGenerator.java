package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;

public class InterfaceGenerator extends SingletonObjectGenerator {

    public InterfaceGenerator(GeneratorConfig config) {
        super(config, "", "");
        _getInstanceModifiers = new Modifier[]{Modifier.PUBLIC, Modifier.STATIC};
        _staticInstanceModifiers = new Modifier[]{Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL};
        _memberMethodModifiers = new Modifier[]{Modifier.PUBLIC, Modifier.DEFAULT};
        _staticObjectMethodModifiers = new Modifier[]{Modifier.PUBLIC, Modifier.STATIC};
        _singletonInitializer = "new $T(){}";
        _isInterface = true;
        _classModifiers = new Modifier[]{Modifier.PUBLIC};
    }

    @Override
    protected void addConstructors() {
        // public static final Instance getInstance(); }
        addMethod(MethodSpec
                .methodBuilder("getInstance")
                .addModifiers(_getInstanceModifiers)
                .returns(_className)
                .addCode(
                        "return $T.getInstance();",
                        _singletonObjectType));
    }

    @Override
    protected void finishConstructor() {
        // hide
    }
}
