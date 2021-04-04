package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIDEVICEOBJECTINSTANCEW dinput_h.DIDEVICEOBJECTINSTANCEW}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwDimension()
 * int getDwDimension(long index)
 * int getDwFFForceResolution()
 * int getDwFFForceResolution(long index)
 * int getDwFFMaxForce()
 * int getDwFFMaxForce(long index)
 * int getDwFlags()
 * int getDwFlags(long index)
 * int getDwOfs()
 * int getDwOfs(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * int getDwType()
 * int getDwType(long index)
 * MemorySegment getGuidType()
 * MemorySegment getTszName()
 * short getWCollectionNumber()
 * short getWCollectionNumber(long index)
 * short getWDesignatorIndex()
 * short getWDesignatorIndex(long index)
 * short getWExponent()
 * short getWExponent(long index)
 * short getWReportId()
 * short getWReportId(long index)
 * short getWUsage()
 * short getWUsage(long index)
 * short getWUsagePage()
 * short getWUsagePage(long index)
 * void setDwDimension(int x)
 * void setDwDimension(long index, int x)
 * void setDwFFForceResolution(int x)
 * void setDwFFForceResolution(long index, int x)
 * void setDwFFMaxForce(int x)
 * void setDwFFMaxForce(long index, int x)
 * void setDwFlags(int x)
 * void setDwFlags(long index, int x)
 * void setDwOfs(int x)
 * void setDwOfs(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)
 * void setDwType(int x)
 * void setDwType(long index, int x)
 * void setWCollectionNumber(short x)
 * void setWCollectionNumber(long index, short x)
 * void setWDesignatorIndex(short x)
 * void setWDesignatorIndex(long index, short x)
 * void setWExponent(short x)
 * void setWExponent(long index, short x)
 * void setWReportId(short x)
 * void setWReportId(long index, short x)
 * void setWUsage(short x)
 * void setWUsage(long index, short x)
 * void setWUsagePage(short x)
 * void setWUsagePage(long index, short x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIDEVICEOBJECTINSTANCEW {
 *   b32 dwSize
 *   guidType {
 *     b32 Data1
 *     b16 Data2
 *     b16 Data3
 *     b8[8] Data4
 *   }
 *   b32 dwOfs
 *   b32 dwType
 *   b32 dwFlags
 *   b16[260] tszName
 *   b32 dwFFMaxForce
 *   b32 dwFFForceResolution
 *   b16 wCollectionNumber
 *   b16 wDesignatorIndex
 *   b16 wUsagePage
 *   b16 wUsage
 *   b32 dwDimension
 *   b16 wExponent
 *   b16 wReportId
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
           type = DIDEVICEOBJECTINSTANCEW
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class DeviceObjectInstance {
  private final MemorySegment _self;

  public DeviceObjectInstance(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public DeviceObjectInstance(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.sizeof();
  }

  public final int getDwSize() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwSize$get(self(), index);
  }

  public final MemorySegment getTszName() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.tszName$slice(self());
  }

  public final void setDwSize(int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwSize$set(self(), index, x);
  }

  public final int getDwOfs(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwOfs$get(self(), index);
  }

  public final int getDwOfs() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwOfs$get(self());
  }

  public final void setDwOfs(long index, int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwOfs$set(self(), index, x);
  }

  public final void setDwOfs(int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwOfs$set(self(), x);
  }

  public final void setWUsage(short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wUsage$set(self(), x);
  }

  public final void setWUsage(long index, short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wUsage$set(self(), index, x);
  }

  public final void setWUsagePage(long index, short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wUsagePage$set(self(), index, x);
  }

  public final void setWUsagePage(short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wUsagePage$set(self(), x);
  }

  public final short getWUsagePage(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wUsagePage$get(self(), index);
  }

  public final short getWUsagePage() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wUsagePage$get(self());
  }

  public final short getWUsage() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wUsage$get(self());
  }

  public final short getWUsage(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wUsage$get(self(), index);
  }

  public final int getDwDimension(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwDimension$get(self(), index);
  }

  public final int getDwDimension() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwDimension$get(self());
  }

  public final void setDwDimension(int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwDimension$set(self(), x);
  }

  public final void setDwDimension(long index, int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwDimension$set(self(), index, x);
  }

  public final void setWExponent(short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wExponent$set(self(), x);
  }

  public final void setWExponent(long index, short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wExponent$set(self(), index, x);
  }

  public final short getWReportId() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wReportId$get(self());
  }

  public final short getWReportId(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wReportId$get(self(), index);
  }

  public final void setWReportId(long index, short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wReportId$set(self(), index, x);
  }

  public final void setWReportId(short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wReportId$set(self(), x);
  }

  public final void setDwFlags(long index, int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwFlags$set(self(), index, x);
  }

  public final void setDwFlags(int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwFlags$set(self(), x);
  }

  public final int getDwFFMaxForce() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwFFMaxForce$get(self());
  }

  public final int getDwFFMaxForce(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwFFMaxForce$get(self(), index);
  }

  public final void setDwFFMaxForce(int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwFFMaxForce$set(self(), x);
  }

  public final void setDwFFMaxForce(long index, int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwFFMaxForce$set(self(), index, x);
  }

  public final void setDwType(long index, int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwType$set(self(), index, x);
  }

  public final void setDwType(int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwType$set(self(), x);
  }

  public final int getDwType(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwType$get(self(), index);
  }

  public final int getDwType() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwType$get(self());
  }

  public final short getWExponent(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wExponent$get(self(), index);
  }

  public final short getWExponent() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wExponent$get(self());
  }

  public final int getDwFlags() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwFlags$get(self());
  }

  public final int getDwFlags(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwFlags$get(self(), index);
  }

  public final MemorySegment getGuidType() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.guidType$slice(self());
  }

  public final int getDwFFForceResolution(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwFFForceResolution$get(self(), index);
  }

  public final int getDwFFForceResolution() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.dwFFForceResolution$get(self());
  }

  public final short getWCollectionNumber() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wCollectionNumber$get(self());
  }

  public final short getWCollectionNumber(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wCollectionNumber$get(self(), index);
  }

  public final void setWCollectionNumber(long index, short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wCollectionNumber$set(self(), index, x);
  }

  public final void setWCollectionNumber(short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wCollectionNumber$set(self(), x);
  }

  public final short getWDesignatorIndex(long index) {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wDesignatorIndex$get(self(), index);
  }

  public final short getWDesignatorIndex() {
    return dinput_h.DIDEVICEOBJECTINSTANCEW.wDesignatorIndex$get(self());
  }

  public final void setWDesignatorIndex(long index, short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wDesignatorIndex$set(self(), index, x);
  }

  public final void setWDesignatorIndex(short x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.wDesignatorIndex$set(self(), x);
  }

  public final void setDwFFForceResolution(int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwFFForceResolution$set(self(), x);
  }

  public final void setDwFFForceResolution(long index, int x) {
    dinput_h.DIDEVICEOBJECTINSTANCEW.dwFFForceResolution$set(self(), index, x);
  }
}
