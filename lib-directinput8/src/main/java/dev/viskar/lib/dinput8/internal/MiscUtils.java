package dev.viskar.lib.dinput8.internal;

import jdk.incubator.foreign.MemoryAddress;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.HexFormat;

public class MiscUtils {

    private static final HexFormat hexFormat = HexFormat.of().withUpperCase();

    public static void appendHex(StringBuilder sb, int value) {
        sb.append(hexFormat.toHighHexDigit((byte) (value >> 24)));
        sb.append(hexFormat.toLowHexDigit((byte) (value >> 24)));
        sb.append(hexFormat.toHighHexDigit((byte) (value >> 16)));
        sb.append(hexFormat.toLowHexDigit((byte) (value >> 16)));
        sb.append(hexFormat.toHighHexDigit((byte) (value >> 8)));
        sb.append(hexFormat.toLowHexDigit((byte) (value >> 8)));
        sb.append(hexFormat.toHighHexDigit((byte) value));
        sb.append(hexFormat.toLowHexDigit((byte) value));
    }

    public static void appendHex(StringBuilder sb, short value) {
        sb.append(hexFormat.toHighHexDigit((byte) (value >> 8)));
        sb.append(hexFormat.toLowHexDigit((byte) (value >> 8)));
        sb.append(hexFormat.toHighHexDigit((byte) value));
        sb.append(hexFormat.toLowHexDigit((byte) value));
    }

}
