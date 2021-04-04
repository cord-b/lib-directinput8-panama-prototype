package dev.viskar.lib.codegen.generator.utils;

import com.squareup.javapoet.MethodSpec;
import dev.viskar.lib.codegen.generator.GeneratorConfig;
import jdk.incubator.foreign.MemoryLayout;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class GeneratorUtils {

    public static boolean hasMethod(Class<?> classs, String methodName) {
        return findMethod(classs, methodName) != null;
    }

    public static Method findMethod(Class<?> classs, String methodName) {
        for (Method method : classs.getDeclaredMethods()) {
            if (methodName.equals(method.getName())) {
                return method;
            }
        }
        return null;
    }

    public static String printStructLayout(Class<?> cType) throws IllegalStateException {
        try {
            Method $LAYOUT = findMethod(cType, "$LAYOUT");
            if ($LAYOUT != null) {
                $LAYOUT.setAccessible(true);
                MemoryLayout layout = (MemoryLayout) $LAYOUT.invoke(null);
                return MemoryLayoutPrinter.format(layout);
            }
            return "";
        } catch (Throwable t) {
            throw new IllegalStateException("Exception while inspecing MemoryLayout of: " + cType.getCanonicalName(), t);
        }
    }

    public static MethodSpec.Builder newMethod(String name, Method signature, int paramOffset) {
        MethodSpec.Builder builder = MethodSpec.methodBuilder(name);
        GeneratorUtils.copySignature(builder, signature, paramOffset);
        return builder;
    }

    public static void copySignature(MethodSpec.Builder builder, Method method, int paramOffset) {
        builder.returns(method.getReturnType());
        Parameter[] params = method.getParameters();
        for (int i = paramOffset; i < params.length; i++) {
            Parameter param = params[i];
            boolean namePresent = param.isNamePresent();
            String name = param.getName();
            builder.addParameter(param.getType(), name);
        }
    }

    public static String proxyArgsList(Method proxyMethod, int paramOffset, boolean leadingComma) {
        StringBuilder sb = new StringBuilder();
        Parameter[] params = proxyMethod.getParameters();

        for (int i = paramOffset; i < params.length; i++) {
            Parameter param = params[i];
            sb.append(", ");
            boolean namePresent = param.isNamePresent();
            String name = param.getName();
            sb.append(name);
        }

        String str = sb.toString();
        if (!leadingComma && str.startsWith(", ")) {
            str = str.substring(2);
        }
        return str;
    }

    public static MethodSpec.Builder tryCatch(GeneratorConfig cfg, MethodSpec.Builder method, String format, Object... args) {
        if (cfg.args.getLombok().isSneakyThrows()) {
            method.addAnnotation(ClassNames.SNEAKY_THROWS);
        } else {
            format = String.format("""
                    try {
                        %s
                    } catch (Throwable t) {
                        throw new IllegalStateException(t);
                    }
                    """, format);
        }
        method.addCode(format, args);
        return method;
    }

}
