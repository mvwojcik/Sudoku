package exceptions;

public class SudokuSolverException extends BoardException {
    public SudokuSolverException(final String message) {
        super(message);
    }

    public SudokuSolverException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
