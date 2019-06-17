package exceptions;

public class WriterIOException extends DaoIOException {
    public WriterIOException(final String message) {
        super(message);
    }

    public WriterIOException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
