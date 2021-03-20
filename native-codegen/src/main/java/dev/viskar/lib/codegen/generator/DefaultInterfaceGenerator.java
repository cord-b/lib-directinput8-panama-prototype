package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

public class DefaultInterfaceGenerator extends SingletonGenerator {

    public DefaultInterfaceGenerator(Builder config) {
        super(config, "", "");
        _getInstanceModifiers = new Modifier[]{Modifier.PUBLIC, Modifier.STATIC };
        _staticInstanceModifiers = new Modifier[]{Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL};
        _memberMethodModifiers = new Modifier[]{Modifier.PUBLIC, Modifier.DEFAULT};
        _staticObjectMethodModifiers = new Modifier[]{Modifier.PUBLIC, Modifier.STATIC};
        _singletonInitializer = "new $T(){}";
    }

    @Override
    public void initClass() {
        _class = TypeSpec
                .interfaceBuilder(_simpleName)
                .addModifiers(Modifier.PUBLIC);
    }

    @Override
    protected void finishConstructor() {
        // hide
    }
}
