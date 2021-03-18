package net.viskar.stubs;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import jdk.incubator.foreign.MemorySegment;

import javax.lang.model.element.Modifier;

public class StaticGenerator extends InstanceGenerator {

    protected static final String SUFFIX = "Static";
    protected final Class<?> initializerClass;
    protected final String initializerMethod;

    public StaticGenerator(Builder config, Class<?> initializerClass, String initializerMethod) {
        super(config, SUFFIX);
        this.initializerClass = initializerClass;
        this.initializerMethod = initializerMethod;
    }

    @Override
    protected void addConstructors() {
        addField(FieldSpec.builder(MemorySegment.class, SELF, Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL));
        _constructor.addModifiers(Modifier.PRIVATE);
        _initializer.add("""
                $L = $T.$L();
                """, SELF, initializerClass, initializerMethod);
    }

    @Override
    protected void addField(FieldSpec.Builder field) {
        if (!field.modifiers.contains(Modifier.STATIC)) {
            field.addModifiers(Modifier.STATIC);
        }
        super.addField(field);
    }

    @Override
    protected void addMethod(MethodSpec.Builder method) {
        if (!method.modifiers.contains(Modifier.STATIC)) {
            method.addModifiers(Modifier.STATIC);
        }
        super.addMethod(method);
    }

    @Override
    public void addInterfaces() {
        //
    }

    protected void finishInitializer() {
        _typeSpec.addStaticBlock(_initializer.build());
    }

}
