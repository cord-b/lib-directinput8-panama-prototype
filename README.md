# DirectInput using Panama + jextract + codegen

An attempt at auto-generating a usable `DirectInput8 (dinput.h)` wrapper in Java using Project Panama and zero JNI code
or helpers.

* Requires jdk17-panama preview to compile or run examples.

Currently this is in a working state and the native calls do work.

However, this is mostly an exercise in discovering code-generator improvements so that it is possible to generate highly
usable native code wrappers.

## Summary

* The JDK `jextract` tool generates low-level classes based on `dinput.h`
  into `lib-directinput8-jextract/dev.viskar.lib.dinput8.natives`
* The `lib-common-codegen` module contains an experimental code-generator tool that can generate code based on the classes
  output by`jextract`. This code generate produces human-friendly code on top of the jextract code. This crucially
  provides the massive amounts of setup code to create Class/Interface objects with all of their virtual methods
  resolved into method handles and corresponding java methods + wrapper classes.
* The `lib-directinput8` module provides the final hand-written code, adding in javadocs and slight interface improvements.

# Code Generation Walkthrough

This project's main focus is its reusable generator aimed at improving the upon `jextract` generated sources. It takes a
lot of the classe files geneatad from `jextract` and re-assembles them into more human-friendly code. The key features
it adds are:

* Genrates Java objects based on C/C++ objects using the discovered vtable structures. These have a fully functioning
  list of methods powered by behind-the-scene `MethodHandles`.
* Generates Java objects that wrap a struct `MemorySegment` with the look and feel of a POJO with getters/setters.

## The Code Generation Logic

After running `jextract`, one of the first things that's apparent is that it's not really streamlined for working with
C/C++ objects/classes yet. Although a bit scattered, the the necessary data does exist, so it's just a matter of making
code smart enough to assemble it into a more usable form.

This is roughly what the raw `jextract` output looks like when it exports an object with vtable methods (comments added
by me).

```
class dinput_h {

    class IDirectInput8W {
        // Object with a vtable has these getters/setters
        static lpVtbl$get(MemoryAddress add);
        static lpVtbl$set(MemoryAddress add);
    }
    
    // The corresponding vtbl
    // - The nested Interfaces describe the function in this vtable
    // - The getters are accessor for the function address
    IDirectInput8WVtbl {
        // int CreateDevice(MemoryAddress, MemoryAddress, MemoryAddress, MemoryAddress)
        public static interface CreateDevice$243 {
            int apply(jdk.incubator.foreign.MemoryAddress x0, jdk.incubator.foreign.MemoryAddress x1, jdk.incubator.foreign.MemoryAddress x2, jdk.incubator.foreign.MemoryAddress x3);
            public static  MemorySegment allocate(CreateDevice$243 fi) {
                return RuntimeHelper.upcallStub(CreateDevice$243.class, fi, dinput_h_constants_4.CreateDevice$243$FUNC(), "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I");
            }
            public static  MemorySegment allocate(CreateDevice$243 fi, NativeScope scope) {
                return allocate(fi).handoff(scope);
            }
        }
        public static  MemoryAddress CreateDevice$get(MemorySegment seg) {
            return (jdk.incubator.foreign.MemoryAddress)dinput_h_constants_4.IDirectInput8AVtbl$CreateDevice$VH().get(seg);
        }
        public static interface EnumDevices$253 {
            int apply(jdk.incubator.foreign.MemoryAddress x0, int x1, jdk.incubator.foreign.MemoryAddress x2, jdk.incubator.foreign.MemoryAddress x3, int x4);
            public static  MemorySegment allocate(EnumDevices$253 fi) {
                return RuntimeHelper.upcallStub(EnumDevices$253.class, fi, dinput_h_constants_4.EnumDevices$253$FUNC(), "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I");
            }
            public static  MemorySegment allocate(EnumDevices$253 fi, NativeScope scope) {
               return allocate(fi).handoff(scope);
            }
        }
        public static  MemoryAddress EnumDevices$get(MemorySegment seg) {
            return (jdk.incubator.foreign.MemoryAddress)dinput_h_constants_4.IDirectInput8AVtbl$EnumDevices$VH().get(seg);
        }
    }
}
```

