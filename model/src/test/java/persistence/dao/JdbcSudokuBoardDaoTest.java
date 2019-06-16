package persistence.dao;

import algorithms.BackTrackingSudokuSolver;
import model.levels.Easy;
import model.sudoku.SudokuBoard;
import org.junit.jupiter.api.Test;

class JdbcSudokuBoardDaoTest {


    @Test
    public void connectionTest() throws Exception {
        SudokuBoard sudokuBoard1;
        BackTrackingSudokuSolver sudokuBoard1Solver;
        sudokuBoard1 = new SudokuBoard();
        sudokuBoard1Solver = new BackTrackingSudokuSolver();
        sudokuBoard1Solver.solve(sudokuBoard1);

Easy easy = new Easy();
easy.handleLevel(sudokuBoard1);
        JdbcSudokuBoardDao jdbcSudokuBoardDao = new JdbcSudokuBoardDao(easy);

        jdbcSudokuBoardDao.drop();
        jdbcSudokuBoardDao.create();
        jdbcSudokuBoardDao.write(sudokuBoard1,"Jazda526");
        jdbcSudokuBoardDao.read("Jazda526");
        jdbcSudokuBoardDao.drop();
        jdbcSudokuBoardDao.close();

    }
}
