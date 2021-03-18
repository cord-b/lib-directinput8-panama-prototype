package net.viskar;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import net.viskar.library.dinput8.DirectInput8;
import net.viskar.library.dinput8.EnumDevicesCallback;
import net.viskar.library.dinput8.internal.NativeUtils;
import net.viskar.library.dinput8.natives.*;

import java.util.TreeMap;

public final class Main {

    private static final DirectInput8 directInput8 = IDirectInput8WSingleton.getInstance();

    public static void main(String[] args) throws Exception {

        System.out.println("Constructed DirectInput8 wrapper:");

        System.out.println("Enum Devices:");
        log(enumDevices((pDevice, pContext) -> {

            TDeviceInstance instance = new TDeviceInstance(pDevice);
            String productName = NativeUtils.stringFromWChars(instance.getTszProductName());
            String instanceName = NativeUtils.stringFromWChars(instance.getTszInstanceName());

            try (TPointer deviceRef = TPointer.allocate()) {
                directInput8.CreateDevice(instance.getGuidInstance(), deviceRef);
                IDirectInputDevice8WInstance deviceInstance = new IDirectInputDevice8WInstance(deviceRef.getPointer());

                System.out.println("Acquire:");
                log(deviceInstance.Acquire());
                System.out.println("After Acquire");
            }

            //MemorySegment segment = pDevice.asSegmentRestricted(dinput_h.DIDEVICEINSTANCEW.sizeof());
//            String productName = NativeUtils.stringFromWChars(dinput_h.DIDEVICEINSTANCEW.tszProductName$slice(segment));
//            String instanceName = NativeUtils.stringFromWChars(dinput_h.DIDEVICEINSTANCEW.tszInstanceName$slice(segment));
            System.out.println("Product: " + productName);
            System.out.println("Instance: " + instanceName);
            return 1;
        }));

        System.out.println("Showing control panel:");
        log(directInput8.RunControlPanel());

        Thread.sleep(60_000);
        System.exit(0);
    }

    static void log(int hres) {
        if (hres != dinput_h.DI_OK()) {
            NativeUtils.logError(hres);
        } else {
            System.out.println("Success");
        }
    }

    static int enumDevices(EnumDevicesCallback callback) {
        return directInput8.EnumDevices(dinput_h.DI8DEVCLASS_ALL(), MemoryAddress.NULL, dinput_h.DIEDFL_ATTACHEDONLY(), callback);
    }

}
