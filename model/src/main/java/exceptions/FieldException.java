package exceptions;

public class FieldException extends BoardException {
    public FieldException(String message) {
        super(message);
    }

    public FieldException(String message, Throwable cause) {
        super(message, cause);
    }
}
