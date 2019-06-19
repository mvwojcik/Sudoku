package persistence.dao;

import exceptions.DBException;
import exceptions.FieldException;
import exceptions.ReaderIOException;
import exceptions.WriterIOException;
import model.levels.Easy;
import model.levels.Hard;
import model.levels.Intermediate;
import model.levels.Level;
import model.sudoku.SudokuBoard;
import org.h2.jdbcx.JdbcDataSource;

import java.sql.*;

public class JdbcSudokuBoardDao implements Dao<SudokuBoard>, AutoCloseable {


    private final String JDBC_DRIVER = "org.h2.Driver";
    private Connection connection;
    private JdbcDataSource dataSource = new JdbcDataSource();

    private int counter = 0;
    private Level level;

    public Level getLevel() {
        return level;
    }

    public JdbcSudokuBoardDao(Level level) throws DBException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new DBException("error.driver", e);
        }

        dataSource.setURL("jdbc:h2:~/test");
        dataSource.setUser("sa");
        dataSource.setPassword("sa");
        this.level = level;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DBException("error.connection", e);
        }

    }


    public void create() {
        Statement statement;

        try {
            statement = connection.createStatement();

            statement.executeUpdate
                    ("CREATE TABLE IF NOT EXISTS BOARDS (name VARCHAR(30) PRIMARY KEY )");

            statement.executeUpdate
                    ("CREATE TABLE IF NOT EXISTS LEVELS (id_board VARCHAR(30), level VARCHAR(30), FOREIGN KEY (id_board) references BOARDS(NAME))");

            statement.executeUpdate
                    ("CREATE TABLE IF NOT EXISTS FIELDS ( id INT PRIMARY KEY, rows INT, col INT, val INT, lock BOOL, id_board VARCHAR(30)," +
                            " FOREIGN KEY (id_board) references BOARDS(name));");
            connection.commit();
            initCounter();

        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public SudokuBoard read(String name) throws ReaderIOException, DBException {
        SudokuBoard sudokuBoard = new SudokuBoard();
        try {
            Statement statement = null;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT level FROM LEVELS where ID_BOARD = '" + name + "';");
            resultSet.next();
            String lvl = resultSet.getString("level");
            if (lvl.equals("Easy")) {
                this.level = new Easy();
            } else if (lvl.equals("Hard")) {
                this.level = new Hard();
            } else {
                this.level = new Intermediate();
            }
        } catch (SQLException e) {
            throw new DBException("error.db");
        }
        Statement statement2 = null;
        try {
            statement2 = connection.createStatement();

            ResultSet rs = statement2.executeQuery("SELECT * FROM FIELDS WHERE id_board = '" + name + "' ORDER BY rows, col; ");
            while (rs.next()) {
                int x = rs.getInt("rows");
                int y = rs.getInt("col");
                sudokuBoard.set(x, y, rs.getInt("val"));
                level.setLock(x, y, rs.getBoolean("lock"));
            }
        } catch (SQLException ex) {
            throw new DBException("error.db");
        }

        return sudokuBoard;
    }

    @Override
    public void write(SudokuBoard sudokuBoard, String name) throws WriterIOException, FieldException, DBException {


        Statement statement;

        try {
            statement = connection.createStatement();

            String boards = "INSERT INTO BOARDS " +
                    "VALUES('" + name + "');";
            statement.addBatch(boards);

            String levels = "INSERT INTO LEVELS VALUES('" + name + "', '" + this.level.getName() + "');";
            statement.addBatch(levels);
            statement.executeBatch();

            StringBuilder fields = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    fields.append("INSERT INTO FIELDS  VALUES(" + counter++ + ", " + i + ", " + j + ", " +
                            sudokuBoard.get(i, j) + "," + this.level.getLock(i, j) + ", '" + name + "'); ");
                }
            }
            statement.addBatch(fields.toString());
            statement.executeBatch();
            connection.commit();
        } catch (Exception ex) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                throw new DBException("error.db");
            }
        }
    }

    public void drop() throws DBException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS BOARDS");
            statement.executeUpdate("DROP TABLE IF EXISTS FIELDS");
            statement.executeUpdate("DROP TABLE IF EXISTS LEVELS");
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
                throw new DBException("error.db");
            } catch (SQLException e1) {
                throw new DBException("error.db");
            }
        }

    }


    @Override
    public void close() throws Exception {
        this.connection.close();
    }

    @Override
    public void finalize() {
    }

    private void initCounter() throws SQLException {
        ResultSet rs;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) AS SIZE FROM FIELDS");
            rs = ps.executeQuery();
            rs.next();
            this.counter = rs.getInt("SIZE");
        } catch (NullPointerException ex) {
            this.counter = 0;
        }
    }
}
