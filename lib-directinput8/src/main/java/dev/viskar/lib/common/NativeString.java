package dev.viskar.lib.common;

import dev.viskar.lib.dinput8.internal.NativeUtils;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.MemorySegment;

public class NativeString implements AutoCloseable {

    private String string;

    private MemorySegment chars;
    private boolean charsOwned;

    private MemorySegment wchars;
    private boolean wcharsOwned;

    public static NativeString of(String string) {
        return new NativeString(string, null, null);
    }

    public static NativeString cString(MemorySegment chars) {
        return new NativeString(null, chars, null);
    }

    public static NativeString wcharString(MemorySegment wchars) {
        return new NativeString(null, null, wchars);
    }

    private NativeString(String javaString, MemorySegment chars, MemorySegment wchars) {
        this.string = javaString;
        this.chars = chars;
        this.wchars = wchars;
    }

    @Override
    public String toString() {
        if (string == null) {
            if (chars != null) {
                string = CLinker.toJavaString(chars);
            } else {
                string = NativeUtils.toStringFromWChars(wchars);
            }
        }
        return string;
    }

    public MemorySegment toChars() {
        if (chars == null) {
            chars = CLinker.toCString(toString());
            charsOwned = true;
        }
        return chars;
    }

    public MemorySegment toWChars() {
        if (wchars == null) {
            wchars = NativeUtils.toWChars(toString());
            wcharsOwned = true;
        }
        return wchars;
    }

    @Override
    public void close() {
        if (charsOwned && chars != null) {
            chars.close();
            chars = null;
            charsOwned = false;
        }
        if (wcharsOwned && wchars != null) {
            wchars.close();
            wchars = null;
            wcharsOwned = false;
        }
    }
}
