package model;

public class SudokuInsideList extends SudokuGroupBase {
  public SudokuInsideList() {
    super();
  }

  public final int set(final int x, final Integer value) {
    this.sudokuFieldList.get(x).setFieldValue(value);
    return value;
  }

  public final int get(final int x) {
    return this.sudokuFieldList.get(x).getFieldValue();
  }

  @Override
  public final String toString() {
    String x = "Sudoku Fields: ";
    for (SudokuField sudokuField : this.sudokuFieldList) {
      x += (sudokuField.getFieldValue() + " ");
    }

    return "SudokuInsideList{" + "sudokuFieldList=" + x + '}';
  }
}
