package model;


public class SudokuColumn extends SudokuGroupBase {
    SudokuField sudokuFields[] = new SudokuField[9];

    public SudokuColumn(SudokuField[] sudokuField) {
        super(sudokuField);
    }
}
