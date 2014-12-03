package george.sfg.userinterface;

import george.sfg.userinterface.framework.ControlledScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Cloud on 03/12/2014.
 */
public class WeaponSelectController implements ControlledScreen {

    private ScreensController myController;

    @FXML
    Button select = new Button();

    public void setScreensParent(ScreensController screensParent)
    {
        myController = screensParent;
    }

}
