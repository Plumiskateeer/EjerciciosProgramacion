package examenes.examen10032022;

public class TiroFallidoException extends RuntimeException{
    public TiroFallidoException() {
    }

    public TiroFallidoException(String message) {
        super(message);
    }

    public TiroFallidoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TiroFallidoException(Throwable cause) {
        super(cause);
    }

    public TiroFallidoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
