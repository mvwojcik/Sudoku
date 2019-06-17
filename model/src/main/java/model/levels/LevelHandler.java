package model.levels;

import exceptions.FieldException;
import model.sudoku.SudokuBoard;
import pl.mwkc.utils.BoardUtils;

import java.io.Serializable;
import java.util.Random;

public class LevelHandler implements Serializable {
    public final SudokuBoard handleLevel(final SudokuBoard sudokuBoard, final int val)
            throws FieldException {
        SudokuBoard sudokuBoardCopy = sudokuBoard.clone();
        Random random = new Random();
        for (int i = 0; i < val; i++) {
            int x = random.nextInt(BoardUtils.SIZE);
            int y = random.nextInt(BoardUtils.SIZE);
            if (sudokuBoardCopy.get(x, y) != 0) {
                sudokuBoardCopy.set(x, y, 0);
            }
        }    return sudokuBoardCopy;
    }
}
