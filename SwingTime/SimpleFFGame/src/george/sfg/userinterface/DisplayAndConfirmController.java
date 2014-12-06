package george.sfg.userinterface;

import com.sun.javafx.scene.SceneEventDispatcher;
import com.sun.javafx.scene.SceneHelper;
import george.sfg.characters.Fighter;
import george.sfg.characters.storedCharacters.FighterList;
import george.sfg.userinterface.framework.ControlledScreen;
import george.sfg.weapons.Weapon;
import george.sfg.weapons.storedWeapons.WeaponList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.net.URL;
import java.util.EventListener;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

/**
 * Created by Cloud on 03/12/2014.
 */
public class DisplayAndConfirmController implements ControlledScreen {

    ScreensController myController;

    FighterList fighters = new FighterList();
    WeaponList weapons = new WeaponList();

    @FXML
    private VBox root_vbox = new VBox();

    @FXML
    private Button confirm_button = new Button();

    @FXML
    private Button cancel_button = new Button();

    @FXML
    private TextArea chosen_character_stats = new TextArea();

    @FXML
    private ImageView chosen_character_image = new ImageView();

    @FXML
    private ImageView chosen_weapon_image = new ImageView();

    public void initialize()
    {
        System.out.println("george.sfg.userinterface.framework.DisplayAndConfirm.initialize");
        Thread thr = new Thread(initTask);
        thr.setName("Init Display and Confirm Thread");
        thr.start();
    }

    @FXML
    public void confirmButtonClicked(ActionEvent event)
    {
        myController.setPlayerFighter(fighters.getFighter(myController.getSelectedCharacter()).copy());
        myController.getPlayerFighter().equipWeapon(weapons.getWeapon(myController.getSelectedWeapon()));
        Thread thr = new Thread(setupFighterTask);
        thr.setName("Enemy Pick Thread");
        thr.start();
        myController.loadScreen(ScreensFramework.screen4ID, ScreensFramework.screen4File);
        myController.setScreen("screen4");
    }

    public void pickRandomEnemy()
    {
        int charSel = IntFunction.randInt(0, fighters.getList().size());
        int wepSel = IntFunction.randInt(0, weapons.getList().size());

        myController.setEnemyFighter(fighters.getList().get(0).copy());
        myController.getEnemyFighter().equipWeapon((Weapon) weapons.getList().get(0).copy());
    }

    @FXML
    public void cancelButtonClicked(ActionEvent event)
    {
        myController.setScreen("main");
    }

    @Override
    public void setScreensParent(ScreensController screenParent) {
        myController = screenParent;
    }

    Task initTask = new Task<Void>() {
        @Override public Void call() {
            System.out.println(myController.getSelectedWeapon());
            Weapon weapon = (Weapon) weapons.getWeapon(myController.getSelectedWeapon()).copy();
            Fighter fighter = fighters.getFighter(myController.getSelectedCharacter()).copy();
            fighter.equipWeapon(weapon);
            chosen_character_image.setImage(fighter.getImage());
            chosen_weapon_image.setImage(weapon.getWepImage());
            chosen_character_stats.setText(fighter.toString() + "\n" + weapon.toString());
            return null;
        }
    };

    Task setupFighterTask = new Task<Void>() {
        @Override public Void call() {
            pickRandomEnemy();
            return null;
        }
    };
}
