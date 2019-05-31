package pl.mwkc.modelfx;


import model.SudokuBoard;

public class Intermediate extends Level{
  private static final String name = "Intermediate";
  private static final int value = 1;


    public static String getName() {
        return name;
    }

    public static int getValue() {
        return value;
    }

    @Override
    public SudokuBoard handleLevel(SudokuBoard sudokuBoard) {
        this.levelHandler = new LevelHandler();

        sudokuBoard = this.levelHandler.handleLevel(sudokuBoard,6);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.dis[i][j] = sudokuBoard.get(i, j) == 0;
            }
        }
        return sudokuBoard;
    }
}
