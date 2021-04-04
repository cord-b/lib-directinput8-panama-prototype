package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIPROPPOINTER dinput_h.DIPROPPOINTER}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * MemorySegment getDiph()
 * long getUData()
 * long getUData(long index)
 * void setUData(long x)
 * void setUData(long index, long x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIPROPPOINTER {
 *   diph {
 *     b32 dwSize
 *     b32 dwHeaderSize
 *     b32 dwObj
 *     b32 dwHow
 *   }
 *   b64 uData
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
           type = DIPROPPOINTER
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class PropPointer {
  private final MemorySegment _self;

  public PropPointer(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public PropPointer(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIPROPPOINTER.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIPROPPOINTER.sizeof();
  }

  public final MemorySegment getDiph() {
    return dinput_h.DIPROPPOINTER.diph$slice(self());
  }

  public final void setUData(long index, long x) {
    dinput_h.DIPROPPOINTER.uData$set(self(), index, x);
  }

  public final void setUData(long x) {
    dinput_h.DIPROPPOINTER.uData$set(self(), x);
  }

  public final long getUData() {
    return dinput_h.DIPROPPOINTER.uData$get(self());
  }

  public final long getUData(long index) {
    return dinput_h.DIPROPPOINTER.uData$get(self(), index);
  }
}
