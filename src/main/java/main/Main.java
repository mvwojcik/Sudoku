package main;

import model.SudokuBoard;
import utils.BoardUtils;

public class Main {
    protected Main() {

    }
    public static void main(final String[] args) {

        SudokuBoard board = new SudokuBoard();
        board.fillBoard();
        BoardUtils.printBoard(board.getBoard());
    }
}
