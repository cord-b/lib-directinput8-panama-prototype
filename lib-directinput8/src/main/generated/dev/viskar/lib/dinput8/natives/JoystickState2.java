package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIJOYSTATE2 dinput_h.DIJOYSTATE2}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getLARx()
 * int getLARx(long index)
 * int getLARy()
 * int getLARy(long index)
 * int getLARz()
 * int getLARz(long index)
 * int getLAX()
 * int getLAX(long index)
 * int getLAY()
 * int getLAY(long index)
 * int getLAZ()
 * int getLAZ(long index)
 * int getLFRx()
 * int getLFRx(long index)
 * int getLFRy()
 * int getLFRy(long index)
 * int getLFRz()
 * int getLFRz(long index)
 * int getLFX()
 * int getLFX(long index)
 * int getLFY()
 * int getLFY(long index)
 * int getLFZ()
 * int getLFZ(long index)
 * int getLRx()
 * int getLRx(long index)
 * int getLRy()
 * int getLRy(long index)
 * int getLRz()
 * int getLRz(long index)
 * int getLVRx()
 * int getLVRx(long index)
 * int getLVRy()
 * int getLVRy(long index)
 * int getLVRz()
 * int getLVRz(long index)
 * int getLVX()
 * int getLVX(long index)
 * int getLVY()
 * int getLVY(long index)
 * int getLVZ()
 * int getLVZ(long index)
 * int getLX()
 * int getLX(long index)
 * int getLY()
 * int getLY(long index)
 * int getLZ()
 * int getLZ(long index)
 * MemorySegment getRgbButtons()
 * MemorySegment getRgdwPOV()
 * MemorySegment getRglASlider()
 * MemorySegment getRglFSlider()
 * MemorySegment getRglSlider()
 * MemorySegment getRglVSlider()
 * void setLARx(int x)
 * void setLARx(long index, int x)
 * void setLARy(int x)
 * void setLARy(long index, int x)
 * void setLARz(int x)
 * void setLARz(long index, int x)
 * void setLAX(int x)
 * void setLAX(long index, int x)
 * void setLAY(int x)
 * void setLAY(long index, int x)
 * void setLAZ(int x)
 * void setLAZ(long index, int x)
 * void setLFRx(int x)
 * void setLFRx(long index, int x)
 * void setLFRy(int x)
 * void setLFRy(long index, int x)
 * void setLFRz(int x)
 * void setLFRz(long index, int x)
 * void setLFX(int x)
 * void setLFX(long index, int x)
 * void setLFY(int x)
 * void setLFY(long index, int x)
 * void setLFZ(int x)
 * void setLFZ(long index, int x)
 * void setLRx(int x)
 * void setLRx(long index, int x)
 * void setLRy(int x)
 * void setLRy(long index, int x)
 * void setLRz(int x)
 * void setLRz(long index, int x)
 * void setLVRx(int x)
 * void setLVRx(long index, int x)
 * void setLVRy(int x)
 * void setLVRy(long index, int x)
 * void setLVRz(int x)
 * void setLVRz(long index, int x)
 * void setLVX(int x)
 * void setLVX(long index, int x)
 * void setLVY(int x)
 * void setLVY(long index, int x)
 * void setLVZ(int x)
 * void setLVZ(long index, int x)
 * void setLX(int x)
 * void setLX(long index, int x)
 * void setLY(int x)
 * void setLY(long index, int x)
 * void setLZ(int x)
 * void setLZ(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIJOYSTATE2 {
 *   b32 lX
 *   b32 lY
 *   b32 lZ
 *   b32 lRx
 *   b32 lRy
 *   b32 lRz
 *   b32[2] rglSlider
 *   b32[4] rgdwPOV
 *   b8[128] rgbButtons
 *   b32 lVX
 *   b32 lVY
 *   b32 lVZ
 *   b32 lVRx
 *   b32 lVRy
 *   b32 lVRz
 *   b32[2] rglVSlider
 *   b32 lAX
 *   b32 lAY
 *   b32 lAZ
 *   b32 lARx
 *   b32 lARy
 *   b32 lARz
 *   b32[2] rglASlider
 *   b32 lFX
 *   b32 lFY
 *   b32 lFZ
 *   b32 lFRx
 *   b32 lFRy
 *   b32 lFRz
 *   b32[2] rglFSlider
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
           type = DIJOYSTATE2
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class JoystickState2 {
  private final MemorySegment _self;

  public JoystickState2(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public JoystickState2(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIJOYSTATE2.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIJOYSTATE2.sizeof();
  }

  public final int getLRz() {
    return dinput_h.DIJOYSTATE2.lRz$get(self());
  }

  public final int getLRz(long index) {
    return dinput_h.DIJOYSTATE2.lRz$get(self(), index);
  }

  public final int getLY() {
    return dinput_h.DIJOYSTATE2.lY$get(self());
  }

  public final int getLY(long index) {
    return dinput_h.DIJOYSTATE2.lY$get(self(), index);
  }

  public final void setLRx(int x) {
    dinput_h.DIJOYSTATE2.lRx$set(self(), x);
  }

  public final void setLRx(long index, int x) {
    dinput_h.DIJOYSTATE2.lRx$set(self(), index, x);
  }

  public final int getLVY() {
    return dinput_h.DIJOYSTATE2.lVY$get(self());
  }

  public final int getLVY(long index) {
    return dinput_h.DIJOYSTATE2.lVY$get(self(), index);
  }

  public final int getLRy(long index) {
    return dinput_h.DIJOYSTATE2.lRy$get(self(), index);
  }

  public final int getLRy() {
    return dinput_h.DIJOYSTATE2.lRy$get(self());
  }

  public final int getLVX() {
    return dinput_h.DIJOYSTATE2.lVX$get(self());
  }

  public final int getLVX(long index) {
    return dinput_h.DIJOYSTATE2.lVX$get(self(), index);
  }

  public final int getLRx(long index) {
    return dinput_h.DIJOYSTATE2.lRx$get(self(), index);
  }

  public final int getLRx() {
    return dinput_h.DIJOYSTATE2.lRx$get(self());
  }

  public final MemorySegment getRgdwPOV() {
    return dinput_h.DIJOYSTATE2.rgdwPOV$slice(self());
  }

  public final void setLVX(int x) {
    dinput_h.DIJOYSTATE2.lVX$set(self(), x);
  }

  public final void setLVX(long index, int x) {
    dinput_h.DIJOYSTATE2.lVX$set(self(), index, x);
  }

  public final void setLVY(int x) {
    dinput_h.DIJOYSTATE2.lVY$set(self(), x);
  }

  public final void setLVY(long index, int x) {
    dinput_h.DIJOYSTATE2.lVY$set(self(), index, x);
  }

  public final void setLVZ(int x) {
    dinput_h.DIJOYSTATE2.lVZ$set(self(), x);
  }

  public final void setLVZ(long index, int x) {
    dinput_h.DIJOYSTATE2.lVZ$set(self(), index, x);
  }

  public final int getLZ() {
    return dinput_h.DIJOYSTATE2.lZ$get(self());
  }

  public final int getLZ(long index) {
    return dinput_h.DIJOYSTATE2.lZ$get(self(), index);
  }

  public final void setLX(int x) {
    dinput_h.DIJOYSTATE2.lX$set(self(), x);
  }

  public final void setLX(long index, int x) {
    dinput_h.DIJOYSTATE2.lX$set(self(), index, x);
  }

  public final MemorySegment getRglSlider() {
    return dinput_h.DIJOYSTATE2.rglSlider$slice(self());
  }

  public final int getLX(long index) {
    return dinput_h.DIJOYSTATE2.lX$get(self(), index);
  }

  public final int getLX() {
    return dinput_h.DIJOYSTATE2.lX$get(self());
  }

  public final void setLRz(long index, int x) {
    dinput_h.DIJOYSTATE2.lRz$set(self(), index, x);
  }

  public final void setLRz(int x) {
    dinput_h.DIJOYSTATE2.lRz$set(self(), x);
  }

  public final void setLZ(int x) {
    dinput_h.DIJOYSTATE2.lZ$set(self(), x);
  }

  public final void setLZ(long index, int x) {
    dinput_h.DIJOYSTATE2.lZ$set(self(), index, x);
  }

  public final MemorySegment getRgbButtons() {
    return dinput_h.DIJOYSTATE2.rgbButtons$slice(self());
  }

  public final int getLVZ() {
    return dinput_h.DIJOYSTATE2.lVZ$get(self());
  }

  public final int getLVZ(long index) {
    return dinput_h.DIJOYSTATE2.lVZ$get(self(), index);
  }

  public final void setLRy(long index, int x) {
    dinput_h.DIJOYSTATE2.lRy$set(self(), index, x);
  }

  public final void setLRy(int x) {
    dinput_h.DIJOYSTATE2.lRy$set(self(), x);
  }

  public final void setLY(int x) {
    dinput_h.DIJOYSTATE2.lY$set(self(), x);
  }

  public final void setLY(long index, int x) {
    dinput_h.DIJOYSTATE2.lY$set(self(), index, x);
  }

  public final int getLARy(long index) {
    return dinput_h.DIJOYSTATE2.lARy$get(self(), index);
  }

  public final int getLARy() {
    return dinput_h.DIJOYSTATE2.lARy$get(self());
  }

  public final int getLVRx() {
    return dinput_h.DIJOYSTATE2.lVRx$get(self());
  }

  public final int getLVRx(long index) {
    return dinput_h.DIJOYSTATE2.lVRx$get(self(), index);
  }

  public final MemorySegment getRglASlider() {
    return dinput_h.DIJOYSTATE2.rglASlider$slice(self());
  }

  public final void setLVRy(long index, int x) {
    dinput_h.DIJOYSTATE2.lVRy$set(self(), index, x);
  }

  public final void setLVRy(int x) {
    dinput_h.DIJOYSTATE2.lVRy$set(self(), x);
  }

  public final int getLVRz() {
    return dinput_h.DIJOYSTATE2.lVRz$get(self());
  }

  public final int getLVRz(long index) {
    return dinput_h.DIJOYSTATE2.lVRz$get(self(), index);
  }

  public final int getLFX(long index) {
    return dinput_h.DIJOYSTATE2.lFX$get(self(), index);
  }

  public final int getLFX() {
    return dinput_h.DIJOYSTATE2.lFX$get(self());
  }

  public final void setLFX(long index, int x) {
    dinput_h.DIJOYSTATE2.lFX$set(self(), index, x);
  }

  public final void setLFX(int x) {
    dinput_h.DIJOYSTATE2.lFX$set(self(), x);
  }

  public final void setLAX(int x) {
    dinput_h.DIJOYSTATE2.lAX$set(self(), x);
  }

  public final void setLAX(long index, int x) {
    dinput_h.DIJOYSTATE2.lAX$set(self(), index, x);
  }

  public final void setLVRz(long index, int x) {
    dinput_h.DIJOYSTATE2.lVRz$set(self(), index, x);
  }

  public final void setLVRz(int x) {
    dinput_h.DIJOYSTATE2.lVRz$set(self(), x);
  }

  public final int getLAX(long index) {
    return dinput_h.DIJOYSTATE2.lAX$get(self(), index);
  }

  public final int getLAX() {
    return dinput_h.DIJOYSTATE2.lAX$get(self());
  }

  public final void setLAY(long index, int x) {
    dinput_h.DIJOYSTATE2.lAY$set(self(), index, x);
  }

  public final void setLAY(int x) {
    dinput_h.DIJOYSTATE2.lAY$set(self(), x);
  }

  public final void setLAZ(int x) {
    dinput_h.DIJOYSTATE2.lAZ$set(self(), x);
  }

  public final void setLAZ(long index, int x) {
    dinput_h.DIJOYSTATE2.lAZ$set(self(), index, x);
  }

  public final void setLARy(int x) {
    dinput_h.DIJOYSTATE2.lARy$set(self(), x);
  }

  public final void setLARy(long index, int x) {
    dinput_h.DIJOYSTATE2.lARy$set(self(), index, x);
  }

  public final int getLAY(long index) {
    return dinput_h.DIJOYSTATE2.lAY$get(self(), index);
  }

  public final int getLAY() {
    return dinput_h.DIJOYSTATE2.lAY$get(self());
  }

  public final int getLAZ(long index) {
    return dinput_h.DIJOYSTATE2.lAZ$get(self(), index);
  }

  public final int getLAZ() {
    return dinput_h.DIJOYSTATE2.lAZ$get(self());
  }

  public final int getLARx(long index) {
    return dinput_h.DIJOYSTATE2.lARx$get(self(), index);
  }

  public final int getLARx() {
    return dinput_h.DIJOYSTATE2.lARx$get(self());
  }

  public final void setLVRx(long index, int x) {
    dinput_h.DIJOYSTATE2.lVRx$set(self(), index, x);
  }

  public final void setLVRx(int x) {
    dinput_h.DIJOYSTATE2.lVRx$set(self(), x);
  }

  public final MemorySegment getRglVSlider() {
    return dinput_h.DIJOYSTATE2.rglVSlider$slice(self());
  }

  public final void setLARx(long index, int x) {
    dinput_h.DIJOYSTATE2.lARx$set(self(), index, x);
  }

  public final void setLARx(int x) {
    dinput_h.DIJOYSTATE2.lARx$set(self(), x);
  }

  public final int getLVRy(long index) {
    return dinput_h.DIJOYSTATE2.lVRy$get(self(), index);
  }

  public final int getLVRy() {
    return dinput_h.DIJOYSTATE2.lVRy$get(self());
  }

  public final int getLARz(long index) {
    return dinput_h.DIJOYSTATE2.lARz$get(self(), index);
  }

  public final int getLARz() {
    return dinput_h.DIJOYSTATE2.lARz$get(self());
  }

  public final void setLARz(int x) {
    dinput_h.DIJOYSTATE2.lARz$set(self(), x);
  }

  public final void setLARz(long index, int x) {
    dinput_h.DIJOYSTATE2.lARz$set(self(), index, x);
  }

  public final void setLFZ(long index, int x) {
    dinput_h.DIJOYSTATE2.lFZ$set(self(), index, x);
  }

  public final void setLFZ(int x) {
    dinput_h.DIJOYSTATE2.lFZ$set(self(), x);
  }

  public final int getLFRx(long index) {
    return dinput_h.DIJOYSTATE2.lFRx$get(self(), index);
  }

  public final int getLFRx() {
    return dinput_h.DIJOYSTATE2.lFRx$get(self());
  }

  public final void setLFRy(long index, int x) {
    dinput_h.DIJOYSTATE2.lFRy$set(self(), index, x);
  }

  public final void setLFRy(int x) {
    dinput_h.DIJOYSTATE2.lFRy$set(self(), x);
  }

  public final int getLFRy(long index) {
    return dinput_h.DIJOYSTATE2.lFRy$get(self(), index);
  }

  public final int getLFRy() {
    return dinput_h.DIJOYSTATE2.lFRy$get(self());
  }

  public final MemorySegment getRglFSlider() {
    return dinput_h.DIJOYSTATE2.rglFSlider$slice(self());
  }

  public final int getLFRz(long index) {
    return dinput_h.DIJOYSTATE2.lFRz$get(self(), index);
  }

  public final int getLFRz() {
    return dinput_h.DIJOYSTATE2.lFRz$get(self());
  }

  public final void setLFRz(int x) {
    dinput_h.DIJOYSTATE2.lFRz$set(self(), x);
  }

  public final void setLFRz(long index, int x) {
    dinput_h.DIJOYSTATE2.lFRz$set(self(), index, x);
  }

  public final int getLFZ() {
    return dinput_h.DIJOYSTATE2.lFZ$get(self());
  }

  public final int getLFZ(long index) {
    return dinput_h.DIJOYSTATE2.lFZ$get(self(), index);
  }

  public final void setLFRx(int x) {
    dinput_h.DIJOYSTATE2.lFRx$set(self(), x);
  }

  public final void setLFRx(long index, int x) {
    dinput_h.DIJOYSTATE2.lFRx$set(self(), index, x);
  }

  public final int getLFY(long index) {
    return dinput_h.DIJOYSTATE2.lFY$get(self(), index);
  }

  public final int getLFY() {
    return dinput_h.DIJOYSTATE2.lFY$get(self());
  }

  public final void setLFY(long index, int x) {
    dinput_h.DIJOYSTATE2.lFY$set(self(), index, x);
  }

  public final void setLFY(int x) {
    dinput_h.DIJOYSTATE2.lFY$set(self(), x);
  }
}
