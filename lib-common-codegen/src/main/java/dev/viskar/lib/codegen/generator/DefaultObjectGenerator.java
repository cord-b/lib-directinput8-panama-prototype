package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import dev.viskar.lib.codegen.generator.utils.ClassNames;

import javax.lang.model.element.Modifier;

public class DefaultObjectGenerator extends CommonGenerator {

    public DefaultObjectGenerator(GeneratorConfig config, String prefix, String suffix) {
        super(config, "T", prefix, suffix);
        _classModifiers = new Modifier[]{Modifier.PUBLIC};
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

        _virtualMethodHandles = new VirtualMethodsBuilder(_cfg, _className, _className, STATIC_VTABLE);

        // static MemorySegment $vtable;
        _class.addField(FieldSpec.builder(ClassNames.MEMORY_SEGMENT, STATIC_VTABLE, Modifier.STATIC).build());

        // $vtable = Inteface.lpVtbl$get(_self).asSegmentRestricted(sizeof());
        _constructor.addCode("""
                if ($L == null) {
                    $L = $T.$L($L)
                        .asSegmentRestricted($T.sizeof());
                }
                """, STATIC_VTABLE, STATIC_VTABLE, _cfg.cType, _cfg.typeVtblField + "$get", FINAL_SELF, _cfg.vtblType);
    }

}
