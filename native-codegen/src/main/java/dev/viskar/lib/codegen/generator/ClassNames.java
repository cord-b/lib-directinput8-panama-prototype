package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.ClassName;
import jdk.incubator.foreign.Addressable;

class ClassNames {

    static final String FOREIGN = "jdk.incubator.foreign";
    static ClassName MEMORY_SEGMENT = ClassName.get(FOREIGN, "MemorySegment");
    static ClassName MEMORY_ADDRESS = ClassName.get(FOREIGN, "MemoryAddress");
    static ClassName MEMORY_LAYOUT = ClassName.get(FOREIGN, "MemoryLayout");
    static ClassName ADDRESSABLE = ClassName.get(FOREIGN, "Addressable");

}
