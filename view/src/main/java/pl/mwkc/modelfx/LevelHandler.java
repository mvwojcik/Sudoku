package pl.mwkc.modelfx;

import model.SudokuBoard;

import java.io.Serializable;
import java.util.Random;

public class LevelHandler implements Serializable {
    public SudokuBoard handleLevel(SudokuBoard sudokuBoard, int val) {
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