The information is all there to piece together an object, but it would still be a lot of boiler plate. So the codegen
module in this project aims to bridge that gap.

Some of the troubles work with these jextract classes:

* There's no pre-generated static methods to help make the `MethodHandle`s that we'll need.
* There's no explicit pairing `IDirectInput8W` and `IDirectInput8WVtbl`, we just have to know to link them together.
* The `interface` declarations in the `vtbl` DO describe the method signature, but its not exposed as
  a `FunctionDescriptor` or `MethodType`. So we have to use reflection to regenerate it.

But we can still work with this, that's what code generators are for. From here, the steps would be:

* For each inner interface inside the vtbl (e.g. `CreateDevice$243`), look for the corresponding vtbl
  getter (`CreateDevice$get`).
* Do some reflection on the "apply" function `CreateDevice$243.apply(..)` to re-build the `MethodType` signature
* Create code to instantiate and hold all the `MethodHandles`.

So, the steps to generate the code are shaping up to look like:

1. Given a `MemoryAddress` to an `IDirectInput8W` instance
2. Convert it to a `MemorySegment` with `IDirectInput8W.sizeof()`
3. Read the `vtbl` pointer with `IDirectInput8W.lpVtbl$get`
4. Convert the vtbl's `MemoryAddress` to its `MemorySegment` using `IDirectInput8WVtbl.sizeof()`.
5. For each discovered inteface/method in `IDirectInput8WVtbl`
    1. Read the function address from the vtbl: `MemoryAddress f = IDirectInput8WVtbl.CreateDevice$get(vtbl)`
    2. Build the `MethodType` from the interface `CreateDevice$243.apply(..)` using some reflection
    3. Grab the `FunctionDescriptor` from the jextract classes `dinput_h_constants.CreateDevice$243$FUNC()`
    4. Build the `MethodHandle` with `RuntimeHelper.downcallHandle(..)`
    5. Store the `MethodHandle` somewhere so we don't have to re-build it
    6. Wrap the all the `MethodHandle` into a class with actual Java methods to guarantee parameter correctness.
    7. Assemble all the methods into a single class
    8. Return the final generated code.

The result is something that resembles this:

```
@Generated("dev.viskar.lib.codegen.generator.Generator")
public final class IDirectInput8WInstance {

    static MemorySegment $vtbl;
    
    private final MemorySegment _self;
    
    public IDirectInput8WInstance(MemoryAddress selfAddress) {
        this(selfAddress.ofasSegmentRestricted(sizeof()));
    }
    
    public IDirectInput8WInstance(MemoryAddress self) {
        _self = self;
        // The VTable will use this later when the class load gets triggered
        if ($vtbl == null) {
            $vtbl = dinput_h.IDirectInput8W.lpVtbl$get(_self)
            .asSegmentRestricted(dinput_h.IDirectInput8WVtbl.sizeof());
        }
    }
    
    public MemoryAddress address() {
        return _self.address();
    }

    public final int CreateDevice(MemoryAddress x1, MemoryAddress x2, MemoryAddress x3) {
        return VTable.CreateDevice(address(), x1, x2, x3);
    }    
    
    public final int EnumDevices(int x1, MemoryAddress x2, MemoryAddress x3, int x4) {
        return VTable.EnumDevices(address(), x1, x2, x3, x4);
    }
    
    // Inner class is using Java's only-once initialization so we can lazy-init
    // All of the VTable MethodHandles into static final fields.
    public static final class VTable {
        private static final MemorySegment $vtable = IDirectInput8WInstance.$vtable;

        public static final MethodHandle $CreateDevice = RuntimeHelper.downcallHandle(
            dinput_h.IDirectInput8WVtbl.CreateDevice$get($vtable),
            dinput_h_constants_5.CreateDevice$243$FUNC(),
            "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I",
            false)
        ;
        
        public static final MethodHandle $EnumDevices = RuntimeHelper.downcallHandle(
            dinput_h.IDirectInput8WVtbl.EnumDevices$get($vtable),
            dinput_h_constants_5.EnumDevices$244$FUNC(),
            "(Ljdk/incubator/foreign/MemoryAddress;ILjdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;I)I",
            false)
        ;
        
        public static final int CreateDevice(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2, MemoryAddress x3) {
            try {
                return (int)$CreateDevice.invokeExact(x0, x1, x2, x3);
            } catch (Throwable t) {
                throw new IllegalStateException(t);
            }
        }
        
        public static final int EnumDevices(MemoryAddress x0, int x1, MemoryAddress x2, MemoryAddress x3, int x4) {
            try {
                return (int)$EnumDevices.invokeExact(x0, x1, x2, x3, x4);
            } catch (Throwable t) {
                throw new IllegalStateException(t);
            }
        }
    }
}
```

