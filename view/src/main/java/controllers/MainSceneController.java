package controllers;

import javafx.beans.property.SimpleListProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;
import model.*;
import utils.FXMLManager;

import java.io.IOException;
import java.util.Locale;

public class MainSceneController {

  @FXML private Slider levelSlider;

  @FXML private ComboBox<String> languageComboBox;

  public void initialize() {
    initSlider();
    /* languageComboBox.setItems(
    new SimpleListProperty<>(FXMLManager.getBundle().getString("language.english")
    ,FXMLManager.getBundle().getString("language.polish")));*/
    languageComboBox.getItems().add(FXMLManager.getBundle().getString("language.english"));
    languageComboBox.getItems().add(FXMLManager.getBundle().getString("language.polish"));
  }

  @FXML
  void changeLanguage(ActionEvent event) {

    if (languageComboBox
            .getSelectionModel()
            .getSelectedItem()
            .equals(FXMLManager.getBundle().getString("language.english"))
        && FXMLManager.getLocale() != Locale.ENGLISH) {
        changeLanguage1(Locale.ENGLISH);
    }
    else if (languageComboBox
            .getSelectionModel()
            .getSelectedItem()
            .equals(FXMLManager.getBundle().getString("language.polish"))
        && FXMLManager.getLocale() != Locale.getDefault()) {
        changeLanguage1(Locale.getDefault());
    }
  }

    private void changeLanguage1(Locale locale) {
        FXMLManager.setLocale(locale);

        FXMLManager manager = new FXMLManager();

        try {
          manager.setStage(manager.getStage(), manager.MAINSCENEPATH);
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
    }

    @FXML
  void confirm() {
    SudokuBoardController.setLevel(handleLevels((int) levelSlider.getValue()));
    FXMLManager manager = new FXMLManager();
    try {
      manager.setStage(manager.getStage(), manager.GAMESCENEPATH);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  private void initSlider() {
    levelSlider.setMin(0);
    levelSlider.setMax(2);
    levelSlider.setValue(1);
    levelSlider.setMinorTickCount(0);
    levelSlider.setMajorTickUnit(1);
    levelSlider.setSnapToTicks(true);
    levelSlider.setShowTickMarks(true);
    levelSlider.setShowTickLabels(true);
    levelSlider.setLabelFormatter(
        /* new StringConverter<Double>() {
          @Override
          public String toString(Double n) {
            if (n == GameSettings.easy.ordinal()) return GameSettings.easy.name();
            else if (n == GameSettings.intermediate.ordinal())
              return GameSettings.intermediate.name();

            return GameSettings.hard.name();
          }

          @Override
          public Double fromString(String string) {
            if (string.equals(GameSettings.easy.name())) return (double) GameSettings.easy.ordinal();
            else if (string.equals(GameSettings.intermediate.name())) return (double) GameSettings.intermediate.ordinal();

            return (double)GameSettings.hard.ordinal();
          }
        }*/
        new StringConverter<Double>() {
          @Override
          public String toString(Double n) {
            if (n == Easy.getValue()) return FXMLManager.getBundle().getString("level.easy");
            else if (n == Intermediate.getValue())
              return FXMLManager.getBundle().getString("level.intermediate");

            return FXMLManager.getBundle().getString("level.hard");
          }

          @Override
          public Double fromString(String string) {
            if (string.equals(Easy.getName())) return (double) Easy.getValue();
            else if (string.equals(Intermediate.getName())) return (double) Intermediate.getValue();

            return (double) Hard.getValue();
          }
        });
  }

  private Level handleLevels(int level) {
    switch (level) {
      case 0:
        return new Easy();
      case 1:
        return new Intermediate();
      default:
        return new Hard();
    }
  }
}
