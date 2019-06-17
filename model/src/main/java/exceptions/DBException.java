package exceptions;

public class DBException extends DaoIOException {
    public DBException(final String message) {
        super(message);
    }

    public DBException
            (final String message, final Throwable cause) {
        super(message, cause);
    }
}
