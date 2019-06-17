package exceptions;

public class DaoIOException extends SudokuException {
    public DaoIOException(final String message) {
        super(message);
    }

    public DaoIOException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
