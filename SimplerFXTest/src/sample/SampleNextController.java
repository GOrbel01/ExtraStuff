package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Cloud on 02/12/2014.
 */
public class SampleNextController implements Initializable, ControlledScreen {

    ScreensController myController;

    @FXML
    private HBox root_box;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {

    }

    public void setScreensParent(ScreensController screensParent)
    {
        myController = screensParent;
    }

    @FXML
    private void goToLastController()
    {
        myController.setScreen(ScreensFramework.screen1ID);
    }

}
