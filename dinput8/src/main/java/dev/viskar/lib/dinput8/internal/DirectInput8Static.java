package dev.viskar.lib.dinput8.internal;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import dev.viskar.lib.dinput8.natives.RuntimeHelper;
import dev.viskar.lib.dinput8.natives.dinput_h;
import dev.viskar.lib.dinput8.Guids;

import java.lang.invoke.MethodHandle;

final class DirectInput8Static {

    private final static MemorySegment interfaceStruct = createStruct();
    private final static MemorySegment iDirectInput8WVtbl = dinput_h.IDirectInput8W
            .lpVtbl$get(interfaceStruct)
            .asSegmentRestricted(dinput_h.IDirectInput8WVtbl.sizeof());

    // IDirectInput8W Interface:
    private static final MethodHandle configureDevices = RuntimeHelper.downcallHandle(
            dinput_h.IDirectInput8WVtbl.ConfigureDevices$get(iDirectInput8WVtbl),
            dinput_h.IDirectInput8WVtbl.ConfigureDevices.func(),
            dinput_h.IDirectInput8WVtbl.ConfigureDevices.nativeMethodType(),
            false);

    private static final MethodHandle enumDevices = RuntimeHelper.downcallHandle(
            dinput_h.IDirectInput8WVtbl.EnumDevices$get(iDirectInput8WVtbl),
            dinput_h.IDirectInput8WVtbl.EnumDevices$244.func(),
            dinput_h.IDirectInput8WVtbl.EnumDevices$244.nativeMethodType(),
            false);

    private static final MethodHandle initialize = dinput_h.IDirectInput8WVtbl.Initialize$247.downcall(
            dinput_h.IDirectInput8WVtbl.Initialize$get(iDirectInput8WVtbl)
    );

    private static final MethodHandle runControlPanel = dinput_h.IDirectInput8WVtbl.RunControlPanel$246.downcall(
            dinput_h.IDirectInput8WVtbl.RunControlPanel$get(iDirectInput8WVtbl)
    );

    //    private final IDirectInput8WVtbl.CreateDevice$243 createDevice;
    //    private final IDirectInput8WVtbl.EnumDevicesBySemantics enumDevicesBySemantics;
    //    private final IDirectInput8WVtbl.FindDevice$248 findDevice;
    //    private final IDirectInput8WVtbl.GetDeviceStatus$245 getDeviceStatus;

    // IUnknown Interface:
    private static final MethodHandle addRef = RuntimeHelper.downcallHandle(
            dinput_h.IDirectInput8WVtbl.AddRef$get(iDirectInput8WVtbl),
            dinput_h.IDirectInput8WVtbl.AddRef$241.func(),
            dinput_h.IDirectInput8WVtbl.AddRef$241.nativeMethodType(),
            false);

    //    private final IDirectInput8WVtbl.QueryInterface$240 queryInterface;
    //    private final IDirectInput8WVtbl.Release$242 release;

    private static volatile Callback prevEnumDevices;
    private static volatile Callback prevEnumObjects;

    private static final MemorySegment createStruct() {
        try (MemorySegment interfacePtr = dinput_h.IDirectInput8W.allocate()) {

            int hres = dinput_h.DirectInput8Create(
                    Kernel32.GetModuleHandleW(),
                    dinput_h.DIRECTINPUT_VERSION(),
                    Guids.IID_IDirectInput8W,
                    interfacePtr,
                    MemoryAddress.NULL);

            if (hres == dinput_h.DI_OK()) {
                return dinput_h.IDirectInput8W.lpVtbl$get(interfacePtr).asSegmentRestricted(dinput_h.IDirectInput8W.sizeof());
            } else {
                NativeUtils.logError(hres);
                return null;
            }
        }
    }

    public static MemoryAddress self() {
        return interfaceStruct.address();
    }

    public static int CreateDevice(MemoryAddress deviceGuid, MemoryAddress out_lplpDirectInputDevice, MemoryAddress pUnkOuter) {
        return -1;
    }

    public static int EnumDevices(int dwDevType, MemoryAddress lpCallback, MemoryAddress pvRef, int dwFlags) {
        try {
            return (int) enumDevices.invokeExact(self(), dwDevType, lpCallback, pvRef, dwFlags);
        } catch (Throwable t) {
            t.printStackTrace();
            return -1;
        }
    }

    static int EnumDevicesBySemantics(MemoryAddress ptszUserName, MemoryAddress lpdiActionFormat, MemoryAddress lpCallback, MemoryAddress pvRef, int dwFlags) {
        // return enumDevicesBySemantics.apply(thiss.address(), ptszUserName.address(), lpdiActionFormat.address(), lpCallback.address(), pvRef.address(), dwFlags);
        return -1;
    }

    static int FindDevice(MemoryAddress deviceClass, MemoryAddress name, MemoryAddress out_deviceGuid) {
        // return findDevice.apply(thiss.address(), deviceClass, name, out_deviceGuid);
        return -1;
    }

    static int GetDeviceStatus(MemoryAddress guid) {
        // return getDeviceStatus.apply(thiss.address(), guid);
        return -1;
    }

    static int Initialize(MemoryAddress hinstance, int version) {
        try {
            return (int) initialize.invokeExact(self(), hinstance, version);
        } catch (Throwable t) {
            t.printStackTrace();
            return -1;
        }
    }

    static int RunControlPanel(MemoryAddress hwndOwner, int flags) {
        try {
            return (int) runControlPanel.invokeExact(self(), hwndOwner, flags);
        } catch (Throwable t) {
            t.printStackTrace();
            return -1;
        }
    }

}

