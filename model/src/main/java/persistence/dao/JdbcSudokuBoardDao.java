package persistence.dao;

import exceptions.ReaderIOException;
import exceptions.WriterIOException;
import model.SudokuBoard;
import org.h2.jdbcx.JdbcDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {


    private final String JDBC_DRIVER = "org.h2.Driver" ;
    private Connection connection;
    private JdbcDataSource dataSource = new JdbcDataSource();
    Logger logger = LoggerFactory.getLogger(JdbcSudokuBoardDao.class);


    public JdbcSudokuBoardDao() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        dataSource.setURL("jdbc:h2:~/test");
        dataSource.setUser("sa");
        dataSource.setPassword("sa");
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("connection.isClosed() = " + connection.isClosed());

    }

    public void create() throws SQLException {
        PreparedStatement statement = null;
        //statement = connection.prepareStatement("CREATE TABLE boards( \"name\" VARCHAR(30)));");
        statement = connection.prepareStatement("CREATE TABLE boards( name  VARCHAR(30));");
        statement.execute();
    }

    public void drop() throws SQLException {
        PreparedStatement statement = null;
        statement = connection.prepareStatement("DROP TABLE BOARDS;");
        statement.execute();
    }

    @Override
    public SudokuBoard read() throws IOException, ClassNotFoundException, ReaderIOException {

        return null;
    }

    @Override
    public void write(SudokuBoard sudokuBoard) throws IOException, WriterIOException {
        PreparedStatement statement = null;
        try {
            statement.setObject(1,sudokuBoard);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {

    }
}
