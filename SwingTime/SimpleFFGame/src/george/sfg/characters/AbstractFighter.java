package george.sfg.characters;

import george.sfg.userinterface.resources.ResDir;
import george.sfg.weapons.Weapon;
import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Cloud on 23/11/2014.
 */
public abstract class AbstractFighter implements Fighter, Cloneable{

    private String name;
    private double attack;
    private int health;
    private int speed;
    private Image image;
    private Weapon weapon;
    private String type;

    public AbstractFighter(String name, int health, int speed, String resource)
    {
        System.out.println(resource);
        String full = ResDir.resString + File.separator + "characters" + File.separator + resource;
        try {
            FileInputStream stream = new FileInputStream(full);
            this.image = new Image(stream);
        }
        catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.weapon = null;
    }

    public AbstractFighter(Fighter copyFighter)
    {
        this.name = copyFighter.getName();
        this.attack = copyFighter.getAttack();
        this.health = copyFighter.getHealth();
        this.speed = copyFighter.getSpeed();
        this.type = copyFighter.getType();
    }

    public AbstractFighter(Fighter copyFighter, String newName)
    {
        this.name = newName;
        this.attack = copyFighter.getAttack();
        this.health = copyFighter.getHealth();
        this.speed = copyFighter.getSpeed();
        this.type = copyFighter.getType();
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

    public Fighter copy()
    {
        try {
            return (Fighter) clone();
        }
        catch (CloneNotSupportedException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public String getName()
    {
        try
        {
            return this.name;
        }
        catch (NullPointerException ex)
        {
            ex.printStackTrace();
        }
        return "";
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public int getHealth()
    {
        return this.health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public void setAttack(double attack)
    {
        this.attack = attack;
    }

    public double getAttack()
    {
        return attack;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public Weapon getWeapon()
    {
        return weapon;
    }

    public void equipWeapon(Weapon newWeapon)
    {
        this.weapon = newWeapon;
    }

    public boolean hasWeaponEquipped()
    {
        if (this.weapon == null)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    public String toString()
    {
        return ("Name:" + name + "\nHealth:" + health + "\nSpeed:" + speed);
    }

    protected String weaponToString()
    {
        if (this.weapon == null)
        {
            return "No Weapon Equipped";
        }
        else
        {
            return "" + weapon.getName();
        }
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Image getImage()
    {
        return image;
    }

}
