package model;

import utils.BoardUtils;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class SudokuGroupBase {
  private List<SudokuField> sudokuFieldList;

  public SudokuGroupBase() {
    this.sudokuFieldList = Arrays.asList(new SudokuField[BoardUtils.SIZE]);
    for (int i = 0; i < BoardUtils.SIZE; i++) {
      this.sudokuFieldList.set(i, new SudokuField());
    }
    //  sudokuFieldList.forEach(sudokuField -> new SudokuField());
  }

  public SudokuGroupBase(final List<SudokuField> sudokuFields) {
    this.sudokuFieldList = Arrays.asList(new SudokuField[BoardUtils.SIZE]);
    if (sudokuFields.size() != BoardUtils.SIZE) {
        throw new IllegalArgumentException("size of list has to be equal to 9");
    }
    sudokuFieldList = sudokuFields;
  }

  public final void setSudokuFieldList(final List<SudokuField> sudokuFields) {
    if (sudokuFields.size() != BoardUtils.SIZE) {
        throw new IllegalArgumentException("size of List has to be equal to 9");
    }
    this.sudokuFieldList = sudokuFields;
  }

  public final boolean verify() {

    //      Arrays.asList(this.sudokuFields);

    TreeSet<Integer> treeSet = new TreeSet<>();
    for (SudokuField sudokuField : this.sudokuFieldList) {
      if (!treeSet.add(sudokuField.getFieldValue())) {
          return false;
      }
    }
    return true;
  }

  public final List<SudokuField> getSudokuFieldList() {
    return sudokuFieldList;
  }

  public final boolean checkProperSize(final int x) {
    if (this.sudokuFieldList.size() != x) {
        throw new IllegalArgumentException("");
    }

    return true;
  }
}
