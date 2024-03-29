package App;

import App.View.StartMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;
//import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;

public class MainApp extends Application{
	
	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	@Override
	// Sets the title for the primary stage
	public void start(Stage primaryStage){

		StartMenuController view = new StartMenuController();

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Start Menu");

		initRootLayout();
		
	}
	
	// call the Start_Menu scene from the View package and displays it
	public void initRootLayout(){
		try {
			// Load root layout from FXML file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("View/Start_Menu.fxml"));
			rootLayout = (AnchorPane) loader.load();


			// show the scene containing the root layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();


		}catch (IOException e) {
			e.printStackTrace();
		}
	}


	
	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
