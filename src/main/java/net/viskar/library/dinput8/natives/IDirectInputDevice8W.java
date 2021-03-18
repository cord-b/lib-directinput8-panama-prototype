package net.viskar.library.dinput8.natives;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;

public interface IDirectInputDevice8W {

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

    int EnumObjects(MemoryAddress x0, MemoryAddress x1, int x2);

    int GetCapabilities(MemoryAddress x0);

    int Release();

    int AddRef();

    int QueryInterface(MemoryAddress x0, MemoryAddress x1);

}

