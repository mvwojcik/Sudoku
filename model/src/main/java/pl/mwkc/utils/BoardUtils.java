package pl.mwkc.utils;

import model.SudokuField;
import model.SudokuInsideList;

import java.util.List;

public class BoardUtils {
    protected BoardUtils() {

    }

    public static final byte SIZE = 9;
    public static final byte BOXSIZE = 3;

    public static SudokuField[] getSudokuFields() {
        SudokuField[] sudokuFields = new SudokuField[SIZE];
        for (int i = 0; i < BoardUtils.SIZE; i++) {
            sudokuFields[i] = new SudokuField();
        }
        return sudokuFields;
    }

    public static void check9arg(final int arg) {
        if (arg < 0 || arg > SIZE)  {
            throw new IllegalArgumentException();
        }

    }

    public static void check3x3arg(final int x, final int y) {
        if (x != 0 && x != BOXSIZE && x != BOXSIZE * 2) {
            throw new IllegalArgumentException();
        } else if (y != 0 && y != BOXSIZE && y != BOXSIZE * 2) {
            throw new IllegalArgumentException();
        }
    }

    public static void printBoard(final int[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printList(final List<SudokuInsideList> list) {
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        System.out.print(list.get(i).get(j));
      }
      System.out.println();
    }
    System.out.println();
    }
}
