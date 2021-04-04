package dev.viskar.lib.dinput8;

import dev.viskar.lib.dinput8.natives.DataFormat;
import dev.viskar.lib.dinput8.natives.DirectInputGlobals;
import dev.viskar.lib.dinput8.natives.JoystickState;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.NativeScope;

/**
 * Use to configer a {@link DirectInputDevice8W}'s data format.
 *
 * @see DirectInputDevice8W#SetDataFormat(DeviceDataFormat)
 */
public class DataFormats {

    private static final MemoryAddress dfDIJoystick = DirectInputGlobals.dfDIJoystick();
    private static final DataFormat dfDIJoystickFormat = dfDIJoystick == null
            ? null
            : new DataFormat((dfDIJoystick));

    /**
     * The default Joystick data format instance known as <code>dfDIJoystick</code>.
     * <p>
     * If this dataformat is used, then {@link DirectInputDevice8W#GetDeviceState} emit data in the shape of {@link JoystickState}.
     */
    public static DataFormat defaultDIJoystickFormat() {
        return dfDIJoystickFormat;
    }

    /**
     * Allocate an instance of this struct, to be used for building a custom DeviceDataFormat.
     */
    public static DataFormat allocate(NativeScope scope) {
        int size = (int) DataFormat.sizeof();
        DataFormat struct = new DataFormat(scope.allocate(size));
        struct.setDwDataSize(size);
        return struct;
    }

}
