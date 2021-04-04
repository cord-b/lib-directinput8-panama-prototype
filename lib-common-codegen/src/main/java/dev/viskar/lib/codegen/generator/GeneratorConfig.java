package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import dev.viskar.lib.codegen.generator.CommandLineConfig.LombokOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class GeneratorConfig {

    public final String packageName;
    public final String baseName;
    public Class<?> headerClass;
    public Class<?> headerConstantsClass;
    public Class<?> cType;
    public Class<?> vtblType;
    public String typeVtblField;
    public CommandLineConfig args;
    public final List<CommonGenerator> generators = new ArrayList<>();
    public final List<ClassName> interfaces = new ArrayList<>();

    public static GeneratorConfig newInstance(Class<?> cType, Class<?> headerClass, Class<?> headerConstantsClass) {
        return new GeneratorConfig(cType, headerClass, headerConstantsClass);
    }

    private GeneratorConfig(Class<?> cType, Class<?> headerClass, Class<?> constantsClass) {
        this.packageName = cType.getPackageName();
        this.baseName = cType.getSimpleName();
        this.cType = cType;
        this.headerClass = headerClass;
        this.headerConstantsClass = constantsClass;
        try {
            this.vtblType = Class.forName(cType.getName() + "Vtbl", false, getClass().getClassLoader());
            this.typeVtblField = "lpVtbl";
        } catch (Throwable t) {
            // ignore
        }
    }

    public GeneratorConfig args(CommandLineConfig args) {
        this.args = args;
        return this;
    }

    public GeneratorConfig withJavaInterface(ClassName cn) {
        interfaces.add(cn);
        return this;
    }

    public GeneratorConfig withJavaInterface(String packageName, String simpleName, String... simpleNames) {
        return withJavaInterface(ClassName.get(packageName, simpleName, simpleNames));
    }

    public GeneratorConfig withJavaInterface(Class<?> iface) {
        return withJavaInterface(ClassName.get(iface));
    }

    public GeneratorConfig toSingleton() {
        generators.add(new StaticObjectGenerator(this));
        generators.add(new SingletonObjectGenerator(this));
        generators.add(new InterfaceGenerator(this));
        return this;
    }

    public GeneratorConfig toObject() {
        generators.add(new DefaultObjectGenerator(this, "", ""));
        return this;
    }

    public void build(Consumer<JavaFile> receiver) {
        if (generators.isEmpty()) {
            toObject();
        }
        if (headerConstantsClass == null) {
            throw new IllegalArgumentException("constantsClass not set");
        }
        for (CommonGenerator generator : generators) {
            generator.build(receiver);
        }
    }
}
