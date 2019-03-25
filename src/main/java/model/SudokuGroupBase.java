package model;

import java.util.Arrays;
import java.util.TreeSet;

public class SudokuGroupBase {
  private SudokuField[] sudokuField;

  public SudokuGroupBase(SudokuField [] sudokuField) {
    this.sudokuField = new SudokuField[9];
    for (int i = 0; i < 9; i++) {
      this.sudokuField[i] = sudokuField[i];
    }
  }

  public boolean verify() {

      Arrays.asList(this.sudokuField);

      TreeSet<Integer> treeSet = new TreeSet<>();
      for (SudokuField sudokuField:this.sudokuField)
      {
          if(!treeSet.add(sudokuField.value))
              return false;
      }
      return true;
  }
}
