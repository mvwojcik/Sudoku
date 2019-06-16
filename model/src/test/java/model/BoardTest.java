package model;

import exceptions.FieldException;
import model.sudoku.SudokuBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void test1()
    {
        SudokuBoard sudokuBoard = new SudokuBoard();
        try {
            assertEquals(sudokuBoard.get(1,2),0);
        } catch (FieldException e) {
            e.printStackTrace();
        }
    }
}
