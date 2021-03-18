package net.viskar.stubs;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import jdk.incubator.foreign.Addressable;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
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

        protected final String packageName;
        protected final String baseName;
        protected Class<?> linkedConstantsClass;
        protected Class<?> linkedInterfaceClass;
        protected Class<?> linkedVtableClass;
        protected String linkedVtableName;
        protected final List<StubGenerators> generators = new ArrayList<>();
        protected final List<Class<?>> interfaces = new ArrayList<>();

        public Builder(String packageName, String baseName) {
            this.packageName = packageName;
            this.baseName = baseName;
            this.interfaces.add(Addressable.class);
        }

        public Builder linkInterface(Class<?> cInterface) {
            this.linkedInterfaceClass = cInterface;
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

        public Builder withJavaInterface(Class<?> iface) {
            interfaces.add(iface);
            return this;
        }

        public Builder toSingleton(Class<?> initializer, String function) {
            generators.add(new StaticGenerator(this, initializer, function));
            generators.add(new SingletonGenerator(this));
            return this;
        }

        public Builder toObject() {
            generators.add(new InstanceGenerator(this));
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

    protected MethodSpec.Builder newMethod(String name, Method signature, int paramOffset) {
        MethodSpec.Builder builder = MethodSpec.methodBuilder(name);
        copySignature(builder, signature, paramOffset);
        return builder;
    }

    protected void copySignature(MethodSpec.Builder builder, Method method, int paramOffset) {
        builder.returns(method.getReturnType());
        Parameter[] params = method.getParameters();
        for(int i = paramOffset; i < params.length; i++) {
            Parameter param = params[i];
            boolean namePresent = param.isNamePresent();
            String name = param.getName();
            builder.addParameter(param.getType(), name);
        }
    }

    protected String proxyArgsList(Method proxyMethod, int paramOffset, boolean leadingComma) {
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

//    protected String proxyArgsList(MethodType proxyMethodType, boolean leadingComma) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < proxyMethodType.parameterCount(); i++) {
//            sb.append(", x").append(i);
//        }
//        String str = sb.toString();
//        if (!leadingComma && str.startsWith(", ")) {
//            str = str.substring(2);
//        }
//        return str;
//    }
}
