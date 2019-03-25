package model;

import utils.BoardUtils;

import java.util.Arrays;
import java.util.TreeSet;


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
        if ((x > BoardUtils.SIZE || x < 0) || (y > BoardUtils.SIZE || y < 0)) {
            throw new IllegalArgumentException();
        }
        return  this.board[y][x];
    }

    public final boolean check() {
        for (int z = 0; z < BoardUtils.BOXSIZE; z++) {
            for (int k = 0; k < BoardUtils.BOXSIZE; k++) {
                for (int i = k * BoardUtils.BOXSIZE; i < BoardUtils.BOXSIZE * k + BoardUtils.BOXSIZE; i++) {
                    TreeSet<Integer> values = new TreeSet<>();
                    for (int j = z * BoardUtils.BOXSIZE; j < BoardUtils.BOXSIZE * z + BoardUtils.BOXSIZE; j++) {
                        System.out.print(this.get(i, j));

                        if (!values.add(this.get(i, j))) {
                            return false;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < BoardUtils.SIZE; i++) {
            TreeSet<Integer> values = new TreeSet<>();
            for (int j = 0; j < BoardUtils.SIZE; j++) {
                if (!(values.add(this.get(i, j)))) {
                    return false;
                }
            }
        }

        for (int i = 0; i < BoardUtils.SIZE; i++) {
            TreeSet<Integer> values = new TreeSet<>();
            for (int j = 0; j < BoardUtils.SIZE; j++) {
                if (!(values.add(this.get(i, j)))) {
                    return false;
                }
            }
        }

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
