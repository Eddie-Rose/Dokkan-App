package App.View;

import App.Handler.WindowsHandler;
import App.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StartMenuController implements Initializable {

	@FXML
	ImageView background;

	@Override
	public void initialize(URL location, ResourceBundle resources){

		setBackground();
	}


	// Take user to the Character Stats scene 
	public void callCharacterScene(ActionEvent event) {
		try {

			Parent start_screen = FXMLLoader.load(getClass().getResource("Stats_Builder.fxml"));
			Scene characterScene = new Scene(start_screen);

			Stage startWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

			startWindow.setScene(characterScene);
			startWindow.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Take user to the Help scene
	public void callHelpScene(ActionEvent event) {
		try {
			Parent start_screen = FXMLLoader.load(getClass().getResource("Help.fxml"));
			Scene helpScene = new Scene(start_screen);

			Stage startWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

			startWindow.setScene(helpScene);
			startWindow.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setBackground() {

		ArrayList<String> listOfFiles = WindowsHandler.fileLister("./src/img/Background");

		if (listOfFiles.isEmpty()){
			return;
		}

		int fileCount = listOfFiles.size();
		System.out.println(fileCount);
		int randomNumber = (int) (Math.random() * (fileCount));

		String[] listOfFilesString = listOfFiles.toArray(new String[listOfFiles.size()]);

		String randomBackground = listOfFilesString[randomNumber];
		System.out.println(randomNumber);
		Image img = new Image("img/Background/" + randomBackground);


		background.setImage(img);
		background.setPreserveRatio(false);
		background.setFitHeight(900);
		background.setFitWidth(1350);

	}
	
	
}
