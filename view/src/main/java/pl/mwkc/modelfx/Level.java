package pl.mwkc.modelfx;

import model.SudokuBoard;
import pl.mwkc.utils.FXMLManager;

import java.io.Serializable;

public abstract class Level implements Serializable {

    boolean [][] dis = new boolean[9][9];
    LevelHandler levelHandler;

    private static String name;

    public abstract SudokuBoard handleLevel(SudokuBoard sudokuBoard);

    public boolean getDis(int x, int y) {
        return dis[x][y];
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
        if (n == Easy.getValue()) return FXMLManager.getBundle().getString("level.easy");
        else if (n == Intermediate.getValue())
            return FXMLManager.getBundle().getString("level.intermediate");

        return FXMLManager.getBundle().getString("level.hard");
    }
}
