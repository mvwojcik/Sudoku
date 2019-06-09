package exceptions;

public class ReaderIOException extends DaoIOException {
    public ReaderIOException(String message) {
        super(message);
    }

    public ReaderIOException(String message, Throwable cause) {
        super(message, cause);
    }
}
