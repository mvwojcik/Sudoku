package model;

import utils.BoardUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuBoard {
  private int[][] board;
  private List<List<SudokuField>> boardAsList;


  public SudokuBoard() {
    this.boardAsList= new ArrayList<>(9);
    for (int i = 0; i < 9; i++) {
      boardAsList.set(i, new ArrayList<>(9));
      boardAsList.get(i).forEach(sudokuField -> sudokuField = new SudokuField());

    }


    this.board = new int[BoardUtils.SIZE][BoardUtils.SIZE];
  }

  public final int[][] getBoard() {
    return this.board;
  }

  public final int set(final int x, final int y, final int value) {
    this.board[y][x] = value;
    this.boardAsList.get(y).set(x,new SudokuField(value));
    return value;
  }

  public final int get(final int x, final int y) {
    if ((x > BoardUtils.SIZE || x < 0) || (y > BoardUtils.SIZE || y < 0)) {
      throw new IllegalArgumentException();
    }
    return this.board[y][x];
  }

  public final SudokuColumn getColumn(final int x) {
    BoardUtils.check9arg(x);
    SudokuField[] sudokuFields = BoardUtils.getSudokuFields();

    for (int i = 0; i < BoardUtils.SIZE; i++) {
      sudokuFields[i].setFieldValue(this.board[i][x]);
    }
    return new SudokuColumn(sudokuFields);
  }

  public final SudokuRow getRow(final int y) {
    BoardUtils.check9arg(y);
    SudokuField[] sudokuFields = BoardUtils.getSudokuFields();

    for (int i = 0; i < BoardUtils.SIZE; i++) {
      System.out.println("");
      sudokuFields[i].setFieldValue(this.board[y][i]);
    }
    return new SudokuRow(sudokuFields);
  }
  // zakladamy ze x i y to poczatek boxa od lewej strony i od gory
  public final SudokuBox getBox(final int x, final int y) {
    BoardUtils.check3x3arg(x, y);

    SudokuField[] sudokuFields = BoardUtils.getSudokuFields();

    int z = 0;
    for (int i = x; i < x + 3; i++) {
      for (int j = y; j < y + 3; j++) {
        sudokuFields[z].setFieldValue(this.board[i][j]);
        z++;
      }
    }
    return new SudokuBox(sudokuFields);
  }

  public final boolean checkBoard() {

    for (int i = 0; i < BoardUtils.SIZE; i++) {
      {
        if (!this.getRow(i).verify() || !this.getColumn(i).verify()) {
          return false;
        }
      }
    }
    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        if (!this.getBox(j, i).verify()) {
          return false;
        }
      }
    }
    return true;
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
