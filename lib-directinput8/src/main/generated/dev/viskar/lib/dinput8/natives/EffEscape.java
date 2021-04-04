package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIEFFESCAPE dinput_h.DIEFFESCAPE}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getCbInBuffer()
 * int getCbInBuffer(long index)
 * int getCbOutBuffer()
 * int getCbOutBuffer(long index)
 * int getDwCommand()
 * int getDwCommand(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * MemoryAddress getLpvInBuffer()
 * MemoryAddress getLpvInBuffer(long index)
 * MemoryAddress getLpvOutBuffer()
 * MemoryAddress getLpvOutBuffer(long index)
 * void setCbInBuffer(int x)
 * void setCbInBuffer(long index, int x)
 * void setCbOutBuffer(int x)
 * void setCbOutBuffer(long index, int x)
 * void setDwCommand(int x)
 * void setDwCommand(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)
 * void setLpvInBuffer(MemoryAddress x)
 * void setLpvInBuffer(long index, MemoryAddress x)
 * void setLpvOutBuffer(MemoryAddress x)
 * void setLpvOutBuffer(long index, MemoryAddress x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIEFFESCAPE {
 *   b32 dwSize
 *   b32 dwCommand
 *   b64 lpvInBuffer
 *   b32 cbInBuffer
 *   b64 lpvOutBuffer
 *   b32 cbOutBuffer
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
           type = DIEFFESCAPE
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class EffEscape {
  private final MemorySegment _self;

  public EffEscape(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public EffEscape(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIEFFESCAPE.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIEFFESCAPE.sizeof();
  }

  public final int getDwSize() {
    return dinput_h.DIEFFESCAPE.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h.DIEFFESCAPE.dwSize$get(self(), index);
  }

  public final void setDwSize(int x) {
    dinput_h.DIEFFESCAPE.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h.DIEFFESCAPE.dwSize$set(self(), index, x);
  }

  public final int getDwCommand(long index) {
    return dinput_h.DIEFFESCAPE.dwCommand$get(self(), index);
  }

  public final int getDwCommand() {
    return dinput_h.DIEFFESCAPE.dwCommand$get(self());
  }

  public final void setDwCommand(int x) {
    dinput_h.DIEFFESCAPE.dwCommand$set(self(), x);
  }

  public final void setDwCommand(long index, int x) {
    dinput_h.DIEFFESCAPE.dwCommand$set(self(), index, x);
  }

  public final MemoryAddress getLpvInBuffer() {
    return dinput_h.DIEFFESCAPE.lpvInBuffer$get(self());
  }

  public final MemoryAddress getLpvInBuffer(long index) {
    return dinput_h.DIEFFESCAPE.lpvInBuffer$get(self(), index);
  }

  public final int getCbOutBuffer() {
    return dinput_h.DIEFFESCAPE.cbOutBuffer$get(self());
  }

  public final int getCbOutBuffer(long index) {
    return dinput_h.DIEFFESCAPE.cbOutBuffer$get(self(), index);
  }

  public final void setLpvInBuffer(MemoryAddress x) {
    dinput_h.DIEFFESCAPE.lpvInBuffer$set(self(), x);
  }

  public final void setLpvInBuffer(long index, MemoryAddress x) {
    dinput_h.DIEFFESCAPE.lpvInBuffer$set(self(), index, x);
  }

  public final int getCbInBuffer(long index) {
    return dinput_h.DIEFFESCAPE.cbInBuffer$get(self(), index);
  }

  public final int getCbInBuffer() {
    return dinput_h.DIEFFESCAPE.cbInBuffer$get(self());
  }

  public final void setCbOutBuffer(int x) {
    dinput_h.DIEFFESCAPE.cbOutBuffer$set(self(), x);
  }

  public final void setCbOutBuffer(long index, int x) {
    dinput_h.DIEFFESCAPE.cbOutBuffer$set(self(), index, x);
  }

  public final void setLpvOutBuffer(long index, MemoryAddress x) {
    dinput_h.DIEFFESCAPE.lpvOutBuffer$set(self(), index, x);
  }

  public final void setLpvOutBuffer(MemoryAddress x) {
    dinput_h.DIEFFESCAPE.lpvOutBuffer$set(self(), x);
  }

  public final void setCbInBuffer(long index, int x) {
    dinput_h.DIEFFESCAPE.cbInBuffer$set(self(), index, x);
  }

  public final void setCbInBuffer(int x) {
    dinput_h.DIEFFESCAPE.cbInBuffer$set(self(), x);
  }

  public final MemoryAddress getLpvOutBuffer(long index) {
    return dinput_h.DIEFFESCAPE.lpvOutBuffer$get(self(), index);
  }

  public final MemoryAddress getLpvOutBuffer() {
    return dinput_h.DIEFFESCAPE.lpvOutBuffer$get(self());
  }
}
