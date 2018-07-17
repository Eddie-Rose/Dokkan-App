package App.View;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public interface ButtonController {

	// Take the user back to the previous scene
	void back(ActionEvent event) throws IOException;

	
	// Take user back to the Start Menu
	void home(ActionEvent event) throws IOException;

}
