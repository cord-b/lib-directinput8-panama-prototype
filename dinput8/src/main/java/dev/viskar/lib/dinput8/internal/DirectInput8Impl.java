package dev.viskar.lib.dinput8.internal;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import dev.viskar.lib.dinput8.natives.RuntimeHelper;
import dev.viskar.lib.dinput8.DirectInput;
import dev.viskar.lib.dinput8.natives.dinput_h;
import dev.viskar.lib.dinput8.Guids;

import java.lang.invoke.MethodHandle;
import java.util.function.Function;

public class DirectInput8Impl implements DirectInput {

    private final MemorySegment interfaceStruct;
    private final MemorySegment iDirectInput8WVtbl;

    // IDirectInput8W Interface:
    private final @See(dinput_h.IDirectInput8WVtbl.ConfigureDevices.class) MethodHandle configureDevices;
    private final @See(dinput_h.IDirectInput8WVtbl.EnumDevices$244.class) MethodHandle enumDevices;
    private final @See(dinput_h.IDirectInput8WVtbl.Initialize$247.class) MethodHandle initialize;
    private final @See(dinput_h.IDirectInput8WVtbl.RunControlPanel$246.class) MethodHandle runControlPanel;
    //    private final IDirectInput8WVtbl.CreateDevice$243 createDevice;
    //    private final IDirectInput8WVtbl.EnumDevicesBySemantics enumDevicesBySemantics;
    //    private final IDirectInput8WVtbl.FindDevice$248 findDevice;
    //    private final IDirectInput8WVtbl.GetDeviceStatus$245 getDeviceStatus;

    // IUnknown Interface:
    private final MethodHandle addRef;
    //    private final IDirectInput8WVtbl.QueryInterface$240 queryInterface;
    //    private final IDirectInput8WVtbl.Release$242 release;

    private volatile Callback prevEnumDevices;
    private volatile Callback prevEnumObjects;

    public static DirectInput create() {

        try (MemorySegment interfacePtr = dinput_h.IDirectInput8W.allocate()) {

            int hres = dinput_h.DirectInput8Create(
                    Kernel32.GetModuleHandleW(),
                    dinput_h.DIRECTINPUT_VERSION(),
                    Guids.IID_IDirectInput8W,
                    interfacePtr,
                    MemoryAddress.NULL);

            if (hres == dinput_h.DI_OK()) {
                return createFromInterfacePtr(interfacePtr);
            } else {
                throw new IllegalArgumentException("Invocation failed. hresult:" + hres);
            }
        }
    }

    private static DirectInput8Impl createFromInterfacePtr(MemorySegment interfacePtr) {

        System.out.println("Interface struct ptr address: " + interfacePtr.address());

        MemorySegment interfaceStruct = dinput_h.IDirectInput8W
                .lpVtbl$get(interfacePtr)
                .asSegmentRestricted(dinput_h.IDirectInput8W.sizeof());

        return createFromInterfaceStruct(interfaceStruct);
    }

    private static DirectInput8Impl createFromInterfaceStruct(MemorySegment interfaceStruct) {
        System.out.println("Interface struct address: " + interfaceStruct.address());
        return new DirectInput8Impl(interfaceStruct);
    }

    private DirectInput8Impl(MemorySegment interfaceStruct) {
        this.interfaceStruct = interfaceStruct;
        this.iDirectInput8WVtbl = dinput_h.IDirectInput8W
                .lpVtbl$get(interfaceStruct)
                .asSegmentRestricted(dinput_h.IDirectInput8WVtbl.sizeof());

        this.addRef = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.AddRef$get(this.iDirectInput8WVtbl),
                dinput_h.IDirectInput8WVtbl.AddRef$241.func(),
                dinput_h.IDirectInput8WVtbl.AddRef$241.nativeMethodType(),
                false);

        this.configureDevices = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.ConfigureDevices$get(this.iDirectInput8WVtbl),
                dinput_h.IDirectInput8WVtbl.ConfigureDevices.func(),
                dinput_h.IDirectInput8WVtbl.ConfigureDevices.nativeMethodType(),
                false);

//        this.createDevice = RuntimeHelper.downcallHandle(
//                IDirectInput8WVtbl.CreateDevice$get(this.iDirectInput8WVtbl),
//                IDirectInput8WVtbl.CreateDevice$243.class,
//                IDirectInput8WVtbl.CreateDevice$243.func(),
//                "",
//                false);
//
        this.enumDevices = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInput8WVtbl.EnumDevices$get(this.iDirectInput8WVtbl),
                dinput_h.IDirectInput8WVtbl.EnumDevices$244.func(),
                dinput_h.IDirectInput8WVtbl.EnumDevices$244.nativeMethodType(),
                false);
