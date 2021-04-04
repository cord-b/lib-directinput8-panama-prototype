package dev.viskar.lib.dinput8.natives;

import dev.viskar.lib.codegen.runtime.SingletonInitializer;
import java.lang.UnsupportedOperationException;
import java.lang.invoke.MethodHandle;
import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * A generated singleton object. Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.IDirectInput8W dinput_h.IDirectInput8W}
 * <p>
 * <strong>Important! YOU must provide an initializer to provide the pointer for this object.
 * Read the <a href="#initializer">Initializer Setup</a> section below.</strong>
 * <p>
 * <h1>Usage</h1>
 * There are several classes generated that all call the same static instance. Use any or all.
 * <ul>
 * <li>{@link dev.viskar.lib.dinput8.natives.IDirectInput8WStatic IDirectInput8WStatic} has direct static methods. All the generated classes end up calling this class under the hood.<pre>
 * IDirectInput8WStatic.Foo(..);
 * IDirectInput8WStatic.Bar(..);
 * </pre></li>
 *
 * <li>{@link dev.viskar.lib.dinput8.natives.IDirectInput8WSingleton IDirectInput8WSingleton} is a singleton object wrapping the static methods.<pre>
 * IDirectInput8WSingleton instance = IDirectInput8WSingleton.getInstance();
 * instance.Foo(..);
 * instance.Bar(..);
 * </pre></li>
 *
 * <li>{@link dev.viskar.lib.dinput8.natives.IDirectInput8W IDirectInput8W} is the interface, whose default methods call {@link dev.viskar.lib.dinput8.natives.IDirectInput8WStatic IDirectInput8WStatic}. It also exposes getInstance()</pre>
 * IDirectInput8W singleton = IDirectInput8W.getInstance();
 * singleton.Foo(..);
 * singleton.Bar(..);
 * </pre></li>
 *
 * <li>Or extend the interface to decorate it with pretty overloads:<pre>
 * public interface MyFoo extends IDirectInput8W {
 *     MyFoo INSTANCE = new MyFoo(){};
 *     static MyFoo getInstance() { return INSTANCE; }
 *
 *     // Add your own prettified wrappers
 *     default void Foo(String str) {
 *          try (MemorySegment mem = CLinker.toCString(str)) {
 *             return Foo(mem);
 *          }
 *     }
 * }
 *
 * MyFoo instance = MyFoo.getInstance();
 * instance.Foo("Hello World");</pre></li>
 * </ul>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int AddRef()
 * int ConfigureDevices(MemoryAddress x1, MemoryAddress x2, int x3, MemoryAddress x4)
 * int CreateDevice(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3)
 * int EnumDevices(int x1, MemoryAddress x2, MemoryAddress x3, int x4)
 * int EnumDevicesBySemantics(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3, MemoryAddress x4, int x5)
 * int FindDevice(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3)
 * int GetDeviceStatus(MemoryAddress x1)
 * int Initialize(MemoryAddress x1, int x2)
 * int QueryInterface(MemoryAddress x1, MemoryAddress x2)
 * int Release()
 * int RunControlPanel(MemoryAddress x1, int x2)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * IDirectInput8W {
 *   b64 lpVtbl
 * }
 * </small></pre></div>
 * <div id="initializer">
 * <h1>Initializer Setup</h1>
 * <p>
 * For this singleton to initialize, you must provide an implementation of the generated {@link dev.viskar.lib.dinput8.natives.IDirectInput8WStatic.Initializer Initializer}
 * interface and register your implementation for the {@link java.util.ServiceLoader ServiceLoader} to detect.
 * <p>
 * <strong>Example Implementation:</strong>
 * <pre>
 * package com.example;
 * import dev.viskar.lib.common.OutPointer;
 * import dev.viskar.lib.dinput8.natives.dinput_h;
 * import dev.viskar.lib.dinput8.natives.IDirectInput8WStatic;
 * public class MyInitializer implements IDirectInput8WStatic.Initializer {
 *     public MemoryAddress get() {
 *         try (OutPointer outPointer = OutPointer.allocate()) {
 *             dinput_h.CreateIDirectInput8W(outPointer);
 *             return outPointer.getPointer();
 *         }
 *     }
 * }
 * </pre>
 * <p>
 * <strong>Register the Initializer (manual approach)</strong>
 * <p>
 * Create the file below and provide your class name implementing the service.
 * <pre>
 * <small>META-INF/services/dev.viskar.lib.dinput8.natives.IDirectInput8WStatic$Initializer:</small>
 *   com.example.MyIDirectInput8WInitializer
 * </pre>
 * <strong>Register the Initializer (automatic approach)</strong>
 * <p>
 * Include "staticInitializer" in your generator.conf configuration for this object:
 * {
 *   from.type = IDirectInput8W
 *   template = static-object
 *   staticInitializer = com.myapp.MyIDirectInput8WInitializer
 * }
 * And also provide the path to the resources directory somewhere in the arguments.
 * <pre>
 * --resources ${project.basedir}/src/main/resources
 * </pre>
 * </div>
 */
