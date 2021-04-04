package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIFILEEFFECT dinput_h.DIFILEEFFECT}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwSize()
 * int getDwSize(long index)
 * MemorySegment getGuidEffect()
 * MemoryAddress getLpDiEffect()
 * MemoryAddress getLpDiEffect(long index)
 * MemorySegment getSzFriendlyName()
 * void setDwSize(int x)
 * void setDwSize(long index, int x)
 * void setLpDiEffect(MemoryAddress x)
 * void setLpDiEffect(long index, MemoryAddress x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIFILEEFFECT {
 *   b32 dwSize
 *   GuidEffect {
 *     b32 Data1
 *     b16 Data2
 *     b16 Data3
 *     b8[8] Data4
 *   }
 *   b64 lpDiEffect
 *   b8[260] szFriendlyName
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
           type = DIFILEEFFECT
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class FileEffect {
  private final MemorySegment _self;

  public FileEffect(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public FileEffect(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIFILEEFFECT.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIFILEEFFECT.sizeof();
  }

  public final MemorySegment getSzFriendlyName() {
    return dinput_h.DIFILEEFFECT.szFriendlyName$slice(self());
  }

  public final int getDwSize() {
    return dinput_h.DIFILEEFFECT.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h.DIFILEEFFECT.dwSize$get(self(), index);
  }

  public final void setDwSize(int x) {
    dinput_h.DIFILEEFFECT.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h.DIFILEEFFECT.dwSize$set(self(), index, x);
  }

  public final MemorySegment getGuidEffect() {
    return dinput_h.DIFILEEFFECT.GuidEffect$slice(self());
  }

  public final void setLpDiEffect(MemoryAddress x) {
    dinput_h.DIFILEEFFECT.lpDiEffect$set(self(), x);
  }

  public final void setLpDiEffect(long index, MemoryAddress x) {
    dinput_h.DIFILEEFFECT.lpDiEffect$set(self(), index, x);
  }

  public final MemoryAddress getLpDiEffect(long index) {
    return dinput_h.DIFILEEFFECT.lpDiEffect$get(self(), index);
  }

  public final MemoryAddress getLpDiEffect() {
    return dinput_h.DIFILEEFFECT.lpDiEffect$get(self());
  }
}
