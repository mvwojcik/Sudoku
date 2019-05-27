package controllers;

import algorithms.BackTrackingSudokuSolver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Level;
import model.SudokuBoard;

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
        sudokuBoard = level.handleLevel(sudokuBoard);
        sudokuBoard2 = sudokuBoard.clone();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.gridPane.add(createButton(sudokuBoard2.get(i, j)), i, j);
            }
        }
    }

    @FXML
    void clickOnAction(ActionEvent event) {

        System.out.println("bum");
    }

    private boolean validate(String value) {

        if (value.matches("[1-9]")) {
            return true;
        }
        return false;
    }

    private TextField createButton(int value) {
        TextField textField = new TextField();
        if (value != 0) {
            textField.setText(String.valueOf(value));
            textField.setDisable(true);
            textField.setPrefWidth(120);
            textField.setPrefHeight(73);
            textField.setAlignment(Pos.CENTER);
        } else {
            textField.setText("");

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
                        });
        return textField;
    }

    public static void setLevel(Level level) {
        SudokuBoardController.level = level;
    }
}