@Generated(
    value = { "dev.viskar.lib.codegen.generator.Generator", "dev.viskar.lib.codegen.generator.StaticObjectGenerator" },
    comments = """
        from {
           package = dev.viskar.lib.dinput8.natives
           header = dinput_h
           constants = dinput_h_constants_5
           type = IDirectInput8W
        }
        template = static-object
        accessors = false
        lombok {
           sneakyThrows = false
        }
        """
)
public final class IDirectInput8WStatic {
  private IDirectInput8WStatic() {
    throw new UnsupportedOperationException("Static class: do not construct.");
  }

  public static final int ConfigureDevices(MemoryAddress x1, MemoryAddress x2, int x3,
      MemoryAddress x4) {
    return VTable.ConfigureDevices(address(), x1, x2, x3, x4);
  }

  public static final int EnumDevicesBySemantics(MemoryAddress x1, MemoryAddress x2,
      MemoryAddress x3, MemoryAddress x4, int x5) {
    return VTable.EnumDevicesBySemantics(address(), x1, x2, x3, x4, x5);
  }

  public static final int FindDevice(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3) {
    return VTable.FindDevice(address(), x1, x2, x3);
  }

  public static final int Initialize(MemoryAddress x1, int x2) {
    return VTable.Initialize(address(), x1, x2);
  }

  public static final int RunControlPanel(MemoryAddress x1, int x2) {
    return VTable.RunControlPanel(address(), x1, x2);
  }

  public static final int GetDeviceStatus(MemoryAddress x1) {
    return VTable.GetDeviceStatus(address(), x1);
  }

  public static final int EnumDevices(int x1, MemoryAddress x2, MemoryAddress x3, int x4) {
    return VTable.EnumDevices(address(), x1, x2, x3, x4);
  }

  public static final int CreateDevice(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3) {
    return VTable.CreateDevice(address(), x1, x2, x3);
  }

  public static final int Release() {
    return VTable.Release(address());
  }

  public static final int AddRef() {
    return VTable.AddRef(address());
  }

  public static final int QueryInterface(MemoryAddress x1, MemoryAddress x2) {
    return VTable.QueryInterface(address(), x1, x2);
  }

  public static final MemoryAddress address() {
    return self().address();
  }

  public static final MemorySegment self() {
    return Instance.$self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.IDirectInput8W.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.IDirectInput8W.sizeof();
  }

  public interface Initializer extends SingletonInitializer {
  }

  public static final class Instance {
    static final MemoryAddress $address = SingletonInitializer.runInitializer(Initializer.class);

    static final MemorySegment $self = $address.asSegmentRestricted(dinput_h.IDirectInput8W.sizeof());

    static final MemorySegment $vtable = dinput_h.IDirectInput8W.lpVtbl$get($self).asSegmentRestricted(dinput_h.IDirectInput8WVtbl.sizeof());
  }

