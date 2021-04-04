package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIPROPGUIDANDPATH dinput_h.DIPROPGUIDANDPATH}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * MemorySegment getDiph()
 * MemorySegment getGuidClass()
 * MemorySegment getWszPath()</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIPROPGUIDANDPATH {
 *   diph {
 *     b32 dwSize
 *     b32 dwHeaderSize
 *     b32 dwObj
 *     b32 dwHow
 *   }
 *   guidClass {
 *     b32 Data1
 *     b16 Data2
 *     b16 Data3
 *     b8[8] Data4
 *   }
 *   b16[260] wszPath
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
           type = DIPROPGUIDANDPATH
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class PropGuidAndPath {
  private final MemorySegment _self;

  public PropGuidAndPath(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public PropGuidAndPath(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIPROPGUIDANDPATH.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIPROPGUIDANDPATH.sizeof();
  }

  public final MemorySegment getDiph() {
    return dinput_h.DIPROPGUIDANDPATH.diph$slice(self());
  }

  public final MemorySegment getGuidClass() {
    return dinput_h.DIPROPGUIDANDPATH.guidClass$slice(self());
  }

  public final MemorySegment getWszPath() {
    return dinput_h.DIPROPGUIDANDPATH.wszPath$slice(self());
  }
}
