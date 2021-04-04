package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h._DICONFIGUREDEVICESPARAMSW dinput_h._DICONFIGUREDEVICESPARAMSW}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * MemorySegment getDics()
 * int getDwSize()
 * int getDwSize(long index)
 * int getDwcFormats()
 * int getDwcFormats(long index)
 * int getDwcUsers()
 * int getDwcUsers(long index)
 * MemoryAddress getHwnd()
 * MemoryAddress getHwnd(long index)
 * MemoryAddress getLpUnkDDSTarget()
 * MemoryAddress getLpUnkDDSTarget(long index)
 * MemoryAddress getLprgFormats()
 * MemoryAddress getLprgFormats(long index)
 * MemoryAddress getLptszUserNames()
 * MemoryAddress getLptszUserNames(long index)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)
 * void setDwcFormats(int x)
 * void setDwcFormats(long index, int x)
 * void setDwcUsers(int x)
 * void setDwcUsers(long index, int x)
 * void setHwnd(MemoryAddress x)
 * void setHwnd(long index, MemoryAddress x)
 * void setLpUnkDDSTarget(MemoryAddress x)
 * void setLpUnkDDSTarget(long index, MemoryAddress x)
 * void setLprgFormats(MemoryAddress x)
 * void setLprgFormats(long index, MemoryAddress x)
 * void setLptszUserNames(MemoryAddress x)
 * void setLptszUserNames(long index, MemoryAddress x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * _DICONFIGUREDEVICESPARAMSW {
 *   b32 dwSize
 *   b32 dwcUsers
 *   b64 lptszUserNames
 *   b32 dwcFormats
 *   b64 lprgFormats
 *   b64 hwnd
 *   dics {
 *     b32 dwSize
 *     b32 cTextFore
 *     b32 cTextHighlight
 *     b32 cCalloutLine
 *     b32 cCalloutHighlight
 *     b32 cBorder
 *     b32 cControlFill
 *     b32 cHighlightFill
 *     b32 cAreaFill
 *   }
 *   b64 lpUnkDDSTarget
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
           type = _DICONFIGUREDEVICESPARAMSW
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class ConfigureDevicesParams {
  private final MemorySegment _self;

  public ConfigureDevicesParams(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public ConfigureDevicesParams(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.sizeof();
  }

  public final int getDwSize() {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.dwSize$get(self(), index);
  }

  public final void setDwSize(int x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.dwSize$set(self(), index, x);
  }

  public final void setDwcFormats(int x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.dwcFormats$set(self(), x);
  }

  public final void setDwcFormats(long index, int x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.dwcFormats$set(self(), index, x);
  }

  public final MemorySegment getDics() {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.dics$slice(self());
  }

  public final MemoryAddress getLpUnkDDSTarget(long index) {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.lpUnkDDSTarget$get(self(), index);
  }

  public final MemoryAddress getLpUnkDDSTarget() {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.lpUnkDDSTarget$get(self());
  }

  public final void setLprgFormats(long index, MemoryAddress x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.lprgFormats$set(self(), index, x);
  }

  public final void setLprgFormats(MemoryAddress x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.lprgFormats$set(self(), x);
  }

  public final int getDwcUsers(long index) {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.dwcUsers$get(self(), index);
  }

  public final int getDwcUsers() {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.dwcUsers$get(self());
  }

  public final void setDwcUsers(long index, int x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.dwcUsers$set(self(), index, x);
  }

  public final void setDwcUsers(int x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.dwcUsers$set(self(), x);
  }

  public final MemoryAddress getLptszUserNames() {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.lptszUserNames$get(self());
  }

  public final MemoryAddress getLptszUserNames(long index) {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.lptszUserNames$get(self(), index);
  }

  public final int getDwcFormats() {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.dwcFormats$get(self());
  }

  public final int getDwcFormats(long index) {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.dwcFormats$get(self(), index);
  }

  public final void setLpUnkDDSTarget(long index, MemoryAddress x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.lpUnkDDSTarget$set(self(), index, x);
  }

  public final void setLpUnkDDSTarget(MemoryAddress x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.lpUnkDDSTarget$set(self(), x);
  }

  public final MemoryAddress getLprgFormats() {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.lprgFormats$get(self());
  }

  public final MemoryAddress getLprgFormats(long index) {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.lprgFormats$get(self(), index);
  }

  public final void setLptszUserNames(MemoryAddress x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.lptszUserNames$set(self(), x);
  }

  public final void setLptszUserNames(long index, MemoryAddress x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.lptszUserNames$set(self(), index, x);
  }

  public final MemoryAddress getHwnd(long index) {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.hwnd$get(self(), index);
  }

  public final MemoryAddress getHwnd() {
    return dinput_h._DICONFIGUREDEVICESPARAMSW.hwnd$get(self());
  }

  public final void setHwnd(long index, MemoryAddress x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.hwnd$set(self(), index, x);
  }

  public final void setHwnd(MemoryAddress x) {
    dinput_h._DICONFIGUREDEVICESPARAMSW.hwnd$set(self(), x);
  }
}
