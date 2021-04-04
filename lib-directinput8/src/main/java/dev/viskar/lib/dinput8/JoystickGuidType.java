package dev.viskar.lib.dinput8;

import jdk.incubator.foreign.MemorySegment;

public enum JoystickGuidType {

    X_AXIS(GUID.XAxis),
    Y_AXIS(GUID.YAxis),
    Z_AXIS(GUID.ZAxis),
    RX_AXIS(GUID.RxAxis),
    RY_AXIS(GUID.RyAxis),
    RZ_AXIS(GUID.RzAxis),
    SLIDER(GUID.Slider),
    BUTTON(GUID.Button),
    POV(GUID.POV);

    private final GUID guid;
    private static JoystickGuidType[] VALUES = values();

    JoystickGuidType(GUID guid) {
        this.guid = guid;
    }

    public GUID guid() {
        return guid;
    }

    public static JoystickGuidType of(MemorySegment segment) {
        for (JoystickGuidType value : VALUES) {
            if (value.guid.equalsMemory(segment)) {
                return value;
            }
        }
        return null;
    }

    public static JoystickGuidType of(GUID guid) {
        return of(guid.self());
    }

}
