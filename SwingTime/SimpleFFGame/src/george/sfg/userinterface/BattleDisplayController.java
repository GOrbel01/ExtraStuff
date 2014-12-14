package george.sfg.userinterface;

import george.sfg.characters.Fighter;
import george.sfg.userinterface.framework.ControlledScreen;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Squall on 04/12/2014.
 */
public class BattleDisplayController implements ControlledScreen {

    private ScreensController myController;

    @FXML
    private MenuButton skillMenu = new MenuButton();

    @FXML
    private Label turnLabel = new Label();

    @FXML
    private TextArea skill_description = new TextArea();

    @FXML
    private MenuItem skill1Info = new MenuItem();

    @FXML
    private MenuItem skill2Info = new MenuItem();

    @FXML
    private MenuItem skill3Info = new MenuItem();

    @FXML
    private MenuItem skill4Info = new MenuItem();

    @FXML
    private TextField current_health = new TextField();

    @FXML
    private TextField player_name = new TextField();

    @FXML
    private TextField enemy_name = new TextField();

    @FXML
    private TextField enemy_health = new TextField();

    private MediaPlayer player;

    @FXML
    private Group player_controls = new Group();

    @FXML
    private Button skill1 = new Button();

    @FXML
    private Button skill2 = new Button();

    @FXML
    private Button skill3 = new Button();

    @FXML
    private Button skill4 = new Button();

    @FXML
    private Button player_attack = new Button();

    @FXML
    private TitledPane skillPane = new TitledPane();

    @FXML
    private AnchorPane skillAnchor = new AnchorPane();

    @FXML
    private Button dmg_test_button = new Button();

    @FXML
    private ImageView player_image = new ImageView();

    @FXML
    private ImageView enemy_image = new ImageView();

    private boolean isPlayerTurn;

    private List<Button> buttons = new ArrayList<>();
    private List<MenuItem> skilldescs = new ArrayList<>();

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
        postPlayerAttackEvent();
    }

    @FXML
    public void onPressedSkillButton2(ActionEvent event)
    {
        System.out.println("SKIll2");
        postPlayerAttackEvent();
    }

    @FXML
    public void onPressedSkillButton3(ActionEvent event)
    {
        System.out.println("SKIll3");
        postPlayerAttackEvent();
    }

    @FXML
    public void onPressedSkillButton4(ActionEvent event)
    {
        System.out.println("SKIll4");
        postPlayerAttackEvent();
    }

    @FXML
    public void onPressedDmgTestButton(ActionEvent event)
    {
        System.out.println("DMG BUTTON");
        System.out.println(myController.getEnemyFighter().getHealth());
        attack(150, myController.getPlayerFighter());
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


    private void deathEvent()
    {
        System.out.println("You Died Noob!");
        player.stop();
        myController.loadScreen(ScreensFramework.screen5ID, ScreensFramework.screen5File);
        myController.setScreen("screen5");
    }

    private void updateHealth(Fighter fighter)
    {
        if (fighter.getIdentifier().equals("AI"))
        {
            if (fighter.getHealth() <= 0)
            {
                fighter.setHealth(0);
                enemy_health.setText("0");
                System.out.println("Player Win");
            }
            else
            {
                enemy_health.setText("" + myController.getEnemyFighter().getHealth());
            }
        }
        else if (fighter.getIdentifier().equals("Player"))
        {
            if (fighter.getHealth() <= 0)
            {
                fighter.setHealth(0);
                current_health.setText("0");
                deathEvent();
            }
            else
            {
                current_health.setText("" + myController.getPlayerFighter().getHealth());
            }
        }
    }

    @FXML
    public void playerAttackButton()
    {
        attack(100, myController.getEnemyFighter());
        postPlayerAttackEvent();
    }

    private void attack(int damage, Fighter fighter)
    {
        fighter.setHealth(fighter.getHealth() - damage);
        updateHealth(fighter);
    }

    private void enemyAttack()
    {
        System.out.println("Enemy Attacking");
        attack(100, myController.getPlayerFighter());
        enemyPostAttackEvent();
    }

    private void enemyPostAttackEvent()
    {
        isPlayerTurn = true;
        setTextLabel(isPlayerTurn);
        player_controls.setDisable(false);
    }

    //Currently Only Disables Player Controls Until Enemies Go.
    private void postPlayerAttackEvent()
    {
        player_controls.setDisable(true);
        isPlayerTurn = false;
        setTextLabel(isPlayerTurn);
        enemyAttack();
    }

    private void setupMusic()
    {
        System.out.println("Music");
        Media medMsg = new Media(ScreensFramework.class.getClassLoader().getResource("george/sfg/userinterface/resources/music/Those Who Fight Further.mp3").toString());
        player = new MediaPlayer(medMsg);
        player.play();
        System.out.println("Leaving Msg thread.\n");
    }

    public void setTextLabel(boolean turn)
    {
        if (turn)
        {
            turnLabel.setText("Player Turn");
        }
        else
        {
            turnLabel.setText("Enemy Label");
        }
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
            isPlayerTurn = true;
            setTextLabel(isPlayerTurn);
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
            Thread.currentThread().interrupt();
            Thread thr2 = new Thread(secondInitTask);
            thr2.setName("Init Second Battle");
            thr2.start();
            return null;
        }
    };

}
