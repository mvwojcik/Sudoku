package exceptions;

public class ReaderIOException extends DaoIOException {
    public ReaderIOException(final String message) {
        super(message);
    }

    public ReaderIOException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
