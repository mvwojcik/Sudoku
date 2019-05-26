package model;

import java.util.Random;

public class Hard implements Level {
  private static final String name = "Hard";
  private static final int value = 2;

  @Override
  public SudokuBoard handleLevel(SudokuBoard sudokuBoard) {
    SudokuBoard sudokuBoardCopy = sudokuBoard.clone();
    Random random = new Random();
    sudokuBoardCopy.set(3, 3, 0);
    return sudokuBoardCopy;
  }

    public static String getName() {
        return name;
    }

    public static int getValue() {
        return value;
    }
}
