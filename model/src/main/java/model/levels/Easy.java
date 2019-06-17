package model.levels;


import exceptions.FieldException;
import model.sudoku.SudokuBoard;
import pl.mwkc.utils.BoardUtils;

public class Easy extends Level {
    private static final String NAME = "Easy";
    private static final int VALUE = 0;


    public static String getName() {
        return NAME;
    }

    public static int getValue() {
        return VALUE;
    }

    public Easy() {
        super.NAME = this.NAME;
    }

    @Override
    public final SudokuBoard handleLevel
            (SudokuBoard sudokuBoard) throws FieldException {
        this.levelHandler = new LevelHandler();

        sudokuBoard = this.levelHandler.handleLevel(sudokuBoard, 2);
        for (int i = 0; i < BoardUtils.SIZE; i++) {
            for (int j = 0; j < BoardUtils.SIZE; j++) {
                this.lock[i][j] = sudokuBoard.get(i, j) == 0;
            }
        }
        return sudokuBoard;
    }
}
