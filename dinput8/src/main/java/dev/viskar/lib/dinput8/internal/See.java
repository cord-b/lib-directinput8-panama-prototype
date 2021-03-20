package dev.viskar.lib.dinput8.internal;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE_USE)
public @interface See {
    public Class<?> value();
}
