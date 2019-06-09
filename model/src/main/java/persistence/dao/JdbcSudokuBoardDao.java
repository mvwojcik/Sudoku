package persistence.dao;

import exceptions.ReaderIOException;
import exceptions.WriterIOException;
import model.SudokuBoard;

import java.io.IOException;

public class JdbcSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {


    @Override
    public SudokuBoard read() throws IOException, ClassNotFoundException, ReaderIOException {
        return null;
    }

    @Override
    public void write(SudokuBoard sudokuBoard) throws IOException, WriterIOException {

    }

    @Override
    public void close() throws Exception {

    }
}
