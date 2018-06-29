package View;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class startMenuController {

	// Take user to the Character Stats scene 
	public void callCharacterScene(ActionEvent event) throws IOException
	{
		Parent start_screen = FXMLLoader.load(getClass().getResource("Stats_Builder.fxml"));
		Scene characterScene = new Scene(start_screen);
		
		Stage startWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		startWindow.setScene(characterScene);
		startWindow.show();
	}
	
	// Take user to the Help scene
	public void callHelpScene(ActionEvent event) throws IOException
	{
		Parent start_screen = FXMLLoader.load(getClass().getResource("help.fxml"));
		Scene helpScene = new Scene(start_screen);
		
		Stage startWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		startWindow.setScene(helpScene);
		startWindow.show();
	}
	
	
}
