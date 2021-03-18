package net.viskar.library.dinput8.natives;

import jdk.incubator.foreign.MemoryAddress;
import net.viskar.library.dinput8.DirectInput8;

public class IDirectInput8WSingleton implements DirectInput8 {
    private static final IDirectInput8WSingleton INSTANCE = new IDirectInput8WSingleton();

    private IDirectInput8WSingleton() {
    }

    public static final IDirectInput8WSingleton getInstance() {
        return INSTANCE;
    }

    public final int ConfigureDevices(MemoryAddress x0, MemoryAddress x1, int x2, MemoryAddress x3) {
        return IDirectInput8WStatic.ConfigureDevices(x0, x1, x2, x3);
    }

    public final int EnumDevicesBySemantics(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
                                            MemoryAddress x3, int x4) {
        return IDirectInput8WStatic.EnumDevicesBySemantics(x0, x1, x2, x3, x4);
    }

    public final int FindDevice(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2) {
        return IDirectInput8WStatic.FindDevice(x0, x1, x2);
    }

    public final int Initialize(MemoryAddress x0, int x1) {
        return IDirectInput8WStatic.Initialize(x0, x1);
    }

    public final int RunControlPanel(MemoryAddress x0, int x1) {
        return IDirectInput8WStatic.RunControlPanel(x0, x1);
    }

    public final int GetDeviceStatus(MemoryAddress x0) {
        return IDirectInput8WStatic.GetDeviceStatus(x0);
    }

    public final int EnumDevices(int x0, MemoryAddress x1, MemoryAddress x2, int x3) {
        return IDirectInput8WStatic.EnumDevices(x0, x1, x2, x3);
    }

    public final int CreateDevice(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2) {
        return IDirectInput8WStatic.CreateDevice(x0, x1, x2);
    }

    public final int Release() {
        return IDirectInput8WStatic.Release();
    }

    public final int AddRef() {
        return IDirectInput8WStatic.AddRef();
    }

    public final int QueryInterface(MemoryAddress x0, MemoryAddress x1) {
        return IDirectInput8WStatic.QueryInterface(x0, x1);
    }
}