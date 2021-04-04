package dev.viskar.lib.dinput8;

import dev.viskar.lib.dinput8.internal.WindowsUtils;
import dev.viskar.lib.dinput8.natives.DataFormat;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;

import java.util.Objects;

public class DirectInputDevice8W extends dev.viskar.lib.dinput8.natives.IDirectInputDevice8W {

    public DirectInputDevice8W(MemoryAddress instanceAddr) {
        super(instanceAddr);
    }

    public DirectInputDevice8W(MemorySegment instanceStruct) {
        super(instanceStruct);
    }

    public static DirectInputDevice8W of(MemoryAddress address) {
        return new DirectInputDevice8W(address);
    }

    /**
     * Applications must specify either DISCL_FOREGROUND or DISCL_BACKGROUND; it is an error to specify both or neither.
     * Similarly, applications must specify either DISCL_EXCLUSIVE or DISCL_NONEXCLUSIVE.
     * <p>
     * If the system mouse is acquired in exclusive mode, the pointer is removed from the screen until the device is unacquired.
     * This applies only to a mouse created by passing GUID_SysMouse to IDirectInput8::CreateDevice.
     * <p>
     * Applications that select the background exclusive mode cooperative level are not guaranteed to retain access to the device if another application requests exclusive access.
     * When a background exclusive mode application loses access, calls to DirectInput device methods will fail and return DIERR_NOTACQUIRED.
     * The application can regain access to the device by manually unacquiring the device and reaquiring it.
     * <p>
     * Applications must call this method before acquiring the device by using the IDirectInputDevice8 Interface method.
     *
     * @param window  Window handle to be associated with the device. This parameter must be a valid top-level window handle that belongs to the process. The window associated with the device must not be destroyed while it is still active in a DirectInput device.
     * @param dwFlags Flags that describe the cooperative level associated with the device. The following flags are defined:<ul>
     *                <li>DISCL_BACKGROUND
     *                The application requires background access. If background access is granted, the device can be acquired at any time, even when the associated window is not the active window.</li>
     *                <li>DISCL_EXCLUSIVE
     *                The application requires exclusive access. If exclusive access is granted, no other instance of the device can obtain exclusive access to the device while it is acquired. However, nonexclusive access to the device is always permitted, even if another application has obtained exclusive access. An application that acquires the mouse or keyboard device in exclusive mode should always unacquire the devices when it receives WM_ENTERSIZEMOVE and WM_ENTERMENULOOP messages. Otherwise, the user cannot manipulate the menu or move and resize the window.</li>
     *                <li>DISCL_FOREGROUND
     *                The application requires foreground access. If foreground access is granted, the device is automatically unacquired when the associated window moves to the background.</li>
     *                <li>DISCL_NONEXCLUSIVE
     *                The application requires nonexclusive access. Access to the device does not interfere with other applications that are accessing the same device.</li>
     *                <li>DISCL_NOWINKEY
     *                Disable the Windows logo key. Setting this flag ensures that the user cannot inadvertently break out of the application. Note, however, that DISCL_NOWINKEY has no effect when the default action mapping user interface (UI) is displayed, and the Windows logo key will operate normally as long as that UI is present.</li></ul>
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED, E_HANDLE.
     */
    public int SetCooperativeLevel(java.awt.Window window, int dwFlags) {
        MemoryAddress hwnd = WindowsUtils.getHWnd(window);
        return SetCooperativeLevel(hwnd, dwFlags);
    }

    /**
     * Applications must specify either DISCL_FOREGROUND or DISCL_BACKGROUND; it is an error to specify both or neither.
     * Similarly, applications must specify either DISCL_EXCLUSIVE or DISCL_NONEXCLUSIVE.
     * <p>
     * If the system mouse is acquired in exclusive mode, the pointer is removed from the screen until the device is unacquired.
     * This applies only to a mouse created by passing GUID_SysMouse to IDirectInput8::CreateDevice.
     * <p>
     * Applications that select the background exclusive mode cooperative level are not guaranteed to retain access to the device if another application requests exclusive access.
     * When a background exclusive mode application loses access, calls to DirectInput device methods will fail and return DIERR_NOTACQUIRED.
     * The application can regain access to the device by manually unacquiring the device and reaquiring it.
     * <p>
     * Applications must call this method before acquiring the device by using the IDirectInputDevice8 Interface method.
     *
     * @param hwnd    Window handle to be associated with the device. This parameter must be a valid top-level window handle that belongs to the process. The window associated with the device must not be destroyed while it is still active in a DirectInput device.
     * @param dwFlags Flags that describe the cooperative level associated with the device. The following flags are defined:<ul>
     *                <li>DISCL_BACKGROUND
     *                The application requires background access. If background access is granted, the device can be acquired at any time, even when the associated window is not the active window.</li>
     *                <li>DISCL_EXCLUSIVE
     *                The application requires exclusive access. If exclusive access is granted, no other instance of the device can obtain exclusive access to the device while it is acquired. However, nonexclusive access to the device is always permitted, even if another application has obtained exclusive access. An application that acquires the mouse or keyboard device in exclusive mode should always unacquire the devices when it receives WM_ENTERSIZEMOVE and WM_ENTERMENULOOP messages. Otherwise, the user cannot manipulate the menu or move and resize the window.</li>
     *                <li>DISCL_FOREGROUND
     *                The application requires foreground access. If foreground access is granted, the device is automatically unacquired when the associated window moves to the background.</li>
     *                <li>DISCL_NONEXCLUSIVE
     *                The application requires nonexclusive access. Access to the device does not interfere with other applications that are accessing the same device.</li>
     *                <li>DISCL_NOWINKEY
     *                Disable the Windows logo key. Setting this flag ensures that the user cannot inadvertently break out of the application. Note, however, that DISCL_NOWINKEY has no effect when the default action mapping user interface (UI) is displayed, and the Windows logo key will operate normally as long as that UI is present.</li></ul>
     * @return If the method succeeds, the return value is DI_OK. If the method fails, the return value can be one of the following error values: DIERR_INVALIDPARAM, DIERR_NOTINITIALIZED, E_HANDLE.
     */
    public int SetCooperativeLevel(MemoryAddress hwnd, int dwFlags, Object ignore) {
        return SetCooperativeLevel(hwnd, dwFlags);
    }

    public int SetDataFormatDefault() {
        DataFormat defaultFormat = DataFormats.defaultDIJoystickFormat();
        Objects.requireNonNull(defaultFormat);
        return SetDataFormat(defaultFormat);
    }

    public int SetDataFormat(DataFormat dataFormat) {
        return SetDataFormat(dataFormat.address());
    }

    public int EnumObjects(int dwFlags, EnumObjectsCallback callback) {
        try (MemorySegment lpCallback = callback.allocate()) {
            return EnumObjects(lpCallback.address(), dwFlags);
        }
    }

    public int EnumObjects(MemoryAddress lpCallback, int dwFlags) {
        return EnumObjects(lpCallback, MemoryAddress.NULL, dwFlags);
    }

}

