//package dev.viskar;
//
//import com.squareup.javapoet.ClassName;
//import com.squareup.javapoet.JavaFile;
//import dev.viskar.lib.dinput8.natives.dinput_h;
//import net.viskar.lib.dinput8.generated.dinput_h_constants_5;
//import dev.viskar.lib.codegen.generator.StubGenerators;
//
//import java.io.File;
//import java.io.IOException;
//import java.lang.reflect.Modifier;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.function.Predicate;
//
//public class Generate {
//
//    private static final String NATIVES = "net.viskar.library.dinput8.natives";
//
//    private static Map<Class<?>, StubGenerators.Builder> BUILDERS = new LinkedHashMap<>();
//
//    static {
//        add(StubGenerators
//                .builder(NATIVES, "IDirectInput8W")
//                .linkInterface(dinput_h.IDirectInput8W.class)
//                .linkConstants(dinput_h_constants_5.class)
//                .linkVtable("lpVtbl", dinput_h.IDirectInput8WVtbl.class)
//                .toInstance()
//                .toSingleton(ClassName.get(NATIVES, "DirectInput8WInitializer"), "initialize")
//                .withJavaInterface("net.viskar.library.dinput8", "DirectInput"));
//
//        add(StubGenerators
//                .builder(NATIVES, "IDirectInputDevice8W")
//                .linkInterface(dinput_h.IDirectInputDevice8W.class)
//                .linkConstants(dinput_h_constants_5.class)
//                .linkVtable("lpVtbl", dinput_h.IDirectInputDevice8WVtbl.class)
//                .toInstance()
//                .withJavaInterface("net.viskar.library.dinput8", "DirectInputDevice"));
//
//    }
//
//    private static void add(StubGenerators.Builder builder) {
//        BUILDERS.put(builder.linkedInterfaceClass, builder);
//    }
//
//    public static void main(String[] args) throws Exception {
//
//        File baseDir;
//
//        if (args.length == 1) {
//            baseDir = new File(args[0]);
//        } else {
//            baseDir = new File("C:\\tmp\\javapoet");
//        }
//
//        if (!baseDir.exists()) {
//            System.exit(1);
//        }
//
//        Predicate<Class<?>> exclude = c -> {
//            if (c.isInterface() || Modifier.isAbstract(c.getModifiers())) {
//                return true;
//            }
//            if (c.getSimpleName().matches(".*[1-7][AW].*") || c.getSimpleName().matches(".*8A.*")) {
//                return true;
//            }
//            return false;
//        };
//
//        for (Class<?> inner : dinput_h.class.getDeclaredClasses()) {
//            if (BUILDERS.containsKey(inner) || exclude.test(inner)) {
//                continue;
//            }
//            if (inner.getSuperclass() == Object.class || inner.getSuperclass() == null) {
//                add(StubGenerators
//                        .builder(NATIVES, inner.getSimpleName())
//                        .linkInterface(inner)
//                        .linkConstants(dinput_h_constants_5.class)
//                        .toObject());
//            }
//        }
//
//        BUILDERS.values().forEach(builder -> {
//            builder.build(javaFile -> {
//                toBaseDir(javaFile, baseDir);
//            });
//        });
//    }
//
//    static void toBaseDir(JavaFile file, File baseDir) {
//        try {
//            file.writeTo(baseDir);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    static void toConsole(JavaFile file) {
//        System.out.println("// " + file.typeSpec.name);
//        try {
//            file.writeTo(System.out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
