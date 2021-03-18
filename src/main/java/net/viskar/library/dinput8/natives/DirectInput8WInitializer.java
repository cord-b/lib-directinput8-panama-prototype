package net.viskar.library.dinput8.natives;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import net.viskar.library.dinput8.Guids;
import net.viskar.library.dinput8.internal.Kernel32;
import net.viskar.library.dinput8.internal.NativeUtils;

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
