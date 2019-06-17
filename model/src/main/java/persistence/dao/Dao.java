package persistence.dao;

import exceptions.DBException;
import exceptions.FieldException;
import exceptions.ReaderIOException;
import exceptions.WriterIOException;

public interface Dao<T> extends AutoCloseable {

    void create();

    T read(String name) throws ReaderIOException, DBException;

    void write(T t, String name) throws WriterIOException, FieldException, DBException;

    void drop() throws DBException;
}
