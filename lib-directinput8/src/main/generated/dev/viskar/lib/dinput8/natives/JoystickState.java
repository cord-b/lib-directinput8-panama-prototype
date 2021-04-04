package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIJOYSTATE dinput_h.DIJOYSTATE}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getLRx()
 * int getLRx(long index)
 * int getLRy()
 * int getLRy(long index)
 * int getLRz()
 * int getLRz(long index)
 * int getLX()
 * int getLX(long index)
 * int getLY()
 * int getLY(long index)
 * int getLZ()
 * int getLZ(long index)
 * MemorySegment getRgbButtons()
 * MemorySegment getRgdwPOV()
 * MemorySegment getRglSlider()
 * void setLRx(int x)
 * void setLRx(long index, int x)
 * void setLRy(int x)
 * void setLRy(long index, int x)
 * void setLRz(int x)
 * void setLRz(long index, int x)
 * void setLX(int x)
 * void setLX(long index, int x)
 * void setLY(int x)
 * void setLY(long index, int x)
 * void setLZ(int x)
 * void setLZ(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIJOYSTATE {
 *   b32 lX
 *   b32 lY
 *   b32 lZ
 *   b32 lRx
 *   b32 lRy
 *   b32 lRz
 *   b32[2] rglSlider
 *   b32[4] rgdwPOV
 *   b8[32] rgbButtons
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
           type = DIJOYSTATE
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class JoystickState {
  private final MemorySegment _self;

  public JoystickState(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public JoystickState(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIJOYSTATE.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIJOYSTATE.sizeof();
  }

  public final int getLRz() {
    return dinput_h.DIJOYSTATE.lRz$get(self());
  }

  public final int getLRz(long index) {
    return dinput_h.DIJOYSTATE.lRz$get(self(), index);
  }

  public final int getLY(long index) {
    return dinput_h.DIJOYSTATE.lY$get(self(), index);
  }

  public final int getLY() {
    return dinput_h.DIJOYSTATE.lY$get(self());
  }

  public final void setLRx(int x) {
    dinput_h.DIJOYSTATE.lRx$set(self(), x);
  }

  public final void setLRx(long index, int x) {
    dinput_h.DIJOYSTATE.lRx$set(self(), index, x);
  }

  public final int getLRy() {
    return dinput_h.DIJOYSTATE.lRy$get(self());
  }

  public final int getLRy(long index) {
    return dinput_h.DIJOYSTATE.lRy$get(self(), index);
  }

  public final int getLRx(long index) {
    return dinput_h.DIJOYSTATE.lRx$get(self(), index);
  }

  public final int getLRx() {
    return dinput_h.DIJOYSTATE.lRx$get(self());
  }

  public final MemorySegment getRgdwPOV() {
    return dinput_h.DIJOYSTATE.rgdwPOV$slice(self());
  }

  public final int getLZ(long index) {
    return dinput_h.DIJOYSTATE.lZ$get(self(), index);
  }

  public final int getLZ() {
    return dinput_h.DIJOYSTATE.lZ$get(self());
  }

  public final void setLX(int x) {
    dinput_h.DIJOYSTATE.lX$set(self(), x);
  }

  public final void setLX(long index, int x) {
    dinput_h.DIJOYSTATE.lX$set(self(), index, x);
  }

  public final MemorySegment getRglSlider() {
    return dinput_h.DIJOYSTATE.rglSlider$slice(self());
  }

  public final int getLX() {
    return dinput_h.DIJOYSTATE.lX$get(self());
  }

  public final int getLX(long index) {
    return dinput_h.DIJOYSTATE.lX$get(self(), index);
  }

  public final void setLRz(long index, int x) {
    dinput_h.DIJOYSTATE.lRz$set(self(), index, x);
  }

  public final void setLRz(int x) {
    dinput_h.DIJOYSTATE.lRz$set(self(), x);
  }

  public final void setLZ(int x) {
    dinput_h.DIJOYSTATE.lZ$set(self(), x);
  }

  public final void setLZ(long index, int x) {
    dinput_h.DIJOYSTATE.lZ$set(self(), index, x);
  }

  public final MemorySegment getRgbButtons() {
    return dinput_h.DIJOYSTATE.rgbButtons$slice(self());
  }

  public final void setLRy(int x) {
    dinput_h.DIJOYSTATE.lRy$set(self(), x);
  }

  public final void setLRy(long index, int x) {
    dinput_h.DIJOYSTATE.lRy$set(self(), index, x);
  }

  public final void setLY(long index, int x) {
    dinput_h.DIJOYSTATE.lY$set(self(), index, x);
  }

  public final void setLY(int x) {
    dinput_h.DIJOYSTATE.lY$set(self(), x);
  }
}
