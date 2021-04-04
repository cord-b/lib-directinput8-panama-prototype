package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigList;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class Generator {

    static Map<Class<?>, GeneratorConfig> BUILDERS = new LinkedHashMap<>();
    static File srcMainJava;
    static File srcMainResources;

    static void add(GeneratorConfig builder) {
        BUILDERS.put(builder.cType, builder);
    }

    public static void main(String[] args) throws Exception {

        // Load reference.conf default from our own jar path:
        Config reference = ConfigFactory.parseResources("dev/viskar/lib/codegen/reference.conf");

        // Build the user config on top of it
        Config config = null;
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            switch (arg) {
                case "--config" -> {
                    File configFile = new File(args[++i]);
                    config = ConfigFactory
                            .parseFile(configFile)
                            .withFallback(reference)
                            .resolve();
                }
                case "--source" -> {
                    srcMainJava = new File(args[++i]);
                }
                case "--resources" -> {
                    srcMainResources = new File(args[++i]);
                }
                default -> throw new IllegalArgumentException("Unknown argument: " + arg);
            }
        }

        Objects.requireNonNull(config, "--config <file> not set");

        Config defaults = config.hasPath("defaults") ? config.getConfig("defaults") : ConfigFactory.empty();
        List<? extends Config> runConfigs = config.getConfigList("generate");

        for (Config runConfig : runConfigs) {
            runConfig = runConfig.withFallback(defaults);
            System.out.println("Generating with config:\n" + runConfig);
            CommandLineConfig parsedConfig = ConfigBeanFactory.create(runConfig, CommandLineConfig.class);
            generate(parsedConfig);
        }

        if (srcMainJava != null) {
            BUILDERS.values().forEach(builder -> {
                builder.build(javaFile -> {
                    toBaseDir(javaFile, srcMainJava);
                });
            });
        }
    }

    public static void generate(CommandLineConfig config) throws Exception {

        Class<?> headerClass = getClass(config.from.packageName, true, config.from.header);
        Class<?> constantsClass = getClass(config.from.packageName, true, config.from.constants);

        if (!config.from.type.isEmpty()) {
            Class<?> type = getClass(headerClass, true, config.from.type);
            generate(config, headerClass, constantsClass, type);
        }

        if (config.from.scan) {
            Predicate<Class<?>> exlclude = getPredicate(config.from.exclude);
            for (Class<?> inner : headerClass.getDeclaredClasses()) {
                if (BUILDERS.containsKey(inner) || exlclude.test(inner)) {
                    continue;
                }
                if (inner.getSuperclass() == Object.class || inner.getSuperclass() == null) {
                    generate(config, headerClass, constantsClass, inner);
                }
            }
        }
    }

    public static void generate(CommandLineConfig config, Class<?> headerClass, Class<?> constantsClass, Class<?> type) throws Exception {

        GeneratorConfig generator = GeneratorConfig
                .newInstance(type, headerClass, constantsClass)
                .args(config);

        if ("static-object".equals(config.template)) {
            generator.toSingleton();
            if (!config.staticInitializer.isEmpty()) {
                ClassName initializer = ClassName.bestGuess(config.staticInitializer);
                // TODO: Generate META-INF/services
            }
        }

        if ("object".equals(config.template)) {
            generator.toObject();
        }

        add(generator);
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

    static Class<?> getClass(String packageName, boolean init, String type, String... types) throws Exception {
        ClassName cn = ClassName.get(packageName, type, types);
        return Class.forName(cn.reflectionName(), init, Generator.class.getClassLoader());
    }

    static Class<?> getClass(Class<?> parent, boolean init, String inner) throws Exception {
        ClassName cn = ClassName.get(parent).nestedClass(inner);
        return Class.forName(cn.reflectionName(), init, Generator.class.getClassLoader());
    }

}
