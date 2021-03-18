package net.viskar.library.dinput8.internal;

import jdk.incubator.foreign.MemorySegment;

public final class GlobalMemory {
    public static final MemorySegment INSTANCE = MemorySegment.ofNativeRestricted();

    public static final MemorySegment all() {
        return INSTANCE;
    }
}
