package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.TypeSpec;
import dev.viskar.lib.codegen.generator.utils.ClassNames;
import dev.viskar.lib.codegen.runtime.SingletonInitializer;

import javax.lang.model.element.Modifier;

/**
 * Generates a static implementation of the given type based on a single instance of the underlying object.
 * <p>
 * Given an C/C++ object 'IDirectInput', this will generate the example code shown at the bottom.
 * <p>
 * For this code to work, the developer using this generated code must provide an implementation of the 'Initialier' class and register it as a service:
 * <pre>
 *     META-INF/services/com.example.natives.IDirectInputStatic$Initializer
 *     ------------
 *     com.example.MyDirectInputInitializer
 * </pre>
 * With code:
 * <pre>
 *     public class MyDirectInputInitializer implements IDirectInputStatic.Initializer {
 *         public MemoryAddress get() {
 *             // your function to construct the singleton instance
 *         }
 *     }
 * </pre>
 * <p>
 * Generate codex example:
 * <pre>
 * public final class IDirectInputStatic {
 *
 *     // Service Provider interface
 *     // Importing code is expected to provide the Initializer implementation
 *     inteface Initializer extends SingletonInitializer {}
 *
 *     public static class Instance {
 *          static final MemoryAddress $address = RuntimeHelper.runInitializer(Initializer.class);
 *          static final MemorySegment $self = $address.asSegmentRestricted(sizeof());
 *          static final MemorySegment $vtbl = lpVtbl$get($self);
 *     }
 *
 *     // Interface methods
 *     public static int EnumDevices(MemoryAddress x2, MemoryAddress x3) {
 *         return VTable.$EnumDevices(address(), x2, x3);
 *     }
 *
 *     // Common methods
 *     public static MemorySegment self(); { .. }
 *     public static MemoryAddress address(); { self().address(); }
 *     ...
 *
 *     // MethodHandles from vtable
 *     public static class VTable {
 *
 *         public static final MethodHandle $EnumDevices = RuntimeHelper.downcallHandle(
 *             dinput_h.IDirectInput8WVtbl.EnumDevices$get($vtable),
 *             dinput_h_constants_5.EnumDevices$244$FUNC(),
 *             "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
 *             false
 *         );
 *
 *         public static int EnumDevices(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3) {
 *             return (int)$EnumDevices.invokeExact(x1, x2, x3);
 *         }
 *
 *     }
 * }
 * </pre>
 */
public class StaticObjectGenerator extends CommonSingletonGenerator {

    protected static final String SUFFIX = "Static";
    protected static final String INNER_CLASS_INSTANCE = "Instance";
    protected static final String INNER_CLASS_INITIALIZER = "Initializer";

    // public static class Instance { .. }
    protected final TypeSpec.Builder instance;

    // public inteface Initializer { .. }
    protected final TypeSpec initializer;

    public StaticObjectGenerator(GeneratorConfig config) {
        super(config, "", SUFFIX);
        this.FINAL_SELF = "Instance.$self";
        this._memberMethodModifiers = new Modifier[]{Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL};
        this.instance = TypeSpec
                .classBuilder(_staticInstanceHolderType)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL);
        this.initializer = TypeSpec
                .interfaceBuilder(_staticInitializerType)
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addSuperinterface(SingletonInitializer.class)
                .build();
    }

    @Override
    protected void addConstructors() {

        // This class initializes with an innter class that calls a service loaded:

        // public static class Instance {
        //    static final MemorySegment $self = Initializer.init();
        //    static final MemorySegment $self = $address.asSegmentRestricted(sizeof());
        //    // added later if vtbl exists:
        //    static final MemorySegment $vtbl = lpVtbl$get($self);
        // }
        instance.addField(FieldSpec
                .builder(ClassNames.MEMORY_ADDRESS, "$address", Modifier.STATIC, Modifier.FINAL)
                .initializer("$T.runInitializer($T.class)", SingletonInitializer.class, _staticInitializerType)
                .build()
        );
        instance.addField(FieldSpec
                .builder(ClassNames.MEMORY_SEGMENT, "$self", Modifier.STATIC, Modifier.FINAL)
                .initializer("$L.asSegmentRestricted($T.sizeof())", "$address", _cfg.cType)
                .build()
        );

        // private Instance() {}
        _constructor.addModifiers(Modifier.PRIVATE);
        _constructor.addCode("throw new $T($S);", UnsupportedOperationException.class, "Static class: do not construct.");
    }

    @Override
    protected void addVTable() {

        // public static class VTable { .. }
        _virtualMethodHandles = new VirtualMethodsBuilder(_cfg, _className, _staticInstanceHolderType, STATIC_VTABLE);

        // static final MemorySegment $vtable = StaticCodes.vtbl$get($self).asSegmentRestricted($T.sizeof());
        instance.addField(FieldSpec
                .builder(ClassNames.MEMORY_SEGMENT, STATIC_VTABLE, Modifier.STATIC, Modifier.FINAL)
                .initializer(
                        "$T.$L($L).asSegmentRestricted($T.sizeof())",
                        _cfg.cType, _cfg.typeVtblField + "$get", "$self", _cfg.vtblType)
                .build());
    }

    @Override
    public void addInterfaces() {
        //
    }

    @Override
    protected void finish() {
        super.finish();
        _class.addType(initializer);
        _class.addType(instance.build());
    }

}
