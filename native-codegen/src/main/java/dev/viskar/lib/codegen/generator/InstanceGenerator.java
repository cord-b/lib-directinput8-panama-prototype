package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;
import java.util.function.Consumer;

public class InstanceGenerator extends CommonGenerator {

    public InstanceGenerator(Builder config, String prefix, String suffix) {
        super(config, prefix, suffix);
    }

    @Override
    protected void addConstructors() {

        // private final MemorySegment _self;
        _class.addField(FieldSpec
                .builder(ClassNames.MEMORY_SEGMENT, FINAL_SELF, Modifier.PRIVATE, Modifier.FINAL)
                .build());

        // public Instance(MemorySegment instanceStruct) {
        //   _self = instanceStruct
        // }
        _constructor.addModifiers(Modifier.PUBLIC);
        _constructor.addParameter(ClassNames.MEMORY_SEGMENT, "instanceStruct");
        _constructor.addCode("""
                $L = instanceStruct;
                """, FINAL_SELF);

        // new Instance(MemoryAddress) -> this(address.asSegmentRestricted(sizeof()));
        if (hasMethod("sizeof")) {
            _class.addMethod(MethodSpec
                    .constructorBuilder()
                    .addModifiers(Modifier.PUBLIC)
                    .addParameter(ClassNames.MEMORY_ADDRESS, "instanceAddr")
                    .addCode("this(instanceAddr.asSegmentRestricted(sizeof()));")
                    .build());
        }
    }

    @Override
    protected void addVTable() {

        // static MemorySegment $vtable;
        _class.addField(FieldSpec.builder(ClassNames.MEMORY_SEGMENT, STATIC_VTABLE, Modifier.STATIC).build());

        // $vtable = Inteface.lpVtbl$get(_self).asSegmentRestricted(sizeof());
        _constructor.addCode("""
                if ($L == null) {
                    $L = $T.$L($L)
                        .asSegmentRestricted($T.sizeof());
                }
                """, STATIC_VTABLE, STATIC_VTABLE, _cfg.linkedInterfaceClass, _cfg.linkedVtableName + "$get", FINAL_SELF, _cfg.linkedVtableClass);
    }

    @Override
    public void build(Consumer<JavaFile> spec) {
        super.build(spec);
    }

}
