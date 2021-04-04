package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h._DIOBJECTDATAFORMAT dinput_h._DIOBJECTDATAFORMAT}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwFlags()
 * int getDwFlags(long index)
 * int getDwOfs()
 * int getDwOfs(long index)
 * int getDwType()
 * int getDwType(long index)
 * MemoryAddress getPguid()
 * MemoryAddress getPguid(long index)
 * void setDwFlags(int x)
 * void setDwFlags(long index, int x)
 * void setDwOfs(int x)
 * void setDwOfs(long index, int x)
 * void setDwType(int x)
 * void setDwType(long index, int x)
 * void setPguid(MemoryAddress x)
 * void setPguid(long index, MemoryAddress x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * _DIOBJECTDATAFORMAT {
 *   b64 pguid
 *   b32 dwOfs
 *   b32 dwType
 *   b32 dwFlags
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
           type = _DIOBJECTDATAFORMAT
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class ObjectDataFormat {
  private final MemorySegment _self;

  public ObjectDataFormat(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public ObjectDataFormat(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h._DIOBJECTDATAFORMAT.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h._DIOBJECTDATAFORMAT.sizeof();
  }

  public final void setDwOfs(long index, int x) {
    dinput_h._DIOBJECTDATAFORMAT.dwOfs$set(self(), index, x);
  }

  public final void setDwOfs(int x) {
    dinput_h._DIOBJECTDATAFORMAT.dwOfs$set(self(), x);
  }

  public final int getDwOfs() {
    return dinput_h._DIOBJECTDATAFORMAT.dwOfs$get(self());
  }

  public final int getDwOfs(long index) {
    return dinput_h._DIOBJECTDATAFORMAT.dwOfs$get(self(), index);
  }

  public final int getDwType() {
    return dinput_h._DIOBJECTDATAFORMAT.dwType$get(self());
  }

  public final int getDwType(long index) {
    return dinput_h._DIOBJECTDATAFORMAT.dwType$get(self(), index);
  }

  public final void setDwType(long index, int x) {
    dinput_h._DIOBJECTDATAFORMAT.dwType$set(self(), index, x);
  }

  public final void setDwType(int x) {
    dinput_h._DIOBJECTDATAFORMAT.dwType$set(self(), x);
  }

  public final int getDwFlags(long index) {
    return dinput_h._DIOBJECTDATAFORMAT.dwFlags$get(self(), index);
  }

  public final int getDwFlags() {
    return dinput_h._DIOBJECTDATAFORMAT.dwFlags$get(self());
  }

  public final void setDwFlags(int x) {
    dinput_h._DIOBJECTDATAFORMAT.dwFlags$set(self(), x);
  }

  public final void setDwFlags(long index, int x) {
    dinput_h._DIOBJECTDATAFORMAT.dwFlags$set(self(), index, x);
  }

  public final void setPguid(MemoryAddress x) {
    dinput_h._DIOBJECTDATAFORMAT.pguid$set(self(), x);
  }

  public final void setPguid(long index, MemoryAddress x) {
    dinput_h._DIOBJECTDATAFORMAT.pguid$set(self(), index, x);
  }

  public final MemoryAddress getPguid() {
    return dinput_h._DIOBJECTDATAFORMAT.pguid$get(self());
  }

  public final MemoryAddress getPguid(long index) {
    return dinput_h._DIOBJECTDATAFORMAT.pguid$get(self(), index);
  }
}
