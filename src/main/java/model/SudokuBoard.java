package model;

import java.util.Arrays;

public class SudokuBoard {
  private int[][] board;

  public SudokuBoard() {

    this.board = BoardGenerator.generateBoard();
    fillBoard();
  }

  public void fillBoard() {
    BoardGenerator.solveSudoku(this.board, 9);
  }

  public int[][] getBoard() {
    return this.board;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SudokuBoard)) return false;
    SudokuBoard that = (SudokuBoard) o;
    return Arrays.equals(this.getBoard(), that.getBoard());
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(getBoard());
  }
}
