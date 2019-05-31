package persistence.dao;

import java.io.*;
import java.nio.file.Paths;

public class FileLevelDao <T> implements Dao<T>, AutoCloseable{

    ObjectOutputStream writer;
    ObjectInputStream reader;
    private File file;

    public FileLevelDao(String path) {
        this.file = new File(path);
        Paths.get(path);
    }

    public T read() throws IOException, ClassNotFoundException {
        reader = new ObjectInputStream(new FileInputStream(file));
        T level = (T)reader.readObject();
        System.out.println(level.hashCode());
        return level;
    }

    @Override
    public void write(T t) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(file));
        writer.writeObject(t);
        System.out.println(t.hashCode());

    }
/*
    @Override
    public void write(Level level) throws IOException {
        writer = new ObjectOutputStream(new FileOutputStream(file));
        writer.writeObject(level);
        System.out.println(level.hashCode());
    }
*/
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
}
