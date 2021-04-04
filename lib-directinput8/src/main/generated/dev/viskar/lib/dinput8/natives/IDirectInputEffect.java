package dev.viskar.lib.dinput8.natives;

import java.lang.invoke.MethodHandle;
import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.IDirectInputEffect dinput_h.IDirectInputEffect}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int AddRef()
 * int Download()
 * int Escape(MemoryAddress x1)
 * int GetEffectGuid(MemoryAddress x1)
 * int GetEffectStatus(MemoryAddress x1)
 * int GetParameters(MemoryAddress x1, int x2)
 * int Initialize(MemoryAddress x1, int x2, MemoryAddress x3)
 * int QueryInterface(MemoryAddress x1, MemoryAddress x2)
 * int Release()
 * int SetParameters(MemoryAddress x1, int x2)
 * int Start(int x1, int x2)
 * int Stop()
 * int Unload()
 * MemoryAddress getLpVtbl()
 * MemoryAddress getLpVtbl(long index)
 * void setLpVtbl(MemoryAddress x)
 * void setLpVtbl(long index, MemoryAddress x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * IDirectInputEffect {
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
           type = IDirectInputEffect
        }
        template = object
        accessors = false
        lombok {
           sneakyThrows = false
        }
        """
)
public class IDirectInputEffect {
  static MemorySegment $vtable;

  private final MemorySegment _self;

  public IDirectInputEffect(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public IDirectInputEffect(MemorySegment instanceStruct) {
    _self = instanceStruct;
    if ($vtable == null) {
        $vtable = dinput_h.IDirectInputEffect.lpVtbl$get(_self)
            .asSegmentRestricted(dinput_h.IDirectInputEffectVtbl.sizeof());
    }
  }

  public final int Escape(MemoryAddress x1) {
    return VTable.Escape(address(), x1);
  }

  public final int Unload() {
    return VTable.Unload(address());
  }

  public final int Download() {
    return VTable.Download(address());
  }

  public final int GetEffectStatus(MemoryAddress x1) {
    return VTable.GetEffectStatus(address(), x1);
  }

  public final int Stop() {
    return VTable.Stop(address());
  }

  public final int Start(int x1, int x2) {
    return VTable.Start(address(), x1, x2);
  }

  public final int SetParameters(MemoryAddress x1, int x2) {
    return VTable.SetParameters(address(), x1, x2);
  }

  public final int GetParameters(MemoryAddress x1, int x2) {
    return VTable.GetParameters(address(), x1, x2);
  }

  public final int GetEffectGuid(MemoryAddress x1) {
    return VTable.GetEffectGuid(address(), x1);
  }

  public final int Initialize(MemoryAddress x1, int x2, MemoryAddress x3) {
    return VTable.Initialize(address(), x1, x2, x3);
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
    return dinput_h.IDirectInputEffect.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.IDirectInputEffect.sizeof();
  }

  public final void setLpVtbl(MemoryAddress x) {
    dinput_h.IDirectInputEffect.lpVtbl$set(self(), x);
  }

  public final void setLpVtbl(long index, MemoryAddress x) {
    dinput_h.IDirectInputEffect.lpVtbl$set(self(), index, x);
  }

  public final MemoryAddress getLpVtbl(long index) {
    return dinput_h.IDirectInputEffect.lpVtbl$get(self(), index);
  }

  public final MemoryAddress getLpVtbl() {
    return dinput_h.IDirectInputEffect.lpVtbl$get(self());
  }

  /**
   * <div id="struct">
   * <h1>Struct</h1>
   * <pre>
   * IDirectInputEffectVtbl {
   *   b64 QueryInterface
   *   b64 AddRef
   *   b64 Release
   *   b64 Initialize
   *   b64 GetEffectGuid
   *   b64 GetParameters
   *   b64 SetParameters
   *   b64 Start
   *   b64 Stop
   *   b64 GetEffectStatus
   *   b64 Download
   *   b64 Unload
   *   b64 Escape
   * }
   * </pre></div>
   */
  @Generated({ "dev.viskar.lib.codegen.generator.Generator", "dev.viskar.lib.codegen.generator.VirtualMethodsBuilder" })
  public static final class VTable {
    private static final MemorySegment $vtable = IDirectInputEffect.$vtable;

    public static final MethodHandle $Escape = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.Escape$get($vtable),
        dinput_h_constants_5.Escape$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Unload = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.Unload$get($vtable),
        dinput_h_constants_5.Unload$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Download = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.Download$get($vtable),
        dinput_h_constants_5.Download$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $GetEffectStatus = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.GetEffectStatus$get($vtable),
        dinput_h_constants_5.GetEffectStatus$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Stop = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.Stop$get($vtable),
        dinput_h_constants_5.Stop$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Start = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.Start$get($vtable),
        dinput_h_constants_5.Start$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;II)I",
        false)
    ;

    public static final MethodHandle $SetParameters = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.SetParameters$get($vtable),
        dinput_h_constants_5.SetParameters$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $GetParameters = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.GetParameters$get($vtable),
        dinput_h_constants_5.GetParameters$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $GetEffectGuid = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.GetEffectGuid$get($vtable),
        dinput_h_constants_5.GetEffectGuid$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Initialize = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.Initialize$get($vtable),
        dinput_h_constants_5.Initialize$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Release = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.Release$get($vtable),
        dinput_h_constants_5.Release$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $AddRef = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.AddRef$get($vtable),
        dinput_h_constants_5.AddRef$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $QueryInterface = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInputEffectVtbl.QueryInterface$get($vtable),
        dinput_h_constants_5.QueryInterface$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final int Escape(MemoryAddress x0, MemoryAddress x1) {
      try {
          return (int)$Escape.invokeExact(x0, x1);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int Unload(MemoryAddress x0) {
      try {
          return (int)$Unload.invokeExact(x0);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int Download(MemoryAddress x0) {
      try {
          return (int)$Download.invokeExact(x0);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int GetEffectStatus(MemoryAddress x0, MemoryAddress x1) {
      try {
          return (int)$GetEffectStatus.invokeExact(x0, x1);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int Stop(MemoryAddress x0) {
      try {
          return (int)$Stop.invokeExact(x0);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int Start(MemoryAddress x0, int x1, int x2) {
      try {
          return (int)$Start.invokeExact(x0, x1, x2);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int SetParameters(MemoryAddress x0, MemoryAddress x1, int x2) {
      try {
          return (int)$SetParameters.invokeExact(x0, x1, x2);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int GetParameters(MemoryAddress x0, MemoryAddress x1, int x2) {
      try {
          return (int)$GetParameters.invokeExact(x0, x1, x2);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int GetEffectGuid(MemoryAddress x0, MemoryAddress x1) {
      try {
          return (int)$GetEffectGuid.invokeExact(x0, x1);
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
