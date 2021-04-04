package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIDEVICEINSTANCEW dinput_h.DIDEVICEINSTANCEW}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwDevType()
 * int getDwDevType(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * MemorySegment getGuidFFDriver()
 * MemorySegment getGuidInstance()
 * MemorySegment getGuidProduct()
 * MemorySegment getTszInstanceName()
 * MemorySegment getTszProductName()
 * short getWUsage()
 * short getWUsage(long index)
 * short getWUsagePage()
 * short getWUsagePage(long index)
 * void setDwDevType(int x)
 * void setDwDevType(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)
 * void setWUsage(short x)
 * void setWUsage(long index, short x)
 * void setWUsagePage(short x)
 * void setWUsagePage(long index, short x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIDEVICEINSTANCEW {
 *   b32 dwSize
 *   guidInstance {
 *     b32 Data1
 *     b16 Data2
 *     b16 Data3
 *     b8[8] Data4
 *   }
 *   guidProduct {
 *     b32 Data1
 *     b16 Data2
 *     b16 Data3
 *     b8[8] Data4
 *   }
 *   b32 dwDevType
 *   b16[260] tszInstanceName
 *   b16[260] tszProductName
 *   guidFFDriver {
 *     b32 Data1
 *     b16 Data2
 *     b16 Data3
 *     b8[8] Data4
 *   }
 *   b16 wUsagePage
 *   b16 wUsage
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
           type = DIDEVICEINSTANCEW
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class DeviceInstance {
  private final MemorySegment _self;

  public DeviceInstance(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public DeviceInstance(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIDEVICEINSTANCEW.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIDEVICEINSTANCEW.sizeof();
  }

  public final int getDwSize() {
    return dinput_h.DIDEVICEINSTANCEW.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h.DIDEVICEINSTANCEW.dwSize$get(self(), index);
  }

  public final void setDwSize(int x) {
    dinput_h.DIDEVICEINSTANCEW.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h.DIDEVICEINSTANCEW.dwSize$set(self(), index, x);
  }

  public final MemorySegment getGuidInstance() {
    return dinput_h.DIDEVICEINSTANCEW.guidInstance$slice(self());
  }

  public final MemorySegment getGuidProduct() {
    return dinput_h.DIDEVICEINSTANCEW.guidProduct$slice(self());
  }

  public final void setWUsage(long index, short x) {
    dinput_h.DIDEVICEINSTANCEW.wUsage$set(self(), index, x);
  }

  public final void setWUsage(short x) {
    dinput_h.DIDEVICEINSTANCEW.wUsage$set(self(), x);
  }

  public final void setWUsagePage(long index, short x) {
    dinput_h.DIDEVICEINSTANCEW.wUsagePage$set(self(), index, x);
  }

  public final void setWUsagePage(short x) {
    dinput_h.DIDEVICEINSTANCEW.wUsagePage$set(self(), x);
  }

  public final MemorySegment getGuidFFDriver() {
    return dinput_h.DIDEVICEINSTANCEW.guidFFDriver$slice(self());
  }

  public final void setDwDevType(long index, int x) {
    dinput_h.DIDEVICEINSTANCEW.dwDevType$set(self(), index, x);
  }

  public final void setDwDevType(int x) {
    dinput_h.DIDEVICEINSTANCEW.dwDevType$set(self(), x);
  }

  public final short getWUsagePage() {
    return dinput_h.DIDEVICEINSTANCEW.wUsagePage$get(self());
  }

  public final short getWUsagePage(long index) {
    return dinput_h.DIDEVICEINSTANCEW.wUsagePage$get(self(), index);
  }

  public final short getWUsage() {
    return dinput_h.DIDEVICEINSTANCEW.wUsage$get(self());
  }

  public final short getWUsage(long index) {
    return dinput_h.DIDEVICEINSTANCEW.wUsage$get(self(), index);
  }

  public final int getDwDevType() {
    return dinput_h.DIDEVICEINSTANCEW.dwDevType$get(self());
  }

  public final int getDwDevType(long index) {
    return dinput_h.DIDEVICEINSTANCEW.dwDevType$get(self(), index);
  }

  public final MemorySegment getTszInstanceName() {
    return dinput_h.DIDEVICEINSTANCEW.tszInstanceName$slice(self());
  }

  public final MemorySegment getTszProductName() {
    return dinput_h.DIDEVICEINSTANCEW.tszProductName$slice(self());
  }
}
