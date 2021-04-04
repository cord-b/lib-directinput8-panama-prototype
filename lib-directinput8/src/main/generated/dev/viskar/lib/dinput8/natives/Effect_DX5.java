package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIEFFECT_DX5 dinput_h.DIEFFECT_DX5}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getCAxes()
 * int getCAxes(long index)
 * int getCbTypeSpecificParams()
 * int getCbTypeSpecificParams(long index)
 * int getDwDuration()
 * int getDwDuration(long index)
 * int getDwFlags()
 * int getDwFlags(long index)
 * int getDwGain()
 * int getDwGain(long index)
 * int getDwSamplePeriod()
 * int getDwSamplePeriod(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * int getDwTriggerButton()
 * int getDwTriggerButton(long index)
 * int getDwTriggerRepeatInterval()
 * int getDwTriggerRepeatInterval(long index)
 * MemoryAddress getLpEnvelope()
 * MemoryAddress getLpEnvelope(long index)
 * MemoryAddress getLpvTypeSpecificParams()
 * MemoryAddress getLpvTypeSpecificParams(long index)
 * MemoryAddress getRgdwAxes()
 * MemoryAddress getRgdwAxes(long index)
 * MemoryAddress getRglDirection()
 * MemoryAddress getRglDirection(long index)
 * void setCAxes(int x)
 * void setCAxes(long index, int x)
 * void setCbTypeSpecificParams(int x)
 * void setCbTypeSpecificParams(long index, int x)
 * void setDwDuration(int x)
 * void setDwDuration(long index, int x)
 * void setDwFlags(int x)
 * void setDwFlags(long index, int x)
 * void setDwGain(int x)
 * void setDwGain(long index, int x)
 * void setDwSamplePeriod(int x)
 * void setDwSamplePeriod(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)
 * void setDwTriggerButton(int x)
 * void setDwTriggerButton(long index, int x)
 * void setDwTriggerRepeatInterval(int x)
 * void setDwTriggerRepeatInterval(long index, int x)
 * void setLpEnvelope(MemoryAddress x)
 * void setLpEnvelope(long index, MemoryAddress x)
 * void setLpvTypeSpecificParams(MemoryAddress x)
 * void setLpvTypeSpecificParams(long index, MemoryAddress x)
 * void setRgdwAxes(MemoryAddress x)
 * void setRgdwAxes(long index, MemoryAddress x)
 * void setRglDirection(MemoryAddress x)
 * void setRglDirection(long index, MemoryAddress x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIEFFECT_DX5 {
 *   b32 dwSize
 *   b32 dwFlags
 *   b32 dwDuration
 *   b32 dwSamplePeriod
 *   b32 dwGain
 *   b32 dwTriggerButton
 *   b32 dwTriggerRepeatInterval
 *   b32 cAxes
 *   b64 rgdwAxes
 *   b64 rglDirection
 *   b64 lpEnvelope
 *   b32 cbTypeSpecificParams
 *   b64 lpvTypeSpecificParams
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
           type = DIEFFECT_DX5
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class Effect_DX5 {
  private final MemorySegment _self;

  public Effect_DX5(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public Effect_DX5(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIEFFECT_DX5.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIEFFECT_DX5.sizeof();
  }

  public final int getCbTypeSpecificParams(long index) {
    return dinput_h.DIEFFECT_DX5.cbTypeSpecificParams$get(self(), index);
  }

  public final int getCbTypeSpecificParams() {
    return dinput_h.DIEFFECT_DX5.cbTypeSpecificParams$get(self());
  }

  public final void setDwTriggerButton(long index, int x) {
    dinput_h.DIEFFECT_DX5.dwTriggerButton$set(self(), index, x);
  }

  public final void setDwTriggerButton(int x) {
    dinput_h.DIEFFECT_DX5.dwTriggerButton$set(self(), x);
  }

  public final MemoryAddress getLpvTypeSpecificParams() {
    return dinput_h.DIEFFECT_DX5.lpvTypeSpecificParams$get(self());
  }

  public final MemoryAddress getLpvTypeSpecificParams(long index) {
    return dinput_h.DIEFFECT_DX5.lpvTypeSpecificParams$get(self(), index);
  }

  public final void setDwTriggerRepeatInterval(int x) {
    dinput_h.DIEFFECT_DX5.dwTriggerRepeatInterval$set(self(), x);
  }

  public final void setDwTriggerRepeatInterval(long index, int x) {
    dinput_h.DIEFFECT_DX5.dwTriggerRepeatInterval$set(self(), index, x);
  }

  public final int getDwTriggerButton() {
    return dinput_h.DIEFFECT_DX5.dwTriggerButton$get(self());
  }

  public final int getDwTriggerButton(long index) {
    return dinput_h.DIEFFECT_DX5.dwTriggerButton$get(self(), index);
  }

  public final void setLpvTypeSpecificParams(long index, MemoryAddress x) {
    dinput_h.DIEFFECT_DX5.lpvTypeSpecificParams$set(self(), index, x);
  }

  public final void setLpvTypeSpecificParams(MemoryAddress x) {
    dinput_h.DIEFFECT_DX5.lpvTypeSpecificParams$set(self(), x);
  }

  public final void setCbTypeSpecificParams(long index, int x) {
    dinput_h.DIEFFECT_DX5.cbTypeSpecificParams$set(self(), index, x);
  }

  public final void setCbTypeSpecificParams(int x) {
    dinput_h.DIEFFECT_DX5.cbTypeSpecificParams$set(self(), x);
  }

  public final int getDwTriggerRepeatInterval() {
    return dinput_h.DIEFFECT_DX5.dwTriggerRepeatInterval$get(self());
  }

  public final int getDwTriggerRepeatInterval(long index) {
    return dinput_h.DIEFFECT_DX5.dwTriggerRepeatInterval$get(self(), index);
  }

  public final int getDwSize() {
    return dinput_h.DIEFFECT_DX5.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h.DIEFFECT_DX5.dwSize$get(self(), index);
  }

  public final void setDwSize(int x) {
    dinput_h.DIEFFECT_DX5.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h.DIEFFECT_DX5.dwSize$set(self(), index, x);
  }

  public final int getDwFlags(long index) {
    return dinput_h.DIEFFECT_DX5.dwFlags$get(self(), index);
  }

  public final int getDwFlags() {
    return dinput_h.DIEFFECT_DX5.dwFlags$get(self());
  }

  public final void setDwFlags(int x) {
    dinput_h.DIEFFECT_DX5.dwFlags$set(self(), x);
  }

  public final void setDwFlags(long index, int x) {
    dinput_h.DIEFFECT_DX5.dwFlags$set(self(), index, x);
  }

  public final void setRglDirection(MemoryAddress x) {
    dinput_h.DIEFFECT_DX5.rglDirection$set(self(), x);
  }

  public final void setRglDirection(long index, MemoryAddress x) {
    dinput_h.DIEFFECT_DX5.rglDirection$set(self(), index, x);
  }

  public final MemoryAddress getLpEnvelope() {
    return dinput_h.DIEFFECT_DX5.lpEnvelope$get(self());
  }

  public final MemoryAddress getLpEnvelope(long index) {
    return dinput_h.DIEFFECT_DX5.lpEnvelope$get(self(), index);
  }

  public final void setDwGain(int x) {
    dinput_h.DIEFFECT_DX5.dwGain$set(self(), x);
  }

  public final void setDwGain(long index, int x) {
    dinput_h.DIEFFECT_DX5.dwGain$set(self(), index, x);
  }

  public final void setLpEnvelope(MemoryAddress x) {
    dinput_h.DIEFFECT_DX5.lpEnvelope$set(self(), x);
  }

  public final void setLpEnvelope(long index, MemoryAddress x) {
    dinput_h.DIEFFECT_DX5.lpEnvelope$set(self(), index, x);
  }

  public final int getDwDuration(long index) {
    return dinput_h.DIEFFECT_DX5.dwDuration$get(self(), index);
  }

  public final int getDwDuration() {
    return dinput_h.DIEFFECT_DX5.dwDuration$get(self());
  }

  public final void setDwSamplePeriod(long index, int x) {
    dinput_h.DIEFFECT_DX5.dwSamplePeriod$set(self(), index, x);
  }

  public final void setDwSamplePeriod(int x) {
    dinput_h.DIEFFECT_DX5.dwSamplePeriod$set(self(), x);
  }

  public final int getDwSamplePeriod() {
    return dinput_h.DIEFFECT_DX5.dwSamplePeriod$get(self());
  }

  public final int getDwSamplePeriod(long index) {
    return dinput_h.DIEFFECT_DX5.dwSamplePeriod$get(self(), index);
  }

  public final void setCAxes(long index, int x) {
    dinput_h.DIEFFECT_DX5.cAxes$set(self(), index, x);
  }

  public final void setCAxes(int x) {
    dinput_h.DIEFFECT_DX5.cAxes$set(self(), x);
  }

  public final int getCAxes(long index) {
    return dinput_h.DIEFFECT_DX5.cAxes$get(self(), index);
  }

  public final int getCAxes() {
    return dinput_h.DIEFFECT_DX5.cAxes$get(self());
  }

  public final int getDwGain(long index) {
    return dinput_h.DIEFFECT_DX5.dwGain$get(self(), index);
  }

  public final int getDwGain() {
    return dinput_h.DIEFFECT_DX5.dwGain$get(self());
  }

  public final MemoryAddress getRgdwAxes(long index) {
    return dinput_h.DIEFFECT_DX5.rgdwAxes$get(self(), index);
  }

  public final MemoryAddress getRgdwAxes() {
    return dinput_h.DIEFFECT_DX5.rgdwAxes$get(self());
  }

  public final void setDwDuration(long index, int x) {
    dinput_h.DIEFFECT_DX5.dwDuration$set(self(), index, x);
  }

  public final void setDwDuration(int x) {
    dinput_h.DIEFFECT_DX5.dwDuration$set(self(), x);
  }

  public final MemoryAddress getRglDirection(long index) {
    return dinput_h.DIEFFECT_DX5.rglDirection$get(self(), index);
  }

  public final MemoryAddress getRglDirection() {
    return dinput_h.DIEFFECT_DX5.rglDirection$get(self());
  }

  public final void setRgdwAxes(MemoryAddress x) {
    dinput_h.DIEFFECT_DX5.rgdwAxes$set(self(), x);
  }

  public final void setRgdwAxes(long index, MemoryAddress x) {
    dinput_h.DIEFFECT_DX5.rgdwAxes$set(self(), index, x);
  }
}