  /**
   * <div id="struct">
   * <h1>Struct</h1>
   * <pre>
   * IDirectInput8WVtbl {
   *   b64 QueryInterface
   *   b64 AddRef
   *   b64 Release
   *   b64 CreateDevice
   *   b64 EnumDevices
   *   b64 GetDeviceStatus
   *   b64 RunControlPanel
   *   b64 Initialize
   *   b64 FindDevice
   *   b64 EnumDevicesBySemantics
   *   b64 ConfigureDevices
   * }
   * </pre></div>
   */
  @Generated({ "dev.viskar.lib.codegen.generator.Generator", "dev.viskar.lib.codegen.generator.VirtualMethodsBuilder" })
  public static final class VTable {
    private static final MemorySegment $vtable = Instance.$vtable;

    public static final MethodHandle $ConfigureDevices = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInput8WVtbl.ConfigureDevices$get($vtable),
        dinput_h_constants_5.ConfigureDevices$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $EnumDevicesBySemantics = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInput8WVtbl.EnumDevicesBySemantics$get($vtable),
        dinput_h_constants_5.EnumDevicesBySemantics$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $FindDevice = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInput8WVtbl.FindDevice$get($vtable),
        dinput_h_constants_5.FindDevice$248$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Initialize = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInput8WVtbl.Initialize$get($vtable),
        dinput_h_constants_5.Initialize$247$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $RunControlPanel = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInput8WVtbl.RunControlPanel$get($vtable),
        dinput_h_constants_5.RunControlPanel$246$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $GetDeviceStatus = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInput8WVtbl.GetDeviceStatus$get($vtable),
        dinput_h_constants_5.GetDeviceStatus$245$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $EnumDevices = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInput8WVtbl.EnumDevices$get($vtable),
        dinput_h_constants_5.EnumDevices$244$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
        false)
    ;

    public static final MethodHandle $CreateDevice = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInput8WVtbl.CreateDevice$get($vtable),
        dinput_h_constants_5.CreateDevice$243$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $Release = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInput8WVtbl.Release$get($vtable),
        dinput_h_constants_5.Release$242$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $AddRef = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInput8WVtbl.AddRef$get($vtable),
        dinput_h_constants_5.AddRef$241$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final MethodHandle $QueryInterface = RuntimeHelper.downcallHandle(
        dinput_h.IDirectInput8WVtbl.QueryInterface$get($vtable),
        dinput_h_constants_5.QueryInterface$240$FUNC(),
        "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
        false)
    ;

    public static final int ConfigureDevices(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
        int x3, MemoryAddress x4) {
      try {
          return (int)$ConfigureDevices.invokeExact(x0, x1, x2, x3, x4);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int EnumDevicesBySemantics(MemoryAddress x0, MemoryAddress x1,
        MemoryAddress x2, MemoryAddress x3, MemoryAddress x4, int x5) {
      try {
          return (int)$EnumDevicesBySemantics.invokeExact(x0, x1, x2, x3, x4, x5);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int FindDevice(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
        MemoryAddress x3) {
      try {
          return (int)$FindDevice.invokeExact(x0, x1, x2, x3);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int Initialize(MemoryAddress x0, MemoryAddress x1, int x2) {
      try {
          return (int)$Initialize.invokeExact(x0, x1, x2);
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

    public static final int GetDeviceStatus(MemoryAddress x0, MemoryAddress x1) {
      try {
          return (int)$GetDeviceStatus.invokeExact(x0, x1);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int EnumDevices(MemoryAddress x0, int x1, MemoryAddress x2,
        MemoryAddress x3, int x4) {
      try {
          return (int)$EnumDevices.invokeExact(x0, x1, x2, x3, x4);
      } catch (Throwable t) {
          throw new IllegalStateException(t);
      }
    }

    public static final int CreateDevice(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2,
        MemoryAddress x3) {
      try {
          return (int)$CreateDevice.invokeExact(x0, x1, x2, x3);
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
