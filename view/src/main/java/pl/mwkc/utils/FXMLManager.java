package pl.mwkc.utils;

import exceptions.BoardException;
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

      locale = Locale.forLanguageTag("pl-PL");
      bundle = ResourceBundle.getBundle("bundles.msgs",locale);
      this.stage = stage;
  }

  private static FXMLLoader fxmlLoader(String path) {
    FXMLLoader loader = new FXMLLoader(FXMLManager.class.getResource(path));
      loader.setResources(ResourceBundle.getBundle("bundles.msgs",locale));
    return loader;
  }

  private static Scene changeScene(String path) throws IOException {
    Parent parent = fxmlLoader(path).load();

    return new Scene(parent);
  }

  public static void setStage(Stage stage, String path) throws BoardException {
    try {
      stage.setScene(changeScene(path));
    } catch (IOException | IllegalStateException e) {
      throw new BoardException(bundle.getString("error.path"), e);
    }
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
