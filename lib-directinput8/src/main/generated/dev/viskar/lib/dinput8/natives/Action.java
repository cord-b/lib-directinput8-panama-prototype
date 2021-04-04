package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h._DIACTIONW dinput_h._DIACTIONW}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwFlags()
 * int getDwFlags(long index)
 * int getDwHow()
 * int getDwHow(long index)
 * int getDwObjID()
 * int getDwObjID(long index)
 * int getDwSemantic()
 * int getDwSemantic(long index)
 * MemorySegment getGuidInstance()
 * MemoryAddress getLptszActionName()
 * MemoryAddress getLptszActionName(long index)
 * long getUAppData()
 * long getUAppData(long index)
 * int getUResIdString()
 * int getUResIdString(long index)
 * void setDwFlags(int x)
 * void setDwFlags(long index, int x)
 * void setDwHow(int x)
 * void setDwHow(long index, int x)
 * void setDwObjID(int x)
 * void setDwObjID(long index, int x)
 * void setDwSemantic(int x)
 * void setDwSemantic(long index, int x)
 * void setLptszActionName(MemoryAddress x)
 * void setLptszActionName(long index, MemoryAddress x)
 * void setUAppData(long x)
 * void setUAppData(long index, long x)
 * void setUResIdString(int x)
 * void setUResIdString(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * _DIACTIONW {
 *   b64 uAppData
 *   b32 dwSemantic
 *   b32 dwFlags
 *   $anon$0(union) {
 *     b64 lptszActionName
 *     b32 uResIdString
 *   }
 *   guidInstance {
 *     b32 Data1
 *     b16 Data2
 *     b16 Data3
 *     b8[8] Data4
 *   }
 *   b32 dwObjID
 *   b32 dwHow
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
           type = _DIACTIONW
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class Action {
  private final MemorySegment _self;

  public Action(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public Action(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h._DIACTIONW.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h._DIACTIONW.sizeof();
  }

  public final MemorySegment getGuidInstance() {
    return dinput_h._DIACTIONW.guidInstance$slice(self());
  }

  public final void setUAppData(long x) {
    dinput_h._DIACTIONW.uAppData$set(self(), x);
  }

  public final void setUAppData(long index, long x) {
    dinput_h._DIACTIONW.uAppData$set(self(), index, x);
  }

  public final long getUAppData() {
    return dinput_h._DIACTIONW.uAppData$get(self());
  }

  public final long getUAppData(long index) {
    return dinput_h._DIACTIONW.uAppData$get(self(), index);
  }

  public final int getDwHow(long index) {
    return dinput_h._DIACTIONW.dwHow$get(self(), index);
  }

  public final int getDwHow() {
    return dinput_h._DIACTIONW.dwHow$get(self());
  }

  public final void setDwHow(int x) {
    dinput_h._DIACTIONW.dwHow$set(self(), x);
  }

  public final void setDwHow(long index, int x) {
    dinput_h._DIACTIONW.dwHow$set(self(), index, x);
  }

  public final void setDwFlags(int x) {
    dinput_h._DIACTIONW.dwFlags$set(self(), x);
  }

  public final void setDwFlags(long index, int x) {
    dinput_h._DIACTIONW.dwFlags$set(self(), index, x);
  }

  public final int getDwFlags(long index) {
    return dinput_h._DIACTIONW.dwFlags$get(self(), index);
  }

  public final int getDwFlags() {
    return dinput_h._DIACTIONW.dwFlags$get(self());
  }

  public final void setDwObjID(long index, int x) {
    dinput_h._DIACTIONW.dwObjID$set(self(), index, x);
  }

  public final void setDwObjID(int x) {
    dinput_h._DIACTIONW.dwObjID$set(self(), x);
  }

  public final int getDwObjID() {
    return dinput_h._DIACTIONW.dwObjID$get(self());
  }

  public final int getDwObjID(long index) {
    return dinput_h._DIACTIONW.dwObjID$get(self(), index);
  }

  public final void setUResIdString(long index, int x) {
    dinput_h._DIACTIONW.uResIdString$set(self(), index, x);
  }

  public final void setUResIdString(int x) {
    dinput_h._DIACTIONW.uResIdString$set(self(), x);
  }

  public final int getDwSemantic() {
    return dinput_h._DIACTIONW.dwSemantic$get(self());
  }

  public final int getDwSemantic(long index) {
    return dinput_h._DIACTIONW.dwSemantic$get(self(), index);
  }

  public final void setDwSemantic(long index, int x) {
    dinput_h._DIACTIONW.dwSemantic$set(self(), index, x);
  }

  public final void setDwSemantic(int x) {
    dinput_h._DIACTIONW.dwSemantic$set(self(), x);
  }

  public final int getUResIdString() {
    return dinput_h._DIACTIONW.uResIdString$get(self());
  }

  public final int getUResIdString(long index) {
    return dinput_h._DIACTIONW.uResIdString$get(self(), index);
  }

  public final MemoryAddress getLptszActionName() {
    return dinput_h._DIACTIONW.lptszActionName$get(self());
  }

  public final MemoryAddress getLptszActionName(long index) {
    return dinput_h._DIACTIONW.lptszActionName$get(self(), index);
  }

  public final void setLptszActionName(MemoryAddress x) {
    dinput_h._DIACTIONW.lptszActionName$set(self(), x);
  }

  public final void setLptszActionName(long index, MemoryAddress x) {
    dinput_h._DIACTIONW.lptszActionName$set(self(), index, x);
  }
}
