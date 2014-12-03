package george.sfg.userinterface;

import george.sfg.characters.Fighter;
import george.sfg.characters.storedCharacters.FighterList;
import george.sfg.userinterface.framework.ControlledScreen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;

/**
 * Created by Cloud on 03/12/2014.
 */
public class CharacterSelectController implements ControlledScreen, Initializable {

    FighterList fighters = new FighterList();

    ScreensController myController;

    @FXML
    private VBox root_box;

    @FXML
    private Button select_button;

    @FXML
    private TextArea stat_display;



    @FXML
    private ListView<String> char_listview;


    @FXML
    private ImageView picture_view;

    @FXML
    void initialize()
    {
        System.out.println("STARTING...");

    }

    public void initialize(URL url, ResourceBundle rb)
    {
        System.out.println("george.sfg.userinterface.framework.Controller.initialize");
        Thread thr = new Thread(initTask);
        thr.setName("Init Thread");
        thr.start();
    }

    public void setScreensParent(ScreensController screensParent)
    {
        myController = screensParent;
    }

    @FXML
    public void listClicked(MouseEvent event)
    {
        System.out.println("THREAD List: " + Thread.currentThread());
        String item = char_listview.getSelectionModel().getSelectedItem();
        Fighter fighter = fighters.getFighter(item);
        picture_view.setImage(fighter.getImage());
        stat_display.setText(fighter.toString());
    }

    Task<ObservableList<String>> initTask = new Task<ObservableList<String>>() {
        @Override protected ObservableList<String> call() throws Exception {
            System.out.println("THREAD: " + Thread.currentThread());
            ObservableList<String> names = FXCollections.observableArrayList();
            for (int i = 0; i < fighters.getList().size(); i++)
            {
                names.add(fighters.getList().get(i).getName());
            }
            char_listview.setItems(names);
            return names;
        }
    };


}
