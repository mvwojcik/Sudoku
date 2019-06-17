package exceptions;

public class GenericException extends ReaderIOException {
    public GenericException(final String message) {
        super(message);
    }

    public GenericException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
