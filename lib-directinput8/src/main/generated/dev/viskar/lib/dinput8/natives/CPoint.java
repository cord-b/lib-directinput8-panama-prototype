package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h._CPOINT dinput_h._CPOINT}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwLog()
 * int getDwLog(long index)
 * int getLP()
 * int getLP(long index)
 * void setDwLog(int x)
 * void setDwLog(long index, int x)
 * void setLP(int x)
 * void setLP(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * _CPOINT {
 *   b32 lP
 *   b32 dwLog
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
           type = _CPOINT
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class CPoint {
  private final MemorySegment _self;

  public CPoint(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public CPoint(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h._CPOINT.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h._CPOINT.sizeof();
  }

  public final int getLP(long index) {
    return dinput_h._CPOINT.lP$get(self(), index);
  }

  public final int getLP() {
    return dinput_h._CPOINT.lP$get(self());
  }

  public final void setDwLog(int x) {
    dinput_h._CPOINT.dwLog$set(self(), x);
  }

  public final void setDwLog(long index, int x) {
    dinput_h._CPOINT.dwLog$set(self(), index, x);
  }

  public final int getDwLog() {
    return dinput_h._CPOINT.dwLog$get(self());
  }

  public final int getDwLog(long index) {
    return dinput_h._CPOINT.dwLog$get(self(), index);
  }

  public final void setLP(long index, int x) {
    dinput_h._CPOINT.lP$set(self(), index, x);
  }

  public final void setLP(int x) {
    dinput_h._CPOINT.lP$set(self(), x);
  }
}
