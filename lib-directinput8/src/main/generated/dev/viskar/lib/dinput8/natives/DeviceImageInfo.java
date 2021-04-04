package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h._DIDEVICEIMAGEINFOW dinput_h._DIDEVICEIMAGEINFOW}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwFlags()
 * int getDwFlags(long index)
 * int getDwObjID()
 * int getDwObjID(long index)
 * int getDwTextAlign()
 * int getDwTextAlign(long index)
 * int getDwViewID()
 * int getDwViewID(long index)
 * int getDwcValidPts()
 * int getDwcValidPts(long index)
 * MemorySegment getRcCalloutRect()
 * MemorySegment getRcOverlay()
 * MemorySegment getRgptCalloutLine()
 * MemorySegment getTszImagePath()
 * void setDwFlags(int x)
 * void setDwFlags(long index, int x)
 * void setDwObjID(int x)
 * void setDwObjID(long index, int x)
 * void setDwTextAlign(int x)
 * void setDwTextAlign(long index, int x)
 * void setDwViewID(int x)
 * void setDwViewID(long index, int x)
 * void setDwcValidPts(int x)
 * void setDwcValidPts(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * _DIDEVICEIMAGEINFOW {
 *   b16[260] tszImagePath
 *   b32 dwFlags
 *   b32 dwViewID
 *   rcOverlay {
 *     b32 left
 *     b32 top
 *     b32 right
 *     b32 bottom
 *   }
 *   b32 dwObjID
 *   b32 dwcValidPts
 *   tagPOINT {
 *     b32 x
 *     b32 y
 *   }[5] rgptCalloutLine
 *   rcCalloutRect {
 *     b32 left
 *     b32 top
 *     b32 right
 *     b32 bottom
 *   }
 *   b32 dwTextAlign
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
           type = _DIDEVICEIMAGEINFOW
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class DeviceImageInfo {
  private final MemorySegment _self;

  public DeviceImageInfo(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public DeviceImageInfo(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h._DIDEVICEIMAGEINFOW.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h._DIDEVICEIMAGEINFOW.sizeof();
  }

  public final MemorySegment getRcCalloutRect() {
    return dinput_h._DIDEVICEIMAGEINFOW.rcCalloutRect$slice(self());
  }

  public final MemorySegment getRgptCalloutLine() {
    return dinput_h._DIDEVICEIMAGEINFOW.rgptCalloutLine$slice(self());
  }

  public final int getDwFlags() {
    return dinput_h._DIDEVICEIMAGEINFOW.dwFlags$get(self());
  }

  public final int getDwFlags(long index) {
    return dinput_h._DIDEVICEIMAGEINFOW.dwFlags$get(self(), index);
  }

  public final void setDwFlags(int x) {
    dinput_h._DIDEVICEIMAGEINFOW.dwFlags$set(self(), x);
  }

  public final void setDwFlags(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOW.dwFlags$set(self(), index, x);
  }

  public final void setDwcValidPts(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOW.dwcValidPts$set(self(), index, x);
  }

  public final void setDwcValidPts(int x) {
    dinput_h._DIDEVICEIMAGEINFOW.dwcValidPts$set(self(), x);
  }

  public final int getDwcValidPts(long index) {
    return dinput_h._DIDEVICEIMAGEINFOW.dwcValidPts$get(self(), index);
  }

  public final int getDwcValidPts() {
    return dinput_h._DIDEVICEIMAGEINFOW.dwcValidPts$get(self());
  }

  public final MemorySegment getTszImagePath() {
    return dinput_h._DIDEVICEIMAGEINFOW.tszImagePath$slice(self());
  }

  public final int getDwViewID() {
    return dinput_h._DIDEVICEIMAGEINFOW.dwViewID$get(self());
  }

  public final int getDwViewID(long index) {
    return dinput_h._DIDEVICEIMAGEINFOW.dwViewID$get(self(), index);
  }

  public final void setDwViewID(int x) {
    dinput_h._DIDEVICEIMAGEINFOW.dwViewID$set(self(), x);
  }

  public final void setDwViewID(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOW.dwViewID$set(self(), index, x);
  }

  public final MemorySegment getRcOverlay() {
    return dinput_h._DIDEVICEIMAGEINFOW.rcOverlay$slice(self());
  }

  public final int getDwObjID() {
    return dinput_h._DIDEVICEIMAGEINFOW.dwObjID$get(self());
  }

  public final int getDwObjID(long index) {
    return dinput_h._DIDEVICEIMAGEINFOW.dwObjID$get(self(), index);
  }

  public final void setDwObjID(int x) {
    dinput_h._DIDEVICEIMAGEINFOW.dwObjID$set(self(), x);
  }

  public final void setDwObjID(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOW.dwObjID$set(self(), index, x);
  }

  public final void setDwTextAlign(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOW.dwTextAlign$set(self(), index, x);
  }

  public final void setDwTextAlign(int x) {
    dinput_h._DIDEVICEIMAGEINFOW.dwTextAlign$set(self(), x);
  }

  public final int getDwTextAlign(long index) {
    return dinput_h._DIDEVICEIMAGEINFOW.dwTextAlign$get(self(), index);
  }

  public final int getDwTextAlign() {
    return dinput_h._DIDEVICEIMAGEINFOW.dwTextAlign$get(self());
  }
}
