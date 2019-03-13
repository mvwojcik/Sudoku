package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BoardGenerator {

  private boolean isSafe(int[][] board, int row, int col, int num) {

      //Sprawdzamy czy ta liczba jest unikalna w wierszu
    for (int d = 0; d < board.length; d++) {
      if (board[row][d] == num) {
        return false;
      }
    }

      //Sprawdzamy czy liczba jest unikalna w kolumnie
    for (int r = 0; r < board.length; r++) {

      if (board[r][col] == num) {
        return false;
      }
    }

//Sprawdzamy w kwadracie 3x3 liczba jest unikalna
    int sqrt = (int) Math.sqrt(board.length);
    int boxRowStart = row - row % sqrt;
    int boxColStart = col - col % sqrt;

    for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
      for (int d = boxColStart; d < boxColStart + sqrt; d++) {
        if (board[r][d] == num) {
          return false;
        }
      }
    }

// mozna umiescic ja na tej pozycji
return true;
  }

  public boolean solveSudoku(int[][] board, int n) {
    int row = -1;
    int col = -1;
    Random random = new Random();
    boolean isEmpty = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 0) {
          row = i;
          col = j;

          isEmpty = false;
          break;
        }
      }
      if (!isEmpty) {
        break;
      }
    }

    if (isEmpty) {
      return true;
    }


        for (int num = 1; num <= n; num++) {
      if (isSafe(board, row, col, num)) {
        board[row][col] = num;
        if (solveSudoku(board, n)) {
          return true;
        } else {
          board[row][col] = 0; // replace it
        }
      }
    }
    return false;
  }
  //metoda wypelniajaca pierwszy wiersz randomowymi liczbami(niepowtarzającymi się)
  private void fillFirstRow(int[][] board) {
    Random rand = new Random();

    List<Integer> list = new ArrayList();
    for (int i = 0; i < 9; i++) {
      list.add(i);
    }
    Collections.shuffle(list);
    for (int i = 0; i < 9; i++) {
      board[0][i] = list.get(i) + 1;
    }
  }
//generowanie tablicy z samymi zerami oraz pierwszym randomowym wierszem
  public int[][] generateBoard() {
    int[][] board = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = 0;
      }
    }
    fillFirstRow(board);
    return board;
  }
}
