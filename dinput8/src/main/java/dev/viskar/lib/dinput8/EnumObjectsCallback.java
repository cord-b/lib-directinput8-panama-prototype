package dev.viskar.lib.dinput8;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.NativeScope;
import dev.viskar.lib.dinput8.natives.dinput_h;

@FunctionalInterface
public interface EnumObjectsCallback extends dinput_h.LPDIENUMDEVICEOBJECTSCALLBACKW {

    @Override
    default int apply(MemoryAddress pObject, MemoryAddress pContent) {
        return apply(new TDIDEVICEOBJECTINSTANCEW(pObject));
    }

    int apply(TDIDEVICEOBJECTINSTANCEW objectInstance);

    /**
     * Do not override
     */
    default MemorySegment allocate() {
        return dinput_h.LPDIENUMDEVICEOBJECTSCALLBACKW.allocate(this);
    }

    /**
     * Do not override
     */
    default MemorySegment allocate(NativeScope scope) {
        return dinput_h.LPDIENUMDEVICEOBJECTSCALLBACKW.allocate(this, scope);
    }

}
