package model;

import utils.BoardUtils;

import java.util.Arrays;


public class SudokuBoard {
    private int[][] board;

    public SudokuBoard() {
        this.board = new int[BoardUtils.SIZE][BoardUtils.SIZE];
    }

    public final int[][] getBoard() {
        return this.board;
    }

    public final int set(final int x, final int y, final int value) {
        this.board[y][x] = value;
        return value;
    }

    public final int get(final int x, final int y) {
        return  this.board[y][x];
    }

    public final boolean check() {
        return true;
    }
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SudokuBoard)) {
            return false;
        }
        SudokuBoard that = (SudokuBoard) o;
        return Arrays.equals(this.getBoard(), that.getBoard());
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(getBoard());
    }

}
