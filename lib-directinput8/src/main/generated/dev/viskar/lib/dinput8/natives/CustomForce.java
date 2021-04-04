package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DICUSTOMFORCE dinput_h.DICUSTOMFORCE}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getCChannels()
 * int getCChannels(long index)
 * int getCSamples()
 * int getCSamples(long index)
 * int getDwSamplePeriod()
 * int getDwSamplePeriod(long index)
 * MemoryAddress getRglForceData()
 * MemoryAddress getRglForceData(long index)
 * void setCChannels(int x)
 * void setCChannels(long index, int x)
 * void setCSamples(int x)
 * void setCSamples(long index, int x)
 * void setDwSamplePeriod(int x)
 * void setDwSamplePeriod(long index, int x)
 * void setRglForceData(MemoryAddress x)
 * void setRglForceData(long index, MemoryAddress x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DICUSTOMFORCE {
 *   b32 cChannels
 *   b32 dwSamplePeriod
 *   b32 cSamples
 *   b64 rglForceData
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
           type = DICUSTOMFORCE
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class CustomForce {
  private final MemorySegment _self;

  public CustomForce(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public CustomForce(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DICUSTOMFORCE.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DICUSTOMFORCE.sizeof();
  }

  public final void setDwSamplePeriod(long index, int x) {
    dinput_h.DICUSTOMFORCE.dwSamplePeriod$set(self(), index, x);
  }

  public final void setDwSamplePeriod(int x) {
    dinput_h.DICUSTOMFORCE.dwSamplePeriod$set(self(), x);
  }

  public final int getDwSamplePeriod() {
    return dinput_h.DICUSTOMFORCE.dwSamplePeriod$get(self());
  }

  public final int getDwSamplePeriod(long index) {
    return dinput_h.DICUSTOMFORCE.dwSamplePeriod$get(self(), index);
  }

  public final int getCChannels(long index) {
    return dinput_h.DICUSTOMFORCE.cChannels$get(self(), index);
  }

  public final int getCChannels() {
    return dinput_h.DICUSTOMFORCE.cChannels$get(self());
  }

  public final void setCChannels(int x) {
    dinput_h.DICUSTOMFORCE.cChannels$set(self(), x);
  }

  public final void setCChannels(long index, int x) {
    dinput_h.DICUSTOMFORCE.cChannels$set(self(), index, x);
  }

  public final MemoryAddress getRglForceData(long index) {
    return dinput_h.DICUSTOMFORCE.rglForceData$get(self(), index);
  }

  public final MemoryAddress getRglForceData() {
    return dinput_h.DICUSTOMFORCE.rglForceData$get(self());
  }

  public final void setRglForceData(MemoryAddress x) {
    dinput_h.DICUSTOMFORCE.rglForceData$set(self(), x);
  }

  public final void setRglForceData(long index, MemoryAddress x) {
    dinput_h.DICUSTOMFORCE.rglForceData$set(self(), index, x);
  }

  public final void setCSamples(int x) {
    dinput_h.DICUSTOMFORCE.cSamples$set(self(), x);
  }

  public final void setCSamples(long index, int x) {
    dinput_h.DICUSTOMFORCE.cSamples$set(self(), index, x);
  }

  public final int getCSamples(long index) {
    return dinput_h.DICUSTOMFORCE.cSamples$get(self(), index);
  }

  public final int getCSamples() {
    return dinput_h.DICUSTOMFORCE.cSamples$get(self());
  }
}
