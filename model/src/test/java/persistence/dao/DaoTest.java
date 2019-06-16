package persistence.dao;

import algorithms.BackTrackingSudokuSolver;
import algorithms.SudokuSolver;
import model.sudoku.SudokuBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DaoTest {

    @Test
    public void init() throws Exception {
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuSolver sudokuSolver = new BackTrackingSudokuSolver();
        sudokuSolver.solve(sudokuBoard);


        try (Dao<SudokuBoard> dao = SudokuBoardDaoFactory.getFileDao()) {

            dao.write(sudokuBoard, "cieciu.txt");

        }

        try (Dao<SudokuBoard> dao = SudokuBoardDaoFactory.getFileDao()) {

            sudokuBoard = dao.read("cieciu.txt");

        }

        assertTrue(sudokuBoard.checkBoard());

    }

}
