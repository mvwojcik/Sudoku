package model;

import java.util.Random;

public class Easy implements Level {
  private static final String name = "Easy";
  private static final int value = 0;

  @Override
  public SudokuBoard handleLevel(SudokuBoard sudokuBoard) {
    SudokuBoard sudokuBoardCopy = sudokuBoard.clone();
    Random random = new Random();
    sudokuBoardCopy.set(1, 1, 0);
    sudokuBoardCopy.set(4, 3, 0);
    sudokuBoardCopy.set(6, 5, 0);
    return sudokuBoardCopy;
  }

    public static String getName() {
        return name;
    }

    public static int getValue() {
        return value;
    }
}
