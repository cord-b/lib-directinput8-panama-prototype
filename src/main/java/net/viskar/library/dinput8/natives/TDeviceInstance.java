package net.viskar.library.dinput8.natives;

import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

public class TDeviceInstance {
    private final MemorySegment _self;

    public TDeviceInstance(MemoryAddress instanceAddr) {
        this(instanceAddr.asSegmentRestricted(sizeof()));
    }

    public TDeviceInstance(MemorySegment instanceStruct) {
        _self = instanceStruct;
    }

    public static final MemoryLayout layout() {
        return dinput_h.DIDEVICEINSTANCEW.$LAYOUT();
    }

    public static final long sizeof() {
        return dinput_h.DIDEVICEINSTANCEW.sizeof();
    }

    public final MemoryAddress address() {
        return _self.address();
    }

    public final MemorySegment self() {
        return _self;
    }

    public final int getDwDevType(long x0) {
        return dinput_h.DIDEVICEINSTANCEW.dwDevType$get(_self, x0);
    }

    public final int getDwDevType() {
        return dinput_h.DIDEVICEINSTANCEW.dwDevType$get(_self);
    }

    public final void setWUsage(long x0, short x1) {
        dinput_h.DIDEVICEINSTANCEW.wUsage$set(_self, x0, x1);
    }

    public final void setWUsage(short x0) {
        dinput_h.DIDEVICEINSTANCEW.wUsage$set(_self, x0);
    }

    public final void setDwDevType(long x0, int x1) {
        dinput_h.DIDEVICEINSTANCEW.dwDevType$set(_self, x0, x1);
    }

    public final void setDwDevType(int x0) {
        dinput_h.DIDEVICEINSTANCEW.dwDevType$set(_self, x0);
    }

    public final MemorySegment getGuidInstance() {
        return dinput_h.DIDEVICEINSTANCEW.guidInstance$slice(_self);
    }

    public final void setDwSize(int x0) {
        dinput_h.DIDEVICEINSTANCEW.dwSize$set(_self, x0);
    }

    public final void setDwSize(long x0, int x1) {
        dinput_h.DIDEVICEINSTANCEW.dwSize$set(_self, x0, x1);
    }

    public final int getDwSize(long x0) {
        return dinput_h.DIDEVICEINSTANCEW.dwSize$get(_self, x0);
    }

    public final int getDwSize() {
        return dinput_h.DIDEVICEINSTANCEW.dwSize$get(_self);
    }

    public final MemorySegment getGuidProduct() {
        return dinput_h.DIDEVICEINSTANCEW.guidProduct$slice(_self);
    }

    public final short getWUsage(long x0) {
        return dinput_h.DIDEVICEINSTANCEW.wUsage$get(_self, x0);
    }

    public final short getWUsage() {
        return dinput_h.DIDEVICEINSTANCEW.wUsage$get(_self);
    }

    public final short getWUsagePage(long x0) {
        return dinput_h.DIDEVICEINSTANCEW.wUsagePage$get(_self, x0);
    }

    public final short getWUsagePage() {
        return dinput_h.DIDEVICEINSTANCEW.wUsagePage$get(_self);
    }

    public final void setWUsagePage(long x0, short x1) {
        dinput_h.DIDEVICEINSTANCEW.wUsagePage$set(_self, x0, x1);
    }

    public final void setWUsagePage(short x0) {
        dinput_h.DIDEVICEINSTANCEW.wUsagePage$set(_self, x0);
    }

    public final MemorySegment getGuidFFDriver() {
        return dinput_h.DIDEVICEINSTANCEW.guidFFDriver$slice(_self);
    }

    public final MemorySegment getTszProductName() {
        return dinput_h.DIDEVICEINSTANCEW.tszProductName$slice(_self);
    }

    public final MemorySegment getTszInstanceName() {
        return dinput_h.DIDEVICEINSTANCEW.tszInstanceName$slice(_self);
    }
}