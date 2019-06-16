package model.levels;

import exceptions.FieldException;
import model.sudoku.SudokuBoard;

import java.io.Serializable;

public abstract class Level implements Serializable {

    boolean[][] lock = new boolean[9][9];
    LevelHandler levelHandler;

    protected static String name;

    public abstract SudokuBoard handleLevel(SudokuBoard sudokuBoard) throws FieldException;

    public boolean getLock(int x, int y) {
        return lock[x][y];
    }

    public void setLock(int x, int y, boolean val) {
        this.lock[x][y] = val;
    }

    public static String getName() {
        return name;
    }

    public static Level handleLevels(int level) {
        switch (level) {
            case 0:
                return new Easy();
            case 1:
                return new Intermediate();
            default:
                return new Hard();
        }
    }

    public static String handleLevelNames(Double n) {
        if (n == Easy.getValue()) return "level.easy";
        else if (n == Intermediate.getValue())
            return "level.intermediate";

        return "level.hard";
    }
}
