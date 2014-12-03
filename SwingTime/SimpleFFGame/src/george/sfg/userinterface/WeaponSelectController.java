package george.sfg.userinterface;

import george.sfg.userinterface.framework.ControlledScreen;
import george.sfg.weapons.Weapon;
import george.sfg.weapons.storedWeapons.WeaponList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Cloud on 03/12/2014.
 */
public class WeaponSelectController implements ControlledScreen {

    private ScreensController myController;

    @FXML
    private Button select_weapon = new Button();

    @FXML
    private VBox root_box = new VBox();

    @FXML
    private TextArea weapon_stats = new TextArea();

    @FXML
    private ListView<String> weapons_list = new ListView<String>();

    @FXML
    private ImageView weapon_image = new ImageView();

    private WeaponList wepList = new WeaponList();

    public void setScreensParent(ScreensController screensParent)
    {
        myController = screensParent;
    }

    @FXML
    public void initialize()
    {
        System.out.println("george.sfg.userinterface.WeaponController.initialize");
        Thread thr = new Thread(initTask);
        thr.setName("New Init Thread");
        thr.start();
    }

    @FXML
    public void selectButtonClicked(ActionEvent event)
    {
        String buttonPressed = select_weapon.getText();
        String selection = StringFunction.splitFunction(buttonPressed);
        myController.setSelectedWeapon(selection);
        myController.loadScreen(ScreensFramework.screen3ID, ScreensFramework.screen3File);
        myController.setScreen("screen3");
    }

    @FXML
    public void listClicked(MouseEvent event)
    {
        String item = weapons_list.getSelectionModel().getSelectedItem();
        runListClickWork(item);
    }

    public void runListClickWork(String clicked)
    {
        Weapon weapon = wepList.getWeapon(clicked);
        weapon_image.setImage(weapon.getWepImage());
        weapon_stats.setText(weapon.toString());
        select_weapon.setText("Select " + weapon.getName());
    }


    Task<ObservableList<String>> initTask = new Task<ObservableList<String>>() {
        @Override protected ObservableList<String> call() throws Exception {
            System.out.println("THREAD: " + Thread.currentThread());
            ObservableList<String> names = FXCollections.observableArrayList();
            for (int i = 0; i < wepList.getList().size(); i++)
            {
                names.add(wepList.getList().get(i).getName());
            }
            weapons_list.setItems(names);
            weapons_list.getSelectionModel().select(0);
            runListClickWork(weapons_list.getSelectionModel().getSelectedItem());
            return names;
        }
    };

}
