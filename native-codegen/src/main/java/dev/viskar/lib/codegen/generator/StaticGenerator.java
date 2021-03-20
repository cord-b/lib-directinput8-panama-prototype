package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;

public class StaticGenerator extends CommonGenerator {

    protected static final String SUFFIX = "Static";
    protected final ClassName initializerClass;
    protected final String initializerMethod;

    public StaticGenerator(Builder config, ClassName initializerClass, String initializerMethod) {
        super(config, "", SUFFIX);
        this.initializerClass = initializerClass;
        this.initializerMethod = initializerMethod;
        this.FINAL_SELF = "$self";
        _memberMethodModifiers = new Modifier[]{Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL};
        _addSetters = false;
        _addGetters = false;
    }

    @Override
    protected void addConstructors() {

        // static final MemorySegment $self = Initializer.init();
        _class.addField(FieldSpec
                .builder(ClassNames.MEMORY_SEGMENT, FINAL_SELF, Modifier.STATIC, Modifier.FINAL)
                .initializer("$T.$L()", initializerClass, initializerMethod)
                .build());

        // private Instance() {}
        _constructor.addModifiers(Modifier.PRIVATE);
    }

    @Override
    protected void addVTable() {

        // satic final MemorySegment $vtable = StaticCodes.vtbl$get($self).asSegmentRestricted($T.sizeof());
        _class.addField(FieldSpec
                .builder(ClassNames.MEMORY_SEGMENT, STATIC_VTABLE, Modifier.STATIC, Modifier.FINAL)
                .initializer(
                        "$T.$L($L).asSegmentRestricted($T.sizeof())",
                        _cfg.linkedInterfaceClass, _cfg.linkedVtableName + "$get", FINAL_SELF, _cfg.linkedVtableClass)
                .build());
    }

    @Override
    public void addInterfaces() {
        //
    }

}
