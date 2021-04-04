package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIPROPHEADER dinput_h.DIPROPHEADER}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwHeaderSize()
 * int getDwHeaderSize(long index)
 * int getDwHow()
 * int getDwHow(long index)
 * int getDwObj()
 * int getDwObj(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * void setDwHeaderSize(int x)
 * void setDwHeaderSize(long index, int x)
 * void setDwHow(int x)
 * void setDwHow(long index, int x)
 * void setDwObj(int x)
 * void setDwObj(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIPROPHEADER {
 *   b32 dwSize
 *   b32 dwHeaderSize
 *   b32 dwObj
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
           type = DIPROPHEADER
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class PropHeader {
  private final MemorySegment _self;

  public PropHeader(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public PropHeader(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIPROPHEADER.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIPROPHEADER.sizeof();
  }

  public final int getDwSize(long index) {
    return dinput_h.DIPROPHEADER.dwSize$get(self(), index);
  }

  public final int getDwSize() {
    return dinput_h.DIPROPHEADER.dwSize$get(self());
  }

  public final void setDwSize(int x) {
    dinput_h.DIPROPHEADER.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h.DIPROPHEADER.dwSize$set(self(), index, x);
  }

  public final int getDwHow(long index) {
    return dinput_h.DIPROPHEADER.dwHow$get(self(), index);
  }

  public final int getDwHow() {
    return dinput_h.DIPROPHEADER.dwHow$get(self());
  }

  public final int getDwHeaderSize(long index) {
    return dinput_h.DIPROPHEADER.dwHeaderSize$get(self(), index);
  }

  public final int getDwHeaderSize() {
    return dinput_h.DIPROPHEADER.dwHeaderSize$get(self());
  }

  public final int getDwObj(long index) {
    return dinput_h.DIPROPHEADER.dwObj$get(self(), index);
  }

  public final int getDwObj() {
    return dinput_h.DIPROPHEADER.dwObj$get(self());
  }

  public final void setDwHow(long index, int x) {
    dinput_h.DIPROPHEADER.dwHow$set(self(), index, x);
  }

  public final void setDwHow(int x) {
    dinput_h.DIPROPHEADER.dwHow$set(self(), x);
  }

  public final void setDwObj(int x) {
    dinput_h.DIPROPHEADER.dwObj$set(self(), x);
  }

  public final void setDwObj(long index, int x) {
    dinput_h.DIPROPHEADER.dwObj$set(self(), index, x);
  }

  public final void setDwHeaderSize(int x) {
    dinput_h.DIPROPHEADER.dwHeaderSize$set(self(), x);
  }

  public final void setDwHeaderSize(long index, int x) {
    dinput_h.DIPROPHEADER.dwHeaderSize$set(self(), index, x);
  }
}
