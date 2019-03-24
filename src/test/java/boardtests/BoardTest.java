package boardtests;

import model.SudokuBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void test1()
    {
        SudokuBoard sudokuBoard = new SudokuBoard();
        assertEquals(sudokuBoard.get(1,2),0);
    }
}
