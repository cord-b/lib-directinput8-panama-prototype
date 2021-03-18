package net.viskar.library.dinput8.internal;

import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
import net.viskar.library.dinput8.DirectInput8;
import net.viskar.library.dinput8.EnumDevicesCallback;
import net.viskar.library.dinput8.natives.dinput_h;

import java.util.Objects;

public class DirectInput8StaticImpl implements DirectInput8 {

    // Singleton holder
    static class Instance {
        static final DirectInput8StaticImpl INSTANCE = new DirectInput8StaticImpl();
    }

    private DirectInput8StaticImpl() {
        // singleton
    }

    public static DirectInput8 singleton() {
        DirectInput8StaticImpl instance = Instance.INSTANCE;
        instance.checkInitialized();
        return instance;
    }

    protected void checkInitialized() {
        Objects.requireNonNull(DirectInput8Static.self());
    }

    @Override
    public int CreateDevice(MemoryAddress deviceGuid, MemoryAddress out_lplpDirectInputDevice, MemoryAddress pUnkOuter) {
        return DirectInput8Static.CreateDevice(deviceGuid, out_lplpDirectInputDevice, pUnkOuter);
    }

    @Override
    public int EnumDevices(int dwDevType, Addressable pvRef, int dwFlags, EnumDevicesCallback deviceCallback) {
        return DirectInput8Static.EnumDevices(dwDevType, pvRef, dwFlags, deviceCallback);
    }

    @Override
    public int EnumDevices(int dwDevType, MemoryAddress lpCallback, MemoryAddress pvRef, int dwFlags) {
        return DirectInput8Static.EnumDevices(dwDevType, lpCallback, pvRef, dwFlags);
    }

    @Override
    public int EnumDevicesBySemantics(MemoryAddress ptszUserName, MemoryAddress lpdiActionFormat, MemoryAddress lpCallback, MemoryAddress pvRef, int dwFlags) {
        return DirectInput8Static.EnumDevicesBySemantics(ptszUserName, lpdiActionFormat, lpCallback, pvRef, dwFlags);
    }

    @Override
    public int FindDevice(MemoryAddress deviceClass, MemoryAddress name, MemoryAddress out_deviceGuid) {
        return DirectInput8Static.FindDevice(deviceClass, name, out_deviceGuid);
    }

    @Override
    public int GetDeviceStatus(MemoryAddress guid) {
        return DirectInput8Static.GetDeviceStatus(guid);
    }

    @Override
    public int Initialize(MemoryAddress hinstance, int version) {
        return DirectInput8Static.Initialize(hinstance, version);
    }

    @Override
    public int RunControlPanel(MemoryAddress hwndOwner, int flags) {
        return DirectInput8Static.RunControlPanel(hwndOwner, flags);
    }
}
