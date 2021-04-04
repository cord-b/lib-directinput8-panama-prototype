package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIPROPCPOINTS dinput_h.DIPROPCPOINTS}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * MemorySegment getCp()
 * MemorySegment getDiph()
 * int getDwCPointsNum()
 * int getDwCPointsNum(long index)
 * void setDwCPointsNum(int x)
 * void setDwCPointsNum(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIPROPCPOINTS {
 *   diph {
 *     b32 dwSize
 *     b32 dwHeaderSize
 *     b32 dwObj
 *     b32 dwHow
 *   }
 *   b32 dwCPointsNum
 *   _CPOINT {
 *     b32 lP
 *     b32 dwLog
 *   }[8] cp
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
           type = DIPROPCPOINTS
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class PropCPoints {
  private final MemorySegment _self;

  public PropCPoints(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public PropCPoints(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIPROPCPOINTS.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIPROPCPOINTS.sizeof();
  }

  public final MemorySegment getDiph() {
    return dinput_h.DIPROPCPOINTS.diph$slice(self());
  }

  public final MemorySegment getCp() {
    return dinput_h.DIPROPCPOINTS.cp$slice(self());
  }

  public final void setDwCPointsNum(int x) {
    dinput_h.DIPROPCPOINTS.dwCPointsNum$set(self(), x);
  }

  public final void setDwCPointsNum(long index, int x) {
    dinput_h.DIPROPCPOINTS.dwCPointsNum$set(self(), index, x);
  }

  public final int getDwCPointsNum() {
    return dinput_h.DIPROPCPOINTS.dwCPointsNum$get(self());
  }

  public final int getDwCPointsNum(long index) {
    return dinput_h.DIPROPCPOINTS.dwCPointsNum$get(self(), index);
  }
}
