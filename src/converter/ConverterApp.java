package converter;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * UI controller for events and initializing components.
 * @author Kunyaruk Katebunlu
 */
public class ConverterApp extends Application {
	
	/**
	 * The start method is called after the init method has returned,
	 * and after the system is ready for the application to begin running.
	 * @param primaryStage is the stage for this application which the application scene can be set.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("ConverterUI.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Length Converter");
			primaryStage.show();
		} catch(Exception e) {
			System.out.println("Exception creating scene: " + e.getMessage());
		}
	}
	
	/**
	 * Main method for run the application.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
