import javafx.application.Application;
import javafx.stage.Stage;

import utils.FXMLManager;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLManager manager = new FXMLManager(primaryStage);
        manager.getStage().setTitle("Sudoku");
        manager.setStage(manager.getStage(), manager.MAINSCENEPATH);
    }
}
