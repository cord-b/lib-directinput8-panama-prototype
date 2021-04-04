package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h._DICOLORSET dinput_h._DICOLORSET}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getCAreaFill()
 * int getCAreaFill(long index)
 * int getCBorder()
 * int getCBorder(long index)
 * int getCCalloutHighlight()
 * int getCCalloutHighlight(long index)
 * int getCCalloutLine()
 * int getCCalloutLine(long index)
 * int getCControlFill()
 * int getCControlFill(long index)
 * int getCHighlightFill()
 * int getCHighlightFill(long index)
 * int getCTextFore()
 * int getCTextFore(long index)
 * int getCTextHighlight()
 * int getCTextHighlight(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * void setCAreaFill(int x)
 * void setCAreaFill(long index, int x)
 * void setCBorder(int x)
 * void setCBorder(long index, int x)
 * void setCCalloutHighlight(int x)
 * void setCCalloutHighlight(long index, int x)
 * void setCCalloutLine(int x)
 * void setCCalloutLine(long index, int x)
 * void setCControlFill(int x)
 * void setCControlFill(long index, int x)
 * void setCHighlightFill(int x)
 * void setCHighlightFill(long index, int x)
 * void setCTextFore(int x)
 * void setCTextFore(long index, int x)
 * void setCTextHighlight(int x)
 * void setCTextHighlight(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * _DICOLORSET {
 *   b32 dwSize
 *   b32 cTextFore
 *   b32 cTextHighlight
 *   b32 cCalloutLine
 *   b32 cCalloutHighlight
 *   b32 cBorder
 *   b32 cControlFill
 *   b32 cHighlightFill
 *   b32 cAreaFill
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
           type = _DICOLORSET
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class ColorSet {
  private final MemorySegment _self;

  public ColorSet(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public ColorSet(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h._DICOLORSET.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h._DICOLORSET.sizeof();
  }

  public final int getCCalloutHighlight(long index) {
    return dinput_h._DICOLORSET.cCalloutHighlight$get(self(), index);
  }

  public final int getCCalloutHighlight() {
    return dinput_h._DICOLORSET.cCalloutHighlight$get(self());
  }

  public final void setCCalloutHighlight(int x) {
    dinput_h._DICOLORSET.cCalloutHighlight$set(self(), x);
  }

  public final void setCCalloutHighlight(long index, int x) {
    dinput_h._DICOLORSET.cCalloutHighlight$set(self(), index, x);
  }

  public final int getDwSize() {
    return dinput_h._DICOLORSET.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h._DICOLORSET.dwSize$get(self(), index);
  }

  public final void setDwSize(int x) {
    dinput_h._DICOLORSET.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h._DICOLORSET.dwSize$set(self(), index, x);
  }

  public final int getCTextFore(long index) {
    return dinput_h._DICOLORSET.cTextFore$get(self(), index);
  }

  public final int getCTextFore() {
    return dinput_h._DICOLORSET.cTextFore$get(self());
  }

  public final int getCCalloutLine(long index) {
    return dinput_h._DICOLORSET.cCalloutLine$get(self(), index);
  }

  public final int getCCalloutLine() {
    return dinput_h._DICOLORSET.cCalloutLine$get(self());
  }

  public final int getCHighlightFill(long index) {
    return dinput_h._DICOLORSET.cHighlightFill$get(self(), index);
  }

  public final int getCHighlightFill() {
    return dinput_h._DICOLORSET.cHighlightFill$get(self());
  }

  public final void setCHighlightFill(int x) {
    dinput_h._DICOLORSET.cHighlightFill$set(self(), x);
  }

  public final void setCHighlightFill(long index, int x) {
    dinput_h._DICOLORSET.cHighlightFill$set(self(), index, x);
  }

  public final int getCBorder(long index) {
    return dinput_h._DICOLORSET.cBorder$get(self(), index);
  }

  public final int getCBorder() {
    return dinput_h._DICOLORSET.cBorder$get(self());
  }

  public final int getCTextHighlight() {
    return dinput_h._DICOLORSET.cTextHighlight$get(self());
  }

  public final int getCTextHighlight(long index) {
    return dinput_h._DICOLORSET.cTextHighlight$get(self(), index);
  }

  public final void setCCalloutLine(int x) {
    dinput_h._DICOLORSET.cCalloutLine$set(self(), x);
  }

  public final void setCCalloutLine(long index, int x) {
    dinput_h._DICOLORSET.cCalloutLine$set(self(), index, x);
  }

  public final void setCBorder(long index, int x) {
    dinput_h._DICOLORSET.cBorder$set(self(), index, x);
  }

  public final void setCBorder(int x) {
    dinput_h._DICOLORSET.cBorder$set(self(), x);
  }

  public final void setCControlFill(long index, int x) {
    dinput_h._DICOLORSET.cControlFill$set(self(), index, x);
  }

  public final void setCControlFill(int x) {
    dinput_h._DICOLORSET.cControlFill$set(self(), x);
  }

  public final int getCControlFill() {
    return dinput_h._DICOLORSET.cControlFill$get(self());
  }

  public final int getCControlFill(long index) {
    return dinput_h._DICOLORSET.cControlFill$get(self(), index);
  }

  public final void setCAreaFill(int x) {
    dinput_h._DICOLORSET.cAreaFill$set(self(), x);
  }

  public final void setCAreaFill(long index, int x) {
    dinput_h._DICOLORSET.cAreaFill$set(self(), index, x);
  }

  public final void setCTextFore(long index, int x) {
    dinput_h._DICOLORSET.cTextFore$set(self(), index, x);
  }

  public final void setCTextFore(int x) {
    dinput_h._DICOLORSET.cTextFore$set(self(), x);
  }

  public final void setCTextHighlight(int x) {
    dinput_h._DICOLORSET.cTextHighlight$set(self(), x);
  }

  public final void setCTextHighlight(long index, int x) {
    dinput_h._DICOLORSET.cTextHighlight$set(self(), index, x);
  }

  public final int getCAreaFill(long index) {
    return dinput_h._DICOLORSET.cAreaFill$get(self(), index);
  }

  public final int getCAreaFill() {
    return dinput_h._DICOLORSET.cAreaFill$get(self());
  }
}
