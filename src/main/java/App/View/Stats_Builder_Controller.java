package App.View;

import App.Handler.SQLHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

public class Stats_Builder_Controller implements ButtonController, Initializable {

    private boolean already_excecuted = false;

    @FXML
    AnchorPane characterIcons;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        first_initialisation();
    }

    public void back(ActionEvent event) throws IOException
	{
		Parent start_screen = FXMLLoader.load(getClass().getResource("Start_Menu.fxml"));
		Scene characterScene = new Scene(start_screen);

		Stage startWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

		startWindow.setScene(characterScene);
		startWindow.show();
	}

    public void home(ActionEvent event) throws IOException
	{
		Parent start_screen = FXMLLoader.load(getClass().getResource("Start_Menu.fxml"));
		Scene characterScene = new Scene(start_screen);

		Stage startWindow = (Stage)((Node)event.getSource()).getScene().getWindow();

		startWindow.setScene(characterScene);
		startWindow.show();
	}


	public void first_initialisation() {
        if(!already_excecuted) {

            HashMap id_icon_mapping = SQLHandler.getInstance().statsBuilderInitialisation();
            Iterator iterator = id_icon_mapping.entrySet().iterator();
            int count = 0;

            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();
                System.out.println(pair.getKey() + " = " + pair.getValue());


                Image image = new Image((String)pair.getValue());
                ImageView toggleImage = new ImageView(image);
                toggleImage.setPreserveRatio(true);
                toggleImage.setFitWidth(186);



                ToggleButton characterIcon = new ToggleButton();
                characterIcon.setText(null);
                characterIcon.setGraphic(toggleImage);

                characterIcons.getChildren().add(characterIcon);
                characterIcon.setLayoutX(204);
                characterIcon.setLayoutY(33);

            }




        }
        already_excecuted = true;
    }

}
