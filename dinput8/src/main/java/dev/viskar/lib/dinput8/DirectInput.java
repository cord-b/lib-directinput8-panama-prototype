package dev.viskar.lib.dinput8;

import dev.viskar.lib.dinput8.natives.TPointer;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import dev.viskar.lib.dinput8.natives.dinput_h;
import net.viskar.library.dinput8.natives.*;

/**
 * Pretty wrapper interface on top of the generated impl.
 */
public interface DirectInput {

    static DirectInput initialize() {
        return IDirectInput8WSingleton.getInstance();
    }

    default DirectInputDevice CreateDevice(TDIDEVICEINSTANCEW deviceInstance) {
        try (TPointer outPointer = TPointer.allocate()) {
            int result = CreateDevice(deviceInstance.getGuidInstance().address(), outPointer.address(), MemoryAddress.NULL);
            if (result == dinput_h.DI_OK()) {
                return new IDirectInputDevice8WInstance(outPointer.getPointer());
            } else {
                return null;
            }
        }
    }

    int CreateDevice(MemoryAddress deviceGuid, MemoryAddress out_lplpDirectInputDevice, MemoryAddress pUnkOuter);

    /**
     * All attached devices are enumerated
     * <p>
     * On Microsoft Windows XP, DirectInput enumerates only one mouse and one keyboard device, referred to as the system mouse and the system keyboard. These devices represent the combined output of all mice and keyboards respectively on a system. For information about how to read from multiple mice or keyboards individually on Windows XP, see the WM_INPUT documentation.
     *
     * @param callback A callback function to be called once for each device enumerated.
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED.
     */
    default int EnumDevicesAll(EnumDevicesCallback callback) {
        return EnumDevices(dinput_h.DI8DEVCLASS_ALL(), callback);
    }

    /**
     * All attached game controllers are enumerated
     * <p>
     * On Microsoft Windows XP, DirectInput enumerates only one mouse and one keyboard device, referred to as the system mouse and the system keyboard. These devices represent the combined output of all mice and keyboards respectively on a system. For information about how to read from multiple mice or keyboards individually on Windows XP, see the WM_INPUT documentation.
     *
     * @param callback A callback function to be called once for each device enumerated.
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED.
     */
    default int EnumDevicesGameControllers(EnumDevicesCallback callback) {
        return EnumDevices(dinput_h.DI8DEVCLASS_GAMECTRL(), callback);
    }

    /**
     * Remarks
     * All installed devices can be enumerated, even if they are not present. For example, a flight stick might be installed on the system but not currently plugged into the computer. Set the dwFlags parameter to indicate whether only attached or all installed devices should be enumerated. If the DIEDFL_ATTACHEDONLY flag is not present, all installed devices are enumerated.
     * <p>
     * A preferred device type can be passed as a dwDevType filter so that only the devices of that type are enumerated.
     * <p>
     * On Microsoft Windows XP, DirectInput enumerates only one mouse and one keyboard device, referred to as the system mouse and the system keyboard. These devices represent the combined output of all mice and keyboards respectively on a system. For information about how to read from multiple mice or keyboards individually on Windows XP, see the WM_INPUT documentation.
     *
     * @param dwDevType Device type filter. To restrict the enumeration to a particular type of device, set this parameter to a DI8DEVTYPE_* value. See DIDEVICEINSTANCE. To enumerate a class of devices, use one of the following values.:<ul></ul>
     *                  <li>DI8DEVCLASS_ALL All devices.</li>
     *                  <li>DI8DEVCLASS_DEVICE All devices that do not fall into another class.</li>
     *                  <li>DI8DEVCLASS_GAMECTRL All game controllers.</li>
     *                  <li>DI8DEVCLASS_KEYBOARD All keyboards. Equivalent to DI8DEVTYPE_KEYBOARD.</li>
     *                  <li>DI8DEVCLASS_POINTER All devices of type DI8DEVTYPE_MOUSE and DI8DEVTYPE_SCREENPOINTER.</li></ul>
     * @param callback  Address of a callback function to be called once for each device enumerated. See DIEnumDevicesCallback.
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED.
     */
    default int EnumDevices(int dwDevType, EnumDevicesCallback callback) {
        return EnumDevices(dwDevType, MemoryAddress.NULL, dinput_h.DIEDFL_ATTACHEDONLY(), callback);
    }

