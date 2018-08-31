package App.View;

import App.Handler.SQLCommands;
import App.Handler.SQLHandler;
import javafx.application.Platform;
import javafx.concurrent.Task;
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

    private boolean already_executed = false;
    private Thread thread;
    private String threadName = "urlThread";
    private HashMap id_icon_mapping;
    private Task<Void> backgroundTask;
    private Task<Void> sqlTask;
    private int count;

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
        if(!already_executed) {


            updateCharacterPane(SQLCommands.INITIALIZE);
        }

        already_executed = true;
    }

    private void updateCharacterPane(SQLCommands command){


        backgroundTask = new Task<Void>() {
            @Override
            public Void call() {


                switch (command) {
                    case INITIALIZE:
                        id_icon_mapping = SQLHandler.getInstance().statsBuilderInitialisation();
                        break;

                    default :
                        System.out.println("No command valid");
                        break;
                }

                Iterator iterator = id_icon_mapping.entrySet().iterator();
                count = 0;

                while (iterator.hasNext()) {
                    Map.Entry pair = (Map.Entry) iterator.next();
                    System.out.println(pair.getKey() + " = " + pair.getValue());


                    Platform.runLater(() -> {
                        Image image = new Image((String) pair.getValue());
                        ImageView toggleImage = new ImageView(image);
                        toggleImage.setPreserveRatio(true);
                        toggleImage.setFitWidth(80);


                        ToggleButton characterIcon = new ToggleButton();
                        characterIcon.setText(null);
                        characterIcon.setGraphic(toggleImage);
                        characterIcon.setLayoutY(((count / 5) * 80) + ((count / 5) * 13) + 13);
                        characterIcon.setLayoutX(((count % 5) * 100) + ((count % 5) * 13) + 13);

                        characterIcons.getChildren().add(characterIcon);
                        count++;

                    });


                }
                return null;
            }
        };

        new Thread(backgroundTask).start();

    }



}
