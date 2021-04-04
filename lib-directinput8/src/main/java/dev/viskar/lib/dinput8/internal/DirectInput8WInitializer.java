package dev.viskar.lib.dinput8.internal;

import dev.viskar.lib.dinput8.DirectInputException;
import dev.viskar.lib.dinput8.GUID;
import dev.viskar.lib.dinput8.TPointer;
import dev.viskar.lib.dinput8.natives.IDirectInput8WStatic;
import dev.viskar.lib.dinput8.natives.dinput_h;
import jdk.incubator.foreign.MemoryAddress;

import java.util.ServiceLoader;

import static dev.viskar.lib.dinput8.natives.dinput_h.*;

/**
 * Used by {@link IDirectInput8WStatic} via {@link ServiceLoader} during its single initialization.
 * <p>
 * This class is registered in META-INF/services automatically by providing the class name
 * in the generator config for {@link dinput_h.IDirectInput8W}.
 * <pre>
 *  // codegen
 *  from {
 *      package = dev.viskar.lib.dinput8.natives
 *      header = dinput_h
 *      constants = dinput_h_constants_5
 *      type = IDirectInput8W
 *  }
 *  template = static-object
 *  staticInitializer = dev.viskar.lib.dinput8.internal.DirectInput8WInitializer
 * </pre>
 */
public class DirectInput8WInitializer implements IDirectInput8WStatic.Initializer {

    private static MemoryAddress address;

    @Override
    public MemoryAddress get() {
        if (address == null) {
            try (TPointer tPointer = TPointer.allocate()) {

                int hres = DirectInput8Create(
                        Kernel32.GetModuleHandleW(),
                        DIRECTINPUT_VERSION(),
                        GUID.IID_IDirectInput8W.address(),
                        tPointer,
                        MemoryAddress.NULL);

                DirectInputException.throwIfError(hres);
                address = tPointer.getPointer();
            }
        }
        return address;
    }

}
