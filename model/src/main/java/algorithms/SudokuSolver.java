package algorithms;

import exceptions.SudokuSolverException;
import model.SudokuBoard;

public interface SudokuSolver {
  void solve(SudokuBoard sudokuBoard) throws SudokuSolverException;
}
