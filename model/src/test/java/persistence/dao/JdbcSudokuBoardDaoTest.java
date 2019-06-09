package persistence.dao;

import algorithms.BackTrackingSudokuSolver;
import exceptions.SudokuSolverException;
import model.SudokuBoard;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class JdbcSudokuBoardDaoTest {


    @Test
    public void connectionTest() throws SQLException, ClassNotFoundException, SudokuSolverException {
         SudokuBoard sudokuBoard1;
         BackTrackingSudokuSolver sudokuBoard1Solver;
        sudokuBoard1 = new SudokuBoard();
        sudokuBoard1Solver = new BackTrackingSudokuSolver();
        sudokuBoard1Solver.solve(sudokuBoard1);



        JdbcSudokuBoardDao jdbcSudokuBoardDao = new JdbcSudokuBoardDao();

        jdbcSudokuBoardDao.drop();
        jdbcSudokuBoardDao.create();
        
    }
}
