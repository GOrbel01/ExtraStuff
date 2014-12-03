package george.sfg.userinterface;

import george.sfg.userinterface.framework.ControlledScreen;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import javafx.util.Duration;
import java.util.HashMap;

/**
 * Credits to acaicedo for this implementation.
 */
public class ScreensController extends StackPane {

    private String selectedCharacter;
    private String selectedWeapon;

    private HashMap<String, Node> screens = new HashMap<>();

    public ScreensController()
    {
        super();
    }


    public void addScreen(String name, Node screen)
    {
        screens.put(name, screen);
    }

    public Node getScreen(String name)
    {
        return screens.get(name);
    }

    public boolean loadScreen(String name, String resource)
    {
        try {
            System.out.println("Loading " + getClass().getResource(resource));
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            Parent loadScreen = (Parent) myLoader.load();
            ControlledScreen myScreenController = (ControlledScreen) myLoader.getController();
            myScreenController.setScreensParent(this);
            addScreen(name, loadScreen);
            return true;
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean setScreen(final String name)
    {
        if (screens.get(name) != null)
        {
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty())
            {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(500), new EventHandler<ActionEvent>()
                        {
                            @Override
                            public void handle(ActionEvent t)
                            {
                                getChildren().remove(0);
                                getChildren().add(0, screens.get(name));
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(500), new KeyValue(opacity, 1.0)));
                                fadeIn.play();

                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();
            }
            else
            {
                setOpacity(0.0);
                getChildren().add(screens.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        }
        else
        {
            System.out.println("Screen hasnt been loaded!!! \n");
            return false;
        }
    }

    public boolean setScreen(final String name, boolean doExtra)
    {
        if (screens.get(name) != null)
        {
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty())
            {
                Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        new KeyFrame(new Duration(500), new EventHandler<ActionEvent>()
                        {
                            @Override
                            public void handle(ActionEvent t)
                            {
                                getChildren().remove(0);
                                getChildren().add(0, screens.get(name));
                                Timeline fadeIn = new Timeline(
                                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                        new KeyFrame(new Duration(500), new KeyValue(opacity, 1.0)));
                                fadeIn.play();

                            }
                        }, new KeyValue(opacity, 0.0)));
                fade.play();
            }
            else
            {
                setOpacity(0.0);
                getChildren().add(screens.get(name));
                Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
            return true;
        }
        else
        {
            System.out.println("Screen hasnt been loaded!!! \n");
            return false;
        }
    }

    public boolean unloadScreen(String name)
    {
        if (screens.remove(name) == null)
        {
            System.out.println("Screen was not found");
            return false;
        }
        else
        {
            return true;
        }
    }

    public String getSelectedCharacter()
    {
        return selectedCharacter;
    }

    public String getSelectedWeapon()
    {
        return selectedWeapon;
    }

    public void setSelectedCharacter(String charSel)
    {
        selectedCharacter = charSel;
    }

    public void setSelectedWeapon(String wepSel)
    {
        selectedWeapon = wepSel;
    }

}
