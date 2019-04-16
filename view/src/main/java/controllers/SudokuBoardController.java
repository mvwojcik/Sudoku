package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuBoardController {

  Button prevButton;
    TextField textField;
  @FXML private GridPane gridPane;

  @FXML
  void clickOnAction(ActionEvent event) {
    if (prevButton != null) {
        prevButton.setText(textField.getText());
      prevButton.setGraphic(null);
    }
    textField = new TextField();
    ((Button) (event.getSource())).setGraphic(textField);
    ((Button) (event.getSource())).setText(textField.getText());
    prevButton = ((Button) (event.getSource()));
  }
}
