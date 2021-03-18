open module net.viskar.library.dinput8 {

    requires transitive jdk.incubator.foreign;
    requires transitive com.squareup.javapoet;
    requires java.compiler;

    exports net.viskar.library.dinput8;
    exports net.viskar.library.dinput8.natives;

}