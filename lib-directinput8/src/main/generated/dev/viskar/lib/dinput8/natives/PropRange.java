package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIPROPRANGE dinput_h.DIPROPRANGE}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * MemorySegment getDiph()
 * int getLMax()
 * int getLMax(long index)
 * int getLMin()
 * int getLMin(long index)
 * void setLMax(int x)
 * void setLMax(long index, int x)
 * void setLMin(int x)
 * void setLMin(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIPROPRANGE {
 *   diph {
 *     b32 dwSize
 *     b32 dwHeaderSize
 *     b32 dwObj
 *     b32 dwHow
 *   }
 *   b32 lMin
 *   b32 lMax
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
           type = DIPROPRANGE
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class PropRange {
  private final MemorySegment _self;

  public PropRange(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public PropRange(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIPROPRANGE.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIPROPRANGE.sizeof();
  }

  public final MemorySegment getDiph() {
    return dinput_h.DIPROPRANGE.diph$slice(self());
  }

  public final int getLMin() {
    return dinput_h.DIPROPRANGE.lMin$get(self());
  }

  public final int getLMin(long index) {
    return dinput_h.DIPROPRANGE.lMin$get(self(), index);
  }

  public final int getLMax(long index) {
    return dinput_h.DIPROPRANGE.lMax$get(self(), index);
  }

  public final int getLMax() {
    return dinput_h.DIPROPRANGE.lMax$get(self());
  }

  public final void setLMax(long index, int x) {
    dinput_h.DIPROPRANGE.lMax$set(self(), index, x);
  }

  public final void setLMax(int x) {
    dinput_h.DIPROPRANGE.lMax$set(self(), x);
  }

  public final void setLMin(int x) {
    dinput_h.DIPROPRANGE.lMin$set(self(), x);
  }

  public final void setLMin(long index, int x) {
    dinput_h.DIPROPRANGE.lMin$set(self(), index, x);
  }
}
