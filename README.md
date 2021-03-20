# DirectInput using Panama + jextract

An attempt at auto-generating a usable `DirectInput8 (dinput.h)` wrapper in Java using Project Panama and zero JNI code
or helpers.
* Requires jdk17-panama to compile or run examples.

Currently this is in a working state and the native calls do work.

However, this is mostly an extercise in working on some really helpful code-generator templates and discover what kind
of code generation is truly needed to help make Panama a success.  
  
## Summary
* The JDK `jextract` tool generates low-level classes based on `dinput.h` into `lib-dinput8-jextract/dev.viskar.lib.dinput8.natives`
* The `native-codegen` module contains additional code generators, which generates more human-friendly code on top of 
  the jextrac code. This provides the Class/Interface objects with all of their virtual methods resolved into method 
  handles and corresponding java methods.
* The `lib-dinput8` module provides the few classes that

# Code Generation Walkthrough

This project's main focus is its reusable generator aimed at improving the upon `jextract` generated sources.
It takes a lot of the classe files geneatad from `jextract` and re-assembles them into more human-friendly code.
The key features it adds are:
* Genrates Java objects based on C/C++ objects using the discovered vtable structures. These have a fully functioning 
  list of methods powered by behind-the-scene `MethodHandle`s.
* Generates Java objects that wrap a struct `MemorySegment` with the look and feel of a POJO with getters/setters.

## The Code Generation Logic

After running `jextract`, one of the first things that's apparent is that it's not 
really streamlined for working with C/C++ objects/classes yet. Although a bit scattered,
the the necessary data does exist, so it's just a matter of making code smart enough to assemble it
into a more usable form.

This is is what it the raw `jextract` output looks like when you find an object with it's methods/vtable structure.
```
class dinput_h {

    // Object with a vtable!
    class IDirectInput8W {
        static lpVtbl$get(MemoryAddress add);
        static lpVtbl$set(MemoryAddress add);
    }
    // It's vtbl structure
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
So it's obvious that we have the information needed to work with this class structure, but it's all very scattered and 
needs some setup:
* There's no pre-generated static methods to help make the `MethodHandle`s that we'll need.
* There's no explicit pairing `IDirectInput8W` and `IDirectInput8WVtbl`, we just have to know to link them together.
* The interfaces inside the `vtbl` describe the native signatures, although this has to be done through java reflection.
  
But we can still work with this, that's what code generators are for. From here, the steps would be:
* For each inner interface inside the vtbl (`CreateDevice$243`), look for the corresponding vtbl getter (`CreateDevice$get`).
* Do some reflection on the "apply" function `CreateDevice$243.apply(..)` to re-build the `MethodType` signature, because 
  only place the the `MethodType` string actually exists is currently hardcoded inside of `allocate()`.
* Create code to instantiate and prepare all the `MethodHandles`.

So, the steps to generate the code are shaping up to look like:
  * Given a `MemoryAddress` to an `IDirectInput8W` instance
  * Convert it to a `MemorySegment` with `IDirectInput8W.sizeof()`
  * Read the `vtbl` pointer with `IDirectInput8W.lpVtbl$get`
  * Convert the vtbl's `MemoryAddress` to its `MemorySegment` using `IDirectInput8WVtbl.sizeof()`.
  * For each discovered inteface/method in `IDirectInput8WVtbl`
    * Read the function address from the vtbl: `MemoryAddress f = IDirectInput8WVtbl.CreateDevice$get(vtbl)`
    * Build the `MethodType` from the interface `CreateDevice$243.apply(..)` using some reflection
    * Grab the `FunctionDescriptor` from the jextract classes `dinput_h_constants.CreateDevice$243$FUNC()`
    * Build the `MethodHandle` with `RuntimeHelper.downcallHandle(..)`
    * Store the `MethodHandle` somewhere so we don't have to re-build it
    * Wrap the all the `MethodHandle` into a class with actual Java methods to guarantee parameter correctness.
    * Assemble all the methods into a single class
    * Return the final generated code.
    
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

So now we have a faily human friendly object to work with:

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

Thankfully with this generator, we can also generate all structs as well. And any callbacks can be sorted out with a tiny bit of code too.

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

directInput.EnumDevices(dinput_h.DI8DEVCLASS_GAMECTRL(), dinput_h.DIEDFL_ATTACHEDONLY(), deviceInstance -> {
    
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

### Build

```
mvn clean package
```
