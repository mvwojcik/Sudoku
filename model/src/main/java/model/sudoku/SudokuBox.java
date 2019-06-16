package model.sudoku;

import java.io.Serializable;
import java.util.List;

public class SudokuBox extends SudokuGroupBase implements Cloneable, Serializable {

  public SudokuBox() {
    super();
  }

  public SudokuBox(final List<SudokuField> sudokuFields) {
    super(sudokuFields);
  }
}
