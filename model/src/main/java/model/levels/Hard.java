package model.levels;

import exceptions.FieldException;
import model.sudoku.SudokuBoard;
import pl.mwkc.utils.BoardUtils;

public class Hard extends Level {
    private static final String NAME = "Hard";
    private static final int VALUE = 2;

    public static String getName() {
        return NAME;
    }

    public static int getValue() {
        return VALUE;
    }

    public Hard() {
        super.NAME = this.NAME;
    }

    @Override
    public SudokuBoard handleLevel(SudokuBoard sudokuBoard)
            throws FieldException {
        this.levelHandler = new LevelHandler();

        sudokuBoard = this.levelHandler.handleLevel(sudokuBoard, 9);
        for (int i = 0; i < BoardUtils.SIZE; i++) {
            for (int j = 0; j < BoardUtils.SIZE; j++) {
                this.lock[i][j] = sudokuBoard.get(i, j) == 0;
            }
        }
        return sudokuBoard;
    }


}
