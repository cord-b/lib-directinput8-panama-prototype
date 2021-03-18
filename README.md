# DirectInput using Panama + jextract

This is a test project for using `DirectInput8 (dinput.h)` using Project Panama.
* We will be using `jextract` to generate code from `dinput.h`

# Snippets

```
jextract -d . \
-extract -l dinput \
--source \
--target-package net.viskar.natives.dinput \
-I "C:\Program Files (x86)\Windows Kits\10\Include\10.0.19041.0\um" \
--filter dinput.h \
"C:\Program Files (x86)\Windows Kits\10\Include\10.0.19041.0\um\dinput.h"
```

# Panama Feedback

### Generated Functional Method Interfaces

The following additions are useful for working with calling into native Objects/Interfaces.

* Added `public static MethodHandle downcallHandle(Addressable)` to create a `MethodHandle` that can invoke the native function.
* Added `public static T downcall(Addressable)` wraps the `downcallHandle` as the java interface.
* Made `methodType()` and `functionType()` public, exposing the function signature. Useful for extensibility without reflection hacks.

```java
// Example generated code for a given function:
// DirectInput8W {
//     FindDevice(MemoryAddress pThis, MemoryAddress pDeviceClassGuid, MemoryAddress pName, MemoryAddress out_pDeviceGuid)
// }
public static interface FindDevice$248 {
    // -- (existing) API --
    int apply(MemoryAddress x0, MemoryAddress x1, MemoryAddress x2, MemoryAddress x3);
    // -- (existing) Upcall Code  --
    public static MemorySegment allocate(FindDevice$248 fi) { return RuntimeHelper.upcallStub(FindDevice$248.class, fi, funcionType(), methodType()); }
    public static MemorySegment allocate(FindDevice$248 fi, NativeScope scope) { return allocate(fi).handoff(scope); }
    // -- (new) Downcall Code --
    public static MethodHandle downcallHandle(Addressable symbol) { return RuntimeHelper.downcallHandle(symbol, funcionType(), methodType(), false); }
    public static FindDevice$248 downcallT(Addressable symbol) { return RuntimeHelper.downcallT(symbol, FindDevice$248.class, funcionType(), methodType(), false); }
    // -- (new) Expose Basic Reflection --
    public static String methodType() { return "(Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;Ljdk/incubator/foreign/MemoryAddress;)I"; }
    public static FunctionDescriptor funcionType() { return dinput_h_constants_4.FindDevice$248$FUNC(); }
}
```

### RuntimeHelper

To support the new functionality, these helpers were added to `RuntimeHelper`
```java
/** Creates a MethodHandle to the native address */
public static MethodHandle downcallHandle(Addressable funcAddr, FunctionDescriptor functionType, String methodType, boolean variadic) {
    try {
        MethodType mt = MethodType.fromMethodDescriptorString(methodType, LOADER);
        return nativeHandle(funcAddr, mt, methodType, functionType);
    } catch (Throwable e) { return null; } // TODO: handle me
}

/** Creates a MethodHandle to the native address, and wraps it with the compatible functional interface class */
public static <T> T downcallT(Addressable funcAddr, Class<T> javaInterface, FunctionDescriptor functionType, String methodType, boolean variadic) {
    try{
        MethodHandle nativeMH = downcallHandle(funcAddr, functionType, methodType, variadic)
        return asInterface(nativeMH, javaInterface, "apply");
    } catch (Throwable e) { return null; } // TODO: handle me
}

// Helpers

/** Make a MethodHandle given an address and descriptor */
private static MethodHandle nativeHandle(Addressable address, MethodType mt, FunctionDescriptor fd, boolean variadic) throws Exception {
    return variadic
        ? VarargsInvoker.make(address, mt, fd)
        : LINKER.downcallHandle(address, mt, fd);
}

/**
 * Wraps a MethodHandle as the provided functional interface with the same signature.
 * The generated lambdas from LambdaMetafactory are typically faster than using the raw `MethodHandle`.
 */ 
private static <T> T asInterface(MethodHandle mh, Class<T> functionalInterface, String methodName) throws Exception {
        return (T) LambdaMetafactory
            .metafactory(
                MH_LOOKUP,
                methodName,
                MethodType.methodType(functionalInterface),
                mh.type(),
                mh,
                mh.type())
            .getTarget().invoke();
}
```