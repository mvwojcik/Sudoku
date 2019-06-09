package pl.mwkc;

import javafx.application.Application;
import javafx.stage.Stage;

import pl.mwkc.utils.FXMLManager;

import java.util.Locale;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLManager manager = new FXMLManager(primaryStage);
        FXMLManager.setLocale(Locale.forLanguageTag("pl-PL"));
        FXMLManager.getStage().setTitle("Sudoku");
        FXMLManager.setStage(FXMLManager.getStage(), FXMLManager.MAINSCENEPATH);
    }
}
