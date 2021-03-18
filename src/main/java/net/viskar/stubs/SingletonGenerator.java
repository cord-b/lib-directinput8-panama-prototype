package net.viskar.stubs;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class SingletonGenerator extends InstanceGenerator {

    protected static final String SUFFIX = "Singleton";
    protected final ClassName _staticInstanceType;

    public SingletonGenerator(Builder config) {
        super(config, SUFFIX);
        _staticInstanceType = ClassName.get(config.packageName, config.baseName + StaticGenerator.SUFFIX);
    }

    @Override
    protected void addConstructors() {
        _constructor.addModifiers(Modifier.PRIVATE);

        addField(FieldSpec.builder(_className, "INSTANCE", Modifier.PRIVATE, Modifier.STATIC, Modifier.FINAL)
                .initializer("new $T()", _className));

        addMethod(MethodSpec
                .methodBuilder("getInstance")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
                .returns(_className)
                .addCode("return INSTANCE;"));
    }

    @Override
    protected void addVirtualMethod(Class<?> virtualMethodInterface, Method signature) throws Exception {

        // Our prettied up name to use
        String ProxyMethod_Name = prettyName(virtualMethodInterface);

        // Our public signature (hiding the MemorySegment param[0])
        addMethod(newMethod(ProxyMethod_Name, signature, 1)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addCode("""
                        return $T.$L($L);
                        """, _staticInstanceType, ProxyMethod_Name, proxyArgsList(signature, 1, false)));
    }

    @Override
    protected void addObjectMethods() {
        //
    }

    @Override
    protected void addVTable() {
        //
    }
}
