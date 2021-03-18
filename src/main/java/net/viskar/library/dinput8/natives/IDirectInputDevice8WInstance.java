package net.viskar.library.dinput8.natives;

import java.lang.invoke.MethodHandle;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;
import net.viskar.library.dinput8.internal.RuntimeHelper;

public class IDirectInputDevice8WInstance implements IDirectInputDevice8W {
    private final MemorySegment _self;

    private final MemorySegment _vtable;

    private final MethodHandle _GetImageInfo;

    private final MethodHandle _SetActionMap;

    private final MethodHandle _BuildActionMap;

    private final MethodHandle _WriteEffectToFile;

    private final MethodHandle _EnumEffectsInFile;

    private final MethodHandle _SendDeviceData;

    private final MethodHandle _Poll;

    private final MethodHandle _Escape;

    private final MethodHandle _EnumCreatedEffectObjects;

    private final MethodHandle _SendForceFeedbackCommand;

    private final MethodHandle _GetForceFeedbackState;

    private final MethodHandle _GetEffectInfo;

    private final MethodHandle _EnumEffects;

    private final MethodHandle _CreateEffect;

    private final MethodHandle _Initialize;

    private final MethodHandle _RunControlPanel;

    private final MethodHandle _GetDeviceInfo;

    private final MethodHandle _GetObjectInfo;

    private final MethodHandle _SetCooperativeLevel;

    private final MethodHandle _SetEventNotification;

    private final MethodHandle _SetDataFormat;

    private final MethodHandle _GetDeviceData;

    private final MethodHandle _GetDeviceState;

    private final MethodHandle _Unacquire;

    private final MethodHandle _Acquire;

    private final MethodHandle _SetProperty;

    private final MethodHandle _GetProperty;

    private final MethodHandle _EnumObjects;

    private final MethodHandle _GetCapabilities;

    private final MethodHandle _Release;

    private final MethodHandle _AddRef;

    private final MethodHandle _QueryInterface;

    public IDirectInputDevice8WInstance(MemoryAddress instanceAddr) {
        this(instanceAddr.asSegmentRestricted(sizeof()));
    }

