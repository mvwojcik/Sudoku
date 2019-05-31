package persistence.dao;

import model.SudokuBoard;
import pl.mwkc.utils.BoardUtils;

import java.io.*;
import java.nio.file.Paths;

public class FileSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {

    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;
    ObjectInputStream reader2;
    ObjectOutputStream writer2;

    public FileSudokuBoardDao(String path) {
        this.file = new File(path);
        Paths.get(path);
    }

    public SudokuBoard read2() throws IOException {
        if (reader == null) {
            reader = new BufferedReader(new FileReader(file));
        }
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

    public void write2(SudokuBoard sudokuBoard) throws IOException {
        writer = new BufferedWriter(new FileWriter(file));

        for (int i = 0; i < BoardUtils.SIZE; i++) {
            for (int j = 0; j < BoardUtils.SIZE; j++) {


                writer.write(((char) sudokuBoard.get(i, j) + 48));
                //  writer.write(32);

            }
            writer.newLine();

        }
    }

    public void write(SudokuBoard sudokuBoard) throws IOException {
        writer2 = new ObjectOutputStream(new FileOutputStream(file));
        writer2.writeObject(sudokuBoard);
        System.out.println(sudokuBoard.hashCode());
    }

    public SudokuBoard read() throws IOException, ClassNotFoundException {
        reader2 = new ObjectInputStream(new FileInputStream(file));
        SudokuBoard sudokuBoard = (SudokuBoard)reader2.readObject();
        System.out.println(sudokuBoard.hashCode());
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
