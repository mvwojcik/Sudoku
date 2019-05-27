package model;

import algorithms.BackTrackingSudokuSolver;
import model.SudokuBoard;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class GeneratorTest {

    private SudokuBoard sudokuBoard1;
    private SudokuBoard sudokuBoard2;
    private BackTrackingSudokuSolver sudokuBoard1Solver;
    private BackTrackingSudokuSolver sudokuBoard2Solver;

    @BeforeAll
    public void initBoards() {
        this.sudokuBoard1 = new SudokuBoard();
        this.sudokuBoard2 = new SudokuBoard();
        this.sudokuBoard1Solver = new BackTrackingSudokuSolver();
        this.sudokuBoard2Solver = new BackTrackingSudokuSolver();
        sudokuBoard1Solver.solve(sudokuBoard1);
        sudokuBoard2Solver.solve(sudokuBoard2);
    }

    @Test
    public void check3() {
        for (int z = 0; z < 3; z++) {
            for (int k = 0; k < 3; k++) {
                for (int i = k * 3; i < 3 * k + 3; i++) {
                    TreeSet<Integer> values = new TreeSet<>();
                    for (int j = z * 3; j < 3 * z + 3; j++) {
//                            System.out.print(sudokuBoard1.get(i, j));

                        assertTrue(values.add(sudokuBoard1.get(i, j)));
                    }
//                        System.out.println();
                }
//                    System.out.println("\n");
            }
        }
    }

    @Test
    public void checkRandomBoardsGeneration() {
        assertFalse(sudokuBoard1 == sudokuBoard2);
        assertFalse(sudokuBoard1.equals(sudokuBoard2));
    }

    @Test
    public void checkrows() {
        for (int i = 0; i < 9; i++) {
            TreeSet<Integer> values = new TreeSet<>();
            for (int j = 0; j < 9; j++) {
                assertTrue(values.add(sudokuBoard1.get(i, j)));
                assertFalse(values.add(sudokuBoard1.get(i, j)));
            }
        }
    }

    @Test
    public void checkColumns() {
        for (int i = 0; i < 9; i++) {
            TreeSet<Integer> values = new TreeSet<>();
            for (int j = 0; j < 9; j++) {
                assertTrue(values.add(sudokuBoard1.get(j, i)));
                assertFalse(values.add(sudokuBoard1.get(j, i)));
            }
        }
    }
    @Test
    public void checkAll()
    {
       assertTrue(this.sudokuBoard1.checkBoard());
    }


}
