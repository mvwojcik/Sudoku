package pl.mwkc.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class FXMLManager {
  public static final String GAMESCENEPATH = "/fxmls/SudokuBoard.fxml";
  public static final String MAINSCENEPATH = "/fxmls/MainScene.fxml";

  private static Stage stage;

  private static Locale locale;
  private static ResourceBundle bundle ;

  public FXMLManager(Stage stage) {

      locale = Locale.getDefault();
      bundle = ResourceBundle.getBundle("bundles.msgs",locale);
      this.stage = stage;
  }

  public FXMLManager() {}

  private static FXMLLoader fxmlLoader(String path) {
    FXMLLoader loader = new FXMLLoader(FXMLManager.class.getClass().getResource(path));
      loader.setResources(ResourceBundle.getBundle("bundles.msgs",locale));
    return loader;
  }

  public static Scene changeScene(String path) throws IOException {
    Parent parent = fxmlLoader(path).load();

    return new Scene(parent);
  }

  public static void setStage(Stage stage, String path) throws IOException {
    stage.setScene(changeScene(path));
    stage.setTitle("Sudoku");
    stage.show();
  }

  public static Stage getStage() {
    return stage;
  }

  public static ResourceBundle getBundle() {
    return bundle;
  }

  public static void setLocale(Locale locale) {
    FXMLManager.locale = locale;
    bundle = ResourceBundle.getBundle("bundles.msgs",locale);
  }

  public static Locale getLocale() {
    return locale;
  }
}
