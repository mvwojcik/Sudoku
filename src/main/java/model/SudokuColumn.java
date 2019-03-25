package model;


public class SudokuColumn implements SudokuGroup {
    SudokuField sudokuFields[] = new SudokuField[9];
    @Override
    public boolean verify() {
        return false;
    }
}
