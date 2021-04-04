package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIPROPDWORD dinput_h.DIPROPDWORD}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * MemorySegment getDiph()
 * int getDwData()
 * int getDwData(long index)
 * void setDwData(int x)
 * void setDwData(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIPROPDWORD {
 *   diph {
 *     b32 dwSize
 *     b32 dwHeaderSize
 *     b32 dwObj
 *     b32 dwHow
 *   }
 *   b32 dwData
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
           type = DIPROPDWORD
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class PropDword {
  private final MemorySegment _self;

  public PropDword(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public PropDword(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIPROPDWORD.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIPROPDWORD.sizeof();
  }

  public final void setDwData(int x) {
    dinput_h.DIPROPDWORD.dwData$set(self(), x);
  }

  public final void setDwData(long index, int x) {
    dinput_h.DIPROPDWORD.dwData$set(self(), index, x);
  }

  public final int getDwData() {
    return dinput_h.DIPROPDWORD.dwData$get(self());
  }

  public final int getDwData(long index) {
    return dinput_h.DIPROPDWORD.dwData$get(self(), index);
  }

  public final MemorySegment getDiph() {
    return dinput_h.DIPROPDWORD.diph$slice(self());
  }
}
