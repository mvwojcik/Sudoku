package exceptions;

public class GroupException extends BoardException {
    public GroupException(final String message) {
        super(message);
    }

    public GroupException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
