package george.sfg.userinterface;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * Created by Cloud on 02/12/2014.
 */
public class ScreensFramework extends Application {

    public static final String screen1ID = "main";
    public static final String screen1File = "CharacterSelect.fxml";
    public static final String screen2ID = "screen2";
    public static final String screen2File = "WeaponSelect.fxml";
    public static final String screen3ID = "screen3";
    public static final String screen3File = "DisplayAndConfirm.fxml";
    public static final String screen4ID = "screen4";
    public static final String screen4File = "BattleDisplay.fxml";


    @Override
    public void start(Stage primaryStage) {

        ScreensController mainContainer = new ScreensController();

        mainContainer.loadScreen(ScreensFramework.screen1ID, ScreensFramework.screen1File);
        mainContainer.loadScreen(ScreensFramework.screen2ID, ScreensFramework.screen2File);

        mainContainer.setScreen(ScreensFramework.screen1ID);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
        System.out.println("End Main");
    }


}
