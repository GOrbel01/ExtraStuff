package george.sfg.userinterface;

import george.sfg.userinterface.framework.ControlledScreen;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Created by Cloud on 05/12/2014.
 */
public class GameOverController implements ControlledScreen {

    ScreensController myController;

    @FXML
    private AnchorPane anchor = new AnchorPane();

    @Override
    public void setScreensParent(ScreensController screenParent) {
        myController = screenParent;
    }

    public void onAnchorPaneClicked()
    {
        Platform.exit();
    }

    public void initialize()
    {
        System.out.println("george.sfg.userinterface.framework.GameOver.initialize");
        Thread thr = new Thread(initTask);
        thr.setName("Game Over Thread");
        thr.start();
    }

    public void setupMusic()
    {
        System.out.println("Setting Up Music.");
        Media medMsg = new Media(ScreensFramework.class.getClassLoader().getResource("george/sfg/userinterface/resources/music/Continue.mp3").toString());
        MediaPlayer player = new MediaPlayer(medMsg);
        player.play();
        System.out.println("Leaving Msg thread.\n");
    }

    Task initTask = new Task<Void>() {
        @Override public Void call() {
            setupMusic();
            return null;
        }
    };

}
