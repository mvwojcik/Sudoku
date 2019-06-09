package exceptions;

public class BoardException extends SudokuException {

    public BoardException(String message) {
        super(message);
    }
    public BoardException(String message, Throwable cause) {
        super(message, cause);
    }
}
