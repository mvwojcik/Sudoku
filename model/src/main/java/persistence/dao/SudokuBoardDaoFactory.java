package persistence.dao;

import exceptions.DBException;
import model.levels.Level;
import model.sudoku.SudokuBoard;

public class SudokuBoardDaoFactory {

    public static Dao<SudokuBoard> getFileDao() {

        return new FileSudokuBoardDao();
    }

    public static <T> Dao<T> getLevelDao() {
        return new FileLevelDao<T>();
    }

    public static Dao<SudokuBoard> getDbDao(Level level) throws DBException {
        return new JdbcSudokuBoardDao(level);
    }
}
