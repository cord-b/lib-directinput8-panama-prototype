package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h._DIDATAFORMAT dinput_h._DIDATAFORMAT}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwDataSize()
 * int getDwDataSize(long index)
 * int getDwFlags()
 * int getDwFlags(long index)
 * int getDwNumObjs()
 * int getDwNumObjs(long index)
 * int getDwObjSize()
 * int getDwObjSize(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * MemoryAddress getRgodf()
 * MemoryAddress getRgodf(long index)
 * void setDwDataSize(int x)
 * void setDwDataSize(long index, int x)
 * void setDwFlags(int x)
 * void setDwFlags(long index, int x)
 * void setDwNumObjs(int x)
 * void setDwNumObjs(long index, int x)
 * void setDwObjSize(int x)
 * void setDwObjSize(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)
 * void setRgodf(MemoryAddress x)
 * void setRgodf(long index, MemoryAddress x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * _DIDATAFORMAT {
 *   b32 dwSize
 *   b32 dwObjSize
 *   b32 dwFlags
 *   b32 dwDataSize
 *   b32 dwNumObjs
 *   b64 rgodf
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
           type = _DIDATAFORMAT
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class DataFormat {
  private final MemorySegment _self;

  public DataFormat(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public DataFormat(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h._DIDATAFORMAT.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h._DIDATAFORMAT.sizeof();
  }

  public final int getDwSize(long index) {
    return dinput_h._DIDATAFORMAT.dwSize$get(self(), index);
  }

  public final int getDwSize() {
    return dinput_h._DIDATAFORMAT.dwSize$get(self());
  }

  public final void setDwSize(long index, int x) {
    dinput_h._DIDATAFORMAT.dwSize$set(self(), index, x);
  }

  public final void setDwSize(int x) {
    dinput_h._DIDATAFORMAT.dwSize$set(self(), x);
  }

  public final void setDwFlags(long index, int x) {
    dinput_h._DIDATAFORMAT.dwFlags$set(self(), index, x);
  }

  public final void setDwFlags(int x) {
    dinput_h._DIDATAFORMAT.dwFlags$set(self(), x);
  }

  public final int getDwFlags(long index) {
    return dinput_h._DIDATAFORMAT.dwFlags$get(self(), index);
  }

  public final int getDwFlags() {
    return dinput_h._DIDATAFORMAT.dwFlags$get(self());
  }

  public final void setDwDataSize(int x) {
    dinput_h._DIDATAFORMAT.dwDataSize$set(self(), x);
  }

  public final void setDwDataSize(long index, int x) {
    dinput_h._DIDATAFORMAT.dwDataSize$set(self(), index, x);
  }

  public final int getDwDataSize(long index) {
    return dinput_h._DIDATAFORMAT.dwDataSize$get(self(), index);
  }

  public final int getDwDataSize() {
    return dinput_h._DIDATAFORMAT.dwDataSize$get(self());
  }

  public final int getDwNumObjs() {
    return dinput_h._DIDATAFORMAT.dwNumObjs$get(self());
  }

  public final int getDwNumObjs(long index) {
    return dinput_h._DIDATAFORMAT.dwNumObjs$get(self(), index);
  }

  public final void setDwObjSize(long index, int x) {
    dinput_h._DIDATAFORMAT.dwObjSize$set(self(), index, x);
  }

  public final void setDwObjSize(int x) {
    dinput_h._DIDATAFORMAT.dwObjSize$set(self(), x);
  }

  public final int getDwObjSize(long index) {
    return dinput_h._DIDATAFORMAT.dwObjSize$get(self(), index);
  }

  public final int getDwObjSize() {
    return dinput_h._DIDATAFORMAT.dwObjSize$get(self());
  }

  public final void setDwNumObjs(int x) {
    dinput_h._DIDATAFORMAT.dwNumObjs$set(self(), x);
  }

  public final void setDwNumObjs(long index, int x) {
    dinput_h._DIDATAFORMAT.dwNumObjs$set(self(), index, x);
  }

  public final MemoryAddress getRgodf(long index) {
    return dinput_h._DIDATAFORMAT.rgodf$get(self(), index);
  }

  public final MemoryAddress getRgodf() {
    return dinput_h._DIDATAFORMAT.rgodf$get(self());
  }

  public final void setRgodf(long index, MemoryAddress x) {
    dinput_h._DIDATAFORMAT.rgodf$set(self(), index, x);
  }

  public final void setRgodf(MemoryAddress x) {
    dinput_h._DIDATAFORMAT.rgodf$set(self(), x);
  }
}
