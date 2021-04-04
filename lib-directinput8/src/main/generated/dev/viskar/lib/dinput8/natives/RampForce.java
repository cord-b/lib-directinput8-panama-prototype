package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIRAMPFORCE dinput_h.DIRAMPFORCE}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getLEnd()
 * int getLEnd(long index)
 * int getLStart()
 * int getLStart(long index)
 * void setLEnd(int x)
 * void setLEnd(long index, int x)
 * void setLStart(int x)
 * void setLStart(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIRAMPFORCE {
 *   b32 lStart
 *   b32 lEnd
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
           type = DIRAMPFORCE
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class RampForce {
  private final MemorySegment _self;

  public RampForce(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public RampForce(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIRAMPFORCE.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIRAMPFORCE.sizeof();
  }

  public final int getLEnd(long index) {
    return dinput_h.DIRAMPFORCE.lEnd$get(self(), index);
  }

  public final int getLEnd() {
    return dinput_h.DIRAMPFORCE.lEnd$get(self());
  }

  public final void setLStart(long index, int x) {
    dinput_h.DIRAMPFORCE.lStart$set(self(), index, x);
  }

  public final void setLStart(int x) {
    dinput_h.DIRAMPFORCE.lStart$set(self(), x);
  }

  public final void setLEnd(int x) {
    dinput_h.DIRAMPFORCE.lEnd$set(self(), x);
  }

  public final void setLEnd(long index, int x) {
    dinput_h.DIRAMPFORCE.lEnd$set(self(), index, x);
  }

  public final int getLStart() {
    return dinput_h.DIRAMPFORCE.lStart$get(self());
  }

  public final int getLStart(long index) {
    return dinput_h.DIRAMPFORCE.lStart$get(self(), index);
  }
}
