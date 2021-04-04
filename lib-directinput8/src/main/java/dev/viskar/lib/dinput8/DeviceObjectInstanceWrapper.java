package dev.viskar.lib.dinput8;

import dev.viskar.lib.common.NativeString;
import dev.viskar.lib.dinput8.natives.DeviceObjectInstance;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;

public class DeviceObjectInstanceWrapper extends DeviceObjectInstance {

    private NativeString name;
    private GUID type;

    public DeviceObjectInstanceWrapper(MemoryAddress instanceAddr) {
        super(instanceAddr);
    }

    public DeviceObjectInstanceWrapper(MemorySegment instanceStruct) {
        super(instanceStruct);
    }

    public GUID getType() {
        if (type == null) {
            type = GUID.of(getGuidType());
        }
        return type;
    }

    public String getName() {
        if (name == null) {
            name = NativeString.wcharString(getTszName());
        }
        return name.toString();
    }
}
