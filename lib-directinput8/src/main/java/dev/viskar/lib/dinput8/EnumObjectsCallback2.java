package dev.viskar.lib.dinput8;

import dev.viskar.lib.dinput8.natives.dinput_h;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.NativeScope;

@FunctionalInterface
public interface EnumObjectsCallback2 extends dinput_h.LPDIENUMDEVICEOBJECTSCALLBACKW {

    @Override
    default int apply(MemoryAddress deviceObjectInfo, MemoryAddress pContext) {
        return apply(new DeviceObjectInstanceWrapper(deviceObjectInfo), pContext);
    }

    int apply(DeviceObjectInstanceWrapper deviceObjectInfo, MemoryAddress pContext);

    /**
     * Allocate the pointer for registering this callback.
     */
    default MemorySegment allocate() {
        return dinput_h.LPDIENUMDEVICEOBJECTSCALLBACKW.allocate(this);
    }

    /**
     * Allocate the pointer for registering this callback.
     */
    default MemorySegment allocate(NativeScope scope) {
        return dinput_h.LPDIENUMDEVICEOBJECTSCALLBACKW.allocate(this, scope);
    }

}
