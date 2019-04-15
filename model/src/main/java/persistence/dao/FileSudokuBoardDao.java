package persistence.dao;

import model.SudokuBoard;
import utils.BoardUtils;

import java.io.*;
import java.nio.file.Paths;

public class FileSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {

    File file;
    BufferedReader reader;
    BufferedWriter writer;
    public FileSudokuBoardDao(String path) {
        this.file = new File(path);
        Paths.get(path);
    }

    @Override
    public SudokuBoard read() throws IOException {
        reader = new BufferedReader(new FileReader(file));
        SudokuBoard sudokuBoard = new SudokuBoard();

        for (int i = 0; i < BoardUtils.SIZE; i++) {
            char[] chars = new char[9];
            reader.read(chars, 0, 9);
            for (int j = 0; j < 9; j++) {

                int x = Character.getNumericValue(chars[j]);
                sudokuBoard.set(i, j, x);
            }
            reader.readLine();
        }
return sudokuBoard;
    }

    @Override
    public void write(SudokuBoard sudokuBoard) throws IOException {
        writer = new BufferedWriter(new FileWriter(file));

        for (int i = 0; i < BoardUtils.SIZE; i++) {
            for (int j = 0; j < BoardUtils.SIZE; j++) {


                writer.write(((char) sudokuBoard.get(i, j) + 48));
                //  writer.write(32);

            }
            writer.newLine();

        }
    }

    @Override
    public void close() throws Exception {
        try {
            writer.close();
        } catch (IOException e) {
        }
        try {
            reader.close();
        } catch (IOException e) {
        }
    }

    public void finalize() {


    }

}
