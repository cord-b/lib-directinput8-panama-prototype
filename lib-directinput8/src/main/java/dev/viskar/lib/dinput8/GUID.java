package dev.viskar.lib.dinput8;

import dev.viskar.lib.dinput8.internal.MiscUtils;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemoryLayout.PathElement;
import jdk.incubator.foreign.MemorySegment;

import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.HexFormat;

public class GUID {

    // Constants copied from dinput.h (unable to generate)
    public static final GUID IID_IDirectInput8W = of(0xBF798031, 0x483A, 0x4DA2, 0xAA, 0x99, 0x5D, 0x64, 0xED, 0x36, 0x97, 0x00);
    public static final GUID IID_IDirectInputDevice8W = of(0x54D41081, 0xDC15, 0x4833, 0xA4, 0x1B, 0x74, 0x8F, 0x73, 0xA3, 0x81, 0x79);
    public static final GUID XAxis = of(0xA36D02E0, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final GUID YAxis = of(0xA36D02E1, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final GUID ZAxis = of(0xA36D02E2, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final GUID RxAxis = of(0xA36D02F4, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final GUID RyAxis = of(0xA36D02F5, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final GUID RzAxis = of(0xA36D02E3, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final GUID Slider = of(0xA36D02E4, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final GUID Button = of(0xA36D02F0, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final GUID Key = of(0x55728220, 0xD33C, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);
    public static final GUID POV = of(0xA36D02F2, 0xC9F3, 0x11CF, 0xBF, 0xC7, 0x44, 0x45, 0x53, 0x54, 0x00, 0x00);

    private static final HexFormat hexFormat = HexFormat.of().withUpperCase();
    private final MemorySegment self;
    private int hashCode;
    private String string;

    private GUID(MemorySegment self) {
        this.self = self;
    }

    public static GUID of(MemoryAddress selfAddr) {
        return of(selfAddr.asSegmentRestricted(Layout.sizeof()));
    }

    public static GUID of(MemorySegment self) {
        return new GUID(self);
    }

    public static long sizeof() {
        return Layout.sizeof();
    }

    public MemoryAddress address() {
        return self.address();
    }

    public MemorySegment self() {
        return self;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        if (string == null) {
            StringBuilder sb = new StringBuilder();
            sb.append('{');
            MiscUtils.appendHex(sb, (int) Layout.DATA_1.get(self));
            sb.append('-');
            MiscUtils.appendHex(sb, (short) Layout.DATA_2.get(self));
            sb.append('-');
            MiscUtils.appendHex(sb, (short) Layout.DATA_3.get(self));
            sb.append('-');
            hexFormat.toHexDigits(sb, (byte) Layout.DATA_4.get(self, 0));
            hexFormat.toHexDigits(sb, (byte) Layout.DATA_4.get(self, 1));
            sb.append('-');
            hexFormat.toHexDigits(sb, (byte) Layout.DATA_4.get(self, 2));
            hexFormat.toHexDigits(sb, (byte) Layout.DATA_4.get(self, 3));
            hexFormat.toHexDigits(sb, (byte) Layout.DATA_4.get(self, 4));
            hexFormat.toHexDigits(sb, (byte) Layout.DATA_4.get(self, 5));
            hexFormat.toHexDigits(sb, (byte) Layout.DATA_4.get(self, 6));
            hexFormat.toHexDigits(sb, (byte) Layout.DATA_4.get(self, 7));
            sb.append('}');
            string = sb.toString();
        }
        return string;
    }

    public boolean equalsMemory(MemorySegment segment) {
        return segment.byteSize() == sizeof() && self.mismatch(segment) == -1;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof GUID) {
            GUID other = (GUID) o;
            return address().equals(other.address()) || equalsMemory(other.self);
        }
        return false;
    }

    // ************************************************************************
    // Helpers
    // ************************************************************************

    private static GUID of(int v1, int s1, int s2, int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8) {
        MemorySegment mem = MemorySegment.allocateNative(Layout.LAYOUT);
        Layout.DATA_1.set(mem, (int) v1);
        Layout.DATA_2.set(mem, (short) s1);
        Layout.DATA_3.set(mem, (short) s2);
        Layout.DATA_4.set(mem, 0, (byte) b1);
        Layout.DATA_4.set(mem, 1, (byte) b2);
        Layout.DATA_4.set(mem, 2, (byte) b3);
        Layout.DATA_4.set(mem, 3, (byte) b4);
        Layout.DATA_4.set(mem, 4, (byte) b5);
        Layout.DATA_4.set(mem, 5, (byte) b6);
        Layout.DATA_4.set(mem, 6, (byte) b7);
        Layout.DATA_4.set(mem, 7, (byte) b8);
        return new GUID(mem.share());
    }

    static class Layout {

        public static final MemoryLayout LAYOUT = MemoryLayout.ofStruct(
                CLinker.C_LONG.withName("Data1"),
                CLinker.C_SHORT.withName("Data2"),
                CLinker.C_SHORT.withName("Data3"),
                MemoryLayout.ofSequence(8, CLinker.C_CHAR).withName("Data4"))
                .withName("GUID");

        private static final long sizeof = LAYOUT.byteSize();

        public static final VarHandle DATA_1 = LAYOUT.varHandle(int.class, PathElement.groupElement("Data1"));
        public static final VarHandle DATA_2 = LAYOUT.varHandle(short.class, PathElement.groupElement("Data2"));
        public static final VarHandle DATA_3 = LAYOUT.varHandle(short.class, PathElement.groupElement("Data3"));
        public static final VarHandle DATA_4 = LAYOUT.varHandle(byte.class, PathElement.groupElement("Data4"), PathElement.sequenceElement());

        public static long sizeof() {
            return sizeof;
        }

        public static int getData1(MemorySegment mem) {
            return (int) DATA_1.get(mem);
        }

        public static short getData2(MemorySegment mem) {
            return (short) DATA_2.get(mem);
        }

        public static short getData3(MemorySegment mem) {
            return (short) DATA_3.get(mem);
        }

        public static byte getData4(MemorySegment mem, int offset) {
            return (byte) DATA_4.get(mem, offset);
        }
    }
}
