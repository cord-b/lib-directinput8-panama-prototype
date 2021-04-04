package dev.viskar.lib.dinput8.natives;

import javax.annotation.processing.Generated;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;

/**
 * <div id="info">
 * <h1>Info</h1>
 * Generated from {@link dev.viskar.lib.dinput8.natives.dinput_h._DIACTIONFORMATW dinput_h._DIACTIONFORMATW}
 * <p>
 * <div id="methods">
 * <h1>Methods</h1>
 * <pre><small>
 * int getDwActionSize()
 * int getDwActionSize(long index)
 * int getDwBufferSize()
 * int getDwBufferSize(long index)
 * int getDwCRC()
 * int getDwCRC(long index)
 * int getDwDataSize()
 * int getDwDataSize(long index)
 * int getDwGenre()
 * int getDwGenre(long index)
 * int getDwNumActions()
 * int getDwNumActions(long index)
 * int getDwSize()
 * int getDwSize(long index)
 * MemorySegment getFtTimeStamp()
 * MemorySegment getGuidActionMap()
 * MemoryAddress getHInstString()
 * MemoryAddress getHInstString(long index)
 * int getLAxisMax()
 * int getLAxisMax(long index)
 * int getLAxisMin()
 * int getLAxisMin(long index)
 * MemoryAddress getRgoAction()
 * MemoryAddress getRgoAction(long index)
 * MemorySegment getTszActionMap()
 * void setDwActionSize(int x)
 * void setDwActionSize(long index, int x)
 * void setDwBufferSize(int x)
 * void setDwBufferSize(long index, int x)
 * void setDwCRC(int x)
 * void setDwCRC(long index, int x)
 * void setDwDataSize(int x)
 * void setDwDataSize(long index, int x)
 * void setDwGenre(int x)
 * void setDwGenre(long index, int x)
 * void setDwNumActions(int x)
 * void setDwNumActions(long index, int x)
 * void setDwSize(int x)
 * void setDwSize(long index, int x)
 * void setHInstString(MemoryAddress x)
 * void setHInstString(long index, MemoryAddress x)
 * void setLAxisMax(int x)
 * void setLAxisMax(long index, int x)
 * void setLAxisMin(int x)
 * void setLAxisMin(long index, int x)
 * void setRgoAction(MemoryAddress x)
 * void setRgoAction(long index, MemoryAddress x)</small></pre></div><div id="struct">
 * <h1>Struct</h1>
 * <pre><small>
 * _DIACTIONFORMATW {
 *   b32 dwSize
 *   b32 dwActionSize
 *   b32 dwDataSize
 *   b32 dwNumActions
 *   b64 rgoAction
 *   guidActionMap {
 *     b32 Data1
 *     b16 Data2
 *     b16 Data3
 *     b8[8] Data4
 *   }
 *   b32 dwGenre
 *   b32 dwBufferSize
 *   b32 lAxisMin
 *   b32 lAxisMax
 *   b64 hInstString
 *   ftTimeStamp {
 *     b32 dwLowDateTime
 *     b32 dwHighDateTime
 *   }
 *   b32 dwCRC
 *   b16[260] tszActionMap
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
           type = _DIACTIONFORMATW
        }
        template = object
        accessors = true
        lombok {
           sneakyThrows = false
        }
        """
)
public class ActionFormat {
  private final MemorySegment _self;

  public ActionFormat(MemoryAddress instanceAddr) {
    this(instanceAddr.asSegmentRestricted(sizeof()));
  }

  public ActionFormat(MemorySegment instanceStruct) {
    _self = instanceStruct;
  }

  public final MemoryAddress address() {
    return self().address();
  }

  public final MemorySegment self() {
    return _self;
  }

  public static final MemoryLayout layout() {
    return dinput_h._DIACTIONFORMATW.$LAYOUT();
  }

  public static final long sizeof() {
    return dinput_h._DIACTIONFORMATW.sizeof();
  }

  public final int getDwSize() {
    return dinput_h._DIACTIONFORMATW.dwSize$get(self());
  }

  public final int getDwSize(long index) {
    return dinput_h._DIACTIONFORMATW.dwSize$get(self(), index);
  }

  public final void setDwSize(int x) {
    dinput_h._DIACTIONFORMATW.dwSize$set(self(), x);
  }

  public final void setDwSize(long index, int x) {
    dinput_h._DIACTIONFORMATW.dwSize$set(self(), index, x);
  }

  public final int getDwBufferSize(long index) {
    return dinput_h._DIACTIONFORMATW.dwBufferSize$get(self(), index);
  }

  public final int getDwBufferSize() {
    return dinput_h._DIACTIONFORMATW.dwBufferSize$get(self());
  }

  public final void setDwBufferSize(int x) {
    dinput_h._DIACTIONFORMATW.dwBufferSize$set(self(), x);
  }

  public final void setDwBufferSize(long index, int x) {
    dinput_h._DIACTIONFORMATW.dwBufferSize$set(self(), index, x);
  }

  public final void setLAxisMin(long index, int x) {
    dinput_h._DIACTIONFORMATW.lAxisMin$set(self(), index, x);
  }

  public final void setLAxisMin(int x) {
    dinput_h._DIACTIONFORMATW.lAxisMin$set(self(), x);
  }

  public final void setLAxisMax(long index, int x) {
    dinput_h._DIACTIONFORMATW.lAxisMax$set(self(), index, x);
  }

  public final void setLAxisMax(int x) {
    dinput_h._DIACTIONFORMATW.lAxisMax$set(self(), x);
  }

  public final void setDwDataSize(int x) {
    dinput_h._DIACTIONFORMATW.dwDataSize$set(self(), x);
  }

  public final void setDwDataSize(long index, int x) {
    dinput_h._DIACTIONFORMATW.dwDataSize$set(self(), index, x);
  }

  public final int getDwActionSize(long index) {
    return dinput_h._DIACTIONFORMATW.dwActionSize$get(self(), index);
  }

  public final int getDwActionSize() {
    return dinput_h._DIACTIONFORMATW.dwActionSize$get(self());
  }

  public final MemoryAddress getHInstString() {
    return dinput_h._DIACTIONFORMATW.hInstString$get(self());
  }

  public final MemoryAddress getHInstString(long index) {
    return dinput_h._DIACTIONFORMATW.hInstString$get(self(), index);
  }

  public final void setDwActionSize(int x) {
    dinput_h._DIACTIONFORMATW.dwActionSize$set(self(), x);
  }

  public final void setDwActionSize(long index, int x) {
    dinput_h._DIACTIONFORMATW.dwActionSize$set(self(), index, x);
  }

  public final int getDwGenre(long index) {
    return dinput_h._DIACTIONFORMATW.dwGenre$get(self(), index);
  }

  public final int getDwGenre() {
    return dinput_h._DIACTIONFORMATW.dwGenre$get(self());
  }

  public final int getLAxisMax() {
    return dinput_h._DIACTIONFORMATW.lAxisMax$get(self());
  }

  public final int getLAxisMax(long index) {
    return dinput_h._DIACTIONFORMATW.lAxisMax$get(self(), index);
  }

  public final void setDwNumActions(long index, int x) {
    dinput_h._DIACTIONFORMATW.dwNumActions$set(self(), index, x);
  }

  public final void setDwNumActions(int x) {
    dinput_h._DIACTIONFORMATW.dwNumActions$set(self(), x);
  }

  public final int getDwDataSize(long index) {
    return dinput_h._DIACTIONFORMATW.dwDataSize$get(self(), index);
  }

  public final int getDwDataSize() {
    return dinput_h._DIACTIONFORMATW.dwDataSize$get(self());
  }

  public final int getDwNumActions(long index) {
    return dinput_h._DIACTIONFORMATW.dwNumActions$get(self(), index);
  }

  public final int getDwNumActions() {
    return dinput_h._DIACTIONFORMATW.dwNumActions$get(self());
  }

  public final void setHInstString(long index, MemoryAddress x) {
    dinput_h._DIACTIONFORMATW.hInstString$set(self(), index, x);
  }

  public final void setHInstString(MemoryAddress x) {
    dinput_h._DIACTIONFORMATW.hInstString$set(self(), x);
  }

  public final MemorySegment getFtTimeStamp() {
    return dinput_h._DIACTIONFORMATW.ftTimeStamp$slice(self());
  }

  public final void setDwGenre(long index, int x) {
    dinput_h._DIACTIONFORMATW.dwGenre$set(self(), index, x);
  }

  public final void setDwGenre(int x) {
    dinput_h._DIACTIONFORMATW.dwGenre$set(self(), x);
  }

  public final void setRgoAction(MemoryAddress x) {
    dinput_h._DIACTIONFORMATW.rgoAction$set(self(), x);
  }

  public final void setRgoAction(long index, MemoryAddress x) {
    dinput_h._DIACTIONFORMATW.rgoAction$set(self(), index, x);
  }

  public final int getLAxisMin(long index) {
    return dinput_h._DIACTIONFORMATW.lAxisMin$get(self(), index);
  }

  public final int getLAxisMin() {
    return dinput_h._DIACTIONFORMATW.lAxisMin$get(self());
  }

  public final MemoryAddress getRgoAction(long index) {
    return dinput_h._DIACTIONFORMATW.rgoAction$get(self(), index);
  }

  public final MemoryAddress getRgoAction() {
    return dinput_h._DIACTIONFORMATW.rgoAction$get(self());
  }

  public final MemorySegment getTszActionMap() {
    return dinput_h._DIACTIONFORMATW.tszActionMap$slice(self());
  }

  public final int getDwCRC() {
    return dinput_h._DIACTIONFORMATW.dwCRC$get(self());
  }

  public final int getDwCRC(long index) {
    return dinput_h._DIACTIONFORMATW.dwCRC$get(self(), index);
  }

  public final void setDwCRC(int x) {
    dinput_h._DIACTIONFORMATW.dwCRC$set(self(), x);
  }

  public final void setDwCRC(long index, int x) {
    dinput_h._DIACTIONFORMATW.dwCRC$set(self(), index, x);
  }

  public final MemorySegment getGuidActionMap() {
    return dinput_h._DIACTIONFORMATW.guidActionMap$slice(self());
  }
}
