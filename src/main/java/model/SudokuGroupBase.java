package model;

import java.util.*;

public class SudokuGroupBase {
 // private SudokuField[] sudokuFields;
  private final List<SudokuField> sudokuFieldList;

  public SudokuGroupBase(SudokuField [] sudokuField) {
//    this.sudokuFields = new SudokuField[9];
    this.sudokuFieldList = new ArrayList<>(9);
    this.sudokuFieldList.addAll(Arrays.asList(sudokuField));
    for (int i = 0; i < 9; i++) {
//     this.sudokuFields[i] = sudokuField[i];
//      this.sudokuFieldList.set(i,sudokuField[i]);
    }
  }

  public boolean verify() {

//      Arrays.asList(this.sudokuFields);

      TreeSet<Integer> treeSet = new TreeSet<>();
      for (SudokuField sudokuField:this.sudokuFieldList)
      {
          if(!treeSet.add(sudokuField.value))
              return false;
      }
      return true;
  }
}
