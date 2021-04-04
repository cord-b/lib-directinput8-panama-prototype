package dev.viskar.lib.codegen.generator.utils;

import com.squareup.javapoet.ClassName;
import jdk.incubator.foreign.Addressable;

import java.util.function.Supplier;

public class ClassNames {

    public static final String FOREIGN = "jdk.incubator.foreign";
    public static final ClassName SUPPLIER = ClassName.get(Supplier.class);
    public static final ClassName MEMORY_SEGMENT = ClassName.get(FOREIGN, "MemorySegment");
    public static final ClassName MEMORY_ADDRESS = ClassName.get(FOREIGN, "MemoryAddress");
    public static final ClassName MEMORY_LAYOUT = ClassName.get(FOREIGN, "MemoryLayout");
    public static final ClassName ADDRESSABLE = ClassName.get(FOREIGN, "Addressable");
    public static final ClassName GENERATED = ClassName.get("javax.annotation.processing", "Generated");
    public static final ClassName SNEAKY_THROWS = ClassName.get("lombok", "SneakyThrows");

}
