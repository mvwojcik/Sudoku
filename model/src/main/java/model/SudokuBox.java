package model;

import java.util.List;

public class SudokuBox extends SudokuGroupBase {

  public SudokuBox() {
    super();
  }

  public SudokuBox(final List<SudokuField> sudokuFields) {
    super(sudokuFields);
  }
}
