package george.sfg.userinterface;

import george.sfg.characters.Fighter;
import george.sfg.userinterface.framework.ControlledScreen;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
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
    HBox bar_group = new HBox();

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

    List<Button> buttons = new ArrayList<>();

    public void initialize()
    {
        System.out.println("BEFORE FIGHTER");
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
    }

    private void updatePlayerHealth()
    {
        current_health.setText("" + myController.getPlayerFighter().getHealth());
    }

    Task initTask = new Task<Void>() {
        @Override public Void call() {
            buttons.add(skill1);
            buttons.add(skill2);
            buttons.add(skill3);
            buttons.add(skill4);
            System.out.println("Enemy Fighter");
            setupMusic();
            System.out.println(myController.getEnemyFighter());
            current_health.setText("" + myController.getPlayerFighter().getHealth());
            for (int i = 0; i < myController.getPlayerFighter().getSkills().size(); i++)
            {
                buttons.get(i).setBackground(new Background(new BackgroundImage(myController.getPlayerFighter().getSkills().get(i).getImage(),
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
                buttons.get(i).setText(myController.getPlayerFighter().getSkills().get(i).getName());
            }

            return null;
        }
    };

    public void setupMusic()
    {
        System.out.println("Music");
        System.out.println(getClass().getResource("resources" + File.separator + "music" + File.separator + "Those Who Fight Further.mp3"));
        Media medMsg = new Media(getClass().getResource(File.separator + "resources" + File.separator + "music" + File.separator + "Those Who Fight Further.mp3").toExternalForm());
        MediaPlayer medplMsg = new MediaPlayer(medMsg);
        medplMsg.play();

        System.out.println("Leaving Msg thread.\n");
    }

}
