package dev.viskar.lib.dinput8;

import dev.viskar.lib.dinput8.natives.dinput_h;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.NativeScope;

public interface EnumDevicesBySemanticsCallback extends dinput_h.LPDIENUMDEVICESBYSEMANTICSCBA {

    @Override
    default int apply(MemoryAddress pDeviceInstance, MemoryAddress pDevice, int dwFlags, int dwRemaining, MemoryAddress pvRef) {
        DeviceInstanceWrapper deviceInstance = new DeviceInstanceWrapper(pDeviceInstance);
        DirectInputDevice8W device = DirectInputDevice8W.of(pDevice);
        return apply(deviceInstance, device, dwFlags,dwRemaining);
    }

    /**
     * If a single hardware device can function as more than one DirectInput device type, it is enumerated as each device type that it supports.
     * For example, a keyboard with a built-in mouse is enumerated twice: once as a keyboard and once as a mouse.
     * The product globally unique identifier (GUID) is the same for each device, however.
     *
     * @param deviceInstance A DIDEVICEINSTANCE structure that describes the device instance.
     * @param device         The IDirectInputDevice8 Interface interface for the device.
     * @param dwFlags        Flags that provide information about why the device is being enumerated. This can be a combination of action-mapping flags and one usage flag. At least one action-mapping flag is always present.
     *                       <p>
     *                       The DIEDBS_MAPPEDPRI1 and DIEDBS_MAPPEDPRI2 action-mapping flags and the DIEDBS_RECENTDEVICE and DIEDBS_NEWDEVICE usage flags are defined below.
     *                       <p>
     *                       DIEDBS_MAPPEDPRI1
     *                       The device is being enumerated because priority 1 actions can be mapped to the device.
     *                       DIEDBS_MAPPEDPRI2
     *                       The device is being enumerated because priority 2 actions can be mapped to the device.
     *                       DIEDBS_RECENTDEVICE
     *                       The device is being enumerated because the commands described by the action-mapping flags were recently used.
     *                       DIEDBS_NEWDEVICE
     *                       The device is being enumerated because the device was installed recently. Devices described by this flag have not been used with this game before.
     * @param dwRemaining    Number of devices, after this one, remaining to be enumerated.
     * @param pvRef          The application-defined value passed to IDirectInput8::EnumDevicesBySemantics as the pvRef parameter.
     * @return Returns DIENUM_CONTINUE to continue the enumeration or DIENUM_STOP to stop the enumeration.
     */
    int apply(DeviceInstanceWrapper deviceInstance, DirectInputDevice8W device, int dwFlags, int dwRemaining);

    default MemorySegment allocate() {
        return dinput_h.LPDIENUMDEVICESBYSEMANTICSCBA.allocate(this);
    }

    /**
     * Allocate the cfunction pointer for registering this callback.
     */
    default MemorySegment allocate(NativeScope scope) {
        return dinput_h.LPDIENUMDEVICESBYSEMANTICSCBA.allocate(this, scope);
    }
}
