package model.levels;

import exceptions.FieldException;
import model.sudoku.SudokuBoard;

import java.io.Serializable;
import java.util.Random;

public class LevelHandler implements Serializable {
    public SudokuBoard handleLevel(SudokuBoard sudokuBoard, int val) throws FieldException {
        SudokuBoard sudokuBoardCopy = sudokuBoard.clone();
        Random random = new Random();
        for (int i = 0; i < val; i++) {
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            if (sudokuBoardCopy.get(x, y) != 0) {
                sudokuBoardCopy.set(x, y, 0);
            }
        }    return sudokuBoardCopy;
    }
}
