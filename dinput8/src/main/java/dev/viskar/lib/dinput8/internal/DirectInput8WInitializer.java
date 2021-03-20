package dev.viskar.lib.dinput8.internal;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import dev.viskar.lib.dinput8.natives.dinput_h;
import dev.viskar.lib.dinput8.Guids;
import dev.viskar.lib.dinput8.natives.TPointer;

public class DirectInput8WInitializer {

    public static final MemorySegment initialize() {
        try (TPointer tPointer = TPointer.allocate()) {

            int hres = dinput_h.DirectInput8Create(
                    Kernel32.GetModuleHandleW(),
                    dinput_h.DIRECTINPUT_VERSION(),
                    Guids.IID_IDirectInput8W,
                    tPointer,
                    MemoryAddress.NULL);

            if (hres == dinput_h.DI_OK()) {
                return tPointer.getPointer().asSegmentRestricted(dinput_h.IDirectInput8W.sizeof());
            } else {
                NativeUtils.logError(hres);
                return null;
            }
        }
    }

}
