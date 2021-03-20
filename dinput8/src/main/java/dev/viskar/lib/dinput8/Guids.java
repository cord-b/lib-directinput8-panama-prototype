package dev.viskar.lib.dinput8;

import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemoryLayout.PathElement;
import jdk.incubator.foreign.MemorySegment;

import java.lang.invoke.VarHandle;

public class Guids {

    public static final MemoryLayout LAYOUT = MemoryLayout.ofStruct(
            CLinker.C_LONG.withName("Data1"),
            CLinker.C_SHORT.withName("Data2"),
            CLinker.C_SHORT.withName("Data3"),
            MemoryLayout.ofSequence(8, CLinker.C_CHAR).withName("Data4"))
            .withName("GUID");

    public static final VarHandle DATA_1 = LAYOUT.varHandle(int.class, PathElement.groupElement("Data1"));
    public static final VarHandle DATA_2 = LAYOUT.varHandle(short.class, PathElement.groupElement("Data2"));
    public static final VarHandle DATA_3 = LAYOUT.varHandle(short.class, PathElement.groupElement("Data3"));
    public static final VarHandle DATA_4 = LAYOUT.varHandle(byte.class, PathElement.groupElement("Data4"), PathElement.sequenceElement());

    public static final MemorySegment IID_IDirectInput8W = of(0xBF798031, 0x483A, 0x4DA2, 0xAA, 0x99, 0x5D, 0x64, 0xED, 0x36, 0x97, 0x00);
    public static final MemorySegment IID_IDirectInputDevice8W = of(0x54D41081, 0xDC15, 0x4833, 0xA4, 0x1B, 0x74, 0x8F, 0x73, 0xA3, 0x81, 0x79);

    public static final MemorySegment XAxis = of(0xA36D02E0, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final MemorySegment YAxis = of(0xA36D02E1, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final MemorySegment ZAxis = of(0xA36D02E2, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final MemorySegment RxAxis = of(0xA36D02F4, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final MemorySegment RyAxis = of(0xA36D02F5, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final MemorySegment RzAxis = of(0xA36D02E3, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final MemorySegment Slider = of(0xA36D02E4, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final MemorySegment Button = of(0xA36D02F0, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final MemorySegment Key = of(0x55728220, 0xD33C, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final MemorySegment POV = of(0xA36D02F2, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);

    private static MemorySegment of(int v1, int s1, int s2, int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8) {
        MemorySegment mem = MemorySegment.allocateNative(LAYOUT);
        DATA_1.set(mem, (int) v1);
        DATA_2.set(mem, (short) s1);
        DATA_3.set(mem, (short) s2);
        DATA_4.set(mem, 0, (byte) b1);
        DATA_4.set(mem, 1, (byte) b2);
        DATA_4.set(mem, 2, (byte) b3);
        DATA_4.set(mem, 3, (byte) b4);
        DATA_4.set(mem, 4, (byte) b5);
        DATA_4.set(mem, 5, (byte) b6);
        DATA_4.set(mem, 6, (byte) b7);
        DATA_4.set(mem, 7, (byte) b8);
        return mem.share();
    }

}
