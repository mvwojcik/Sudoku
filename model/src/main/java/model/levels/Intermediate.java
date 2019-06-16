package model.levels;


import exceptions.FieldException;
import model.sudoku.SudokuBoard;

public class Intermediate extends Level{
  private static final String name = "Intermediate";
  private static final int value = 1;


    public static String getName() {
        return name;
    }

    public static int getValue() {
        return value;
    }

    public Intermediate() {
        super.name = this.name;
    }

    @Override
    public SudokuBoard handleLevel(SudokuBoard sudokuBoard) throws FieldException {
        this.levelHandler = new LevelHandler();

        sudokuBoard = this.levelHandler.handleLevel(sudokuBoard,6);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.lock[i][j] = sudokuBoard.get(i, j) == 0;
            }
        }
        return sudokuBoard;
    }
}
