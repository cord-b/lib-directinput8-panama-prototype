package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h._DIMOUSESTATE2 dinput_h._DIMOUSESTATE2}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getLX()
 * int getLX(long index)
 * int getLY()
 * int getLY(long index)
 * int getLZ()
 * int getLZ(long index)
 * MemorySegment getRgbButtons()
 * void setLX(int x)
 * void setLX(long index, int x)
 * void setLY(int x)
 * void setLY(long index, int x)
 * void setLZ(int x)
 * void setLZ(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * _DIMOUSESTATE2 {
 *   b32 lX
 *   b32 lY
 *   b32 lZ
 *   b8[8] rgbButtons
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
           type = _DIMOUSESTATE2
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class MouseState2 {
  private final MemorySegment _self;

  public MouseState2(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public MouseState2(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h._DIMOUSESTATE2.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h._DIMOUSESTATE2.sizeof();
  }

  public final int getLZ(long index) {
    return dinput_h._DIMOUSESTATE2.lZ$get(self(), index);
  }

  public final int getLZ() {
    return dinput_h._DIMOUSESTATE2.lZ$get(self());
  }

  public final void setLY(long index, int x) {
    dinput_h._DIMOUSESTATE2.lY$set(self(), index, x);
  }

  public final void setLY(int x) {
    dinput_h._DIMOUSESTATE2.lY$set(self(), x);
  }

  public final void setLX(long index, int x) {
    dinput_h._DIMOUSESTATE2.lX$set(self(), index, x);
  }

  public final void setLX(int x) {
    dinput_h._DIMOUSESTATE2.lX$set(self(), x);
  }

  public final int getLY() {
    return dinput_h._DIMOUSESTATE2.lY$get(self());
  }

  public final int getLY(long index) {
    return dinput_h._DIMOUSESTATE2.lY$get(self(), index);
  }

  public final int getLX() {
    return dinput_h._DIMOUSESTATE2.lX$get(self());
  }

  public final int getLX(long index) {
    return dinput_h._DIMOUSESTATE2.lX$get(self(), index);
  }

  public final void setLZ(int x) {
    dinput_h._DIMOUSESTATE2.lZ$set(self(), x);
  }

  public final void setLZ(long index, int x) {
    dinput_h._DIMOUSESTATE2.lZ$set(self(), index, x);
  }

  public final MemorySegment getRgbButtons() {
    return dinput_h._DIMOUSESTATE2.rgbButtons$slice(self());
  }
}
