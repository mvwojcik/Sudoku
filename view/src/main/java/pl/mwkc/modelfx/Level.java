package pl.mwkc.modelfx;

import model.SudokuBoard;

import java.io.Serializable;

public abstract class Level implements Serializable {

    boolean [][] dis = new boolean[9][9];
    LevelHandler levelHandler;


    public abstract SudokuBoard handleLevel(SudokuBoard sudokuBoard);

    public boolean getDis(int x, int y) {
        return dis[x][y];
    }
}
