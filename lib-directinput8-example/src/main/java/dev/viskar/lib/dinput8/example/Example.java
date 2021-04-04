package dev.viskar.lib.dinput8.example;

import dev.viskar.lib.dinput8.DataFormats;
import dev.viskar.lib.dinput8.DirectInput8W;
import dev.viskar.lib.dinput8.DirectInputDevice8W;
import dev.viskar.lib.dinput8.GUID;
import dev.viskar.lib.dinput8.JoystickGuidType;

import java.awt.Frame;
import java.util.HexFormat;

import static dev.viskar.lib.dinput8.natives.dinput_h.*;

/*
    VM Options:
    --add-modules jdk.incubator.foreign
    -Dforeign.restricted=permit
    --add-exports java.desktop/sun.awt.windows=ALL-UNNAMED
    --add-opens java.desktop/sun.awt.windows=ALL-UNNAMED
    --illegal-access=permit
 */
public final class Example {

    public static void main(String[] args) throws Exception {

        // Frame so we can get HWnd
        Frame window = new Frame();
        window.setSize(10, 10);
        window.setVisible(true);

        System.out.println("GuidX: " + GUID.XAxis);

        System.out.println("Constructed DirectInput8 wrapper:");
        DirectInput8W directInput = DirectInput8W.getInstance();

        System.out.println("dataFormat:" + DataFormats.defaultDIJoystickFormat());

        System.out.println("Enum Devices:");
        log(directInput.EnumDevicesAll(deviceInstance -> {

            System.out.println("-------------deviceInstance-----------------");
            DirectInputDevice8W device = directInput.CreateDevice(deviceInstance);
            System.out.println("Create Device: success");
            System.out.println("Product: " + deviceInstance.getProductName());
            System.out.println("Instance: " + deviceInstance.getInstanceName());

//          System.out.print("Set co-op level:");
//          log(device.SetCooperativeLevel(window, DISCL_NONEXCLUSIVE() | DISCL_BACKGROUND()));

            device.EnumObjects(DIDFT_ALL(), deviceObjectInfo -> {
                String name = deviceObjectInfo.getName();
                GUID deviceObjectGuid = deviceObjectInfo.getType();
                JoystickGuidType joystickObjectType = JoystickGuidType.of(deviceObjectGuid);
                System.out.println(name + " : " + deviceObjectGuid + " : " + joystickObjectType);
                return DIENUM_CONTINUE();
            });

            return DIENUM_CONTINUE();
        }));

        System.out.println("Showing control panel:");
        log(directInput.RunControlPanel());

        Thread.sleep(60_000);
        System.exit(0);
    }

    static void log(int hres) {
        if (hres != DI_OK()) {
            logError(hres);
        } else {
            System.out.println("Success");
        }
    }

    public static void logError(int hres) {
        System.out.println("Failed: " + HexFormat.of().toHexDigits(hres));
    }

}
