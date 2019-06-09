package pl.mwkc.controllers;

import exceptions.BoardException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.mwkc.modelfx.Easy;
import pl.mwkc.modelfx.Hard;
import pl.mwkc.modelfx.Intermediate;
import pl.mwkc.modelfx.Level;
import pl.mwkc.utils.FXMLManager;

import java.util.Locale;
import java.util.ResourceBundle;

public class MainSceneController {

    @FXML
    private Slider levelSlider;

    @FXML
    private ComboBox<String> languageComboBox;

    private static Logger logger = LoggerFactory.getLogger(MainSceneController.class);


    public void initialize() {
        initSlider();
        initComboBox();
    }

    @FXML
    void changeLanguage(ActionEvent event) {

        if (languageComboBox
                .getSelectionModel()
                .getSelectedItem()
                .equals(FXMLManager.getBundle().getString("language.english"))
                && FXMLManager.getLocale() != Locale.ENGLISH) {
            changeLanguage1(Locale.ENGLISH);
        } else if (languageComboBox
                .getSelectionModel()
                .getSelectedItem()
                .equals(FXMLManager.getBundle().getString("language.polish"))
                && FXMLManager.getLocale() != Locale.forLanguageTag("pl-PL")) {
            changeLanguage1(Locale.forLanguageTag("pl-PL"));
        }
    }

    @FXML
    void confirm() {
        SudokuBoardController.setLevel(Level.handleLevels((int) levelSlider.getValue()));
        try {
            logger.info(FXMLManager.getBundle().getString("game.creating") +
                    "\n" + FXMLManager.getBundle().getString("game.level") +
                    " " + Level.handleLevelNames(levelSlider.getValue()) +
                    "\n" + FXMLManager.getBundle().getString("game.language") +
                    " " + FXMLManager.getLocale().getLanguage());

            FXMLManager.setStage(FXMLManager.getStage(), FXMLManager.GAMESCENEPATH);
        } catch (BoardException e) {
            logger.error(FXMLManager.getBundle().getString(e.getMessage()));
        }
    }

    private void changeLanguage1(Locale locale) {
        FXMLManager.setLocale(locale);
        try {
            FXMLManager.setStage(FXMLManager.getStage(), FXMLManager.MAINSCENEPATH);
        } catch (BoardException e) {
            logger.error(FXMLManager.getBundle().getString(e.getMessage()));
        } catch (IllegalStateException e) {
            logger.error(FXMLManager.getBundle().getString("error.location"));
        }
    }

    private void initComboBox() {
        languageComboBox.getItems().add(FXMLManager.getBundle().getString("language.english"));
        languageComboBox.getItems().add(FXMLManager.getBundle().getString("language.polish"));
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
                new StringConverter<Double>() {
                    @Override
                    public String toString(Double n) {
                        return Level.handleLevelNames(n);
                    }

                    @Override
                    public Double fromString(String string) {
                        if (string.equals(Easy.getName())) return (double) Easy.getValue();
                        else if (string.equals(Intermediate.getName())) return (double) Intermediate.getValue();

                        return (double) Hard.getValue();
                    }
                });
    }

    @FXML
    void creditsOnAction() {
        logger.info("openCreditsIn " + FXMLManager.getLocale() + " language");
        ResourceBundle bundle = ResourceBundle.getBundle("pl.mwkc.utils.Authors", FXMLManager.getLocale());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(bundle.getString("title"));
        alert.setHeaderText(bundle.getString("authors"));
        alert.showAndWait();
    }

}