    public IDirectInputDevice8WInstance(MemorySegment instanceStruct) {
        _self = instanceStruct;
        _vtable = dinput_h.IDirectInputDevice8W.lpVtbl$get(_self)
                .asSegmentRestricted(dinput_h.IDirectInputDevice8WVtbl.sizeof());
        _GetImageInfo = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.GetImageInfo$get(_vtable),
                dinput_h_constants_5.GetImageInfo$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _SetActionMap = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.SetActionMap$get(_vtable),
                dinput_h_constants_5.SetActionMap$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _BuildActionMap = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.BuildActionMap$get(_vtable),
                dinput_h_constants_5.BuildActionMap$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _WriteEffectToFile = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.WriteEffectToFile$get(_vtable),
                dinput_h_constants_5.WriteEffectToFile$158$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _EnumEffectsInFile = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.EnumEffectsInFile$get(_vtable),
                dinput_h_constants_5.EnumEffectsInFile$157$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _SendDeviceData = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.SendDeviceData$get(_vtable),
                dinput_h_constants_5.SendDeviceData$156$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _Poll = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.Poll$get(_vtable),
                dinput_h_constants_5.Poll$155$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _Escape = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.Escape$get(_vtable),
                dinput_h_constants_5.Escape$154$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _EnumCreatedEffectObjects = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.EnumCreatedEffectObjects$get(_vtable),
                dinput_h_constants_5.EnumCreatedEffectObjects$153$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _SendForceFeedbackCommand = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.SendForceFeedbackCommand$get(_vtable),
                dinput_h_constants_5.SendForceFeedbackCommand$152$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _GetForceFeedbackState = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.GetForceFeedbackState$get(_vtable),
                dinput_h_constants_5.GetForceFeedbackState$151$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _GetEffectInfo = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.GetEffectInfo$get(_vtable),
                dinput_h_constants_5.GetEffectInfo$150$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _EnumEffects = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.EnumEffects$get(_vtable),
                dinput_h_constants_5.EnumEffects$149$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _CreateEffect = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.CreateEffect$get(_vtable),
                dinput_h_constants_5.CreateEffect$148$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _Initialize = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.Initialize$get(_vtable),
                dinput_h_constants_5.Initialize$147$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)I",
                false);
        _RunControlPanel = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.RunControlPanel$get(_vtable),
                dinput_h_constants_5.RunControlPanel$146$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _GetDeviceInfo = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.GetDeviceInfo$get(_vtable),
                dinput_h_constants_5.GetDeviceInfo$145$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _GetObjectInfo = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.GetObjectInfo$get(_vtable),
                dinput_h_constants_5.GetObjectInfo$144$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;II)I",
                false);
        _SetCooperativeLevel = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.SetCooperativeLevel$get(_vtable),
                dinput_h_constants_5.SetCooperativeLevel$143$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _SetEventNotification = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.SetEventNotification$get(_vtable),
                dinput_h_constants_5.SetEventNotification$142$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _SetDataFormat = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.SetDataFormat$get(_vtable),
                dinput_h_constants_5.SetDataFormat$141$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _GetDeviceData = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.GetDeviceData$get(_vtable),
                dinput_h_constants_5.GetDeviceData$140$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _GetDeviceState = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.GetDeviceState$get(_vtable),
                dinput_h_constants_5.GetDeviceState$139$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)I",
                false);
        _Unacquire = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.Unacquire$get(_vtable),
                dinput_h_constants_5.Unacquire$138$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _Acquire = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.Acquire$get(_vtable),
                dinput_h_constants_5.Acquire$137$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _SetProperty = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.SetProperty$get(_vtable),
                dinput_h_constants_5.SetProperty$136$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _GetProperty = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.GetProperty$get(_vtable),
                dinput_h_constants_5.GetProperty$135$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _EnumObjects = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.EnumObjects$get(_vtable),
                dinput_h_constants_5.EnumObjects$134$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
                false);
        _GetCapabilities = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.GetCapabilities$get(_vtable),
                dinput_h_constants_5.GetCapabilities$133$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _Release = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.Release$get(_vtable),
                dinput_h_constants_5.Release$132$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _AddRef = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.AddRef$get(_vtable),
                dinput_h_constants_5.AddRef$131$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
        _QueryInterface = RuntimeHelper.downcallHandle(
                dinput_h.IDirectInputDevice8WVtbl.QueryInterface$get(_vtable),
                dinput_h_constants_5.QueryInterface$130$FUNC(),
                "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
                false);
    }

    public final int GetImageInfo(MemoryAddress x0) {
        try {
            return (int)_GetImageInfo.invokeExact(address(), x0);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int SetActionMap(MemoryAddress x0, MemoryAddress x1, int x2) {
        try {
            return (int)_SetActionMap.invokeExact(address(), x0, x1, x2);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int BuildActionMap(MemoryAddress x0, MemoryAddress x1, int x2) {
        try {
            return (int)_BuildActionMap.invokeExact(address(), x0, x1, x2);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int WriteEffectToFile(MemoryAddress x0, int x1, MemoryAddress x2, int x3) {
        try {
            return (int)_WriteEffectToFile.invokeExact(address(), x0, x1, x2, x3);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int EnumEffectsInFile(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2, int x3) {
        try {
            return (int)_EnumEffectsInFile.invokeExact(address(), x0, x1, x2, x3);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int SendDeviceData(int x0, MemoryAddress x1, MemoryAddress x2, int x3) {
        try {
            return (int)_SendDeviceData.invokeExact(address(), x0, x1, x2, x3);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int Poll() {
        try {
            return (int)_Poll.invokeExact(address());
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int Escape(MemoryAddress x0) {
        try {
            return (int)_Escape.invokeExact(address(), x0);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int EnumCreatedEffectObjects(MemoryAddress x0, MemoryAddress x1, int x2) {
        try {
            return (int)_EnumCreatedEffectObjects.invokeExact(address(), x0, x1, x2);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int SendForceFeedbackCommand(int x0) {
        try {
            return (int)_SendForceFeedbackCommand.invokeExact(address(), x0);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int GetForceFeedbackState(MemoryAddress x0) {
        try {
            return (int)_GetForceFeedbackState.invokeExact(address(), x0);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int GetEffectInfo(MemoryAddress x0, MemoryAddress x1) {
        try {
            return (int)_GetEffectInfo.invokeExact(address(), x0, x1);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int EnumEffects(MemoryAddress x0, MemoryAddress x1, int x2) {
        try {
            return (int)_EnumEffects.invokeExact(address(), x0, x1, x2);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int CreateEffect(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
                                  MemoryAddress x3) {
        try {
            return (int)_CreateEffect.invokeExact(address(), x0, x1, x2, x3);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int Initialize(MemoryAddress x0, int x1, MemoryAddress x2) {
        try {
            return (int)_Initialize.invokeExact(address(), x0, x1, x2);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int RunControlPanel(MemoryAddress x0, int x1) {
        try {
            return (int)_RunControlPanel.invokeExact(address(), x0, x1);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int GetDeviceInfo(MemoryAddress x0) {
        try {
            return (int)_GetDeviceInfo.invokeExact(address(), x0);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int GetObjectInfo(MemoryAddress x0, int x1, int x2) {
        try {
            return (int)_GetObjectInfo.invokeExact(address(), x0, x1, x2);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int SetCooperativeLevel(MemoryAddress x0, int x1) {
        try {
            return (int)_SetCooperativeLevel.invokeExact(address(), x0, x1);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int SetEventNotification(MemoryAddress x0) {
        try {
            return (int)_SetEventNotification.invokeExact(address(), x0);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int SetDataFormat(MemoryAddress x0) {
        try {
            return (int)_SetDataFormat.invokeExact(address(), x0);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int GetDeviceData(int x0, MemoryAddress x1, MemoryAddress x2, int x3) {
        try {
            return (int)_GetDeviceData.invokeExact(address(), x0, x1, x2, x3);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int GetDeviceState(int x0, MemoryAddress x1) {
        try {
            return (int)_GetDeviceState.invokeExact(address(), x0, x1);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int Unacquire() {
        try {
            return (int)_Unacquire.invokeExact(address());
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int Acquire() {
        try {
            return (int)_Acquire.invokeExact(address());
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int SetProperty(MemoryAddress x0, MemoryAddress x1) {
        try {
            return (int)_SetProperty.invokeExact(address(), x0, x1);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int GetProperty(MemoryAddress x0, MemoryAddress x1) {
        try {
            return (int)_GetProperty.invokeExact(address(), x0, x1);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int EnumObjects(MemoryAddress x0, MemoryAddress x1, int x2) {
        try {
            return (int)_EnumObjects.invokeExact(address(), x0, x1, x2);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int GetCapabilities(MemoryAddress x0) {
        try {
            return (int)_GetCapabilities.invokeExact(address(), x0);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int Release() {
        try {
            return (int)_Release.invokeExact(address());
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int AddRef() {
        try {
            return (int)_AddRef.invokeExact(address());
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public final int QueryInterface(MemoryAddress x0, MemoryAddress x1) {
        try {
            return (int)_QueryInterface.invokeExact(address(), x0, x1);
        } catch (Throwable t) {
            throw new IllegalStateException(t);
        }
    }

    public static final MemoryLayout layout() {
        return dinput_h.IDirectInputDevice8W.$LAYOUT();
    }

    public static final long sizeof() {
        return dinput_h.IDirectInputDevice8W.sizeof();
    }

    protected final MemoryAddress address() {
        return _self.address();
    }
}