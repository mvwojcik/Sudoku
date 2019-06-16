/**
 * Pakiet zawiera algorytmy rozwiązywania sudoku
 */
package algorithms;

import exceptions.FieldException;
import exceptions.SudokuSolverException;
import model.sudoku.SudokuBoard;
import pl.mwkc.utils.BoardUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackTrackingSudokuSolver implements SudokuSolver {
  public final void solve(final SudokuBoard sudokuBoard) throws SudokuSolverException {
    fillFirstRow(sudokuBoard);
    try {
      solveSudoku(sudokuBoard, BoardUtils.SIZE);
    } catch (FieldException e) {
throw new SudokuSolverException("error.solver",e);
    }
  }

  private boolean isSafe(final SudokuBoard board,
                         final int row, final int col, final int num) throws FieldException {

    // Sprawdzamy czy ta liczba jest unikalna w wierszu
    for (int d = 0; d < BoardUtils.SIZE; d++) {
      if (board.get(row, d) == num) {
        return false;
      }
    }

    // Sprawdzamy czy liczba jest unikalna w kolumnie
    for (int r = 0; r < BoardUtils.SIZE; r++) {

      if (board.get(r, col) == num) {
        return false;
      }
    }

    // Sprawdzamy w kwadracie 3x3 liczba jest unikalna
    int sqrt = (int) Math.sqrt(BoardUtils.SIZE);
    int boxRowStart = row - row % sqrt;
    int boxColStart = col - col % sqrt;

    for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
      for (int d = boxColStart; d < boxColStart + sqrt; d++) {
        if (board.get(r, d) == num) {
          return false;
        }
      }
    }

    // mozna umiescic ja na tej pozycji
    return true;
  }

  private boolean solveSudoku(final SudokuBoard board, final int n) throws FieldException {

    int row = -1;
    int col = -1;
    boolean isEmpty = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board.get(i, j) == 0) {
          row = i;
          col = j;

          isEmpty = false;
          break;
        }
      }
      if (!isEmpty) {
        break;
      }
    }

    if (isEmpty) {
      return true;
    }

    for (int num = 1; num <= n; num++) {
      if (isSafe(board, row, col, num)) {
        board.set(row, col, num);
        if (solveSudoku(board, n)) {
          return true;
        } else {
          board.set(row, col, 0);
        }
      }
    }
    return false;
  }

  private static void fillFirstRow(final SudokuBoard board) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < BoardUtils.SIZE; i++) {
      list.add(i);
    }
    Collections.shuffle(list);
    for (int i = 0; i < BoardUtils.SIZE; i++) {
      board.set(0, i, list.get(i) + 1);
    }
  }
}
