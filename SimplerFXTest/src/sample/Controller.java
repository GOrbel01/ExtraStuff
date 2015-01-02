package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, ControlledScreen {

    ScreensController myController;

    @FXML
    private VBox root_vbox;

    @FXML
    private Button change_button;

    public void setScreensParent(ScreensController screenParent)
    {
        myController = screenParent;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    @FXML
    void initialize()
    {
        System.out.println("sample.Controller.initialize");
        assert root_vbox != null : "root vbox not injected'.";
    }

    @FXML
    void buttonResponse(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("samplenext.fxml"));

        Stage secondStage = new Stage();
        secondStage.setTitle("Next Stage");
        secondStage.setScene(new Scene(root, 300, 175));
        secondStage.show();
    }

    @FXML
    private void goToScreen2(ActionEvent event)
    {
        myController.setScreen(ScreensFramework.screen2ID);
    }

}
