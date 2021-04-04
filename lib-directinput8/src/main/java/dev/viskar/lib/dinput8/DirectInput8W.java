package dev.viskar.lib.dinput8;

import dev.viskar.lib.common.NativeString;
import dev.viskar.lib.dinput8.natives.ActionFormat;
import dev.viskar.lib.dinput8.natives.IDirectInput8WStatic;
import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;

import static dev.viskar.lib.dinput8.natives.dinput_h.*;

/**
 * Pretty wrapper interface on top of the generated impl.
 */
public class DirectInput8W {

    private static final DirectInput8W INSTANCE = new DirectInput8W();

    private DirectInput8W() {
        // singleton
    }

    public static final DirectInput8W getInstance() throws DirectInputException {
        return INSTANCE;
    }

    /**
     * Create a DirectInputDevice8W object.
     *
     * @param deviceInstance Device instance obtained from EnumDevicesCallback
     * @return The DirectInputDevice8W object
     * @throws DirectInputException if CreateDevice failed.
     */
    public final DirectInputDevice8W CreateDevice(DeviceInstanceWrapper deviceInstance) throws DirectInputException {
        try (TPointer outPointer = TPointer.allocate()) {
            int result = IDirectInput8WStatic.CreateDevice(deviceInstance.getGuidInstance().address(), outPointer.address(), MemoryAddress.NULL);
            DirectInputException.throwIfError(result);
            return DirectInputDevice8W.of(outPointer.getPointer());
        }
    }

    /**
     * All attached devices are enumerated
     * <p>
     * On Microsoft Windows XP, DirectInput enumerates only one mouse and one keyboard device, referred to as the system mouse and the system keyboard. These devices represent the combined output of all mice and keyboards respectively on a system. For information about how to read from multiple mice or keyboards individually on Windows XP, see the WM_INPUT documentation.
     *
     * @param callback A callback function to be called once for each device enumerated.
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED.
     */
    public final int EnumDevicesAll(EnumDevicesCallback callback) {
        return EnumDevices(DI8DEVCLASS_ALL(), DIEDFL_ATTACHEDONLY(), MemoryAddress.NULL, callback);
    }

