package exceptions;

public class WriterIOException extends DaoIOException {
    public WriterIOException(String message) {
        super(message);
    }

    public WriterIOException(String message, Throwable cause) {
        super(message, cause);
    }
}
