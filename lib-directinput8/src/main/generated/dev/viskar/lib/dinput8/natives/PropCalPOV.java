package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIPROPCALPOV dinput_h.DIPROPCALPOV}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * MemorySegment getDiph()
 * MemorySegment getLMax()
 * MemorySegment getLMin()</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIPROPCALPOV {
 *   diph {
 *     b32 dwSize
 *     b32 dwHeaderSize
 *     b32 dwObj
 *     b32 dwHow
 *   }
 *   b32[5] lMin
 *   b32[5] lMax
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
           type = DIPROPCALPOV
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class PropCalPOV {
  private final MemorySegment _self;

  public PropCalPOV(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public PropCalPOV(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIPROPCALPOV.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIPROPCALPOV.sizeof();
  }

  public final MemorySegment getDiph() {
    return dinput_h.DIPROPCALPOV.diph$slice(self());
  }

  public final MemorySegment getLMax() {
    return dinput_h.DIPROPCALPOV.lMax$slice(self());
  }

  public final MemorySegment getLMin() {
    return dinput_h.DIPROPCALPOV.lMin$slice(self());
  }
}
