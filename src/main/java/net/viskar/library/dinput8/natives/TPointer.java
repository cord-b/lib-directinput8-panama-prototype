package net.viskar.library.dinput8.natives;

import jdk.incubator.foreign.*;

import java.lang.invoke.VarHandle;

import static jdk.incubator.foreign.CLinker.C_POINTER;

public class TPointer implements AutoCloseable, Addressable {

    private static final MemoryLayout LAYOUT = MemoryLayout.ofStruct(C_POINTER.withName("lpStruct")).withName("LPLPOut");
    private static final VarHandle lpStruct$VH = MemoryHandles.asAddressVarHandle(LAYOUT.varHandle(long.class, MemoryLayout.PathElement.groupElement("lpStruct")));

    private final MemorySegment _self;

    public TPointer(MemoryAddress instanceAddr) {
        this(instanceAddr.asSegmentRestricted(sizeof()));
    }

    public TPointer(MemorySegment instanceStruct) {
        _self = instanceStruct;
    }

    public void setPointer(Addressable lpObject) {
        lpStruct$VH.set(_self, lpObject.address());
    }

    public MemoryAddress getPointer() {
        return (MemoryAddress) lpStruct$VH.get(_self);
    }

    public MemorySegment getPointerAsSegment(long size) {
        return getPointer().asSegmentRestricted(size);
    }

    public MemorySegment getPointerAsSegment(MemoryLayout layout) {
        return getPointerAsSegment(layout.byteSize());
    }

    public MemorySegment self() {
        return _self;
    }

    public MemoryAddress address() {
        return _self.address();
    }

    public static long sizeof() {
        return LAYOUT.bitSize();
    }

    public static TPointer allocate() {
        return new TPointer(MemorySegment.allocateNative(LAYOUT));
    }

    public static TPointer allocate(NativeScope scope) {
        return new TPointer(scope.allocate(LAYOUT));
    }

    @Override
    public void close() {
        _self.close();
    }
}
