package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public abstract class StubGenerators {

    static final MethodHandles.Lookup LOOKUP = MethodHandles.lookup();

    public static Builder builder(Class<?> stub) {
        return new Builder(stub.getPackageName(), stub.getSimpleName());
    }

    public static Builder builder(String packageName, String baseName) {
        return new Builder(packageName, baseName);
    }

    protected abstract void build(Consumer<JavaFile> spec);

    public static class Builder {

        public String packageName;
        public String baseName;
        public Class<?> linkedConstantsClass;
        public Class<?> linkedInterfaceClass;
        public Class<?> linkedVtableClass;
        public String linkedVtableName;
        public final List<StubGenerators> generators = new ArrayList<>();
        public final List<ClassName> interfaces = new ArrayList<>();

        public Builder(Class<?> cType) {
            this.packageName = cType.getPackageName();
            this.baseName = cType.getSimpleName();
            this.linkedInterfaceClass = cType;
            try {
                this.linkedVtableClass = Class.forName(cType.getName() + "Vtbl", false, getClass().getClassLoader());
                this.linkedVtableName = "lpVtbl";
            } catch (Throwable t) {
                // no vtbl for this type
            }
        }

        public Builder linkInterface(Class<?> cType) {
            this.linkedInterfaceClass = cType;
            return this;
        }

        public Builder linkVtable(String fieldName, Class<?> vtableClass) {
            this.linkedVtableName = fieldName;
            this.linkedVtableClass = vtableClass;
            return this;
        }

        public Builder linkConstants(Class<?> constants) {
            this.linkedConstantsClass = constants;
            return this;
        }

        public Builder withJavaInterface(ClassName cn) {
            interfaces.add(cn);
            return this;
        }

        public Builder withJavaInterface(String packageName, String simpleName, String... simpleNames) {
            return withJavaInterface(ClassName.get(packageName, simpleName, simpleNames));
        }

        public Builder withJavaInterface(Class<?> iface) {
            return withJavaInterface(ClassName.get(iface));
        }

        public Builder toSingleton(ClassName initializerClass, String initializerMethod) {
            generators.add(new StaticGenerator(this, initializerClass, initializerMethod));
            generators.add(new SingletonGenerator(this));
            return this;
        }

        public Builder toSingleton(Class<?> initializerClass, String initializerMethod) {
            return toSingleton(ClassName.get(initializerClass), initializerMethod);
        }

        public Builder toInstance() {
            generators.add(new InstanceGenerator(this, "", "Instance"));
            return this;
        }

        public Builder toObject() {
            generators.add(new InstanceGenerator(this, "T", "" ));
            return this;
        }

        public void build(Consumer<JavaFile> receiver) {
            for (StubGenerators generator : generators) {
                generator.build(receiver);
            }
        }
    }

    protected static String prettyName(Class<?> cls) {
        return prettyName(cls.getSimpleName());
    }

    protected static String prettyName(String str) {
        int i = str.indexOf('$');
        return i > 0 ? str.substring(0, i) : str;
    }

    protected static MethodSpec.Builder newMethod(String name, Method signature, int paramOffset) {
        MethodSpec.Builder builder = MethodSpec.methodBuilder(name);
        copySignature(builder, signature, paramOffset);
        return builder;
    }

    protected static void copySignature(MethodSpec.Builder builder, Method method, int paramOffset) {
        builder.returns(method.getReturnType());
        Parameter[] params = method.getParameters();
        for(int i = paramOffset; i < params.length; i++) {
            Parameter param = params[i];
            boolean namePresent = param.isNamePresent();
            String name = param.getName();
            builder.addParameter(param.getType(), name);
        }
    }

    protected static String proxyArgsList(Method proxyMethod, int paramOffset, boolean leadingComma) {
        StringBuilder sb = new StringBuilder();
        Parameter[] params = proxyMethod.getParameters();

        for(int i = paramOffset; i < params.length; i++) {
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

}
