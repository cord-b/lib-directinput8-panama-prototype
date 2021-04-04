package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIEFFECTINFOW dinput_h.DIEFFECTINFOW}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwDynamicParams()
 * int getDwDynamicParams(long index)
 * int getDwEffType()
 * int getDwEffType(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * int getDwStaticParams()
 * int getDwStaticParams(long index)
 * MemorySegment getGuid()
 * MemorySegment getTszName()
 * void setDwDynamicParams(int x)
 * void setDwDynamicParams(long index, int x)
 * void setDwEffType(int x)
 * void setDwEffType(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)
 * void setDwStaticParams(int x)
 * void setDwStaticParams(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIEFFECTINFOW {
 *   b32 dwSize
 *   guid {
 *     b32 Data1
 *     b16 Data2
 *     b16 Data3
 *     b8[8] Data4
 *   }
 *   b32 dwEffType
 *   b32 dwStaticParams
 *   b32 dwDynamicParams
 *   b16[260] tszName
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
           type = DIEFFECTINFOW
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class EffectInfo {
  private final MemorySegment _self;

  public EffectInfo(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public EffectInfo(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIEFFECTINFOW.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIEFFECTINFOW.sizeof();
  }

  public final void setDwDynamicParams(long index, int x) {
    dinput_h.DIEFFECTINFOW.dwDynamicParams$set(self(), index, x);
  }

  public final void setDwDynamicParams(int x) {
    dinput_h.DIEFFECTINFOW.dwDynamicParams$set(self(), x);
  }

  public final int getDwDynamicParams(long index) {
    return dinput_h.DIEFFECTINFOW.dwDynamicParams$get(self(), index);
  }

  public final int getDwDynamicParams() {
    return dinput_h.DIEFFECTINFOW.dwDynamicParams$get(self());
  }

  public final MemorySegment getGuid() {
    return dinput_h.DIEFFECTINFOW.guid$slice(self());
  }

  public final void setDwStaticParams(long index, int x) {
    dinput_h.DIEFFECTINFOW.dwStaticParams$set(self(), index, x);
  }

  public final void setDwStaticParams(int x) {
    dinput_h.DIEFFECTINFOW.dwStaticParams$set(self(), x);
  }

  public final int getDwEffType() {
    return dinput_h.DIEFFECTINFOW.dwEffType$get(self());
  }

  public final int getDwEffType(long index) {
    return dinput_h.DIEFFECTINFOW.dwEffType$get(self(), index);
  }

  public final MemorySegment getTszName() {
    return dinput_h.DIEFFECTINFOW.tszName$slice(self());
  }

  public final int getDwSize() {
    return dinput_h.DIEFFECTINFOW.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h.DIEFFECTINFOW.dwSize$get(self(), index);
  }

  public final void setDwSize(int x) {
    dinput_h.DIEFFECTINFOW.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h.DIEFFECTINFOW.dwSize$set(self(), index, x);
  }

  public final int getDwStaticParams(long index) {
    return dinput_h.DIEFFECTINFOW.dwStaticParams$get(self(), index);
  }

  public final int getDwStaticParams() {
    return dinput_h.DIEFFECTINFOW.dwStaticParams$get(self());
  }

  public final void setDwEffType(int x) {
    dinput_h.DIEFFECTINFOW.dwEffType$set(self(), x);
  }

  public final void setDwEffType(long index, int x) {
    dinput_h.DIEFFECTINFOW.dwEffType$set(self(), index, x);
  }
}
