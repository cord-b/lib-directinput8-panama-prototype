package dev.viskar.lib.dinput8.internal;

import jdk.incubator.foreign.MemoryAddress;
import sun.misc.Unsafe;

import java.awt.Component;
import java.lang.reflect.Field;
import java.util.Objects;

public class WindowsUtils {

    private static final Unsafe unsafe = getUnsafe();
    private static final Class<?> WComponentPeer = getClass("sun.awt.windows.WComponentPeer");
    private static final long peerOffset = getOffset(Component.class, "peer");
    private static final long hwndOffset = getOffset(WComponentPeer, "hwnd");

    private static final boolean getHWndPossible = unsafe != null && WComponentPeer != null && peerOffset >= 0 && hwndOffset >= 0;

    public static MemoryAddress getHWnd(Component component) {
        Objects.requireNonNull(component, "component is null");
        if (!getHWndPossible) {
            throw new UnsupportedOperationException("getHWnd is not available");
        }
        Object wComponentPeer = unsafe.getObject(component, peerOffset);
        if (wComponentPeer == null) {
            throw new IllegalStateException("compontent perr is not present");
        }
        long hwnd = unsafe.getLong(wComponentPeer, hwndOffset);
        return MemoryAddress.ofLong(hwnd);
    }

    // ************************************************************************
    // Helpers
    // ************************************************************************

    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Throwable t) {
            System.err.println("unsafe not available");
            t.printStackTrace();
            return null;
        }
    }

    private static Class<?> getClass(String classs) {
        try {
            return Class.forName(classs, false, WindowsUtils.class.getClassLoader());
        } catch (Throwable t) {
            System.err.println("class not accessible: " + classs);
            t.printStackTrace();
            return null;
        }
    }

    private static long getOffset(Class<?> classs, String field) {
        if (unsafe != null && classs != null) {
            try {
                Field f = classs.getDeclaredField(field);
                return unsafe.objectFieldOffset(f);
            } catch (Throwable t) {
                System.err.println("field not available: " + field);
                t.printStackTrace();
            }
        }
        return -1L;
    }

}