    /**
     * Remarks
     * All installed devices can be enumerated, even if they are not present. For example, a flight stick might be installed on the system but not currently plugged into the computer. Set the dwFlags parameter to indicate whether only attached or all installed devices should be enumerated. If the DIEDFL_ATTACHEDONLY flag is not present, all installed devices are enumerated.
     * <p>
     * A preferred device type can be passed as a dwDevType filter so that only the devices of that type are enumerated.
     * <p>
     * On Microsoft Windows XP, DirectInput enumerates only one mouse and one keyboard device, referred to as the system mouse and the system keyboard. These devices represent the combined output of all mice and keyboards respectively on a system. For information about how to read from multiple mice or keyboards individually on Windows XP, see the WM_INPUT documentation.
     *
     * @param dwDevType      Device type filter. To restrict the enumeration to a particular type of device, set this parameter to a DI8DEVTYPE_* value. See DIDEVICEINSTANCE. To enumerate a class of devices, use one of the following values.:<ul></ul>
     *                       <li>DI8DEVCLASS_ALL All devices.</li>
     *                       <li>DI8DEVCLASS_DEVICE All devices that do not fall into another class.</li>
     *                       <li>DI8DEVCLASS_GAMECTRL All game controllers.</li>
     *                       <li>DI8DEVCLASS_KEYBOARD All keyboards. Equivalent to DI8DEVTYPE_KEYBOARD.</li>
     *                       <li>DI8DEVCLASS_POINTER All devices of type DI8DEVTYPE_MOUSE and DI8DEVTYPE_SCREENPOINTER.</li></ul>
     * @param deviceCallback A callback function to be called once for each device enumerated. See DIEnumDevicesCallback.
     * @param pvRef          Application-defined 32-bit value to be passed to the enumeration callback each time it is called.
     * @param dwFlags        Flag value that specifies the scope of the enumeration. This parameter can be one or more of the following values:<ul>
     *                       <li>DIEDFL_ALLDEVICES All installed devices are enumerated. This is the default behavior.</li>
     *                       <li>DIEDFL_ATTACHEDONLY Only attached and installed devices.</li>
     *                       <li>DIEDFL_FORCEFEEDBACK Only devices that support force feedback.</li>
     *                       <li>DIEDFL_INCLUDEALIASES Include devices that are aliases for other devices.</li>
     *                       <li>DIEDFL_INCLUDEHIDDEN Include hidden devices. For more information about hidden devices, see DIDEVCAPS.</li>
     *                       <li>DIEDFL_INCLUDEPHANTOMS Include phantom (placeholder) devices.</li></ul>
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED.
     */
    default int EnumDevices(int dwDevType, Addressable pvRef, int dwFlags, EnumDevicesCallback deviceCallback) {
        try (MemorySegment lpCallback = deviceCallback.allocate()) {
            return EnumDevices(dwDevType, lpCallback, pvRef, dwFlags);
        }
    }

