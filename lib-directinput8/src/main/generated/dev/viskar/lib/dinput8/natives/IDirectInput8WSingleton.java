package dev.viskar.lib.dinput8.natives;

import java.lang.Override;
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
 * For this singleton to initialize, you must provide an implementation of the generated {@link dev.viskar.lib.dinput8.natives.IDirectInput8WSingleton.Initializer Initializer}
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
 * <small>META-INF/services/dev.viskar.lib.dinput8.natives.IDirectInput8WSingleton$Initializer:</small>
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
    value = { "dev.viskar.lib.codegen.generator.Generator", "dev.viskar.lib.codegen.generator.SingletonObjectGenerator" },
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
public final class IDirectInput8WSingleton implements IDirectInput8W {
  private static final IDirectInput8WSingleton INSTANCE = new IDirectInput8WSingleton();

  private IDirectInput8WSingleton() {
    // Singleton constructor
  }

  public static final IDirectInput8WSingleton getInstance() {
    return INSTANCE;
  }

  @Override
  public final int ConfigureDevices(MemoryAddress x1, MemoryAddress x2, int x3, MemoryAddress x4) {
    return IDirectInput8WStatic.ConfigureDevices(x1, x2, x3, x4);
  }

  @Override
  public final int EnumDevicesBySemantics(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3,
      MemoryAddress x4, int x5) {
    return IDirectInput8WStatic.EnumDevicesBySemantics(x1, x2, x3, x4, x5);
  }

  @Override
  public final int FindDevice(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3) {
    return IDirectInput8WStatic.FindDevice(x1, x2, x3);
  }

  @Override
  public final int Initialize(MemoryAddress x1, int x2) {
    return IDirectInput8WStatic.Initialize(x1, x2);
  }

  @Override
  public final int RunControlPanel(MemoryAddress x1, int x2) {
    return IDirectInput8WStatic.RunControlPanel(x1, x2);
  }

  @Override
  public final int GetDeviceStatus(MemoryAddress x1) {
    return IDirectInput8WStatic.GetDeviceStatus(x1);
  }

  @Override
  public final int EnumDevices(int x1, MemoryAddress x2, MemoryAddress x3, int x4) {
    return IDirectInput8WStatic.EnumDevices(x1, x2, x3, x4);
  }

  @Override
  public final int CreateDevice(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3) {
    return IDirectInput8WStatic.CreateDevice(x1, x2, x3);
  }

  @Override
  public final int Release() {
    return IDirectInput8WStatic.Release();
  }

  @Override
  public final int AddRef() {
    return IDirectInput8WStatic.AddRef();
  }

  @Override
  public final int QueryInterface(MemoryAddress x1, MemoryAddress x2) {
    return IDirectInput8WStatic.QueryInterface(x1, x2);
  }

  public final MemoryAddress address() {
    return IDirectInput8WStatic.address();
  }

  public final MemorySegment self() {
    return IDirectInput8WStatic.self();
  }

  public static final MemoryLayout layout() {
    return dinput_h.IDirectInput8W.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.IDirectInput8W.sizeof();
  }
}