//
//        this.enumDevicesBySemantics = RuntimeHelper.downcallHandle(
//                IDirectInput8WVtbl.EnumDevicesBySemantics$get(this.iDirectInput8WVtbl),
//                IDirectInput8WVtbl.EnumDevicesBySemantics.class,
//                IDirectInput8WVtbl.EnumDevicesBySemantics.func(),
//                "",
//                false);
//
//        this.findDevice = RuntimeHelper.downcallHandle(
//                IDirectInput8WVtbl.FindDevice$get(this.iDirectInput8WVtbl),
//                IDirectInput8WVtbl.FindDevice$248.class,
//                IDirectInput8WVtbl.FindDevice$248.func(),
//                "",
//                false);
//
//        this.getDeviceStatus = RuntimeHelper.downcallHandle(
//                IDirectInput8WVtbl.GetDeviceStatus$get(this.iDirectInput8WVtbl),
//                IDirectInput8WVtbl.GetDeviceStatus$245.class,
//                IDirectInput8WVtbl.GetDeviceStatus$245.func(),
//                false);
//
        this.initialize = dinput_h.IDirectInput8WVtbl.Initialize$247.downcall(
                dinput_h.IDirectInput8WVtbl.Initialize$get(this.iDirectInput8WVtbl)
        );

//
//        this.release = RuntimeHelper.downcallHandle(
//                IDirectInput8WVtbl.Release$get(this.iDirectInput8WVtbl),
//                IDirectInput8WVtbl.Release$242.class,
//                IDirectInput8WVtbl.Release$242.func(),
//                false);
//
//        this.runControlPanel = IDirectInput8WVtbl.RunControlPanel$246.downcall(
//                IDirectInput8WVtbl.RunControlPanel$get(this.iDirectInput8WVtbl)
//        );
        this.runControlPanel = symbol(dinput_h.IDirectInput8WVtbl::RunControlPanel$get, dinput_h.IDirectInput8WVtbl.RunControlPanel$246::downcall);
//
//        this.queryInterface = RuntimeHelper.downcallHandle(
//                IDirectInput8WVtbl.QueryInterface$get(this.iDirectInput8WVtbl),
//                IDirectInput8WVtbl.QueryInterface$240.class,
//                IDirectInput8WVtbl.QueryInterface$240.func(),
//                false);
    }

    private MethodHandle symbol(Function<MemorySegment, MemoryAddress> vtblLookup, Function<MemoryAddress, MethodHandle> mh) {
        MemoryAddress symbol = vtblLookup.apply(this.iDirectInput8WVtbl);
        return mh.apply(symbol);
    }

    private MemoryAddress self() {
        return interfaceStruct.address();
    }

    @Override
    public int CreateDevice(MemoryAddress deviceGuid, MemoryAddress out_lplpDirectInputDevice, MemoryAddress pUnkOuter) {
        //        return CreateDevice(deviceGuid, out_lplpDirectInputDevice, MemoryAddress.NULL);
        return -1;
    }

    public int EnumDevices(int dwDevType, MemoryAddress lpCallback, MemoryAddress pvRef, int dwFlags) {
        try {
            return (int) enumDevices.invokeExact(self(), dwDevType, lpCallback, pvRef, dwFlags);
        } catch (Throwable t) {
            throw new RuntimeException((t));
        }
    }

    @Override
    public int EnumDevicesBySemantics(MemoryAddress ptszUserName, MemoryAddress lpdiActionFormat, MemoryAddress lpCallback, MemoryAddress pvRef, int dwFlags) {
//        return enumDevicesBySemantics.apply(thiss.address(), ptszUserName.address(), lpdiActionFormat.address(), lpCallback.address(), pvRef.address(), dwFlags);
        return -1;
    }

    @Override
    public int FindDevice(MemoryAddress deviceClass, MemoryAddress name, MemoryAddress out_deviceGuid) {
//        return findDevice.apply(thiss.address(), deviceClass, name, out_deviceGuid);
        return -1;
    }

    @Override
    public int GetDeviceStatus(MemoryAddress guid) {
//        return getDeviceStatus.apply(thiss.address(), guid);
        return -1;
    }

    @Override
    public int Initialize(MemoryAddress hinstance, int version) {
        try {
            return (int) initialize.invokeExact(self(), hinstance, version);
        } catch (Throwable t) {
            t.printStackTrace();;
            return -1;
        }
    }

    @Override
    public int RunControlPanel(MemoryAddress hwndOwner, int flags) {
        try {
            return (int) runControlPanel.invokeExact(self(), hwndOwner, flags);
        } catch (Throwable t) {
            t.printStackTrace();;
            return -1;
        }
    }

}
