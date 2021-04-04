package dev.viskar.lib.dinput8.natives;

import java.lang.invoke.MethodHandle;
import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.IDirectInputDevice8W dinput_h.IDirectInputDevice8W}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int Acquire()
 * int AddRef()
 * int BuildActionMap(MemoryAddress x1, MemoryAddress x2, int x3)
 * int CreateEffect(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3, MemoryAddress x4)
 * int EnumCreatedEffectObjects(MemoryAddress x1, MemoryAddress x2, int x3)
 * int EnumEffects(MemoryAddress x1, MemoryAddress x2, int x3)
 * int EnumEffectsInFile(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3, int x4)
 * int EnumObjects(MemoryAddress x1, MemoryAddress x2, int x3)
 * int Escape(MemoryAddress x1)
 * int GetCapabilities(MemoryAddress x1)
 * int GetDeviceData(int x1, MemoryAddress x2, MemoryAddress x3, int x4)
 * int GetDeviceInfo(MemoryAddress x1)
 * int GetDeviceState(int x1, MemoryAddress x2)
 * int GetEffectInfo(MemoryAddress x1, MemoryAddress x2)
 * int GetForceFeedbackState(MemoryAddress x1)
 * int GetImageInfo(MemoryAddress x1)
 * int GetObjectInfo(MemoryAddress x1, int x2, int x3)
 * int GetProperty(MemoryAddress x1, MemoryAddress x2)
 * int Initialize(MemoryAddress x1, int x2, MemoryAddress x3)
 * int Poll()
 * int QueryInterface(MemoryAddress x1, MemoryAddress x2)
 * int Release()
 * int RunControlPanel(MemoryAddress x1, int x2)
 * int SendDeviceData(int x1, MemoryAddress x2, MemoryAddress x3, int x4)
 * int SendForceFeedbackCommand(int x1)
 * int SetActionMap(MemoryAddress x1, MemoryAddress x2, int x3)
 * int SetCooperativeLevel(MemoryAddress x1, int x2)
 * int SetDataFormat(MemoryAddress x1)
 * int SetEventNotification(MemoryAddress x1)
 * int SetProperty(MemoryAddress x1, MemoryAddress x2)
 * int Unacquire()
 * int WriteEffectToFile(MemoryAddress x1, int x2, MemoryAddress x3, int x4)
 * MemoryAddress getLpVtbl()
 * MemoryAddress getLpVtbl(long index)
 * void setLpVtbl(MemoryAddress x)
 * void setLpVtbl(long index, MemoryAddress x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * IDirectInputDevice8W {
 *   b64 lpVtbl
 * }
 * </small></pre></div>
 */
@Generated(
    value = { "dev.viskar.lib.codegen.generator.Generator", "dev.viskar.lib.codegen.generator.DefaultObjectGenerator" },
    comments = """
        from {
           package = dev.viskar.lib.dinput8.natives
           header = dinput_h
           constants = dinput_h_constants_5
           type = IDirectInputDevice8W
        }
        template = object
        accessors = false
        lombok {
           sneakyThrows = false
        }
        """
)
public class IDirectInputDevice8W {
  static MemorySegment $vtable;

  private final MemorySegment _self;

  public IDirectInputDevice8W(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public IDirectInputDevice8W(MemorySegment instanceStruct) {
    _self = instanceStruct;
    if ($vtable == null) {
        $vtable = dinput_h.IDirectInputDevice8W.lpVtbl$get(_self)
            .asSegmentRestricted(dinput_h.IDirectInputDevice8WVtbl.sizeof());
    }
  }

  public final int GetImageInfo(MemoryAddress x1) {
    return VTable.GetImageInfo(address(), x1);
  }

  public final int SetActionMap(MemoryAddress x1, MemoryAddress x2, int x3) {
    return VTable.SetActionMap(address(), x1, x2, x3);
  }

  public final int BuildActionMap(MemoryAddress x1, MemoryAddress x2, int x3) {
    return VTable.BuildActionMap(address(), x1, x2, x3);
  }

  public final int WriteEffectToFile(MemoryAddress x1, int x2, MemoryAddress x3, int x4) {
    return VTable.WriteEffectToFile(address(), x1, x2, x3, x4);
  }

  public final int EnumEffectsInFile(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3, int x4) {
    return VTable.EnumEffectsInFile(address(), x1, x2, x3, x4);
  }

  public final int SendDeviceData(int x1, MemoryAddress x2, MemoryAddress x3, int x4) {
    return VTable.SendDeviceData(address(), x1, x2, x3, x4);
  }

  public final int Poll() {
    return VTable.Poll(address());
  }

  public final int Escape(MemoryAddress x1) {
    return VTable.Escape(address(), x1);
  }

  public final int EnumCreatedEffectObjects(MemoryAddress x1, MemoryAddress x2, int x3) {
    return VTable.EnumCreatedEffectObjects(address(), x1, x2, x3);
  }

  public final int SendForceFeedbackCommand(int x1) {
    return VTable.SendForceFeedbackCommand(address(), x1);
  }

  public final int GetForceFeedbackState(MemoryAddress x1) {
    return VTable.GetForceFeedbackState(address(), x1);
  }

  public final int GetEffectInfo(MemoryAddress x1, MemoryAddress x2) {
    return VTable.GetEffectInfo(address(), x1, x2);
  }

  public final int EnumEffects(MemoryAddress x1, MemoryAddress x2, int x3) {
    return VTable.EnumEffects(address(), x1, x2, x3);
  }

  public final int CreateEffect(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3,
      MemoryAddress x4) {
    return VTable.CreateEffect(address(), x1, x2, x3, x4);
  }

  public final int Initialize(MemoryAddress x1, int x2, MemoryAddress x3) {
    return VTable.Initialize(address(), x1, x2, x3);
  }

  public final int RunControlPanel(MemoryAddress x1, int x2) {
    return VTable.RunControlPanel(address(), x1, x2);
  }

  public final int GetDeviceInfo(MemoryAddress x1) {
    return VTable.GetDeviceInfo(address(), x1);
  }

  public final int GetObjectInfo(MemoryAddress x1, int x2, int x3) {
    return VTable.GetObjectInfo(address(), x1, x2, x3);
  }

  public final int SetCooperativeLevel(MemoryAddress x1, int x2) {
    return VTable.SetCooperativeLevel(address(), x1, x2);
  }

  public final int SetEventNotification(MemoryAddress x1) {
    return VTable.SetEventNotification(address(), x1);
  }

  public final int SetDataFormat(MemoryAddress x1) {
    return VTable.SetDataFormat(address(), x1);
  }

  public final int GetDeviceData(int x1, MemoryAddress x2, MemoryAddress x3, int x4) {
    return VTable.GetDeviceData(address(), x1, x2, x3, x4);
  }

  public final int GetDeviceState(int x1, MemoryAddress x2) {
    return VTable.GetDeviceState(address(), x1, x2);
  }

  public final int Unacquire() {
    return VTable.Unacquire(address());
  }

  public final int Acquire() {
    return VTable.Acquire(address());
  }

  public final int SetProperty(MemoryAddress x1, MemoryAddress x2) {
    return VTable.SetProperty(address(), x1, x2);
  }

  public final int GetProperty(MemoryAddress x1, MemoryAddress x2) {
    return VTable.GetProperty(address(), x1, x2);
  }

  public final int EnumObjects(MemoryAddress x1, MemoryAddress x2, int x3) {
    return VTable.EnumObjects(address(), x1, x2, x3);
  }

  public final int GetCapabilities(MemoryAddress x1) {
    return VTable.GetCapabilities(address(), x1);
  }

  public final int Release() {
    return VTable.Release(address());
  }

  public final int AddRef() {
    return VTable.AddRef(address());
  }

  public final int QueryInterface(MemoryAddress x1, MemoryAddress x2) {
    return VTable.QueryInterface(address(), x1, x2);
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.IDirectInputDevice8W.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.IDirectInputDevice8W.sizeof();
  }

  public final void setLpVtbl(MemoryAddress x) {
    dinput_h.IDirectInputDevice8W.lpVtbl$set(self(), x);
  }

  public final void setLpVtbl(long index, MemoryAddress x) {
    dinput_h.IDirectInputDevice8W.lpVtbl$set(self(), index, x);
  }

  public final MemoryAddress getLpVtbl(long index) {
    return dinput_h.IDirectInputDevice8W.lpVtbl$get(self(), index);
  }

  public final MemoryAddress getLpVtbl() {
    return dinput_h.IDirectInputDevice8W.lpVtbl$get(self());
  }

  /**
   * <div id="struct">
   * <h1>Struct</h1>
   * <pre>
   * IDirectInputDevice8WVtbl {
   *   b64 QueryInterface
   *   b64 AddRef
   *   b64 Release
   *   b64 GetCapabilities
   *   b64 EnumObjects
   *   b64 GetProperty
   *   b64 SetProperty
   *   b64 Acquire
   *   b64 Unacquire
   *   b64 GetDeviceState
   *   b64 GetDeviceData
   *   b64 SetDataFormat
   *   b64 SetEventNotification
   *   b64 SetCooperativeLevel
   *   b64 GetObjectInfo
   *   b64 GetDeviceInfo
   *   b64 RunControlPanel
   *   b64 Initialize
   *   b64 CreateEffect
   *   b64 EnumEffects
   *   b64 GetEffectInfo
   *   b64 GetForceFeedbackState
   *   b64 SendForceFeedbackCommand
   *   b64 EnumCreatedEffectObjects
   *   b64 Escape
   *   b64 Poll
   *   b64 SendDeviceData
   *   b64 EnumEffectsInFile
   *   b64 WriteEffectToFile
   *   b64 BuildActionMap
   *   b64 SetActionMap
   *   b64 GetImageInfo
   * }
   * </pre></div>
   */
  @Generated({ "dev.viskar.lib.codegen.generator.Generator", "dev.viskar.lib.codegen.generator.VirtualMethodsBuilder" })
  public static final class VTable {
    private static final MemorySegment $vtable = IDirectInputDevice8W.$vtable;

    public static final MethodHandle $GetImageInfo = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.GetImageInfo$get($vtable),
        dinput_h_constants_5.GetImageInfo$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $SetActionMap = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.SetActionMap$get($vtable),
        dinput_h_constants_5.SetActionMap$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $BuildActionMap = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.BuildActionMap$get($vtable),
        dinput_h_constants_5.BuildActionMap$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $WriteEffectToFile = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.WriteEffectToFile$get($vtable),
        dinput_h_constants_5.WriteEffectToFile$158$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $EnumEffectsInFile = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.EnumEffectsInFile$get($vtable),
        dinput_h_constants_5.EnumEffectsInFile$157$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $SendDeviceData = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.SendDeviceData$get($vtable),
        dinput_h_constants_5.SendDeviceData$156$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $Poll = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.Poll$get($vtable),
        dinput_h_constants_5.Poll$155$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Escape = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.Escape$get($vtable),
        dinput_h_constants_5.Escape$154$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $EnumCreatedEffectObjects = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.EnumCreatedEffectObjects$get($vtable),
        dinput_h_constants_5.EnumCreatedEffectObjects$153$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $SendForceFeedbackCommand = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.SendForceFeedbackCommand$get($vtable),
        dinput_h_constants_5.SendForceFeedbackCommand$152$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $GetForceFeedbackState = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.GetForceFeedbackState$get($vtable),
        dinput_h_constants_5.GetForceFeedbackState$151$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $GetEffectInfo = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.GetEffectInfo$get($vtable),
        dinput_h_constants_5.GetEffectInfo$150$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $EnumEffects = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.EnumEffects$get($vtable),
        dinput_h_constants_5.EnumEffects$149$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $CreateEffect = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.CreateEffect$get($vtable),
        dinput_h_constants_5.CreateEffect$148$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Initialize = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.Initialize$get($vtable),
        dinput_h_constants_5.Initialize$147$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $RunControlPanel = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.RunControlPanel$get($vtable),
        dinput_h_constants_5.RunControlPanel$146$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $GetDeviceInfo = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.GetDeviceInfo$get($vtable),
        dinput_h_constants_5.GetDeviceInfo$145$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $GetObjectInfo = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.GetObjectInfo$get($vtable),
        dinput_h_constants_5.GetObjectInfo$144$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;II)I",
        false)
    ;

    public static final MethodHandle $SetCooperativeLevel = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.SetCooperativeLevel$get($vtable),
        dinput_h_constants_5.SetCooperativeLevel$143$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $SetEventNotification = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.SetEventNotification$get($vtable),
        dinput_h_constants_5.SetEventNotification$142$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $SetDataFormat = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.SetDataFormat$get($vtable),
        dinput_h_constants_5.SetDataFormat$141$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $GetDeviceData = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.GetDeviceData$get($vtable),
        dinput_h_constants_5.GetDeviceData$140$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $GetDeviceState = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.GetDeviceState$get($vtable),
        dinput_h_constants_5.GetDeviceState$139$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Unacquire = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.Unacquire$get($vtable),
        dinput_h_constants_5.Unacquire$138$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Acquire = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.Acquire$get($vtable),
        dinput_h_constants_5.Acquire$137$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $SetProperty = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.SetProperty$get($vtable),
        dinput_h_constants_5.SetProperty$136$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $GetProperty = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.GetProperty$get($vtable),
        dinput_h_constants_5.GetProperty$135$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $EnumObjects = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.EnumObjects$get($vtable),
        dinput_h_constants_5.EnumObjects$134$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $GetCapabilities = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.GetCapabilities$get($vtable),
        dinput_h_constants_5.GetCapabilities$133$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Release = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.Release$get($vtable),
        dinput_h_constants_5.Release$132$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $AddRef = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.AddRef$get($vtable),
        dinput_h_constants_5.AddRef$131$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $QueryInterface = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputDevice8WVtbl.QueryInterface$get($vtable),
        dinput_h_constants_5.QueryInterface$130$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final int GetImageInfo(MemoryAddress x0, MemoryAddress x1) {
      try {
          return (int)$GetImageInfo.invokeExact(x0, x1);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int SetActionMap(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
        int x3) {
      try {
          return (int)$SetActionMap.invokeExact(x0, x1, x2, x3);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int BuildActionMap(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
        int x3) {
      try {
          return (int)$BuildActionMap.invokeExact(x0, x1, x2, x3);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int WriteEffectToFile(MemoryAddress x0, MemoryAddress x1, int x2,
        MemoryAddress x3, int x4) {
      try {
          return (int)$WriteEffectToFile.invokeExact(x0, x1, x2, x3, x4);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int EnumEffectsInFile(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
        MemoryAddress x3, int x4) {
      try {
          return (int)$EnumEffectsInFile.invokeExact(x0, x1, x2, x3, x4);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int SendDeviceData(MemoryAddress x0, int x1, MemoryAddress x2,
        MemoryAddress x3, int x4) {
      try {
          return (int)$SendDeviceData.invokeExact(x0, x1, x2, x3, x4);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int Poll(MemoryAddress x0) {
      try {
          return (int)$Poll.invokeExact(x0);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int Escape(MemoryAddress x0, MemoryAddress x1) {
      try {
          return (int)$Escape.invokeExact(x0, x1);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int EnumCreatedEffectObjects(MemoryAddress x0, MemoryAddress x1,
        MemoryAddress x2, int x3) {
      try {
          return (int)$EnumCreatedEffectObjects.invokeExact(x0, x1, x2, x3);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int SendForceFeedbackCommand(MemoryAddress x0, int x1) {
      try {
          return (int)$SendForceFeedbackCommand.invokeExact(x0, x1);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int GetForceFeedbackState(MemoryAddress x0, MemoryAddress x1) {
      try {
          return (int)$GetForceFeedbackState.invokeExact(x0, x1);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int GetEffectInfo(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2) {
      try {
          return (int)$GetEffectInfo.invokeExact(x0, x1, x2);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int EnumEffects(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
        int x3) {
      try {
          return (int)$EnumEffects.invokeExact(x0, x1, x2, x3);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int CreateEffect(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
        MemoryAddress x3, MemoryAddress x4) {
      try {
          return (int)$CreateEffect.invokeExact(x0, x1, x2, x3, x4);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int Initialize(MemoryAddress x0, MemoryAddress x1, int x2,
        MemoryAddress x3) {
      try {
          return (int)$Initialize.invokeExact(x0, x1, x2, x3);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int RunControlPanel(MemoryAddress x0, MemoryAddress x1, int x2) {
      try {
          return (int)$RunControlPanel.invokeExact(x0, x1, x2);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int GetDeviceInfo(MemoryAddress x0, MemoryAddress x1) {
      try {
          return (int)$GetDeviceInfo.invokeExact(x0, x1);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int GetObjectInfo(MemoryAddress x0, MemoryAddress x1, int x2, int x3) {
      try {
          return (int)$GetObjectInfo.invokeExact(x0, x1, x2, x3);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int SetCooperativeLevel(MemoryAddress x0, MemoryAddress x1, int x2) {
      try {
          return (int)$SetCooperativeLevel.invokeExact(x0, x1, x2);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int SetEventNotification(MemoryAddress x0, MemoryAddress x1) {
      try {
          return (int)$SetEventNotification.invokeExact(x0, x1);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int SetDataFormat(MemoryAddress x0, MemoryAddress x1) {
      try {
          return (int)$SetDataFormat.invokeExact(x0, x1);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int GetDeviceData(MemoryAddress x0, int x1, MemoryAddress x2,
        MemoryAddress x3, int x4) {
      try {
          return (int)$GetDeviceData.invokeExact(x0, x1, x2, x3, x4);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int GetDeviceState(MemoryAddress x0, int x1, MemoryAddress x2) {
      try {
          return (int)$GetDeviceState.invokeExact(x0, x1, x2);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int Unacquire(MemoryAddress x0) {
      try {
          return (int)$Unacquire.invokeExact(x0);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int Acquire(MemoryAddress x0) {
      try {
          return (int)$Acquire.invokeExact(x0);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int SetProperty(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2) {
      try {
          return (int)$SetProperty.invokeExact(x0, x1, x2);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int GetProperty(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2) {
      try {
          return (int)$GetProperty.invokeExact(x0, x1, x2);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int EnumObjects(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
        int x3) {
      try {
          return (int)$EnumObjects.invokeExact(x0, x1, x2, x3);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int GetCapabilities(MemoryAddress x0, MemoryAddress x1) {
      try {
          return (int)$GetCapabilities.invokeExact(x0, x1);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int Release(MemoryAddress x0) {
      try {
          return (int)$Release.invokeExact(x0);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int AddRef(MemoryAddress x0) {
      try {
          return (int)$AddRef.invokeExact(x0);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int QueryInterface(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2) {
      try {
          return (int)$QueryInterface.invokeExact(x0, x1, x2);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }
  }
}
