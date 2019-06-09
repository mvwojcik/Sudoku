package exceptions;

public class DaoIOException extends SudokuException{
    public DaoIOException(String message) {
        super(message);
    }

    public DaoIOException(String message, Throwable cause) {
        super(message, cause);
    }
}
