package model;

import utils.BoardUtils;

import java.util.Arrays;

public class SudokuBoard {
  private int[][] board;

  public SudokuBoard() {

    this.board = BoardGenerator.generateBoard();
    fillBoard();
  }

  public final void fillBoard() {
    BoardGenerator.solveSudoku(this.board, BoardUtils.SIZE);
  }

  public final int[][] getBoard() {
    return this.board;
  }

  @Override
  public final boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SudokuBoard)) {
      return false;
    }
    SudokuBoard that = (SudokuBoard) o;
    return Arrays.equals(this.getBoard(), that.getBoard());
  }

  @Override
  public final int hashCode() {
    return Arrays.hashCode(getBoard());
  }
}
