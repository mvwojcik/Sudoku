package exceptions;

public class SudokuSolverException extends BoardException {
    public SudokuSolverException(String message) {
        super(message);
    }

    public SudokuSolverException(String message, Throwable cause) {
        super(message, cause);
    }
}
