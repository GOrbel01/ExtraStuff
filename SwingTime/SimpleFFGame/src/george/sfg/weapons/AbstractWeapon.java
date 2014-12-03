package george.sfg.weapons;

import george.sfg.userinterface.resources.ResDir;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Cloud on 23/11/2014.
 */
public abstract class AbstractWeapon implements Weapon, Cloneable {
    private final String name;
    private double bonusAttack;
    private Image image;
    private String type;

    public AbstractWeapon(String name, double attack)
    {
        this.name = name;
        this.bonusAttack = attack;
    }

    public AbstractWeapon(String name, double attack, String imagePath)
    {
        String full = ResDir.resString + File.separator + "weapons" + File.separator + imagePath;
        try
        {
            FileInputStream stream = new FileInputStream(full);
            this.image = new Image(stream);
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        this.name = name;
        this.bonusAttack = attack;
    }

    public String getName()
    {
        return name;
    }

    public double getBonusAttack()
    {
        return bonusAttack;
    }

    protected Object clone() throws CloneNotSupportedException
    {
            try
            {
                return super.clone();
            }
            catch(CloneNotSupportedException ex)
            {
                ex.printStackTrace();
                return null;
            }
    }

    public Weapon copy()
    {
        try {
            return (Weapon) clone();
        }
        catch (CloneNotSupportedException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public Image getWepImage()
    {
        return image;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String toString()
    {
        return "Name: " + name + "\n" + "Bonus Attack: " + bonusAttack;
    }
}

