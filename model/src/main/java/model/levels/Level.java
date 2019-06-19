package model.levels;

import exceptions.FieldException;
import model.sudoku.SudokuBoard;
import pl.mwkc.utils.BoardUtils;

import java.io.Serializable;

public abstract class Level implements Serializable {

    protected boolean[][] lock = new boolean[BoardUtils.SIZE][BoardUtils.SIZE];
    protected LevelHandler levelHandler;

    protected static String NAME;

    public abstract SudokuBoard handleLevel(SudokuBoard sudokuBoard)
            throws FieldException;

    public final boolean getLock(final int x, final int y) {
        return lock[x][y];
    }

    public final void setLock(int x, int y, boolean val) {
        this.lock[x][y] = val;
    }

    public static String getName() {
        return NAME;
    }

    public final static Level handleLevels(final int level) {
        switch (level) {
            case 0:
                return new Easy();
            case 1:
                return new Intermediate();
            default:
                return new Hard();
        }
    }

    public final static String handleLevelNames(final Double n) {
        if (n == Easy.getValue()) {
            return "level.easy";
        } else if (n == Intermediate.getValue()) {
            return "level.intermediate";
        }
        return "level.hard";
    }
}
