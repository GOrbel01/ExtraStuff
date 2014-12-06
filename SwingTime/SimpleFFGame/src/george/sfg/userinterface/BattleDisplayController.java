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

import javax.swing.*;
import javax.swing.event.MenuEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Squall on 04/12/2014.
 */
public class BattleDisplayController implements ControlledScreen {

    private ScreensController myController;

    @FXML
    MenuButton skillMenu = new MenuButton();

    @FXML
    TextArea skill_description = new TextArea();

    @FXML
    MenuItem skill1Info = new MenuItem();

    @FXML
    MenuItem skill2Info = new MenuItem();

    @FXML
    MenuItem skill3Info = new MenuItem();

    @FXML
    MenuItem skill4Info = new MenuItem();

    @FXML
    TextField current_health = new TextField();

    @FXML
    TextField player_name = new TextField();

    @FXML
    TextField enemy_name = new TextField();

    @FXML
    TextField enemy_health = new TextField();

    MediaPlayer player;

    @FXML
    Group player_controls = new Group();

    @FXML
    Button skill1 = new Button();

    @FXML
    Button skill2 = new Button();

    @FXML
    Button skill3 = new Button();

    @FXML
    Button skill4 = new Button();

    @FXML
    Button player_attack = new Button();

    @FXML
    TitledPane skillPane = new TitledPane();

    @FXML
    AnchorPane skillAnchor = new AnchorPane();

    @FXML
    Button dmg_test_button = new Button();

    @FXML
    ImageView player_image = new ImageView();

    @FXML
    ImageView enemy_image = new ImageView();

    List<Button> buttons = new ArrayList<>();
    List<MenuItem> skilldescs = new ArrayList<>();

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
        player_controls.setDisable(true);
    }

    @FXML
    public void onPressedDmgTestButton(ActionEvent event)
    {
        System.out.println("DMG BUTTON");
        System.out.println(myController.getEnemyFighter().getHealth());
        takeDamage(150, myController.getPlayerFighter());
        updatePlayerHealth();
    }

    @FXML
    public void selectSkill(ActionEvent event)
    {
        MenuItem temp = (MenuItem) event.getSource();
        String numString = temp.getId().substring(5, 6);
        int skillNo = Integer.parseInt(numString);
        skillNo = skillNo - 1;
        skill_description.setText(myController.getPlayerFighter().getSkills().get(skillNo).getDescription());
        player_controls.setDisable(false);
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

    private void updateEnemyHealth()
    {
        enemy_health.setText("" + myController.getEnemyFighter().getHealth());
    }

    @FXML
    public void playerAttackButton()
    {
        playerAttack(140, myController.getEnemyFighter());
        updateEnemyHealth();
    }

    private void playerAttack(int damage, Fighter fighter)
    {
        if (fighter.getHealth() - damage < 0)
        {
            fighter.setHealth(0);
            updateEnemyHealth();
            System.out.println("You Win");
            //playerWin
        }
        else if (fighter.getHealth() - damage == 0)
        {
            fighter.setHealth(0);
            updateEnemyHealth();
            System.out.println("You Win");
            //playerWin
        }
        else
        {
            fighter.setHealth(fighter.getHealth() - damage);
        }
    }

    public void setupMusic()
    {
        System.out.println("Music");
        Media medMsg = new Media(ScreensFramework.class.getClassLoader().getResource("george/sfg/userinterface/resources/music/Those Who Fight Further.mp3").toString());
        player = new MediaPlayer(medMsg);
        player.play();
        System.out.println("Leaving Msg thread.\n");
    }

    Task secondInitTask = new Task<Void>() {
        @Override public Void call()
        {
            System.out.println("In Thread 2");
            skilldescs.add(skill1Info);
            skilldescs.add(skill2Info);
            skilldescs.add(skill3Info);
            skilldescs.add(skill4Info);
            skill_description.setWrapText(true);
            for (int i = 0; i < myController.getPlayerFighter().getSkills().size(); i++)
            {
                skilldescs.get(i).setText(myController.getPlayerFighter().getSkills().get(i).getName());
            }
            return null;
        }
    };

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
            System.out.println("HERE!!!");
            setupMusic();
            Thread thr2 = new Thread(secondInitTask);
            thr2.setName("Init Second Battle");
            thr2.start();

            return null;
        }
    };

}
