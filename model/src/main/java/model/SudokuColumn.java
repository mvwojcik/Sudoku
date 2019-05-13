package model;

import java.io.Serializable;
import java.util.List;

public class SudokuColumn extends SudokuGroupBase implements Cloneable, Serializable {
  public SudokuColumn() {
    super();
  }

  public SudokuColumn(final List<SudokuField> sudokuFieldList) {
    super(sudokuFieldList);
  }
}
