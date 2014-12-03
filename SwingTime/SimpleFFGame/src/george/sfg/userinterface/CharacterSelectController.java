package george.sfg.userinterface;

import george.sfg.characters.Fighter;
import george.sfg.characters.storedCharacters.FighterList;
import george.sfg.userinterface.framework.ControlledScreen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
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
public class CharacterSelectController implements ControlledScreen {

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
        String item = char_listview.getSelectionModel().getSelectedItem();
        listClickedMethod(item);
    }

    public void listClickedMethod(String clicked)
    {
        Fighter fighter = fighters.getFighter(clicked);
        picture_view.setImage(fighter.getImage());
        stat_display.setText(fighter.toString());
        select_button.setText("Select " + fighter.getName());
    }

    @FXML
    public void selectButtonClicked(ActionEvent event)
    {
        String buttonPressed = select_button.getText();
        String selection = StringFunction.splitFunction(buttonPressed);
        myController.setSelectedCharacter(selection);
        myController.setScreen("screen2");
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
            char_listview.getSelectionModel().select(0);
            listClickedMethod(char_listview.getSelectionModel().getSelectedItem());
            return names;
        }
    };

}
