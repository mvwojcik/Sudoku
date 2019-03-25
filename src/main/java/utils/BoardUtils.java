package utils;

import model.SudokuField;

public class BoardUtils {
  protected BoardUtils() {

  }
  public static final byte SIZE = 9;
  public static final byte BOXSIZE = 3;
  public static SudokuField[] getSudokuFields() {
    SudokuField[] sudokuFields = new SudokuField[9];
    for (int i = 0; i < BoardUtils.SIZE; i++) {
      sudokuFields[i] = new SudokuField();
    }
    return sudokuFields;
  }
  public static void check9arg(int arg) {
    if (arg < 0 || arg > 9) throw new IllegalArgumentException();

  }
  public static void check3x3arg(int x, int y) {
    if (x != 0 && x != 3 && x != 6) throw new IllegalArgumentException();
    else if (y != 0 && y != 3 && y != 6) throw new IllegalArgumentException();
  }

  public static void printBoard(final int[][] board) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }
}
