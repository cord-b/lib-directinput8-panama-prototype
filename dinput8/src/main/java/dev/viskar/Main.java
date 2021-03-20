package dev.viskar;

import dev.viskar.lib.dinput8.natives.DirectInputGlobals;
import jdk.incubator.foreign.MemorySegment;
import dev.viskar.lib.dinput8.natives.dinput_h;
import dev.viskar.lib.dinput8.DirectInput;
import dev.viskar.lib.dinput8.DirectInputDevice;
import dev.viskar.lib.dinput8.Guids;
import dev.viskar.lib.dinput8.internal.NativeUtils;

import java.util.HexFormat;

public final class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("GuidX: " + HexFormat.of().formatHex(Guids.XAxis.toByteArray()));

        System.out.println("Constructed DirectInput8 wrapper:");
        DirectInput directInput = DirectInput.initialize();

        System.out.println("dataFormat:" + DirectInputGlobals.getDIJoystickDataFormat().address());
        System.out.println("dataFormat:" + DirectInputGlobals.getDIJoystickDataFormat().address());
        System.out.println("dataFormat:" + DirectInputGlobals.getDIJoystickDataFormat().address());

        System.out.println("Enum Devices:");
        log(directInput.EnumDevicesAll(deviceInstance -> {

            String productName = NativeUtils.stringFromWChars(deviceInstance.getTszProductName());
            String instanceName = NativeUtils.stringFromWChars(deviceInstance.getTszInstanceName());
            System.out.println("----------------------------------------");
            System.out.println("Product: " + productName);
            System.out.println("Instance: " + instanceName);

            DirectInputDevice device = directInput.CreateDevice(deviceInstance);
            System.out.println("device: " + device);
            if (device != null) {
                device.EnumObjects(dinput_h.DIDFT_ALL(), object -> {
                    String name = NativeUtils.stringFromWChars(object.getTszName());
                    MemorySegment guidType = object.getGuidType();
                    String guid = HexFormat.of().formatHex(guidType.toByteArray());
                    System.out.println(name + " : " + guid + " : " + Guids.XAxis.mismatch(guidType));
                    return dinput_h.DIENUM_CONTINUE();
                });
            }
            return dinput_h.DIENUM_CONTINUE();
        }));

        System.out.println("Showing control panel:");
        log(directInput.RunControlPanel());

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

}
