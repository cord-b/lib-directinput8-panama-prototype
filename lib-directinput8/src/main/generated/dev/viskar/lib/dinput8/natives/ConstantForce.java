package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DICONSTANTFORCE dinput_h.DICONSTANTFORCE}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getLMagnitude()
 * int getLMagnitude(long index)
 * void setLMagnitude(int x)
 * void setLMagnitude(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DICONSTANTFORCE {
 *   b32 lMagnitude
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
           type = DICONSTANTFORCE
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class ConstantForce {
  private final MemorySegment _self;

  public ConstantForce(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public ConstantForce(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DICONSTANTFORCE.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DICONSTANTFORCE.sizeof();
  }

  public final int getLMagnitude(long index) {
    return dinput_h.DICONSTANTFORCE.lMagnitude$get(self(), index);
  }

  public final int getLMagnitude() {
    return dinput_h.DICONSTANTFORCE.lMagnitude$get(self());
  }

  public final void setLMagnitude(long index, int x) {
    dinput_h.DICONSTANTFORCE.lMagnitude$set(self(), index, x);
  }

  public final void setLMagnitude(int x) {
    dinput_h.DICONSTANTFORCE.lMagnitude$set(self(), x);
  }
}
