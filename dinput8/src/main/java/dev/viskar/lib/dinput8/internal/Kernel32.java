package dev.viskar.lib.dinput8.internal;

import jdk.incubator.foreign.*;
import dev.viskar.lib.dinput8.natives.RuntimeHelper;

import java.lang.invoke.MethodHandle;

import static jdk.incubator.foreign.CLinker.C_POINTER;

public final class Kernel32 {

    private static final LibraryLookup[] LIBRARIES = RuntimeHelper.libraries(
            "C:\\Windows\\System32\\kernel32.dll"
    );

    private static final FunctionDescriptor GetModuleHandleW$FUNC_ = FunctionDescriptor.of(C_POINTER, C_POINTER);
    private static final MethodHandle GetModuleHandleW$MH_ = RuntimeHelper.downcallHandle(
            LIBRARIES,
            "GetModuleHandleW",
            "(Ljdk/incubator/foreign/MemoryAddress;)Ljdk/incubator/foreign/MemoryAddress;",
            GetModuleHandleW$FUNC_,
            false
    );

    public static MemoryAddress GetModuleHandleW() {
        return GetModuleHandleW(MemoryAddress.NULL);
    }

    public static MemoryAddress GetModuleHandleW(Addressable p1) {
        var mh$ = RuntimeHelper.requireNonNull(GetModuleHandleW$MH_, "unresolved symbol: GetModuleHandleW");
        try {
            return (MemoryAddress) mh$.invokeExact(p1.address());
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }

}
