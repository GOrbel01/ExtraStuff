package george.sfg.skills;

import george.sfg.userinterface.ScreensFramework;
import george.sfg.userinterface.resources.ResDir;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Squall on 03/12/2014.
 */
public class SkillImpl implements Skill {

    private String name;
    private int cost;
    private int power;
    private Image image;
    private String imagePath;

    public SkillImpl(String name, int power, int cost, String resource)
    {
        this.name = name;
        this.cost = cost;
        this.power = power;
        imagePath = "george/sfg/userinterface/resources/skills/" + resource;
        this.image = new Image(ScreensFramework.class.getClassLoader().getResourceAsStream("george/sfg/userinterface/resources/skills/" + resource));
    }

    public String getImagePath()
    {
        return imagePath;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getCost()
    {
        return cost;
    }

    public void setCost(int newCost)
    {
        cost = newCost;
    }

    public int getPower()
    {
        return power;
    }

    public void setPower(int newPower)
    {
        power = newPower;
    }

    public Image getImage()
    {
        return image;
    }

}
