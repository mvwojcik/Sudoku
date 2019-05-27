package model;

import model.SudokuField;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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


    @Test
    public void checkHashcodesAndEquals() {
        SudokuField sudokuField = new SudokuField(3);
        SudokuField sudokuField1 = new SudokuField(3);

        assertEquals(sudokuField.hashCode(),sudokuField1.hashCode());
        assertTrue(sudokuField.equals(sudokuField1));
        sudokuField1.setFieldValue(5);
        assertNotEquals(sudokuField.hashCode(),sudokuField1.hashCode());
        assertFalse(sudokuField.equals(sudokuField1));
    }

    @Test
    public void checkCompareTo() {
        SudokuField sudokuField = new SudokuField(3);
        SudokuField sudokuField1 = new SudokuField(3);

        assertEquals(sudokuField.compareTo(sudokuField1),0);

        sudokuField.setFieldValue(1);

        assertEquals(sudokuField.compareTo(sudokuField1),-1);
        assertEquals(sudokuField1.compareTo(sudokuField),1);

        sudokuField1.setFieldValue(8);

        assertEquals(sudokuField.compareTo(sudokuField1),1);
        assertEquals(sudokuField1.compareTo(sudokuField),-1);
    }
}
