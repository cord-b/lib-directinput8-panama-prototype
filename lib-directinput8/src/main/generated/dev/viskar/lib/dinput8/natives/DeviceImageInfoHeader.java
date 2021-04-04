package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h._DIDEVICEIMAGEINFOHEADERW dinput_h._DIDEVICEIMAGEINFOHEADERW}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwBufferSize()
 * int getDwBufferSize(long index)
 * int getDwBufferUsed()
 * int getDwBufferUsed(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * int getDwSizeImageInfo()
 * int getDwSizeImageInfo(long index)
 * int getDwcAxes()
 * int getDwcAxes(long index)
 * int getDwcButtons()
 * int getDwcButtons(long index)
 * int getDwcPOVs()
 * int getDwcPOVs(long index)
 * int getDwcViews()
 * int getDwcViews(long index)
 * MemoryAddress getLprgImageInfoArray()
 * MemoryAddress getLprgImageInfoArray(long index)
 * void setDwBufferSize(int x)
 * void setDwBufferSize(long index, int x)
 * void setDwBufferUsed(int x)
 * void setDwBufferUsed(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)
 * void setDwSizeImageInfo(int x)
 * void setDwSizeImageInfo(long index, int x)
 * void setDwcAxes(int x)
 * void setDwcAxes(long index, int x)
 * void setDwcButtons(int x)
 * void setDwcButtons(long index, int x)
 * void setDwcPOVs(int x)
 * void setDwcPOVs(long index, int x)
 * void setDwcViews(int x)
 * void setDwcViews(long index, int x)
 * void setLprgImageInfoArray(MemoryAddress x)
 * void setLprgImageInfoArray(long index, MemoryAddress x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * _DIDEVICEIMAGEINFOHEADERW {
 *   b32 dwSize
 *   b32 dwSizeImageInfo
 *   b32 dwcViews
 *   b32 dwcButtons
 *   b32 dwcAxes
 *   b32 dwcPOVs
 *   b32 dwBufferSize
 *   b32 dwBufferUsed
 *   b64 lprgImageInfoArray
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
           type = _DIDEVICEIMAGEINFOHEADERW
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class DeviceImageInfoHeader {
  private final MemorySegment _self;

  public DeviceImageInfoHeader(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public DeviceImageInfoHeader(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.sizeof();
  }

  public final int getDwSize() {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwSize$get(self(), index);
  }

  public final void setDwSize(int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwSize$set(self(), index, x);
  }

  public final void setDwBufferUsed(int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwBufferUsed$set(self(), x);
  }

  public final void setDwBufferUsed(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwBufferUsed$set(self(), index, x);
  }

  public final int getDwBufferSize() {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwBufferSize$get(self());
  }

  public final int getDwBufferSize(long index) {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwBufferSize$get(self(), index);
  }

  public final void setDwcAxes(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcAxes$set(self(), index, x);
  }

  public final void setDwcAxes(int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcAxes$set(self(), x);
  }

  public final int getDwcAxes() {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcAxes$get(self());
  }

  public final int getDwcAxes(long index) {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcAxes$get(self(), index);
  }

  public final void setDwcViews(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcViews$set(self(), index, x);
  }

  public final void setDwcViews(int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcViews$set(self(), x);
  }

  public final int getDwBufferUsed() {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwBufferUsed$get(self());
  }

  public final int getDwBufferUsed(long index) {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwBufferUsed$get(self(), index);
  }

  public final void setDwBufferSize(int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwBufferSize$set(self(), x);
  }

  public final void setDwBufferSize(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwBufferSize$set(self(), index, x);
  }

  public final int getDwcViews(long index) {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcViews$get(self(), index);
  }

  public final int getDwcViews() {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcViews$get(self());
  }

  public final int getDwcButtons() {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcButtons$get(self());
  }

  public final int getDwcButtons(long index) {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcButtons$get(self(), index);
  }

  public final void setDwcPOVs(int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcPOVs$set(self(), x);
  }

  public final void setDwcPOVs(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcPOVs$set(self(), index, x);
  }

  public final int getDwcPOVs(long index) {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcPOVs$get(self(), index);
  }

  public final int getDwcPOVs() {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcPOVs$get(self());
  }

  public final void setDwcButtons(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcButtons$set(self(), index, x);
  }

  public final void setDwcButtons(int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwcButtons$set(self(), x);
  }

  public final void setDwSizeImageInfo(long index, int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwSizeImageInfo$set(self(), index, x);
  }

  public final void setDwSizeImageInfo(int x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.dwSizeImageInfo$set(self(), x);
  }

  public final MemoryAddress getLprgImageInfoArray(long index) {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.lprgImageInfoArray$get(self(), index);
  }

  public final MemoryAddress getLprgImageInfoArray() {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.lprgImageInfoArray$get(self());
  }

  public final int getDwSizeImageInfo() {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwSizeImageInfo$get(self());
  }

  public final int getDwSizeImageInfo(long index) {
    return dinput_h._DIDEVICEIMAGEINFOHEADERW.dwSizeImageInfo$get(self(), index);
  }

  public final void setLprgImageInfoArray(MemoryAddress x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.lprgImageInfoArray$set(self(), x);
  }

  public final void setLprgImageInfoArray(long index, MemoryAddress x) {
    dinput_h._DIDEVICEIMAGEINFOHEADERW.lprgImageInfoArray$set(self(), index, x);
  }
}
