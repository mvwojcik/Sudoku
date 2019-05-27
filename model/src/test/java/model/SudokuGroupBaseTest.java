package model;

import algorithms.BackTrackingSudokuSolver;
import algorithms.SudokuSolver;
import model.SudokuBoard;
import model.SudokuColumn;
import model.SudokuField;
import model.SudokuInsideList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuGroupBaseTest {

    @Test
    public void testcheck() {

        SudokuColumn sudokuColumn = new SudokuColumn();
        assertEquals(sudokuColumn.getSudokuFieldList().size(),9);
        assertThrows(UnsupportedOperationException.class,() ->sudokuColumn.getSudokuFieldList().add(new SudokuField(9)));

    }

    @Test
    public void checkBoard() {
        SudokuBoard sudokuBoard = new SudokuBoard();


    }
    @Test
    public void checkSetBoard() {
            SudokuBoard sudokuBoard1 = new SudokuBoard();
             SudokuSolver sudokuBoard1Solver = new BackTrackingSudokuSolver();
            sudokuBoard1Solver.solve(sudokuBoard1);
            assertEquals(1,1);


    }

    @Test
    public void checkEquals() {

        SudokuField sudokuField = new SudokuField(2);
        SudokuField sudokuField1 = new SudokuField(2);
        assertEquals(sudokuField,sudokuField1);
        assertTrue(sudokuField.equals(sudokuField1));
        assertFalse(sudokuField==sudokuField1);

        SudokuField sudokuField2 = new SudokuField();
        SudokuField sudokuField3 = new SudokuField();
        assertEquals(sudokuField2,sudokuField3);
        assertTrue(sudokuField2.equals(sudokuField3));
        assertFalse(sudokuField2==sudokuField3);


    }

    @Test
    public void checkListEquals() {


    }

}
