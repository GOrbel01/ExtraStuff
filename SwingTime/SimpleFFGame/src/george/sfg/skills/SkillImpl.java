package george.sfg.skills;

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

    public SkillImpl(String name, int power, int cost, String resource)
    {
        this.name = name;
        this.cost = cost;
        this.power = power;
        String full = ResDir.resString + File.separator + "skills" + File.separator + resource;
        try
        {
            FileInputStream stream = new FileInputStream(full);
            this.image = new Image(stream);
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
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
