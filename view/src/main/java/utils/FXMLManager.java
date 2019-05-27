package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class FXMLManager {
  public final String GAMESCENEPATH = "/fxmls/SudokuBoard.fxml";
  public final String MAINSCENEPATH = "/fxmls/MainScene.fxml";

  private static Stage stage;

  private static Locale locale = Locale.ENGLISH;
  private static ResourceBundle bundle = ResourceBundle.getBundle("bundles.msgs",locale);

  public FXMLManager(Stage stage) {
    this.stage = stage;
  }

  public FXMLManager() {}

  private FXMLLoader fxmlLoader(String path) {
    FXMLLoader loader = new FXMLLoader(FXMLManager.class.getClass().getResource(path));
      loader.setResources(ResourceBundle.getBundle("bundles.msgs"));
    return loader;
  }

  public Scene changeScene(String path) throws IOException {
    Parent parent = fxmlLoader(path).load();

    return new Scene(parent);
  }

  public void setStage(Stage stage, String path) throws IOException {
    stage.setScene(changeScene(path));
    stage.setTitle("Sudoku");
    stage.show();
  }

  public Stage getStage() {
    return stage;
  }

  public static ResourceBundle getBundle() {
    return bundle;
  }

  public static void setLocale(Locale locale) {
    FXMLManager.locale = locale;
  }

  public static Locale getLocale() {
    return locale;
  }
}
