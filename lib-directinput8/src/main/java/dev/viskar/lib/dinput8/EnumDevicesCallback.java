package dev.viskar.lib.dinput8;

import jdk.incubator.foreign.MemoryAddress;

@FunctionalInterface
public interface EnumDevicesCallback extends EnumDevicesCallback2 {

    @Override
    default int apply(DeviceInstanceWrapper deviceInstance, MemoryAddress context) {
        return apply(deviceInstance);
    }

    int apply(DeviceInstanceWrapper deviceInstance);

}

