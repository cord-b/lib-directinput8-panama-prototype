package dev.viskar.lib.dinput8;

import dev.viskar.lib.dinput8.natives.dinput_h;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.NativeScope;

public interface EnumDevicesCallback2 extends dinput_h.LPDIENUMDEVICESCALLBACKW {

    @Override
    default int apply(MemoryAddress deviceInstance, MemoryAddress context) {
        return apply(new DeviceInstanceWrapper(deviceInstance), context);
    }

    int apply(DeviceInstanceWrapper deviceInstance, MemoryAddress context);

    /**
     * Allocate the cfunction pointer for registering this callback.
     */
    default MemorySegment allocate() {
        return dinput_h.LPDIENUMDEVICESCALLBACKW.allocate(this);
    }

    /**
     * Allocate the cfunction pointer for registering this callback.
     */
    default MemorySegment allocate(NativeScope scope) {
        return dinput_h.LPDIENUMDEVICESCALLBACKW.allocate(this, scope);
    }
}
