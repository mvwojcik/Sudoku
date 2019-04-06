package model;

import java.util.List;

public class SudokuColumn extends SudokuGroupBase {
  public SudokuColumn() {
    super();
  }

  public SudokuColumn(final List<SudokuField> sudokuFieldList) {
    super(sudokuFieldList);
  }
}
