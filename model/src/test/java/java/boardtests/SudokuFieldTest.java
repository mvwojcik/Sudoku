package java.boardtests;

import model.SudokuField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SudokuFieldTest {

    @Test
    public void checkSudokuFieldConstructorWithParametr() {
        SudokuField sudokuField = new SudokuField(5);
        assertEquals(sudokuField.getFieldValue(),5);
    }
    @Test
    public void checkSudokuFieldConstructor() {
        SudokuField sudokuField = new SudokuField();
        sudokuField.setFieldValue(5);
        assertEquals(sudokuField.getFieldValue(),5);
    }
}
