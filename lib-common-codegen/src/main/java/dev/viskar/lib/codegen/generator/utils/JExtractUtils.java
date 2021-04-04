package dev.viskar.lib.codegen.generator.utils;

import java.lang.reflect.Method;

public class JExtractUtils {

    public static String getVirtualMethodNameFromGeneratedInterfaceMethod(Method method) {

        if (!method.getName().equals("apply")) {
            throw new IllegalArgumentException("Unexpected method: " + method + ". Expected: apply(..)");
        }

        Class<?> parent = method.getDeclaringClass();
        return stripAt$(parent.getSimpleName());
    }

    public static boolean isAccessorMethod(Method method) {
        return isAccessorMethod(method.getName());
    }

    public static boolean isAccessorMethod(String methodName) {
        return isGetter(methodName) || isSetter(methodName);
    }

    public static boolean isGetter(Method method) {
    return isGetter(method.getName());
    }

    public static boolean isGetter(String method) {
        return method.endsWith("$get") || method.endsWith("$slice");
    }

    public static boolean isSetter(Method method) {
        return isSetter(method.getName());
    }

    public static boolean isSetter(String method) {
        return method.endsWith("$set");
    }


    public static String normalizeAccessorMethodName(Method method) {
        return normalizeAccessorMethodName(method.getName());
    }

    public static String normalizeAccessorMethodName(String methodName) {

        if (!isAccessorMethod(methodName)) {
            throw new IllegalArgumentException("Not an accessor method");
        }

        int $index = methodName.lastIndexOf('$');
        String accessorType = methodName.substring($index + 1);
        if (accessorType.equals("slice")) {
            accessorType = "get";
        }
        String simpleName = stripAt$(methodName);
        return accessorType + Character.toUpperCase(simpleName.charAt(0)) + simpleName.substring(1);
    }

    private static String stripAt$(String str) {
        int i = str.indexOf('$');
        return i > 0 ? str.substring(0, i) : str;
    }

}
