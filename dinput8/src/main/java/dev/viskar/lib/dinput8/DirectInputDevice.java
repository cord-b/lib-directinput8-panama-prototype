package dev.viskar.lib.dinput8;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;

public interface DirectInputDevice {

    static DirectInputDevice of(MemoryAddress address) {
        return new IDirectInputDevice8WInstance(address);
    }

    int GetImageInfo(MemoryAddress x0);

    int SetActionMap(MemoryAddress x0, MemoryAddress x1, int x2);

    int BuildActionMap(MemoryAddress x0, MemoryAddress x1, int x2);

    int WriteEffectToFile(MemoryAddress x0, int x1, MemoryAddress x2, int x3);

    int EnumEffectsInFile(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2, int x3);

    int SendDeviceData(int x0, MemoryAddress x1, MemoryAddress x2, int x3);

    int Poll();

    int Escape(MemoryAddress x0);

    int EnumCreatedEffectObjects(MemoryAddress x0, MemoryAddress x1, int x2);

    int SendForceFeedbackCommand(int x0);

    int GetForceFeedbackState(MemoryAddress x0);

    int GetEffectInfo(MemoryAddress x0, MemoryAddress x1);

    int EnumEffects(MemoryAddress x0, MemoryAddress x1, int x2);

    int CreateEffect(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
                     MemoryAddress x3);

    int Initialize(MemoryAddress x0, int x1, MemoryAddress x2);

    int RunControlPanel(MemoryAddress x0, int x1);

    int GetDeviceInfo(MemoryAddress x0);

    int GetObjectInfo(MemoryAddress x0, int x1, int x2);

    int SetCooperativeLevel(MemoryAddress x0, int x1);

    int SetEventNotification(MemoryAddress x0);

    int SetDataFormat(MemoryAddress x0);

    int GetDeviceData(int x0, MemoryAddress x1, MemoryAddress x2, int x3);

    int GetDeviceState(int x0, MemoryAddress x1);

    int Unacquire();

    int Acquire();

    int SetProperty(MemoryAddress x0, MemoryAddress x1);

    int GetProperty(MemoryAddress x0, MemoryAddress x1);

    default int EnumObjects(int dwFlags, EnumObjectsCallback callback) {
        try (MemorySegment lpCallback = callback.allocate()) {
            return EnumObjects(lpCallback.address(), dwFlags);
        }
    }

    default int EnumObjects(MemoryAddress lpCallback, int dwFlags) {
        return EnumObjects(lpCallback, MemoryAddress.NULL, dwFlags);
    }

    int EnumObjects(MemoryAddress lpCallback, MemoryAddress pvRef, int dwFlags);

    int GetCapabilities(MemoryAddress x0);

    int Release();

    int AddRef();

    int QueryInterface(MemoryAddress x0, MemoryAddress x1);

}

