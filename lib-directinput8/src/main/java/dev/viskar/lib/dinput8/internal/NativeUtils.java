package dev.viskar.lib.dinput8.internal;

import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.MemoryLayout;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ValueLayout;

import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.Map;

public final class NativeUtils {

    private static final ValueLayout WCHAR_LAYOUT = CLinker.C_SHORT;

    public static String toStringFromWChars(MemorySegment segment) {
        CharBuffer buf = segment.asByteBuffer().order(ByteOrder.nativeOrder()).asCharBuffer();
        int len = buf.remaining();
        int pos = 0;
        while (pos < len) {
            if (buf.get(pos) == '\u0000') {
                break;
            }
            pos++;
        }
        return buf.limit(pos).toString();
    }

    public static MemorySegment toWChars(String s) {

        MemorySegment data = MemorySegment.allocateNative(s.length() * 2 + 2, 2);
        data
                .asByteBuffer()
                .order(ByteOrder.nativeOrder())
                .asCharBuffer()
                .put(s)
                .put('\u0000');
        return data;
    }

    public static void assertSame(MemoryLayout expect, MemoryLayout target) {
        if (!expect.equals(target)) {
            throw new AssertionError("Memory layout: " + target + " did not match " + expect);
        }
    }

}
