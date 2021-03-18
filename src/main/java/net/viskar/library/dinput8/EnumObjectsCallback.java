package net.viskar.library.dinput8;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.NativeScope;
import net.viskar.library.dinput8.natives.dinput_h;

public interface EnumObjectsCallback extends dinput_h.LPDIENUMDEVICEOBJECTSCALLBACKW {

    @Override
    int apply(MemoryAddress pObject, MemoryAddress pContent);

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
