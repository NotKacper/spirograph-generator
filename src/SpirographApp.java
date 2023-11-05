import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SpirographApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("paint.fxml"))));
		stage.setTitle("Spirograph plotter");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}