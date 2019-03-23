package model;

import utils.BoardUtils;

import java.util.*;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard() {
        this.board = new int[9][9];
    }

    public final int[][] getBoard() {
        return this.board;
    }

    public int set(int x, int y,int value){
        this.board[y][x] = value;
        return value;
    }

    public int get(int x, int y){
        return  this.board[y][x];
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