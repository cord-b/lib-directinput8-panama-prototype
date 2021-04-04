package dev.viskar.lib.codegen.generator;

import com.squareup.javapoet.ClassName;

public abstract class CommonSingletonGenerator extends CommonGenerator {

    protected final ClassName _staticType;
    protected final ClassName _staticInstanceHolderType;
    protected final ClassName _staticInitializerType;
    protected final ClassName _singletonObjectType;
    protected final ClassName _singletonInterfaceType;

    protected CommonSingletonGenerator(GeneratorConfig config, String prefix, String suffix) {
        super(config, "I", prefix, suffix);
        _singletonObjectType = ClassName.get(config.packageName, config.baseName + SingletonObjectGenerator.SUFFIX);
        _singletonInterfaceType = ClassName.get(config.packageName, config.baseName);
        _staticType = ClassName.get(config.packageName, config.baseName + StaticObjectGenerator.SUFFIX);
        _staticInstanceHolderType = _className.nestedClass(StaticObjectGenerator.INNER_CLASS_INSTANCE);
        _staticInitializerType = _className.nestedClass(StaticObjectGenerator.INNER_CLASS_INITIALIZER);
        _addGetters = false;
        _addSetters = false;
    }

    @Override
    protected void addInfoJavadoc() {
        _class.addJavadoc("""
                        <div id="info">
                        <h1>Info</h1>
                        A generated singleton object. Generated from {@link $L $L.$L}
                        <p>
                        <strong>Important! YOU must provide an initializer to provide the pointer for this object.
                        Read the <a href="#initializer">Initializer Setup</a> section below.</strong>
                        <p>
                        <h1>Usage</h1>
                        There are several classes generated that all call the same static instance. Use any or all.
                        <ul>
                        <li>{@link $L $L} has direct static methods. All the generated classes end up calling this class under the hood.<pre>
                        $L.Foo(..);
                        $L.Bar(..);
                        </pre></li>
                                        
                        <li>{@link $L $L} is a singleton object wrapping the static methods.<pre>
                        $L instance = $L.getInstance();
                        instance.Foo(..);
                        instance.Bar(..);          
                        </pre></li>
                                        
                        <li>{@link $L $L} is the interface, whose default methods call {@link $L $L}. It also exposes getInstance()</pre>
                        $L singleton = $L.getInstance();
                        singleton.Foo(..);
                        singleton.Bar(..);
                        </pre></li>
                                        
                        <li>Or extend the interface to decorate it with pretty overloads:<pre>
                        public interface MyFoo extends $L {
                            MyFoo INSTANCE = new MyFoo(){};
                            static MyFoo getInstance() { return INSTANCE; }
                            
                            // Add your own prettified wrappers 
                            default void Foo(String str) {
                                 try (MemorySegment mem = CLinker.toCString(str)) {
                                    return Foo(mem);
                                 }
                            }
                        }
                                        
                        MyFoo instance = MyFoo.getInstance();
                        instance.Foo("Hello World");</pre></li>
                        </ul>
                        """,
                // {@link foo.bar.header_h.MyType header_h.MyType}
                _cfg.cType.getCanonicalName(), _cfg.headerClass.getSimpleName(), _cfg.cType.getSimpleName(),
                // Static Instance
                _staticType.canonicalName(), _staticType.simpleName(),
                _staticType.simpleName(), _staticType.simpleName(),
                // Singleton Object Wrapper
                _singletonObjectType.canonicalName(), _singletonObjectType.simpleName(),
                _singletonObjectType.simpleName(), _singletonObjectType.simpleName(),
                // Interface
                _singletonInterfaceType.canonicalName(), _singletonInterfaceType.simpleName(),
                _staticType.canonicalName(), _staticType.simpleName(),
                _singletonInterfaceType.simpleName(), _singletonInterfaceType.simpleName(),
                // Interface overrides
                _singletonInterfaceType.simpleName()
        );
    }

    @Override
    protected void addExtraJavadoc() {
        _class.addJavadoc("""
                        <div id="initializer">
                        <h1>Initializer Setup</h1>
                        <p>
                        For this singleton to initialize, you must provide an implementation of the generated {@link $L $L} 
                        interface and register your implementation for the {@link java.util.ServiceLoader ServiceLoader} to detect.
                        <p>
                        <strong>Example Implementation:</strong>
                        <pre>
                        package com.example;
                        import dev.viskar.lib.common.OutPointer;
                        import $L;
                        import $L;
                        public class MyInitializer implements $L.$L {
                            public MemoryAddress get() {
                                try (OutPointer outPointer = OutPointer.allocate()) {
                                    dinput_h.Create$L(outPointer);
                                    return outPointer.getPointer();
                                }
                            }
                        }
                        </pre>
                        <p>
                        <strong>Register the Initializer (manual approach)</strong>
                        <p>
                        Create the file below and provide your class name implementing the service.
                        <pre>
                        <small>META-INF/services/$L:</small>
                          com.example.My$LInitializer
                        </pre>
                        <strong>Register the Initializer (automatic approach)</strong>
                        <p>
                        Include "staticInitializer" in your generator.conf configuration for this object:
                        {
                          from.type = $L
                          template = static-object
                          staticInitializer = com.myapp.My$LInitializer
                        }
                        And also provide the path to the resources directory somewhere in the arguments.
                        <pre>
                        --resources $L
                        </pre>
                        </div>""",
                // {@link FooStatic.Initializer Initializer}
                _staticInitializerType.canonicalName(), _staticInitializerType.simpleName(),
                // import header; import FooStatic;
                _cfg.headerClass.getCanonicalName(), _staticType.canonicalName(),
                // implements FooStatic.Initializer
                _staticType.simpleName(), _staticInitializerType.simpleName(),
                // dinput_h.CreateFoo(outPointer);
                _cfg.cType.getSimpleName(),
                // META-INF/services/FooStatic$Initializer
                _staticInitializerType.reflectionName(),
                _cfg.cType.getSimpleName(),
                // Include staticInitializer ...
                _cfg.cType.getSimpleName(), _cfg.cType.getSimpleName(),
                // --resources ${project.basedir}/src/main/resources
                "${project.basedir}/src/main/resources");
    }

}
