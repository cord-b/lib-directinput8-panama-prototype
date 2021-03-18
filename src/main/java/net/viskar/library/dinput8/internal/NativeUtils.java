package net.viskar.library.dinput8.internal;

import jdk.incubator.foreign.MemorySegment;

import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;

public final class NativeUtils {

    public static String stringFromWChars(MemorySegment segment) {
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

    public static void logError(int hres) {
        System.out.println("Failed: " + Integer.toUnsignedString(hres, 16));
    }

}
