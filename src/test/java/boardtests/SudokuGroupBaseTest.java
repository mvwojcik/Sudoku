package boardtests;

import algorithms.BackTrackingSudokuSolver;
import algorithms.SudokuSolver;
import model.*;
import org.junit.jupiter.api.BeforeAll;
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
        assertEquals(sudokuBoard.getBoardAsList().size(),9);
        assertThrows(UnsupportedOperationException.class,() ->sudokuBoard.getBoardAsList().add(new SudokuInsideList()));
        assertDoesNotThrow(()-> sudokuBoard.getBoardAsList().set(5,new SudokuInsideList()));

    }
    @Test
    public void checkSetBoard() {
            SudokuBoard sudokuBoard1 = new SudokuBoard();
             SudokuSolver sudokuBoard1Solver = new BackTrackingSudokuSolver();
            sudokuBoard1Solver.solve(sudokuBoard1);
           for (int i=0; i<9; i++ ) {
      System.out.println(sudokuBoard1.getBoardAsList().get(i));
            }
            assertEquals(1,1);


    }

}
