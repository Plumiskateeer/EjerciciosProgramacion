package examenes.examen15032022;

public class DineroInsuficienteException extends Exception {
    public DineroInsuficienteException() {
        super();
    }

    public DineroInsuficienteException(String message) {
        super(message);
    }

    public DineroInsuficienteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DineroInsuficienteException(Throwable cause) {
        super(cause);
    }

    protected DineroInsuficienteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
