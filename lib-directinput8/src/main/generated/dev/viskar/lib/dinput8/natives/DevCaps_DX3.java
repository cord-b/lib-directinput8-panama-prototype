package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIDEVCAPS_DX3 dinput_h.DIDEVCAPS_DX3}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwAxes()
 * int getDwAxes(long index)
 * int getDwButtons()
 * int getDwButtons(long index)
 * int getDwDevType()
 * int getDwDevType(long index)
 * int getDwFlags()
 * int getDwFlags(long index)
 * int getDwPOVs()
 * int getDwPOVs(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * void setDwAxes(int x)
 * void setDwAxes(long index, int x)
 * void setDwButtons(int x)
 * void setDwButtons(long index, int x)
 * void setDwDevType(int x)
 * void setDwDevType(long index, int x)
 * void setDwFlags(int x)
 * void setDwFlags(long index, int x)
 * void setDwPOVs(int x)
 * void setDwPOVs(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIDEVCAPS_DX3 {
 *   b32 dwSize
 *   b32 dwFlags
 *   b32 dwDevType
 *   b32 dwAxes
 *   b32 dwButtons
 *   b32 dwPOVs
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
           type = DIDEVCAPS_DX3
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class DevCaps_DX3 {
  private final MemorySegment _self;

  public DevCaps_DX3(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public DevCaps_DX3(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIDEVCAPS_DX3.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIDEVCAPS_DX3.sizeof();
  }

  public final int getDwSize(long index) {
    return dinput_h.DIDEVCAPS_DX3.dwSize$get(self(), index);
  }

  public final int getDwSize() {
    return dinput_h.DIDEVCAPS_DX3.dwSize$get(self());
  }

  public final void setDwSize(int x) {
    dinput_h.DIDEVCAPS_DX3.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h.DIDEVCAPS_DX3.dwSize$set(self(), index, x);
  }

  public final void setDwDevType(long index, int x) {
    dinput_h.DIDEVCAPS_DX3.dwDevType$set(self(), index, x);
  }

  public final void setDwDevType(int x) {
    dinput_h.DIDEVCAPS_DX3.dwDevType$set(self(), x);
  }

  public final int getDwDevType(long index) {
    return dinput_h.DIDEVCAPS_DX3.dwDevType$get(self(), index);
  }

  public final int getDwDevType() {
    return dinput_h.DIDEVCAPS_DX3.dwDevType$get(self());
  }

  public final void setDwFlags(int x) {
    dinput_h.DIDEVCAPS_DX3.dwFlags$set(self(), x);
  }

  public final void setDwFlags(long index, int x) {
    dinput_h.DIDEVCAPS_DX3.dwFlags$set(self(), index, x);
  }

  public final int getDwFlags(long index) {
    return dinput_h.DIDEVCAPS_DX3.dwFlags$get(self(), index);
  }

  public final int getDwFlags() {
    return dinput_h.DIDEVCAPS_DX3.dwFlags$get(self());
  }

  public final int getDwAxes(long index) {
    return dinput_h.DIDEVCAPS_DX3.dwAxes$get(self(), index);
  }

  public final int getDwAxes() {
    return dinput_h.DIDEVCAPS_DX3.dwAxes$get(self());
  }

  public final void setDwAxes(long index, int x) {
    dinput_h.DIDEVCAPS_DX3.dwAxes$set(self(), index, x);
  }

  public final void setDwAxes(int x) {
    dinput_h.DIDEVCAPS_DX3.dwAxes$set(self(), x);
  }

  public final int getDwPOVs(long index) {
    return dinput_h.DIDEVCAPS_DX3.dwPOVs$get(self(), index);
  }

  public final int getDwPOVs() {
    return dinput_h.DIDEVCAPS_DX3.dwPOVs$get(self());
  }

  public final void setDwPOVs(long index, int x) {
    dinput_h.DIDEVCAPS_DX3.dwPOVs$set(self(), index, x);
  }

  public final void setDwPOVs(int x) {
    dinput_h.DIDEVCAPS_DX3.dwPOVs$set(self(), x);
  }

  public final void setDwButtons(long index, int x) {
    dinput_h.DIDEVCAPS_DX3.dwButtons$set(self(), index, x);
  }

  public final void setDwButtons(int x) {
    dinput_h.DIDEVCAPS_DX3.dwButtons$set(self(), x);
  }

  public final int getDwButtons() {
    return dinput_h.DIDEVCAPS_DX3.dwButtons$get(self());
  }

  public final int getDwButtons(long index) {
    return dinput_h.DIDEVCAPS_DX3.dwButtons$get(self(), index);
  }
}
