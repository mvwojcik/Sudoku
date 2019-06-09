package persistence.dao;

import exceptions.ReaderIOException;
import exceptions.WriterIOException;

import java.io.IOException;

public interface Dao <T> extends AutoCloseable{

    T read() throws IOException, ClassNotFoundException, ReaderIOException;

    void write(T t) throws IOException, WriterIOException;

}
