package controllers;

import algorithms.BackTrackingSudokuSolver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.SudokuBoard;

public class SudokuBoardController {

    Button prevButton;
    TextField textField;
    TextField previousTextField;
    SudokuBoard sudokuBoard;
    private BackTrackingSudokuSolver sudokuBoard1Solver;


    @FXML
    private GridPane gridPane;

    @FXML
    private void initialize() {
        sudokuBoard1Solver = new BackTrackingSudokuSolver();
        sudokuBoard = new SudokuBoard();
        sudokuBoard1Solver.solve(sudokuBoard);
        for (int i = 0; i < 9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                
            }

        }
    }

    @FXML
    void clickOnAction(ActionEvent event) {
        if (previousTextField != null && !validate(previousTextField.getText())) {
            previousTextField.setText("");
        }
        if (prevButton != null) {
            prevButton.setText(textField.getText());
            prevButton.setGraphic(null);
        }
        textField = new TextField();
        ((Button) (event.getSource())).setGraphic(textField);
        ((Button) (event.getSource())).setText(textField.getText());
        prevButton = ((Button) (event.getSource()));
        previousTextField = textField;
    }


    private boolean validate(String jazda) {

        if (jazda.matches("[1-9]")) {
            return true;
        }
        return false;
    }
}
