package dev.viskar.lib.dinput8;

import jdk.incubator.foreign.MemoryAddress;

@FunctionalInterface
public interface EnumObjectsCallback extends EnumObjectsCallback2 {

    @Override
    default int apply(DeviceObjectInstanceWrapper deviceObjectInfo, MemoryAddress pContent) {
        return apply(deviceObjectInfo);
    }

    int apply(DeviceObjectInstanceWrapper deviceObjectInfo);

}
