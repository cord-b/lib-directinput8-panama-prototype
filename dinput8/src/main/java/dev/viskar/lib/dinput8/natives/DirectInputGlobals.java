package dev.viskar.lib.dinput8.natives;

import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.LibraryLookup;
import jdk.incubator.foreign.MemoryAddress;
import dev.viskar.lib.codegen.runtime.RuntimeHelper;

import java.lang.invoke.MethodHandle;

public class DirectInputGlobals {

    private static final LibraryLookup[] LIBRARIES = dinput_h_constants_0.LIBRARIES;

    private static final MethodHandle GetdfDIJoystick = RuntimeHelper.downcallHandle(
            LIBRARIES,
            "GetdfDIJoystick",
            "()Ljdk/incubator/foreign/MemoryAddress;",
            FunctionDescriptor.of(CLinker.C_POINTER),
            false
    );

    public static final T_DIDATAFORMAT getDIJoystickDataFormat() {
        return new T_DIDATAFORMAT(GetdfDIJoystick());
    }

    public static final MemoryAddress GetdfDIJoystick() {
        try {
            return (MemoryAddress) GetdfDIJoystick.invokeExact();
        } catch (Throwable t) {
            return null;
        }
    }

}
