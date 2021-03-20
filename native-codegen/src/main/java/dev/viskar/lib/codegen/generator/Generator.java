package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Generator {

    static Map<Class<?>, StubGenerators.Builder> BUILDERS = new LinkedHashMap<>();

    static void add(StubGenerators.Builder builder) {
        BUILDERS.put(builder.linkedInterfaceClass, builder);
    }

    public static void main(String[] args) throws Exception {

        List<String> excludePatterns = new ArrayList<>();
        List<String> S = new ArrayList<>();
        List<String> I = new ArrayList<>();

        File baseDir = null;
        String packageName = null;
        String header = null;
        Class<?> headerClass;
        String constants = null;
        Class<?> constantsClass;

        for (int i = 0; i < args.length; i++) {
            String[] data = args[i].split("\\s+", 2);
            String key = data[0];
            String value = data.length == 1 ? args[++i] : data[1];
            switch (data[0]) {
                case "-F" -> {
                    baseDir = new File(value);
                    if (!baseDir.exists()) {
                        throw new IllegalArgumentException("Unknown folder: " + value);
                    }
                }
                case "-P" -> packageName = value;
                case "-H" -> header = value;
                case "-C" -> constants = value;
                case "-X" -> excludePatterns.add(value);
                case "-S" -> S.add(value);
                case "-I" -> I.add(value);
                default -> throw new IllegalArgumentException("Unknown argument: " + key);
            }
        }

        System.out.println("baseDir " + baseDir);
        System.out.println("packageName " + packageName);
        System.out.println("header " + header);
        System.out.println("constants " + constants);
        System.out.println("excludes " + excludePatterns);

        Predicate<Class<?>> exlclude = getPredicate(excludePatterns);
        headerClass = getClass(packageName, header);
        constantsClass = getClass(packageName, constants);

        System.out.println("headerClass " + headerClass);
        System.out.println("constantsClass" + constantsClass);

        for (String s : S) {
            String[] config = s.split("::");
            Class<?> type = getClass(headerClass, config[0]);
            ClassName initializer = ClassName.bestGuess(config[1]);
            String initializerMethod = config[2];
            add(StubGenerators.builder(type, constantsClass).toSingleton(initializer, initializerMethod));
        }
        for (String i : I) {
            String[] config = i.split("::");
            Class<?> type = Class.forName(headerClass.getName() + "$" + config[0]);
            add(StubGenerators.builder(type, constantsClass).toInstance());
        }

        for (Class<?> inner : headerClass.getDeclaredClasses()) {
            if (BUILDERS.containsKey(inner) || exlclude.test(inner)) {
                continue;
            }
            if (inner.getSuperclass() == Object.class || inner.getSuperclass() == null) {
                add(StubGenerators.builder(inner, constantsClass).toObject());
            }
        }

        File dir = baseDir;
        BUILDERS.values().forEach(builder -> {
            builder.build(javaFile -> {
                toBaseDir(javaFile, dir);
            });
        });
    }

    static Predicate<Class<?>> getPredicate(List<String> excludePatterns) {
        return c -> {
            if (c.isInterface() || Modifier.isAbstract(c.getModifiers())) {
                return true;
            }
            for (String pattern : excludePatterns) {
                if (c.getSimpleName().matches(pattern)) {
                    return true;
                }
            }
            return false;
        };
    }

    static void toBaseDir(JavaFile file, File baseDir) {
        try {
            file.writeTo(baseDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void toConsole(JavaFile file) {
        System.out.println("// " + file.typeSpec.name);
        try {
            file.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Class<?> getClass(String packageName, String type, String... types) throws Exception {
        ClassName cn = ClassName.get(packageName, type, types);
        return Class.forName(cn.reflectionName(), false, Generator.class.getClassLoader());
    }

    static Class<?> getClass(Class<?> parent, String inner) throws Exception {
        ClassName cn = ClassName.get(parent).nestedClass(inner);
        return Class.forName(cn.reflectionName(), false, Generator.class.getClassLoader());
    }

}
