package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIPROPCAL dinput_h.DIPROPCAL}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * MemorySegment getDiph()
 * int getLCenter()
 * int getLCenter(long index)
 * int getLMax()
 * int getLMax(long index)
 * int getLMin()
 * int getLMin(long index)
 * void setLCenter(int x)
 * void setLCenter(long index, int x)
 * void setLMax(int x)
 * void setLMax(long index, int x)
 * void setLMin(int x)
 * void setLMin(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIPROPCAL {
 *   diph {
 *     b32 dwSize
 *     b32 dwHeaderSize
 *     b32 dwObj
 *     b32 dwHow
 *   }
 *   b32 lMin
 *   b32 lCenter
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
           type = DIPROPCAL
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class PropCal {
  private final MemorySegment _self;

  public PropCal(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public PropCal(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIPROPCAL.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIPROPCAL.sizeof();
  }

  public final MemorySegment getDiph() {
    return dinput_h.DIPROPCAL.diph$slice(self());
  }

  public final int getLMin() {
    return dinput_h.DIPROPCAL.lMin$get(self());
  }

  public final int getLMin(long index) {
    return dinput_h.DIPROPCAL.lMin$get(self(), index);
  }

  public final int getLMax(long index) {
    return dinput_h.DIPROPCAL.lMax$get(self(), index);
  }

  public final int getLMax() {
    return dinput_h.DIPROPCAL.lMax$get(self());
  }

  public final void setLMax(long index, int x) {
    dinput_h.DIPROPCAL.lMax$set(self(), index, x);
  }

  public final void setLMax(int x) {
    dinput_h.DIPROPCAL.lMax$set(self(), x);
  }

  public final int getLCenter() {
    return dinput_h.DIPROPCAL.lCenter$get(self());
  }

  public final int getLCenter(long index) {
    return dinput_h.DIPROPCAL.lCenter$get(self(), index);
  }

  public final void setLMin(long index, int x) {
    dinput_h.DIPROPCAL.lMin$set(self(), index, x);
  }

  public final void setLMin(int x) {
    dinput_h.DIPROPCAL.lMin$set(self(), x);
  }

  public final void setLCenter(int x) {
    dinput_h.DIPROPCAL.lCenter$set(self(), x);
  }

  public final void setLCenter(long index, int x) {
    dinput_h.DIPROPCAL.lCenter$set(self(), index, x);
  }
}
