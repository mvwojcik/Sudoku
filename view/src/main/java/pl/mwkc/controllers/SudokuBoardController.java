package pl.mwkc.controllers;

import algorithms.BackTrackingSudokuSolver;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.SudokuBoard;
import persistence.dao.Dao;
import persistence.dao.SudokuBoardDaoFactory;
import pl.mwkc.modelfx.Level;

public class SudokuBoardController {

    private SudokuBoard sudokuBoard;
    private static Level level;
    private SudokuBoard sudokuBoard2;

    @FXML
    private GridPane gridPane;

    @FXML
    private void initialize() {
        BackTrackingSudokuSolver sudokuBoard1Solver = new BackTrackingSudokuSolver();
        sudokuBoard = new SudokuBoard();
        sudokuBoard1Solver.solve(sudokuBoard);
        sudokuBoard2 = sudokuBoard.clone();
        sudokuBoard2 = level.handleLevel(sudokuBoard2);

        //SimpleObjectProperty<SudokuBoard> sudokuBoardSimpleObjectProperty = new SimpleObjectProperty<>();
        //sudokuBoardSimpleObjectProperty.bind(sudokuBoard);
        createFields();
        //______________________________________________print(sudokuBoard2);

    }

    private void createFields() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.gridPane.add(createButton(sudokuBoard2.get(i, j), i, j, level.getDis(i, j)), i, j);
            }
        }
    }

    @FXML
    void check() {
        if (sudokuBoard2.equals(sudokuBoard)) {
            System.out.println("GOOD");
        }
    }

    @FXML
    void save() {
        try (Dao<SudokuBoard> dao = SudokuBoardDaoFactory.getFileDao("zapis.cieciu");
             Dao<Level> dao1 = SudokuBoardDaoFactory.getLevelDao("zapis.level")) {
            dao.write(this.sudokuBoard);
            dao.write(this.sudokuBoard2);
            dao1.write(level);

        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    @FXML
    void load() {
        try (Dao<SudokuBoard> dao = SudokuBoardDaoFactory.getFileDao("zapis.cieciu");
             Dao<Level> dao2 = SudokuBoardDaoFactory.getLevelDao("zapis.level")) {
            SudokuBoard boardOrigin = dao.read();
            SudokuBoard board = dao.read();
            this.sudokuBoard = boardOrigin;
            this.sudokuBoard2 = board;
            level = dao2.read();
            gridPane.getChildren().remove(0, 81);


            createFields();
            // ______________________________________________print(sudokuBoard2);


        } catch (Exception e) {
            e.printStackTrace();
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
            textField.setPrefWidth(120);
            textField.setPrefHeight(73);
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
                                System.out.println("sudokuBoard2.get(x,y) = " + sudokuBoard2.get(x, y));
                            }
                        });
        return textField;
    }

    public static void setLevel(Level level) {
        SudokuBoardController.level = level;
    }

    public static Level getLevel() {
        return level;
    }

    void ______________________________________________print(SudokuBoard sudokuBoard) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudokuBoard.get(i, j));
                System.out.print(level.getDis(i, j));
                System.out.println();
            }
            System.out.println();
        }
    }
}