    /**
     * All attached game controllers are enumerated
     * <p>
     * On Microsoft Windows XP, DirectInput enumerates only one mouse and one keyboard device, referred to as the system mouse and the system keyboard. These devices represent the combined output of all mice and keyboards respectively on a system. For information about how to read from multiple mice or keyboards individually on Windows XP, see the WM_INPUT documentation.
     *
     * @param callback A callback function to be called once for each device enumerated.
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED.
     */
    public final int EnumDevicesGameControllers(EnumDevicesCallback callback) {
        return EnumDevices(DI8DEVCLASS_GAMECTRL(), DIEDFL_ATTACHEDONLY(), MemoryAddress.NULL, callback);
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
    public final int EnumDevices(int dwDevType, EnumDevicesCallback callback) {
        return EnumDevices(dwDevType, DIEDFL_ATTACHEDONLY(), MemoryAddress.NULL, callback);
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
     * @param dwFlags        Flag value that specifies the scope of the enumeration. This parameter can be one or more of the following values:<ul>
     *                       <li>DIEDFL_ALLDEVICES All installed devices are enumerated. This is the default behavior.</li>
     *                       <li>DIEDFL_ATTACHEDONLY Only attached and installed devices.</li>
     *                       <li>DIEDFL_FORCEFEEDBACK Only devices that support force feedback.</li>
     *                       <li>DIEDFL_INCLUDEALIASES Include devices that are aliases for other devices.</li>
     *                       <li>DIEDFL_INCLUDEHIDDEN Include hidden devices. For more information about hidden devices, see DIDEVCAPS.</li>
     *                       <li>DIEDFL_INCLUDEPHANTOMS Include phantom (placeholder) devices.</li></ul>
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED.
     */
    public final int EnumDevices(int dwDevType, int dwFlags, EnumDevicesCallback deviceCallback) {
        return EnumDevices(dwDevType, dwFlags, MemoryAddress.NULL, deviceCallback);
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
    public final int EnumDevices(int dwDevType, int dwFlags, Addressable pvRef, EnumDevicesCallback2 deviceCallback) {
        try (MemorySegment lpCallback = deviceCallback.allocate()) {
            return EnumDevices(dwDevType, dwFlags, pvRef.address(), lpCallback);
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
    public final int EnumDevices(int dwDevType, int dwFlags, MemoryAddress pvRef, MemorySegment lpCallback) {
        return IDirectInput8WStatic.EnumDevices(dwDevType, lpCallback.address(), pvRef.address(), dwFlags);
    }

    /**
     * The keyboard and mouse are enumerated last.
     *
     * @param userName     String identifying the current user, or NULL to specify the user logged onto the system. The user name is taken into account when enumerating devices. A device with user mappings is preferred to a device without any user mappings. By default, devices in use by other users are not enumerated for this user.
     * @param actionFormat Address of a DIACTIONFORMAT structure that specifies the action map for which suitable devices are enumerated.
     * @param callback     Address of a callback function to be called once for each device enumerated. See DIEnumDevicesBySemanticsCallback.
     * @param dwFlags      Flag value that specifies the scope of the enumeration. This parameter can be one or more of the following values.<ul>
     *                     <li>DIEDBSFL_ATTACHEDONLY
     *                     Only attached and installed devices are enumerated.</li>
     *                     <li>DIEDBSFL_AVAILABLEDEVICES
     *                     Only unowned, installed devices are enumerated.</li>
     *                     <li>DIEDBSFL_FORCEFEEDBACK
     *                     Only devices that support force feedback are enumerated.</li>
     *                     <li>DIEDBSFL_MULTIMICEKEYBOARDS
     *                     Only secondary (non-system) keyboard and mouse devices.</li>
     *                     <li>DIEDBSFL_NONGAMINGDEVICES
     *                     Only HID-compliant devices whose primary purpose is not as a gaming device. Devices such as USB speakers and multimedia buttons on some keyboards would fall within this value.</li>
     *                     <li>DIEDBSFL_THISUSER
     *                     All installed devices for the user identified by ptszUserName, and all unowned devices, are enumerated.</li>
     *                     <li>DIEDBSFL_VALID
     *                     DIEDBSFL_VALID is also defined in Dinput.h, but is not used by applications.</li>
     *                     </ul>
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED.
     */
    public final int EnumDevicesBySemantics(String userName, ActionFormat actionFormat, int dwFlags, EnumDevicesBySemanticsCallback callback) {
        if (userName != null) {
            try (NativeString ns = NativeString.of(userName)) {
                return EnumDevicesBySemantics(ns.toWChars().address(), actionFormat, dwFlags, callback);
            }
        }
        return EnumDevicesBySemantics(MemoryAddress.NULL, actionFormat, dwFlags, callback);
    }

    private final int EnumDevicesBySemantics(MemoryAddress address, ActionFormat actionFormat, int dwFlags, EnumDevicesBySemanticsCallback callback) {
        try (MemorySegment callbackHandle = callback.allocate()) {
            return IDirectInput8WStatic.EnumDevicesBySemantics(address, actionFormat.address(), callbackHandle.address(), MemoryAddress.NULL, dwFlags);
        }
    }

    /**
     * Open Windows control panel
     *
     * @return
     */
    public final int RunControlPanel() {
        return RunControlPanel(MemoryAddress.NULL, 0);
    }

    /**
     * Open Windows control panel
     *
     * @return
     */
    public final int RunControlPanel(MemoryAddress hwndOwner) {
        return RunControlPanel(hwndOwner, 0);
    }

    /**
     * Open Windows control panel
     *
     * @return
     */
    public final int RunControlPanel(int dwFlags) {
        return RunControlPanel(MemoryAddress.NULL, dwFlags);
    }

    /**
     * Open Windows control panel
     *
     * @return
     */
    public final int RunControlPanel(MemoryAddress hwndOwner, int dwFlags) {
        return IDirectInput8WStatic.RunControlPanel(hwndOwner, dwFlags);
    }

    /**
     * Not needed
     *
     * @param hinstance
     * @return
     */
    public final int Initialize(MemoryAddress hinstance) {
        return IDirectInput8WStatic.Initialize(hinstance, DIRECTINPUT_VERSION());
    }

}
