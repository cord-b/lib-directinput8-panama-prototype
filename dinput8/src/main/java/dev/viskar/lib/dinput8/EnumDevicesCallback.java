package dev.viskar.lib.dinput8;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.NativeScope;
import dev.viskar.lib.dinput8.natives.dinput_h;

@FunctionalInterface
public interface EnumDevicesCallback extends dinput_h.LPDIENUMDEVICESCALLBACKW {

    @Override
    default int apply(MemoryAddress device, MemoryAddress context) {
        return apply(new TDIDEVICEINSTANCEW(device));
    }

    int apply(TDIDEVICEINSTANCEW deviceInstance);

    /**
     * Do not override
     */
    default MemorySegment allocate() {
        return dinput_h.LPDIENUMDEVICESCALLBACKW.allocate(this);
    }

    /**
     * Do not override
     */
    default MemorySegment allocate(NativeScope scope) {
        return dinput_h.LPDIENUMDEVICESCALLBACKW.allocate(this, scope);
    }

}

