package net.viskar.stubs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface VStub {

    String lib();

    Class<?> constants();

    Class<?> ifaceClass();

    Class<?> vtableClass() default Void.class;

    String vtableField() default "";
}
