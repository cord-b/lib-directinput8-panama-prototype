package dev.viskar.lib.dinput8;

import dev.viskar.lib.dinput8.natives.JoystickState;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout.PathElement;
import jdk.incubator.foreign.MemorySegment;

import java.lang.invoke.VarHandle;

public class JoystickStateWrapper extends JoystickState {

    private static final VarHandle rgbButtons = layout().varHandle(byte.class, PathElement.groupElement("rgbButtons"), PathElement.sequenceElement());
    private static final VarHandle rgdwPOV = layout().varHandle(int.class, PathElement.groupElement("rgdwPOV"), PathElement.sequenceElement());
    private static final VarHandle rglSlider = layout().varHandle(int.class, PathElement.groupElement("rglSlider"), PathElement.sequenceElement());

    public JoystickStateWrapper(MemoryAddress instanceAddr) {
        super(instanceAddr);
    }

    public JoystickStateWrapper(MemorySegment instanceStruct) {
        super(instanceStruct);
    }

    public byte getButton(int id) {
        if (id < 0 || id >= 32) {
            return 0;
        }
        return (byte) rgbButtons.get(self(), id);
    }

    public int getPOV(int id) {
        if (id < 0 || id >= 4) {
            return 0;
        }
        return (int) rgdwPOV.get(self(), id);
    }

    public int getSlider(int id) {
        if (id < 0 || id >= 2) {
            return 0;
        }
        return (int) rglSlider.get(self(), id);
    }

}
