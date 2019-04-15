package persistence.dao;

import model.SudokuBoard;

public class SudokuBoardDaoFactory {

    public static Dao<SudokuBoard> getFileDao(String fileName) {

        return new FileSudokuBoardDao(fileName);
    }
}
