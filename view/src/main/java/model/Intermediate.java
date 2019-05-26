package model;

import java.util.Random;

public class Intermediate implements Level {
  private static final String name = "Intermediate";
  private static final int value = 1;

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
