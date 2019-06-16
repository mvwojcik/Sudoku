package algorithms;

import exceptions.SudokuSolverException;
import model.sudoku.SudokuBoard;

public interface SudokuSolver {
  void solve(SudokuBoard sudokuBoard) throws SudokuSolverException;
}
