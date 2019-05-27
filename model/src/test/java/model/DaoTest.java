package model;

import algorithms.BackTrackingSudokuSolver;
import algorithms.SudokuSolver;
import model.SudokuBoard;
import org.junit.jupiter.api.Test;
import persistence.dao.Dao;
import persistence.dao.SudokuBoardDaoFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DaoTest {

    @Test
    public void init() throws Exception {
        SudokuBoard sudokuBoard = new SudokuBoard();
        SudokuSolver sudokuSolver = new BackTrackingSudokuSolver();
        sudokuSolver.solve(sudokuBoard);


        try (Dao<SudokuBoard> dao = SudokuBoardDaoFactory.getFileDao("cieciu.txt")) {

            dao.write(sudokuBoard);

        }

        try (Dao<SudokuBoard> dao = SudokuBoardDaoFactory.getFileDao("cieciu.txt")) {

            sudokuBoard = dao.read();

        }

        assertTrue(sudokuBoard.checkBoard());

    }

}
