package net.viskar.library.dinput8;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.NativeScope;
import net.viskar.library.dinput8.natives.dinput_h;

import java.lang.annotation.Native;

@FunctionalInterface
public interface EnumDevicesCallback extends dinput_h.LPDIENUMDEVICESCALLBACKW {

    @Override
    int apply(MemoryAddress device, MemoryAddress context);

    /** Do not override */
    default MemorySegment allocate() {
        return dinput_h.LPDIENUMDEVICESCALLBACKW.allocate(this);
    }

    /** Do not override */
    default MemorySegment allocate(NativeScope scope) {
        return dinput_h.LPDIENUMDEVICESCALLBACKW.allocate(this, scope);
    }

}
