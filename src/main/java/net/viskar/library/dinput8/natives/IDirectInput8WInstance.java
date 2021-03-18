package net.viskar.library.dinput8.natives;

import java.lang.invoke.MethodHandle;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;
import net.viskar.library.dinput8.DirectInput8;
import net.viskar.library.dinput8.internal.RuntimeHelper;

public class IDirectInput8WInstance implements DirectInput8 {
    private final MemorySegment _self;

    private final MemorySegment _vtable;

    private final MethodHandle _ConfigureDevices;

    private final MethodHandle _EnumDevicesBySemantics;

    private final MethodHandle _FindDevice;

    private final MethodHandle _Initialize;

    private final MethodHandle _RunControlPanel;

    private final MethodHandle _GetDeviceStatus;

    private final MethodHandle _EnumDevices;

    private final MethodHandle _CreateDevice;

    private final MethodHandle _Release;

    private final MethodHandle _AddRef;

    private final MethodHandle _QueryInterface;

    public IDirectInput8WInstance(MemorySegment instanceStruct) {
        _self = instanceStruct;
        _vtable = dinput_h.IDirectInput8W.lpVtbl$get(_self)
                .asSegmentRestricted(dinput_h.IDirectInput8WVtbl.sizeof());
        _ConfigureDevices = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.ConfigureDevices$get(_vtable),
                dinput_h_constants_5.ConfigureDevices$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)I",
                false);
        _EnumDevicesBySemantics = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.EnumDevicesBySemantics$get(_vtable),
                dinput_h_constants_5.EnumDevicesBySemantics$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _FindDevice = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.FindDevice$get(_vtable),
                dinput_h_constants_5.FindDevice$248$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _Initialize = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.Initialize$get(_vtable),
                dinput_h_constants_5.Initialize$247$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _RunControlPanel = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.RunControlPanel$get(_vtable),
                dinput_h_constants_5.RunControlPanel$246$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _GetDeviceStatus = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.GetDeviceStatus$get(_vtable),
                dinput_h_constants_5.GetDeviceStatus$245$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _EnumDevices = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.EnumDevices$get(_vtable),
                dinput_h_constants_5.EnumDevices$244$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _CreateDevice = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.CreateDevice$get(_vtable),
                dinput_h_constants_5.CreateDevice$243$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _Release = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.Release$get(_vtable),
                dinput_h_constants_5.Release$242$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _AddRef = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.AddRef$get(_vtable),
                dinput_h_constants_5.AddRef$241$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _QueryInterface = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.QueryInterface$get(_vtable),
                dinput_h_constants_5.QueryInterface$240$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
    }

    public final int ConfigureDevices(MemoryAddress x0, MemoryAddress x1, int x2, MemoryAddress x3) {
        try {
            return (int)_ConfigureDevices.invokeExact(address(), x0, x1, x2, x3);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int EnumDevicesBySemantics(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
                                            MemoryAddress x3, int x4) {
        try {
            return (int)_EnumDevicesBySemantics.invokeExact(address(), x0, x1, x2, x3, x4);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int FindDevice(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2) {
        try {
            return (int)_FindDevice.invokeExact(address(), x0, x1, x2);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int Initialize(MemoryAddress x0, int x1) {
        try {
            return (int)_Initialize.invokeExact(address(), x0, x1);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int RunControlPanel(MemoryAddress x0, int x1) {
        try {
            return (int)_RunControlPanel.invokeExact(address(), x0, x1);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int GetDeviceStatus(MemoryAddress x0) {
        try {
            return (int)_GetDeviceStatus.invokeExact(address(), x0);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int EnumDevices(int x0, MemoryAddress x1, MemoryAddress x2, int x3) {
        try {
            return (int)_EnumDevices.invokeExact(address(), x0, x1, x2, x3);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int CreateDevice(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2) {
        try {
            return (int)_CreateDevice.invokeExact(address(), x0, x1, x2);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int Release() {
        try {
            return (int)_Release.invokeExact(address());
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int AddRef() {
        try {
            return (int)_AddRef.invokeExact(address());
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int QueryInterface(MemoryAddress x0, MemoryAddress x1) {
        try {
            return (int)_QueryInterface.invokeExact(address(), x0, x1);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public static final MemoryLayout layout() {
        return dinput_h.IDirectInput8W.$LAYOUT();
    }

    public static final long sizeof() {
        return dinput_h.IDirectInput8W.sizeof();
    }

    protected final MemoryAddress address() {
        return _self.address();
    }
}