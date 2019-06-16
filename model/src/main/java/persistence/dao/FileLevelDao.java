package persistence.dao;

import exceptions.*;

import java.io.*;

public class FileLevelDao<T> implements Dao<T>, AutoCloseable {

    ObjectOutputStream writer;
    ObjectInputStream reader;

    public FileLevelDao() {
    }

    @Override
    public void create() {

    }

    @Override
    public T read(String name) throws ReaderIOException {
        try {
            reader = new ObjectInputStream(new FileInputStream(new File(name)));
            return (T) reader.readObject();
        } catch (IOException e) {
throw new ReaderIOException("error.reader",e);
        } catch (ClassNotFoundException e) {
throw new GenericException("error.generic",e);
        }
    }

    @Override
    public void write(T t, String name) throws WriterIOException {
        try {
            writer = new ObjectOutputStream(new FileOutputStream(new File(name)));
            writer.writeObject(t);
        } catch (IOException e) {
throw new WriterIOException("error.writer",e);
        }
    }

    @Override
    public void drop() throws DBException {

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
