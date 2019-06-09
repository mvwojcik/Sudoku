package persistence.dao;

import model.SudokuBoard;

import java.io.*;
import java.nio.file.Paths;

public class FileSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {

    private File file;
    private ObjectInputStream reader;
    private ObjectOutputStream writer;

    public FileSudokuBoardDao(String path) {
        this.file = new File(path);
        Paths.get(path);
    }

    public void write(SudokuBoard sudokuBoard) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(file));
        writer.writeObject(sudokuBoard);
    }

    public SudokuBoard read() throws IOException, ClassNotFoundException {
        reader = new ObjectInputStream(new FileInputStream(file));
        SudokuBoard sudokuBoard = (SudokuBoard)reader.readObject();
        return sudokuBoard;
    }

    @Override
    public void close() throws Exception {

        if (this.reader != null)
        {
            reader.close();
        }
        else if(this.writer != null) {
            writer.close();
        }

    }

    public void finalize() {
    }

}
