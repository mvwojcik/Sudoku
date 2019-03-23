package utils;

public class BoardUtils {
  protected BoardUtils() {

  }
public static final byte SIZE = 9;
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
