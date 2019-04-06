package model;

import java.util.List;

public class SudokuRow extends SudokuGroupBase {
  public SudokuRow() {
    super();
  }

  public SudokuRow(final List<SudokuField> sudokuFields) {
    super(sudokuFields);
  }
}
