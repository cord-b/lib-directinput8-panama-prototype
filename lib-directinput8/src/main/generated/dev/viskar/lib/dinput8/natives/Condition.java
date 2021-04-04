package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DICONDITION dinput_h.DICONDITION}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwNegativeSaturation()
 * int getDwNegativeSaturation(long index)
 * int getDwPositiveSaturation()
 * int getDwPositiveSaturation(long index)
 * int getLDeadBand()
 * int getLDeadBand(long index)
 * int getLNegativeCoefficient()
 * int getLNegativeCoefficient(long index)
 * int getLOffset()
 * int getLOffset(long index)
 * int getLPositiveCoefficient()
 * int getLPositiveCoefficient(long index)
 * void setDwNegativeSaturation(int x)
 * void setDwNegativeSaturation(long index, int x)
 * void setDwPositiveSaturation(int x)
 * void setDwPositiveSaturation(long index, int x)
 * void setLDeadBand(int x)
 * void setLDeadBand(long index, int x)
 * void setLNegativeCoefficient(int x)
 * void setLNegativeCoefficient(long index, int x)
 * void setLOffset(int x)
 * void setLOffset(long index, int x)
 * void setLPositiveCoefficient(int x)
 * void setLPositiveCoefficient(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DICONDITION {
 *   b32 lOffset
 *   b32 lPositiveCoefficient
 *   b32 lNegativeCoefficient
 *   b32 dwPositiveSaturation
 *   b32 dwNegativeSaturation
 *   b32 lDeadBand
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
           type = DICONDITION
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class Condition {
  private final MemorySegment _self;

  public Condition(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public Condition(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DICONDITION.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DICONDITION.sizeof();
  }

  public final void setDwPositiveSaturation(long index, int x) {
    dinput_h.DICONDITION.dwPositiveSaturation$set(self(), index, x);
  }

  public final void setDwPositiveSaturation(int x) {
    dinput_h.DICONDITION.dwPositiveSaturation$set(self(), x);
  }

  public final void setDwNegativeSaturation(long index, int x) {
    dinput_h.DICONDITION.dwNegativeSaturation$set(self(), index, x);
  }

  public final void setDwNegativeSaturation(int x) {
    dinput_h.DICONDITION.dwNegativeSaturation$set(self(), x);
  }

  public final int getDwNegativeSaturation() {
    return dinput_h.DICONDITION.dwNegativeSaturation$get(self());
  }

  public final int getDwNegativeSaturation(long index) {
    return dinput_h.DICONDITION.dwNegativeSaturation$get(self(), index);
  }

  public final void setLPositiveCoefficient(int x) {
    dinput_h.DICONDITION.lPositiveCoefficient$set(self(), x);
  }

  public final void setLPositiveCoefficient(long index, int x) {
    dinput_h.DICONDITION.lPositiveCoefficient$set(self(), index, x);
  }

  public final int getLNegativeCoefficient() {
    return dinput_h.DICONDITION.lNegativeCoefficient$get(self());
  }

  public final int getLNegativeCoefficient(long index) {
    return dinput_h.DICONDITION.lNegativeCoefficient$get(self(), index);
  }

  public final void setLNegativeCoefficient(int x) {
    dinput_h.DICONDITION.lNegativeCoefficient$set(self(), x);
  }

  public final void setLNegativeCoefficient(long index, int x) {
    dinput_h.DICONDITION.lNegativeCoefficient$set(self(), index, x);
  }

  public final int getDwPositiveSaturation() {
    return dinput_h.DICONDITION.dwPositiveSaturation$get(self());
  }

  public final int getDwPositiveSaturation(long index) {
    return dinput_h.DICONDITION.dwPositiveSaturation$get(self(), index);
  }

  public final int getLPositiveCoefficient(long index) {
    return dinput_h.DICONDITION.lPositiveCoefficient$get(self(), index);
  }

  public final int getLPositiveCoefficient() {
    return dinput_h.DICONDITION.lPositiveCoefficient$get(self());
  }

  public final void setLOffset(long index, int x) {
    dinput_h.DICONDITION.lOffset$set(self(), index, x);
  }

  public final void setLOffset(int x) {
    dinput_h.DICONDITION.lOffset$set(self(), x);
  }

  public final void setLDeadBand(int x) {
    dinput_h.DICONDITION.lDeadBand$set(self(), x);
  }

  public final void setLDeadBand(long index, int x) {
    dinput_h.DICONDITION.lDeadBand$set(self(), index, x);
  }

  public final int getLOffset() {
    return dinput_h.DICONDITION.lOffset$get(self());
  }

  public final int getLOffset(long index) {
    return dinput_h.DICONDITION.lOffset$get(self(), index);
  }

  public final int getLDeadBand() {
    return dinput_h.DICONDITION.lDeadBand$get(self());
  }

  public final int getLDeadBand(long index) {
    return dinput_h.DICONDITION.lDeadBand$get(self(), index);
  }
}
