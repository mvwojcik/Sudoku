package persistence.dao;

import java.io.IOException;

public interface Dao <T> extends AutoCloseable{

    T read() throws IOException, ClassNotFoundException;

    void write(T t) throws IOException;

}