    /**
     * Remarks
     * All installed devices can be enumerated, even if they are not present. For example, a flight stick might be installed on the system but not currently plugged into the computer. Set the dwFlags parameter to indicate whether only attached or all installed devices should be enumerated. If the DIEDFL_ATTACHEDONLY flag is not present, all installed devices are enumerated.
     * <p>
     * A preferred device type can be passed as a dwDevType filter so that only the devices of that type are enumerated.
     * <p>
     * On Microsoft Windows XP, DirectInput enumerates only one mouse and one keyboard device, referred to as the system mouse and the system keyboard. These devices represent the combined output of all mice and keyboards respectively on a system. For information about how to read from multiple mice or keyboards individually on Windows XP, see the WM_INPUT documentation.
     *
     * @param dwDevType  Device type filter. To restrict the enumeration to a particular type of device, set this parameter to a DI8DEVTYPE_* value. See DIDEVICEINSTANCE. To enumerate a class of devices, use one of the following values.:<ul></ul>
     *                   <li>DI8DEVCLASS_ALL All devices.</li>
     *                   <li>DI8DEVCLASS_DEVICE All devices that do not fall into another class.</li>
     *                   <li>DI8DEVCLASS_GAMECTRL All game controllers.</li>
     *                   <li>DI8DEVCLASS_KEYBOARD All keyboards. Equivalent to DI8DEVTYPE_KEYBOARD.</li>
     *                   <li>DI8DEVCLASS_POINTER All devices of type DI8DEVTYPE_MOUSE and DI8DEVTYPE_SCREENPOINTER.</li></ul>
     * @param lpCallback Address of a callback function to be called once for each device enumerated. See DIEnumDevicesCallback.
     * @param pvRef      Application-defined 32-bit value to be passed to the enumeration callback each time it is called.
     * @param dwFlags    Flag value that specifies the scope of the enumeration. This parameter can be one or more of the following values:<ul>
     *                   <li>DIEDFL_ALLDEVICES All installed devices are enumerated. This is the default behavior.</li>
     *                   <li>DIEDFL_ATTACHEDONLY Only attached and installed devices.</li>
     *                   <li>DIEDFL_FORCEFEEDBACK Only devices that support force feedback.</li>
     *                   <li>DIEDFL_INCLUDEALIASES Include devices that are aliases for other devices.</li>
     *                   <li>DIEDFL_INCLUDEHIDDEN Include hidden devices. For more information about hidden devices, see DIDEVCAPS.</li>
     *                   <li>DIEDFL_INCLUDEPHANTOMS Include phantom (placeholder) devices.</li></ul>
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED.
     */
    default int EnumDevices(int dwDevType, MemorySegment lpCallback, Addressable pvRef, int dwFlags) {
        return EnumDevices(dwDevType, lpCallback.address(), pvRef.address(), dwFlags);
    }

    /**
     * Remarks
     * All installed devices can be enumerated, even if they are not present. For example, a flight stick might be installed on the system but not currently plugged into the computer. Set the dwFlags parameter to indicate whether only attached or all installed devices should be enumerated. If the DIEDFL_ATTACHEDONLY flag is not present, all installed devices are enumerated.
     * <p>
     * A preferred device type can be passed as a dwDevType filter so that only the devices of that type are enumerated.
     * <p>
     * On Microsoft Windows XP, DirectInput enumerates only one mouse and one keyboard device, referred to as the system mouse and the system keyboard. These devices represent the combined output of all mice and keyboards respectively on a system. For information about how to read from multiple mice or keyboards individually on Windows XP, see the WM_INPUT documentation.
     *
     * @param dwDevType  Device type filter. To restrict the enumeration to a particular type of device, set this parameter to a DI8DEVTYPE_* value. See DIDEVICEINSTANCE. To enumerate a class of devices, use one of the following values.:<ul></ul>
     *                   <li>DI8DEVCLASS_ALL All devices.</li>
     *                   <li>DI8DEVCLASS_DEVICE All devices that do not fall into another class.</li>
     *                   <li>DI8DEVCLASS_GAMECTRL All game controllers.</li>
     *                   <li>DI8DEVCLASS_KEYBOARD All keyboards. Equivalent to DI8DEVTYPE_KEYBOARD.</li>
     *                   <li>DI8DEVCLASS_POINTER All devices of type DI8DEVTYPE_MOUSE and DI8DEVTYPE_SCREENPOINTER.</li></ul>
     * @param lpCallback Address of a callback function to be called once for each device enumerated. See DIEnumDevicesCallback.
     * @param pvRef      Application-defined 32-bit value to be passed to the enumeration callback each time it is called.
     * @param dwFlags    Flag value that specifies the scope of the enumeration. This parameter can be one or more of the following values:<ul>
     *                   <li>DIEDFL_ALLDEVICES All installed devices are enumerated. This is the default behavior.</li>
     *                   <li>DIEDFL_ATTACHEDONLY Only attached and installed devices.</li>
     *                   <li>DIEDFL_FORCEFEEDBACK Only devices that support force feedback.</li>
     *                   <li>DIEDFL_INCLUDEALIASES Include devices that are aliases for other devices.</li>
     *                   <li>DIEDFL_INCLUDEHIDDEN Include hidden devices. For more information about hidden devices, see DIDEVCAPS.</li>
     *                   <li>DIEDFL_INCLUDEPHANTOMS Include phantom (placeholder) devices.</li></ul>
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED.
     */
    int EnumDevices(int dwDevType, MemoryAddress lpCallback, MemoryAddress pvRef, int dwFlags);

