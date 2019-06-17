package exceptions;

public class BoardException extends SudokuException {

    public BoardException(final String message) {
        super(message);
    }

    public BoardException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
