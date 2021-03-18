package net.viskar.library.dinput8.natives;

import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.MemoryAddress;
import net.viskar.library.dinput8.natives.dinput_h.IDirectInput8WVtbl;
import net.viskar.stubs.annotation.VStub;
import net.viskar.stubs.annotation.VMethod;

@VStub(
        lib = "C:\\Windows\\System32\\dinput8.dll",
        constants = dinput_h_constants_5.class,
        ifaceClass = dinput_h.IDirectInput8W.class,
        vtableClass = dinput_h.IDirectInput8WVtbl.class,
        vtableField = "lpVtbl"
)
public interface IDirectInput8WStub {

    @VMethod(IDirectInput8WVtbl.CreateDevice$243.class)
    int CreateDevice(MemoryAddress deviceGuid, MemoryAddress out_lplpDirectInputDevice, MemoryAddress pUnkOuter);

    @VMethod(IDirectInput8WVtbl.EnumDevices$244.class)
    int EnumDevices(int dwDevType, MemoryAddress lpCallback, Addressable pvRef, int dwFlags);

    @VMethod(IDirectInput8WVtbl.EnumDevicesBySemantics.class)
    int EnumDeviceBySemantics(MemoryAddress ptszUserName, MemoryAddress lpdiActionFormat, MemoryAddress lpCallback, MemoryAddress pvRef, int dwFlags);

    @VMethod(IDirectInput8WVtbl.FindDevice$248.class)
    int FindDevice(MemoryAddress deviceClass, MemoryAddress name, MemoryAddress out_deviceGuid);

    @VMethod(IDirectInput8WVtbl.GetDeviceStatus$245.class)
    int GetDeviceStatus(MemoryAddress guid);

    @VMethod(IDirectInput8WVtbl.Initialize$247.class)
    int Initialize(MemoryAddress hinstance, int version);

    @VMethod(IDirectInput8WVtbl.RunControlPanel$246.class)
    int RunControlPanel(MemoryAddress hwndOwner, int flags);

    public static void main(String[] args) {

    }

}
