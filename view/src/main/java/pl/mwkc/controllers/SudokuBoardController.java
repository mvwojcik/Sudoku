package pl.mwkc.controllers;

import algorithms.BackTrackingSudokuSolver;
import exceptions.*;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.levels.Level;
import model.sudoku.SudokuBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import persistence.dao.Dao;
import persistence.dao.JdbcSudokuBoardDao;
import persistence.dao.SudokuBoardDaoFactory;
import pl.mwkc.utils.FXMLManager;

import java.util.Optional;

public class SudokuBoardController {

    private SudokuBoard sudokuBoard;
    private static Level level;
    private SudokuBoard sudokuBoard2;
    @FXML
    private BorderPane border;

    private static Logger logger = LoggerFactory.getLogger(SudokuBoardController.class);

    @FXML
    private GridPane gridPane;

    @FXML
    private void initialize() {
        BackTrackingSudokuSolver sudokuBoard1Solver = new BackTrackingSudokuSolver();
        sudokuBoard = new SudokuBoard();
        try {
            sudokuBoard1Solver.solve(sudokuBoard);
        } catch (SudokuSolverException e) {
            logger.error(FXMLManager.getBundle().getString(e.getMessage())
                    + "\n" + FXMLManager.getBundle().getString(e.getCause().getMessage()));
        }
        sudokuBoard2 = sudokuBoard.clone();
        try {
            sudokuBoard2 = level.handleLevel(sudokuBoard2);
        } catch (FieldException e) {
            logger.error(FXMLManager.getBundle().getString(e.getMessage()));
        }
        createFields();
    }

    private void createFields() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                try {
                    this.gridPane.add(createButton(sudokuBoard2.get(i, j), i, j, level.getLock(i, j)), i, j);
                } catch (FieldException e) {
                    logger.error(FXMLManager.getBundle().getString(e.getMessage()));
                }
            }
        }
    }

    @FXML
    void check() {
        if (sudokuBoard2.equals(sudokuBoard)) {
            logger.info(FXMLManager.getBundle().getString("game.win"));
        }
        try {
            if(sudokuBoard2.checkBoard()) {
                logger.info(FXMLManager.getBundle().getString("game.win"));
            }
            else
            {
                logger.info(FXMLManager.getBundle().getString("game.lose"));
            }

        } catch (VerificationException | GroupException e) {
            FXMLManager.getBundle().getString(e.getMessage());
        }

    }

    @FXML
    void save() {
        try (Dao<SudokuBoard> dao = SudokuBoardDaoFactory.getFileDao();
             Dao<Level> dao1 = SudokuBoardDaoFactory.getLevelDao()) {
            dao.write(this.sudokuBoard, "zapis.sudoku");
            dao.write(this.sudokuBoard2, "zapis.sudoku");
            dao1.write(level, "zapis.level");

        } catch (FieldException | DBException | WriterIOException e) {
            logger.error(FXMLManager.getBundle().getString(e.getMessage()));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @FXML
    void load() {
        try (Dao<SudokuBoard> dao = SudokuBoardDaoFactory.getFileDao();
             Dao<Level> dao2 = SudokuBoardDaoFactory.getLevelDao()) {
            SudokuBoard boardOrigin = dao.read("zapis.sudoku");
            SudokuBoard board = dao.read("zapis.sudoku");
            this.sudokuBoard = boardOrigin;
            this.sudokuBoard2 = board;
            level = dao2.read("zapis.level");

            gridPane.getChildren().remove(0, 81);


            createFields();

        } catch (ReaderIOException | DBException e) {
            logger.error(FXMLManager.getBundle().getString(e.getMessage()));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @FXML
    public void saveDb() {
        try (Dao<SudokuBoard> dao = SudokuBoardDaoFactory.getDbDao(level)) {
            dao.create();
            String s = editDialog();
            dao.write(sudokuBoard2, s);
            logger.info(FXMLManager.getBundle().getString("DB.saved")+" " + s);

        } catch (DBException e) {
            e.printStackTrace();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @FXML
    public void loadDb() {
        try (Dao<SudokuBoard> dao = SudokuBoardDaoFactory.getDbDao(level)) {
            String s = editDialog();

            this.sudokuBoard2 = dao.read(s);
            logger.info(FXMLManager.getBundle().getString("DB.readed")+" " + s);
            level = ((JdbcSudokuBoardDao) dao ).getLevel();
            gridPane.getChildren().remove(0, 81);

            createFields();
        } catch (DBException e) {
            logger.error(FXMLManager.getBundle().getString(e.getMessage()));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private boolean validate(String value) {

        return value.matches("[1-9]");
    }

    private TextField createButton(int value, int x, int y, boolean wasDisabled) {
        TextField textField = new TextField();
        if (value != 0) {
            if (wasDisabled) {
                textField.setDisable(false);
            } else {
                textField.setDisable(true);
            }
            textField.setText(String.valueOf(value));
            textField.setPrefWidth(142);
            textField.setPrefHeight(81);
            textField.setAlignment(Pos.CENTER);
        } else {
            if (wasDisabled) {
                textField.setDisable(false);
                if (value != 0) {
                    textField.setText(String.valueOf(value));
                } else textField.setText("");
            } else {
                textField.setText("");
            }
            textField.setPrefWidth(120);
            textField.setPrefHeight(73);
            textField.setAlignment(Pos.CENTER);
        }

        textField
                .textProperty()
                .addListener(
                        (observable, oldValue, newValue) -> {
                            if (!validate(newValue) && !newValue.equals("")) {
                                textField.setText(oldValue);
                            }
                            if (validate(newValue) && !newValue.equals("")) {
                                sudokuBoard2.set(x, y, Integer.valueOf(newValue));
                            }
                            if (!validate(newValue) && newValue.equals("")) {
                                sudokuBoard2.set(x, y, 0);
                            }
                        });
        return textField;
    }

    public static void setLevel(Level level) {
        SudokuBoardController.level = level;
    }

    public static String editDialog() {
        TextInputDialog dialog = new TextInputDialog("sudokuSave");
        dialog.setContentText(FXMLManager.getBundle().getString("dialog.name"));
        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
    }
}
