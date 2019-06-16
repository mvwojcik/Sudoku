package persistence.dao;

import exceptions.DBException;
import exceptions.ReaderIOException;
import model.sudoku.SudokuBoard;

import java.io.*;

public class FileSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {

    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    public FileSudokuBoardDao() {
    }

    @Override
    public void write(SudokuBoard sudokuBoard, String name) {
        try {
            writer = new ObjectOutputStream(new FileOutputStream(new File(name)));
            writer.writeObject(sudokuBoard);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drop() throws DBException {

    }

    @Override
    public void create() {

    }

    @Override
    public SudokuBoard read(String name) throws ReaderIOException {
        try {
            reader = new ObjectInputStream(new FileInputStream(new File(name)));
        } catch (IOException e) {
            throw new ReaderIOException("error.file");
        }
        SudokuBoard sudokuBoard = null;
        try {
            sudokuBoard = (SudokuBoard) reader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new ReaderIOException("error.read");
        }
        return sudokuBoard;
    }

    @Override
    public void close() throws Exception {

        if (this.reader != null) {
            reader.close();
        } else if (this.writer != null) {
            writer.close();
        }

    }

    public void finalize() {
    }

}
