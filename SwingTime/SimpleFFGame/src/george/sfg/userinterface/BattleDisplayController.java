package george.sfg.userinterface;

import george.sfg.characters.Fighter;
import george.sfg.userinterface.framework.ControlledScreen;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

import javax.sound.sampled.*;
import javax.swing.*;
import java.applet.Applet;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Squall on 04/12/2014.
 */
public class BattleDisplayController implements ControlledScreen {

    private ScreensController myController;

    @FXML
    TextField current_health = new TextField();

    @FXML
    TextField player_name = new TextField();

    @FXML
    TextField enemy_name = new TextField();

    @FXML
    TextField enemy_health = new TextField();

    @FXML
    HBox bar_group = new HBox();

    MediaPlayer player;


    @FXML
    Button skill1 = new Button();

    @FXML
    Button skill2 = new Button();

    @FXML
    Button skill3 = new Button();

    @FXML
    Button skill4 = new Button();

    @FXML
    Button dmg_test_button = new Button();

    @FXML
    ImageView player_image = new ImageView();

    @FXML
    ImageView enemy_image = new ImageView();

    List<Button> buttons = new ArrayList<>();
    List<ImageView> images = new ArrayList<>();

    public void initialize()
    {
        System.out.println("george.sfg.userinterface.framework.BattleDisplayController.initialize");
        Thread thr = new Thread(initTask);
        thr.setName("Init Battle");
        thr.start();
    }



    @FXML
    public void onPressedSkillButton1(ActionEvent event)
    {
        System.out.println("SKIll1");
    }

    @FXML
    public void onPressedDmgTestButton(ActionEvent event)
    {
        System.out.println("DMG BUTTON");
        System.out.println(myController.getEnemyFighter().getHealth());
        takeDamage(150, myController.getPlayerFighter());
        updatePlayerHealth();
    }

    @Override
    public void setScreensParent(ScreensController screenParent) {
        myController = screenParent;
    }

    public void takeDamage(int damage, Fighter fighter)
    {
        if (fighter.getHealth() - damage < 0)
        {
            fighter.setHealth(0);
            updatePlayerHealth();
            deathEvent();
        }
        else if (fighter.getHealth() - damage == 0)
        {
            fighter.setHealth(0);
            updatePlayerHealth();
            deathEvent();
        }
        else
        {
            fighter.setHealth(fighter.getHealth() - damage);
        }
    }

    private void deathEvent()
    {
        System.out.println("You Died Noob!");
        player.stop();
        myController.loadScreen(ScreensFramework.screen5ID, ScreensFramework.screen5File);
        myController.setScreen("screen5");
    }

    private void updatePlayerHealth()
    {
        current_health.setText("" + myController.getPlayerFighter().getHealth());
    }

    public void setupMusic()
    {
        System.out.println("Music");
        Media medMsg = new Media(ScreensFramework.class.getClassLoader().getResource("george/sfg/userinterface/resources/music/Those Who Fight Further.mp3").toString());
        player = new MediaPlayer(medMsg);
        player.play();
        System.out.println("Leaving Msg thread.\n");
    }

    Task initTask = new Task<Void>() {
        @Override public Void call() {
            buttons.add(skill1);
            buttons.add(skill2);
            buttons.add(skill3);
            buttons.add(skill4);
            player_image.setImage(myController.getPlayerFighter().getImage());
            enemy_image.setImage(myController.getEnemyFighter().getImage());
            current_health.setText("" + myController.getPlayerFighter().getHealth());
            player_name.setText(myController.getPlayerFighter().getName());
            enemy_health.setText("" + myController.getEnemyFighter().getHealth());
            enemy_name.setText(myController.getEnemyFighter().getName());
            for (int i = 0; i < myController.getPlayerFighter().getSkills().size(); i++)
            {
                buttons.get(i).setGraphic(new ImageView(myController.getPlayerFighter().getSkills().get(i).getImage()));
            }
            setupMusic();

            return null;
        }
    };

}
