package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIEFFECT dinput_h.DIEFFECT}
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
 * int getDwStartDelay()
 * int getDwStartDelay(long index)
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
 * void setDwStartDelay(int x)
 * void setDwStartDelay(long index, int x)
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
 * DIEFFECT {
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
 *   b32 dwStartDelay
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
           type = DIEFFECT
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class Effect {
  private final MemorySegment _self;

  public Effect(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public Effect(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIEFFECT.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIEFFECT.sizeof();
  }

  public final int getDwSize() {
    return dinput_h.DIEFFECT.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h.DIEFFECT.dwSize$get(self(), index);
  }

  public final void setDwSize(int x) {
    dinput_h.DIEFFECT.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h.DIEFFECT.dwSize$set(self(), index, x);
  }

  public final void setDwFlags(int x) {
    dinput_h.DIEFFECT.dwFlags$set(self(), x);
  }

  public final void setDwFlags(long index, int x) {
    dinput_h.DIEFFECT.dwFlags$set(self(), index, x);
  }

  public final int getDwFlags(long index) {
    return dinput_h.DIEFFECT.dwFlags$get(self(), index);
  }

  public final int getDwFlags() {
    return dinput_h.DIEFFECT.dwFlags$get(self());
  }

  public final int getDwTriggerButton(long index) {
    return dinput_h.DIEFFECT.dwTriggerButton$get(self(), index);
  }

  public final int getDwTriggerButton() {
    return dinput_h.DIEFFECT.dwTriggerButton$get(self());
  }

  public final int getCbTypeSpecificParams() {
    return dinput_h.DIEFFECT.cbTypeSpecificParams$get(self());
  }

  public final int getCbTypeSpecificParams(long index) {
    return dinput_h.DIEFFECT.cbTypeSpecificParams$get(self(), index);
  }

  public final void setDwTriggerButton(long index, int x) {
    dinput_h.DIEFFECT.dwTriggerButton$set(self(), index, x);
  }

  public final void setDwTriggerButton(int x) {
    dinput_h.DIEFFECT.dwTriggerButton$set(self(), x);
  }

  public final MemoryAddress getLpvTypeSpecificParams(long index) {
    return dinput_h.DIEFFECT.lpvTypeSpecificParams$get(self(), index);
  }

  public final MemoryAddress getLpvTypeSpecificParams() {
    return dinput_h.DIEFFECT.lpvTypeSpecificParams$get(self());
  }

  public final void setDwTriggerRepeatInterval(int x) {
    dinput_h.DIEFFECT.dwTriggerRepeatInterval$set(self(), x);
  }

  public final void setDwTriggerRepeatInterval(long index, int x) {
    dinput_h.DIEFFECT.dwTriggerRepeatInterval$set(self(), index, x);
  }

  public final void setLpvTypeSpecificParams(MemoryAddress x) {
    dinput_h.DIEFFECT.lpvTypeSpecificParams$set(self(), x);
  }

  public final void setLpvTypeSpecificParams(long index, MemoryAddress x) {
    dinput_h.DIEFFECT.lpvTypeSpecificParams$set(self(), index, x);
  }

  public final int getDwTriggerRepeatInterval(long index) {
    return dinput_h.DIEFFECT.dwTriggerRepeatInterval$get(self(), index);
  }

  public final int getDwTriggerRepeatInterval() {
    return dinput_h.DIEFFECT.dwTriggerRepeatInterval$get(self());
  }

  public final void setCbTypeSpecificParams(long index, int x) {
    dinput_h.DIEFFECT.cbTypeSpecificParams$set(self(), index, x);
  }

  public final void setCbTypeSpecificParams(int x) {
    dinput_h.DIEFFECT.cbTypeSpecificParams$set(self(), x);
  }

  public final void setDwSamplePeriod(int x) {
    dinput_h.DIEFFECT.dwSamplePeriod$set(self(), x);
  }

  public final void setDwSamplePeriod(long index, int x) {
    dinput_h.DIEFFECT.dwSamplePeriod$set(self(), index, x);
  }

  public final void setDwGain(long index, int x) {
    dinput_h.DIEFFECT.dwGain$set(self(), index, x);
  }

  public final void setDwGain(int x) {
    dinput_h.DIEFFECT.dwGain$set(self(), x);
  }

  public final int getDwGain() {
    return dinput_h.DIEFFECT.dwGain$get(self());
  }

  public final int getDwGain(long index) {
    return dinput_h.DIEFFECT.dwGain$get(self(), index);
  }

  public final int getDwDuration() {
    return dinput_h.DIEFFECT.dwDuration$get(self());
  }

  public final int getDwDuration(long index) {
    return dinput_h.DIEFFECT.dwDuration$get(self(), index);
  }

  public final void setDwDuration(int x) {
    dinput_h.DIEFFECT.dwDuration$set(self(), x);
  }

  public final void setDwDuration(long index, int x) {
    dinput_h.DIEFFECT.dwDuration$set(self(), index, x);
  }

  public final int getDwSamplePeriod() {
    return dinput_h.DIEFFECT.dwSamplePeriod$get(self());
  }

  public final int getDwSamplePeriod(long index) {
    return dinput_h.DIEFFECT.dwSamplePeriod$get(self(), index);
  }

  public final int getDwStartDelay() {
    return dinput_h.DIEFFECT.dwStartDelay$get(self());
  }

  public final int getDwStartDelay(long index) {
    return dinput_h.DIEFFECT.dwStartDelay$get(self(), index);
  }

  public final void setRglDirection(long index, MemoryAddress x) {
    dinput_h.DIEFFECT.rglDirection$set(self(), index, x);
  }

  public final void setRglDirection(MemoryAddress x) {
    dinput_h.DIEFFECT.rglDirection$set(self(), x);
  }

  public final MemoryAddress getRgdwAxes() {
    return dinput_h.DIEFFECT.rgdwAxes$get(self());
  }

  public final MemoryAddress getRgdwAxes(long index) {
    return dinput_h.DIEFFECT.rgdwAxes$get(self(), index);
  }

  public final void setLpEnvelope(MemoryAddress x) {
    dinput_h.DIEFFECT.lpEnvelope$set(self(), x);
  }

  public final void setLpEnvelope(long index, MemoryAddress x) {
    dinput_h.DIEFFECT.lpEnvelope$set(self(), index, x);
  }

  public final void setCAxes(int x) {
    dinput_h.DIEFFECT.cAxes$set(self(), x);
  }

  public final void setCAxes(long index, int x) {
    dinput_h.DIEFFECT.cAxes$set(self(), index, x);
  }

  public final MemoryAddress getRglDirection(long index) {
    return dinput_h.DIEFFECT.rglDirection$get(self(), index);
  }

  public final MemoryAddress getRglDirection() {
    return dinput_h.DIEFFECT.rglDirection$get(self());
  }

  public final MemoryAddress getLpEnvelope(long index) {
    return dinput_h.DIEFFECT.lpEnvelope$get(self(), index);
  }

  public final MemoryAddress getLpEnvelope() {
    return dinput_h.DIEFFECT.lpEnvelope$get(self());
  }

  public final void setDwStartDelay(long index, int x) {
    dinput_h.DIEFFECT.dwStartDelay$set(self(), index, x);
  }

  public final void setDwStartDelay(int x) {
    dinput_h.DIEFFECT.dwStartDelay$set(self(), x);
  }

  public final void setRgdwAxes(MemoryAddress x) {
    dinput_h.DIEFFECT.rgdwAxes$set(self(), x);
  }

  public final void setRgdwAxes(long index, MemoryAddress x) {
    dinput_h.DIEFFECT.rgdwAxes$set(self(), index, x);
  }

  public final int getCAxes() {
    return dinput_h.DIEFFECT.cAxes$get(self());
  }

  public final int getCAxes(long index) {
    return dinput_h.DIEFFECT.cAxes$get(self(), index);
  }
}