    /**
     * The keyboard and mouse are enumerated last.
     *
     * @param ptszUserName     String identifying the current user, or NULL to specify the user logged onto the system. The user name is taken into account when enumerating devices. A device with user mappings is preferred to a device without any user mappings. By default, devices in use by other users are not enumerated for this user.
     * @param lpdiActionFormat Address of a DIACTIONFORMAT structure that specifies the action map for which suitable devices are enumerated.
     * @param lpCallback       Address of a callback function to be called once for each device enumerated. See DIEnumDevicesBySemanticsCallback.
     * @param pvRef            Application-defined 32-bit value to pass to the enumeration callback each time it is called.
     * @param dwFlags          Flag value that specifies the scope of the enumeration. This parameter can be one or more of the following values.<ul>
     *                         <li>DIEDBSFL_ATTACHEDONLY
     *                         Only attached and installed devices are enumerated.</li>
     *                         <li>DIEDBSFL_AVAILABLEDEVICES
     *                         Only unowned, installed devices are enumerated.</li>
     *                         <li>DIEDBSFL_FORCEFEEDBACK
     *                         Only devices that support force feedback are enumerated.</li>
     *                         <li>DIEDBSFL_MULTIMICEKEYBOARDS
     *                         Only secondary (non-system) keyboard and mouse devices.</li>
     *                         <li>DIEDBSFL_NONGAMINGDEVICES
     *                         Only HID-compliant devices whose primary purpose is not as a gaming device. Devices such as USB speakers and multimedia buttons on some keyboards would fall within this value.</li>
     *                         <li>DIEDBSFL_THISUSER
     *                         All installed devices for the user identified by ptszUserName, and all unowned devices, are enumerated.</li>
     *                         <li>DIEDBSFL_VALID
     *                         DIEDBSFL_VALID is also defined in Dinput.h, but is not used by applications.</li>
     *                         </ul>
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED.
     */
    default int EnumDevicesBySemantics(Addressable ptszUserName, MemorySegment lpdiActionFormat, MemorySegment lpCallback, Addressable pvRef, int dwFlags) {
        return EnumDevicesBySemantics(ptszUserName.address(), lpdiActionFormat.address(), lpCallback.address(), pvRef.address(), dwFlags);
    }

    int EnumDevicesBySemantics(MemoryAddress ptszUserName, MemoryAddress lpdiActionFormat, MemoryAddress lpCallback, MemoryAddress pvRef, int dwFlags);

    int FindDevice(MemoryAddress deviceClass, MemoryAddress name, MemoryAddress out_deviceGuid);

    int GetDeviceStatus(MemoryAddress guid);

    default int Initialize(MemoryAddress hinstance) {
        return Initialize(hinstance, dinput_h.DIRECTINPUT_VERSION());
    }

    int Initialize(MemoryAddress hinstance, int version);

    default int RunControlPanel() {
        return RunControlPanel(MemoryAddress.NULL, 0);
    }

    default int RunControlPanel(MemoryAddress hwndOwner) {
        return RunControlPanel(hwndOwner, 0);
    }

    default int RunControlPanel(int dwFlags) {
        return RunControlPanel(MemoryAddress.NULL, dwFlags);
    }

    int RunControlPanel(MemoryAddress hwndOwner, int flags);

}
