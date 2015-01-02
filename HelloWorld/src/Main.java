import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Cloud on 02/12/2014.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = MainClass.class.getResource("Thing.fxml");
//        System.out.println(url);
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("AirportApp");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
