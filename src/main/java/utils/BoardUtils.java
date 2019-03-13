package utils;

public class BoardUtils {

  public static void printBoard(int board[][]) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }
}
