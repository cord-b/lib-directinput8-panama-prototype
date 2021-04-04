package dev.viskar.lib.dinput8;

import java.util.HexFormat;

import static dev.viskar.lib.dinput8.natives.dinput_h.*;

public class DirectInputException extends RuntimeException {

    private final int result;

    public DirectInputException(int hresult) {
        super("Error. hresult=(" + hresult + ") 0x" + HexFormat.of().toHexDigits(hresult));
        this.result = hresult;
    }

    public static void throwIfError(int hresult) {
        if (hresult != DI_OK()) {
            throw new DirectInputException(hresult);
        }
    }

    public int getResult() {
        return result;
    }

}