So now we have a fairly human friendly object to work with:

```
IDirectInput8WInstance instance = new IDirectInput8WInstance(address);
instance.EnumDevices(..);
instance.CreateDevice(..);
...
```

But it's still not quite usable. It could use some final touches:

* Add javadoc
* Add real parameter names
* Add new method signatures that use more accurate types rather than just `MemoryAddress`.

Thankfully with this generator, we can also generate all structs as well. And any callbacks can be sorted out with a
tiny bit of code too.

So the final bit of work is just to hand-write some clean adapters:

```
class DirecInput8W {
    final IDirectInput8W instance;

    public int EnumDevices(int dwDevType, int dwFlags, EnumDevicesCallback callback) {
        try (MemorySegment lpCallback = deviceCallback.allocate()) {
            return instance.EnumDevices(dwDevType, lpCallback, MemoryAddress.NULL, dwFlags);
        }
    }

    public DirectInputDevice8W CreateDevice(TDIDEVICEINSTANCEW deviceInstance) {
        try (OutPointer outPointer = OutPointer.allocate()) {
            int result = instance.CreateDevice(
                    deviceInstance.getGuidInstance().address(),
                    outPointer.address(),
                    MemoryAddress.NULL);
            if (result == dinput_h.DI_OK()) {
                return DirectInputDevice8W.of(outPointer.getPointer());
            } else {
                return null;
            }
        }
    }
}
```

The final user code looks like this:

```
DirecInput8W directInput = DirecInput8W.getInstance();

directInput.EnumDevices(DI8DEVCLASS_GAMECTRL(), DIEDFL_ATTACHEDONLY(), deviceInstance -> {
    
    // Strongly typed invocation.
    // The callback and CreateDevice both take a TDIDEVICEINSTANCEW object
    DirectInputDevice8W device = directInput.CreateDevice(deviceInstance);
    
    // TDIDEVICEINSTANCEW is also an auto-generated object with getters/setters for its struct
    String productName = NativeUtils.stringFromWChars(deviceInstance.getTszProductName());
    System.out.println("Found device: " + productName);
});
```

## Misc Notes

### jextract snippets

```
jextract -d . \
-extract -l dinput \
--source \
--target-package dev.viskar.lib.dinput8.natives \
-I "C:\Program Files (x86)\Windows Kits\10\Include\10.0.19041.0\um" \
--filter dinput.h \
"C:\Program Files (x86)\Windows Kits\10\Include\10.0.19041.0\um\dinput.h"
```

After generating, need to fix the `LIBRARY[]` object in `dinput_h_constants` to use a correct path.

### Export

```
--add-opens java.desktop/java.awt=ALL-UNNAMED
--add-exports java.desktop/
```
