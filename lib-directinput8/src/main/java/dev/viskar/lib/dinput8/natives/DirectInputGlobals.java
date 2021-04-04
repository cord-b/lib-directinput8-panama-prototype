package dev.viskar.lib.dinput8.natives;

import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAddress;

import java.lang.invoke.MethodHandle;

// In natives package to get package-private access
public class DirectInputGlobals {

    private static final MethodHandle GetdfDIJoystick = RuntimeHelper.downcallHandle(
            dinput_h_constants_0.LIBRARIES,
            "GetdfDIJoystick",
            "()Ljdk/incubator/foreign/MemoryAddress;",
            FunctionDescriptor.of(CLinker.C_POINTER),
            false
    );

    public static final MemoryAddress dfDIJoystick() {
        try {
            return (MemoryAddress) GetdfDIJoystick.invokeExact();
        } catch (Throwable t) {
            return null;
        }
    }

}
