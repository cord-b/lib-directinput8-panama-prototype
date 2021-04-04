package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIENVELOPE dinput_h.DIENVELOPE}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwAttackLevel()
 * int getDwAttackLevel(long index)
 * int getDwAttackTime()
 * int getDwAttackTime(long index)
 * int getDwFadeLevel()
 * int getDwFadeLevel(long index)
 * int getDwFadeTime()
 * int getDwFadeTime(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * void setDwAttackLevel(int x)
 * void setDwAttackLevel(long index, int x)
 * void setDwAttackTime(int x)
 * void setDwAttackTime(long index, int x)
 * void setDwFadeLevel(int x)
 * void setDwFadeLevel(long index, int x)
 * void setDwFadeTime(int x)
 * void setDwFadeTime(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIENVELOPE {
 *   b32 dwSize
 *   b32 dwAttackLevel
 *   b32 dwAttackTime
 *   b32 dwFadeLevel
 *   b32 dwFadeTime
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
           type = DIENVELOPE
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class Envelope {
  private final MemorySegment _self;

  public Envelope(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public Envelope(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIENVELOPE.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIENVELOPE.sizeof();
  }

  public final int getDwSize() {
    return dinput_h.DIENVELOPE.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h.DIENVELOPE.dwSize$get(self(), index);
  }

  public final void setDwSize(int x) {
    dinput_h.DIENVELOPE.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h.DIENVELOPE.dwSize$set(self(), index, x);
  }

  public final void setDwFadeLevel(int x) {
    dinput_h.DIENVELOPE.dwFadeLevel$set(self(), x);
  }

  public final void setDwFadeLevel(long index, int x) {
    dinput_h.DIENVELOPE.dwFadeLevel$set(self(), index, x);
  }

  public final int getDwFadeLevel() {
    return dinput_h.DIENVELOPE.dwFadeLevel$get(self());
  }

  public final int getDwFadeLevel(long index) {
    return dinput_h.DIENVELOPE.dwFadeLevel$get(self(), index);
  }

  public final void setDwAttackTime(int x) {
    dinput_h.DIENVELOPE.dwAttackTime$set(self(), x);
  }

  public final void setDwAttackTime(long index, int x) {
    dinput_h.DIENVELOPE.dwAttackTime$set(self(), index, x);
  }

  public final void setDwFadeTime(long index, int x) {
    dinput_h.DIENVELOPE.dwFadeTime$set(self(), index, x);
  }

  public final void setDwFadeTime(int x) {
    dinput_h.DIENVELOPE.dwFadeTime$set(self(), x);
  }

  public final int getDwAttackTime() {
    return dinput_h.DIENVELOPE.dwAttackTime$get(self());
  }

  public final int getDwAttackTime(long index) {
    return dinput_h.DIENVELOPE.dwAttackTime$get(self(), index);
  }

  public final int getDwAttackLevel() {
    return dinput_h.DIENVELOPE.dwAttackLevel$get(self());
  }

  public final int getDwAttackLevel(long index) {
    return dinput_h.DIENVELOPE.dwAttackLevel$get(self(), index);
  }

  public final void setDwAttackLevel(int x) {
    dinput_h.DIENVELOPE.dwAttackLevel$set(self(), x);
  }

  public final void setDwAttackLevel(long index, int x) {
    dinput_h.DIENVELOPE.dwAttackLevel$set(self(), index, x);
  }

  public final int getDwFadeTime(long index) {
    return dinput_h.DIENVELOPE.dwFadeTime$get(self(), index);
  }

  public final int getDwFadeTime() {
    return dinput_h.DIENVELOPE.dwFadeTime$get(self());
  }
}
