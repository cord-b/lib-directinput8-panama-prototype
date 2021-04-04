package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIDEVICEOBJECTDATA dinput_h.DIDEVICEOBJECTDATA}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwData()
 * int getDwData(long index)
 * int getDwOfs()
 * int getDwOfs(long index)
 * int getDwSequence()
 * int getDwSequence(long index)
 * int getDwTimeStamp()
 * int getDwTimeStamp(long index)
 * long getUAppData()
 * long getUAppData(long index)
 * void setDwData(int x)
 * void setDwData(long index, int x)
 * void setDwOfs(int x)
 * void setDwOfs(long index, int x)
 * void setDwSequence(int x)
 * void setDwSequence(long index, int x)
 * void setDwTimeStamp(int x)
 * void setDwTimeStamp(long index, int x)
 * void setUAppData(long x)
 * void setUAppData(long index, long x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIDEVICEOBJECTDATA {
 *   b32 dwOfs
 *   b32 dwData
 *   b32 dwTimeStamp
 *   b32 dwSequence
 *   b64 uAppData
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
           scan = true
           # Detected by scan:
           type = DIDEVICEOBJECTDATA
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class DeviceObjectData {
  private final MemorySegment _self;

  public DeviceObjectData(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public DeviceObjectData(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIDEVICEOBJECTDATA.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIDEVICEOBJECTDATA.sizeof();
  }

  public final int getDwOfs(long index) {
    return dinput_h.DIDEVICEOBJECTDATA.dwOfs$get(self(), index);
  }

  public final int getDwOfs() {
    return dinput_h.DIDEVICEOBJECTDATA.dwOfs$get(self());
  }

  public final void setDwOfs(int x) {
    dinput_h.DIDEVICEOBJECTDATA.dwOfs$set(self(), x);
  }

  public final void setDwOfs(long index, int x) {
    dinput_h.DIDEVICEOBJECTDATA.dwOfs$set(self(), index, x);
  }

  public final void setDwTimeStamp(long index, int x) {
    dinput_h.DIDEVICEOBJECTDATA.dwTimeStamp$set(self(), index, x);
  }

  public final void setDwTimeStamp(int x) {
    dinput_h.DIDEVICEOBJECTDATA.dwTimeStamp$set(self(), x);
  }

  public final void setUAppData(long index, long x) {
    dinput_h.DIDEVICEOBJECTDATA.uAppData$set(self(), index, x);
  }

  public final void setUAppData(long x) {
    dinput_h.DIDEVICEOBJECTDATA.uAppData$set(self(), x);
  }

  public final long getUAppData(long index) {
    return dinput_h.DIDEVICEOBJECTDATA.uAppData$get(self(), index);
  }

  public final long getUAppData() {
    return dinput_h.DIDEVICEOBJECTDATA.uAppData$get(self());
  }

  public final int getDwTimeStamp(long index) {
    return dinput_h.DIDEVICEOBJECTDATA.dwTimeStamp$get(self(), index);
  }

  public final int getDwTimeStamp() {
    return dinput_h.DIDEVICEOBJECTDATA.dwTimeStamp$get(self());
  }

  public final void setDwData(long index, int x) {
    dinput_h.DIDEVICEOBJECTDATA.dwData$set(self(), index, x);
  }

  public final void setDwData(int x) {
    dinput_h.DIDEVICEOBJECTDATA.dwData$set(self(), x);
  }

  public final int getDwSequence(long index) {
    return dinput_h.DIDEVICEOBJECTDATA.dwSequence$get(self(), index);
  }

  public final int getDwSequence() {
    return dinput_h.DIDEVICEOBJECTDATA.dwSequence$get(self());
  }

  public final int getDwData(long index) {
    return dinput_h.DIDEVICEOBJECTDATA.dwData$get(self(), index);
  }

  public final int getDwData() {
    return dinput_h.DIDEVICEOBJECTDATA.dwData$get(self());
  }

  public final void setDwSequence(long index, int x) {
    dinput_h.DIDEVICEOBJECTDATA.dwSequence$set(self(), index, x);
  }

  public final void setDwSequence(int x) {
    dinput_h.DIDEVICEOBJECTDATA.dwSequence$set(self(), x);
  }
}
