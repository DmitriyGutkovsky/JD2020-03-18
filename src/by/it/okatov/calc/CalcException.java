package by.it.okatov.calc;

import by.it.okatov.calc.globalization.IError;
import by.it.okatov.calc.globalization.ResourceManager;

public class CalcException extends Exception {
    static ResourceManager manager = ResourceManager.INSTANCE;

    public CalcException() {
        this(manager.getString(IError.msgErrorUnknown));
    }

    public CalcException(String message) {
        super(manager.getString(IError.msgErrorError) + message);
    }

    public CalcException(String message, Throwable cause) {
        super(manager.getString(IError.msgErrorError) + message + cause);
    }

    public CalcException(Throwable cause) {
        this(manager.getString(IError.msgErrorUnknown) + cause);
    }
}
