package net.viskar.library.dinput8.natives;

import jdk.incubator.foreign.Addressable;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

public class TDIDataFormat implements Addressable {

    private final MemorySegment _self;

    public TDIDataFormat(MemoryAddress instanceAddr) {
        this(instanceAddr, 1);
    }

    public TDIDataFormat(MemoryAddress instanceAddr, int arrayElements) {
        this(instanceAddr.asSegmentRestricted(arrayElements*sizeof()));
    }

    public TDIDataFormat(MemorySegment instanceStruct) {
        _self = instanceStruct;
    }

    public static final MemoryLayout layout() {
        return dinput_h._DIDATAFORMAT.$LAYOUT();
    }

    public static final long sizeof() {
        return dinput_h._DIDATAFORMAT.sizeof();
    }

    public final MemoryAddress address() {
        return _self.address();
    }

    public final MemorySegment self() {
        return _self;
    }

    public final int getDwFlags() {
        return dinput_h._DIDATAFORMAT.dwFlags$get(_self);
    }

    public final int getDwFlags(long x0) {
        return dinput_h._DIDATAFORMAT.dwFlags$get(_self, x0);
    }

    public final void setDwNumObjs(long x0, int x1) {
        dinput_h._DIDATAFORMAT.dwNumObjs$set(_self, x0, x1);
    }

    public final void setDwNumObjs(int x0) {
        dinput_h._DIDATAFORMAT.dwNumObjs$set(_self, x0);
    }

    public final int getDwDataSize(long x0) {
        return dinput_h._DIDATAFORMAT.dwDataSize$get(_self, x0);
    }

    public final int getDwDataSize() {
        return dinput_h._DIDATAFORMAT.dwDataSize$get(_self);
    }

    public final MemoryAddress getRgodf() {
        return dinput_h._DIDATAFORMAT.rgodf$get(_self);
    }

    public final MemoryAddress getRgodf(long x0) {
        return dinput_h._DIDATAFORMAT.rgodf$get(_self, x0);
    }

    public final int getDwNumObjs(long x0) {
        return dinput_h._DIDATAFORMAT.dwNumObjs$get(_self, x0);
    }

    public final int getDwNumObjs() {
        return dinput_h._DIDATAFORMAT.dwNumObjs$get(_self);
    }

    public final void setDwFlags(long x0, int x1) {
        dinput_h._DIDATAFORMAT.dwFlags$set(_self, x0, x1);
    }

    public final void setDwFlags(int x0) {
        dinput_h._DIDATAFORMAT.dwFlags$set(_self, x0);
    }

    public final int getDwObjSize(long x0) {
        return dinput_h._DIDATAFORMAT.dwObjSize$get(_self, x0);
    }

    public final int getDwObjSize() {
        return dinput_h._DIDATAFORMAT.dwObjSize$get(_self);
    }

    public final void setDwDataSize(int x0) {
        dinput_h._DIDATAFORMAT.dwDataSize$set(_self, x0);
    }

    public final void setDwDataSize(long x0, int x1) {
        dinput_h._DIDATAFORMAT.dwDataSize$set(_self, x0, x1);
    }

    public final void setDwObjSize(int x0) {
        dinput_h._DIDATAFORMAT.dwObjSize$set(_self, x0);
    }

    public final void setDwObjSize(long x0, int x1) {
        dinput_h._DIDATAFORMAT.dwObjSize$set(_self, x0, x1);
    }

    public final void setRgodf(MemoryAddress x0) {
        dinput_h._DIDATAFORMAT.rgodf$set(_self, x0);
    }

    public final void setRgodf(long x0, MemoryAddress x1) {
        dinput_h._DIDATAFORMAT.rgodf$set(_self, x0, x1);
    }

    public final int getDwSize(long x0) {
        return dinput_h._DIDATAFORMAT.dwSize$get(_self, x0);
    }

    public final int getDwSize() {
        return dinput_h._DIDATAFORMAT.dwSize$get(_self);
    }

    public final void setDwSize(long x0, int x1) {
        dinput_h._DIDATAFORMAT.dwSize$set(_self, x0, x1);
    }

    public final void setDwSize(int x0) {
        dinput_h._DIDATAFORMAT.dwSize$set(_self, x0);
    }
}
