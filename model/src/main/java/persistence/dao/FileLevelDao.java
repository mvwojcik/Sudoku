package persistence.dao;

import exceptions.DaoIOException;
import exceptions.GenericException;
import exceptions.ReaderIOException;
import exceptions.WriterIOException;

import java.io.*;
import java.nio.file.Paths;

public class FileLevelDao<T> implements Dao<T>, AutoCloseable {

    ObjectOutputStream writer;
    ObjectInputStream reader;
    private File file;

    public FileLevelDao(String path) {
        this.file = new File(path);
        Paths.get(path);
    }

    public T read() throws ReaderIOException {
        try {
            reader = new ObjectInputStream(new FileInputStream(file));
            return (T) reader.readObject();
        } catch (IOException e) {
throw new ReaderIOException("error.reader",e);
        } catch (ClassNotFoundException e) {
throw new GenericException("error.generic",e);
        }
    }

    @Override
    public void write(T t) throws WriterIOException {
        try {
            writer = new ObjectOutputStream(new FileOutputStream(file));
            writer.writeObject(t);
        } catch (IOException e) {
throw new WriterIOException("error.writer",e);
        }
    }

    @Override
    public void close() throws DaoIOException {

        if (this.reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                throw new ReaderIOException("error.reader",e);
            }
        } else if (this.writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                throw new WriterIOException("error.writer",e);
            }
        }

    }
}
