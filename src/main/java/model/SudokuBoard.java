package model;

import java.util.Arrays;

public class SudokuBoard {
  private int[][] board;
  private BoardGenerator generatorbcOOP;

  public SudokuBoard() {

    this.generatorbcOOP = new BoardGenerator();
    this.board = generatorbcOOP.generateBoard();
    fillBoard();
  }

  public void fillBoard() {
    generatorbcOOP.solveSudoku(board, 9);
  }

  public int[][] getBoard() {
    return board;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SudokuBoard)) return false;
    SudokuBoard that = (SudokuBoard) o;
    return Arrays.equals(getBoard(), that.getBoard());
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(getBoard());
  }
}
