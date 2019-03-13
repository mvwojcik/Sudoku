package main;

import model.SudokuBoard;
import utils.BoardUtils;

public class Main {
  public static void main(String[] args) {

    SudokuBoard board = new SudokuBoard();
    board.fillBoard();
    BoardUtils.printBoard(board.getBoard());
  }
}
