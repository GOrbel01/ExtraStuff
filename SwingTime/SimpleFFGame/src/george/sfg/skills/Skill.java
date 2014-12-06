package george.sfg.skills;

import javafx.scene.image.Image;

/**
 * Created by Squall on 03/12/2014.
 */
public interface Skill {

    String getName();

    void setName(String newName);

    int getPower();

    void setPower(int newPower);

    int getCost();

    String getDescription();

    void setCost(int cost);

    Image getImage();

    String getImagePath();
}
