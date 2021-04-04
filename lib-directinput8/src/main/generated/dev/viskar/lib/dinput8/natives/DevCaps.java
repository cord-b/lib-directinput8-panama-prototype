package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h.DIDEVCAPS dinput_h.DIDEVCAPS}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwAxes()
 * int getDwAxes(long index)
 * int getDwButtons()
 * int getDwButtons(long index)
 * int getDwDevType()
 * int getDwDevType(long index)
 * int getDwFFDriverVersion()
 * int getDwFFDriverVersion(long index)
 * int getDwFFMinTimeResolution()
 * int getDwFFMinTimeResolution(long index)
 * int getDwFFSamplePeriod()
 * int getDwFFSamplePeriod(long index)
 * int getDwFirmwareRevision()
 * int getDwFirmwareRevision(long index)
 * int getDwFlags()
 * int getDwFlags(long index)
 * int getDwHardwareRevision()
 * int getDwHardwareRevision(long index)
 * int getDwPOVs()
 * int getDwPOVs(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * void setDwAxes(int x)
 * void setDwAxes(long index, int x)
 * void setDwButtons(int x)
 * void setDwButtons(long index, int x)
 * void setDwDevType(int x)
 * void setDwDevType(long index, int x)
 * void setDwFFDriverVersion(int x)
 * void setDwFFDriverVersion(long index, int x)
 * void setDwFFMinTimeResolution(int x)
 * void setDwFFMinTimeResolution(long index, int x)
 * void setDwFFSamplePeriod(int x)
 * void setDwFFSamplePeriod(long index, int x)
 * void setDwFirmwareRevision(int x)
 * void setDwFirmwareRevision(long index, int x)
 * void setDwFlags(int x)
 * void setDwFlags(long index, int x)
 * void setDwHardwareRevision(int x)
 * void setDwHardwareRevision(long index, int x)
 * void setDwPOVs(int x)
 * void setDwPOVs(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * DIDEVCAPS {
 *   b32 dwSize
 *   b32 dwFlags
 *   b32 dwDevType
 *   b32 dwAxes
 *   b32 dwButtons
 *   b32 dwPOVs
 *   b32 dwFFSamplePeriod
 *   b32 dwFFMinTimeResolution
 *   b32 dwFirmwareRevision
 *   b32 dwHardwareRevision
 *   b32 dwFFDriverVersion
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
           type = DIDEVCAPS
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class DevCaps {
  private final MemorySegment _self;

  public DevCaps(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public DevCaps(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h.DIDEVCAPS.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h.DIDEVCAPS.sizeof();
  }

  public final int getDwHardwareRevision(long index) {
    return dinput_h.DIDEVCAPS.dwHardwareRevision$get(self(), index);
  }

  public final int getDwHardwareRevision() {
    return dinput_h.DIDEVCAPS.dwHardwareRevision$get(self());
  }

  public final int getDwFFMinTimeResolution(long index) {
    return dinput_h.DIDEVCAPS.dwFFMinTimeResolution$get(self(), index);
  }

  public final int getDwFFMinTimeResolution() {
    return dinput_h.DIDEVCAPS.dwFFMinTimeResolution$get(self());
  }

  public final int getDwFFSamplePeriod() {
    return dinput_h.DIDEVCAPS.dwFFSamplePeriod$get(self());
  }

  public final int getDwFFSamplePeriod(long index) {
    return dinput_h.DIDEVCAPS.dwFFSamplePeriod$get(self(), index);
  }

  public final void setDwFirmwareRevision(int x) {
    dinput_h.DIDEVCAPS.dwFirmwareRevision$set(self(), x);
  }

  public final void setDwFirmwareRevision(long index, int x) {
    dinput_h.DIDEVCAPS.dwFirmwareRevision$set(self(), index, x);
  }

  public final void setDwHardwareRevision(long index, int x) {
    dinput_h.DIDEVCAPS.dwHardwareRevision$set(self(), index, x);
  }

  public final void setDwHardwareRevision(int x) {
    dinput_h.DIDEVCAPS.dwHardwareRevision$set(self(), x);
  }

  public final void setDwFFMinTimeResolution(long index, int x) {
    dinput_h.DIDEVCAPS.dwFFMinTimeResolution$set(self(), index, x);
  }

  public final void setDwFFMinTimeResolution(int x) {
    dinput_h.DIDEVCAPS.dwFFMinTimeResolution$set(self(), x);
  }

  public final void setDwFFDriverVersion(int x) {
    dinput_h.DIDEVCAPS.dwFFDriverVersion$set(self(), x);
  }

  public final void setDwFFDriverVersion(long index, int x) {
    dinput_h.DIDEVCAPS.dwFFDriverVersion$set(self(), index, x);
  }

  public final void setDwFFSamplePeriod(int x) {
    dinput_h.DIDEVCAPS.dwFFSamplePeriod$set(self(), x);
  }

  public final void setDwFFSamplePeriod(long index, int x) {
    dinput_h.DIDEVCAPS.dwFFSamplePeriod$set(self(), index, x);
  }

  public final int getDwFFDriverVersion() {
    return dinput_h.DIDEVCAPS.dwFFDriverVersion$get(self());
  }

  public final int getDwFFDriverVersion(long index) {
    return dinput_h.DIDEVCAPS.dwFFDriverVersion$get(self(), index);
  }

  public final int getDwFirmwareRevision() {
    return dinput_h.DIDEVCAPS.dwFirmwareRevision$get(self());
  }

  public final int getDwFirmwareRevision(long index) {
    return dinput_h.DIDEVCAPS.dwFirmwareRevision$get(self(), index);
  }

  public final int getDwDevType(long index) {
    return dinput_h.DIDEVCAPS.dwDevType$get(self(), index);
  }

  public final int getDwDevType() {
    return dinput_h.DIDEVCAPS.dwDevType$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h.DIDEVCAPS.dwSize$get(self(), index);
  }

  public final int getDwSize() {
    return dinput_h.DIDEVCAPS.dwSize$get(self());
  }

  public final void setDwSize(long index, int x) {
    dinput_h.DIDEVCAPS.dwSize$set(self(), index, x);
  }

  public final void setDwSize(int x) {
    dinput_h.DIDEVCAPS.dwSize$set(self(), x);
  }

  public final void setDwDevType(int x) {
    dinput_h.DIDEVCAPS.dwDevType$set(self(), x);
  }

  public final void setDwDevType(long index, int x) {
    dinput_h.DIDEVCAPS.dwDevType$set(self(), index, x);
  }

  public final int getDwFlags() {
    return dinput_h.DIDEVCAPS.dwFlags$get(self());
  }

  public final int getDwFlags(long index) {
    return dinput_h.DIDEVCAPS.dwFlags$get(self(), index);
  }

  public final void setDwFlags(long index, int x) {
    dinput_h.DIDEVCAPS.dwFlags$set(self(), index, x);
  }

  public final void setDwFlags(int x) {
    dinput_h.DIDEVCAPS.dwFlags$set(self(), x);
  }

  public final int getDwAxes() {
    return dinput_h.DIDEVCAPS.dwAxes$get(self());
  }

  public final int getDwAxes(long index) {
    return dinput_h.DIDEVCAPS.dwAxes$get(self(), index);
  }

  public final void setDwAxes(int x) {
    dinput_h.DIDEVCAPS.dwAxes$set(self(), x);
  }

  public final void setDwAxes(long index, int x) {
    dinput_h.DIDEVCAPS.dwAxes$set(self(), index, x);
  }

  public final int getDwButtons() {
    return dinput_h.DIDEVCAPS.dwButtons$get(self());
  }

  public final int getDwButtons(long index) {
    return dinput_h.DIDEVCAPS.dwButtons$get(self(), index);
  }

  public final void setDwButtons(long index, int x) {
    dinput_h.DIDEVCAPS.dwButtons$set(self(), index, x);
  }

  public final void setDwButtons(int x) {
    dinput_h.DIDEVCAPS.dwButtons$set(self(), x);
  }

  public final void setDwPOVs(int x) {
    dinput_h.DIDEVCAPS.dwPOVs$set(self(), x);
  }

  public final void setDwPOVs(long index, int x) {
    dinput_h.DIDEVCAPS.dwPOVs$set(self(), index, x);
  }

  public final int getDwPOVs() {
    return dinput_h.DIDEVCAPS.dwPOVs$get(self());
  }

  public final int getDwPOVs(long index) {
    return dinput_h.DIDEVCAPS.dwPOVs$get(self(), index);
  }
}
