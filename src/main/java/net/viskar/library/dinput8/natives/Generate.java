package net.viskar.library.dinput8.natives;

import com.squareup.javapoet.JavaFile;
import net.viskar.library.dinput8.DirectInput8;
import net.viskar.stubs.StubGenerators;

import java.io.IOException;

public class Generate {

    private static final String PCKG = Generate.class.getPackageName();

    public static void main(String[] args) throws Exception {

        StubGenerators
                .builder(PCKG, "IDirectInput8W")
                .linkInterface(dinput_h.IDirectInput8W.class)
                .linkConstants(dinput_h_constants_5.class)
                .linkVtable("lpVtbl", dinput_h.IDirectInput8WVtbl.class)
                .toObject()
                .toSingleton(DirectInput8WInitializer.class, "initialize")
                .withJavaInterface(DirectInput8.class)
                .build(Generate::toConsole);

        StubGenerators
                .builder(PCKG, "IDirectInputDevice8W")
                .linkInterface(dinput_h.IDirectInputDevice8W.class)
                .linkConstants(dinput_h_constants_5.class)
                .linkVtable("lpVtbl", dinput_h.IDirectInputDevice8WVtbl.class)
                .toObject()
                .withJavaInterface(IDirectInputDevice8W.class)
                .build(Generate::toConsole);

        StubGenerators
                .builder(PCKG, "TDevice")
                .linkInterface(dinput_h.DIDEVICEINSTANCEW.class)
                .linkConstants(dinput_h_constants_5.class)
                .toObject()
                .build(Generate::toConsole);

        StubGenerators
                .builder(PCKG, "TDIDataFormat")
                .linkInterface(dinput_h._DIDATAFORMAT.class)
                .linkConstants(dinput_h_constants_5.class)
                .toObject()
                .build(Generate::toConsole);
    }

    static void toConsole(JavaFile file) {
        System.out.println("// " + file.typeSpec.name);
        try {
            file.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
