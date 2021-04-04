package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIPERIODIC dinput_h.DIPERIODIC}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwMagnitude()
 * int getDwMagnitude(long index)
 * int getDwPeriod()
 * int getDwPeriod(long index)
 * int getDwPhase()
 * int getDwPhase(long index)
 * int getLOffset()
 * int getLOffset(long index)
 * void setDwMagnitude(int x)
 * void setDwMagnitude(long index, int x)
 * void setDwPeriod(int x)
 * void setDwPeriod(long index, int x)
 * void setDwPhase(int x)
 * void setDwPhase(long index, int x)
 * void setLOffset(int x)
 * void setLOffset(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIPERIODIC {
 *   b32 dwMagnitude
 *   b32 lOffset
 *   b32 dwPhase
 *   b32 dwPeriod
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
           type = DIPERIODIC
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class Periodic {
  private final MemorySegment _self;

  public Periodic(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public Periodic(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIPERIODIC.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIPERIODIC.sizeof();
  }

  public final int getDwPhase() {
    return dinput_h.DIPERIODIC.dwPhase$get(self());
  }

  public final int getDwPhase(long index) {
    return dinput_h.DIPERIODIC.dwPhase$get(self(), index);
  }

  public final void setDwPhase(int x) {
    dinput_h.DIPERIODIC.dwPhase$set(self(), x);
  }

  public final void setDwPhase(long index, int x) {
    dinput_h.DIPERIODIC.dwPhase$set(self(), index, x);
  }

  public final void setLOffset(long index, int x) {
    dinput_h.DIPERIODIC.lOffset$set(self(), index, x);
  }

  public final void setLOffset(int x) {
    dinput_h.DIPERIODIC.lOffset$set(self(), x);
  }

  public final int getLOffset(long index) {
    return dinput_h.DIPERIODIC.lOffset$get(self(), index);
  }

  public final int getLOffset() {
    return dinput_h.DIPERIODIC.lOffset$get(self());
  }

  public final void setDwMagnitude(int x) {
    dinput_h.DIPERIODIC.dwMagnitude$set(self(), x);
  }

  public final void setDwMagnitude(long index, int x) {
    dinput_h.DIPERIODIC.dwMagnitude$set(self(), index, x);
  }

  public final int getDwMagnitude() {
    return dinput_h.DIPERIODIC.dwMagnitude$get(self());
  }

  public final int getDwMagnitude(long index) {
    return dinput_h.DIPERIODIC.dwMagnitude$get(self(), index);
  }

  public final int getDwPeriod() {
    return dinput_h.DIPERIODIC.dwPeriod$get(self());
  }

  public final int getDwPeriod(long index) {
    return dinput_h.DIPERIODIC.dwPeriod$get(self(), index);
  }

  public final void setDwPeriod(long index, int x) {
    dinput_h.DIPERIODIC.dwPeriod$set(self(), index, x);
  }

  public final void setDwPeriod(int x) {
    dinput_h.DIPERIODIC.dwPeriod$set(self(), x);
  }
}
