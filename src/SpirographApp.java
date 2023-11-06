import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpirographApp extends Application {

  @Override
  public void start(Stage stage) throws IOException {
    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("paint.fxml"))));
    stage.setTitle("Spirograph Plotter");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
