package App.View;

import App.Handler.WindowsHandler;
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

	private final String imageUrl = "img/Background/";


	@FXML
	ImageView leftBackground;

	@FXML
	ImageView test;

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
			Parent start_screen = FXMLLoader.load(getClass().getResource("Help_Menu.fxml"));
			Scene helpScene = new Scene(start_screen);

			Stage startWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

			startWindow.setScene(helpScene);
			startWindow.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void setBackground() {

        String testBackground;

        ArrayList<String> listOfFiles = WindowsHandler.fileLister("./src/main/resources/" + imageUrl);

        if (listOfFiles.isEmpty()) {
            return;
        }

        int fileCount = listOfFiles.size();
        System.out.println(fileCount);
        int randomNumber = (int) (Math.random() * (fileCount));
        System.out.println((int) (Math.random()));

        String[] listOfFilesString = listOfFiles.toArray(new String[listOfFiles.size()]);

        String randomBackground = listOfFilesString[randomNumber];
        System.out.println(randomNumber);
        System.out.println(randomBackground);
        Image setLeftImg = new Image(imageUrl + randomBackground);

        if (randomNumber < (fileCount - 1)) {
            int num = randomNumber + 1;
            testBackground = listOfFilesString[num];
        } else {
            testBackground = listOfFilesString[(int) (Math.random() * 0)];
        }

        Image setRightImg = new Image(imageUrl + testBackground);

        test.setImage(setRightImg);
        test.setPreserveRatio(false);
        test.setFitHeight(900);
        test.setFitWidth(473);

        leftBackground.setImage(setLeftImg);
        leftBackground.setPreserveRatio(false);
        leftBackground.setFitHeight(900);
        leftBackground.setFitWidth(473);

    }


	
}
