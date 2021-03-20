package dev.viskar.lib.dinput8.internal;

import jdk.incubator.foreign.MemorySegment;

final class Callback {

    final Object impl;
    final MemorySegment segment;

    Callback(Object impl, MemorySegment segment) {
        this.impl = impl;
        this.segment = segment;
    }

}