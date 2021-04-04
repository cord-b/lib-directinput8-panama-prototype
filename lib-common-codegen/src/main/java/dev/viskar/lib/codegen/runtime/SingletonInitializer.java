package dev.viskar.lib.codegen.runtime;

import jdk.incubator.foreign.MemoryAddress;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.function.Supplier;

public interface SingletonInitializer extends Supplier<MemoryAddress> {

    @Override
    MemoryAddress get();

    static <T extends SingletonInitializer> MemoryAddress runInitializer(Class<T> initializerClass) {
        Optional<T> initializer = ServiceLoader.load(initializerClass).findFirst();
        if (!initializer.isPresent()) {
            throw new IllegalStateException(String.format("""
                    Could not locate the initializer class implementing '%s'.
                    This must be registered with the ServiceLoader:
                    Please add resource: META-INF/services/%s
                    ---------
                    com.example.MyInitializerImpl
                    """, initializerClass.getName(), initializerClass.getName()));
        }
        return initializer.get().get();
    }

}
