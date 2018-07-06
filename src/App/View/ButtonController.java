package App.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ButtonController {

	// Take the user back to the previous scene
	public void back(ActionEvent event) throws IOException
	{
		Parent start_screen = FXMLLoader.load(getClass().getResource("Start_Menu.fxml"));
		Scene characterScene = new Scene(start_screen);
		
		Stage startWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		startWindow.setScene(characterScene);
		startWindow.show();
	}
	
	// Take user back to the Start Menu
	public void home(ActionEvent event) throws IOException
	{
		Parent start_screen = FXMLLoader.load(getClass().getResource("Start_Menu.fxml"));
		Scene characterScene = new Scene(start_screen);
		
		Stage startWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		startWindow.setScene(characterScene);
		startWindow.show();
	}
}
