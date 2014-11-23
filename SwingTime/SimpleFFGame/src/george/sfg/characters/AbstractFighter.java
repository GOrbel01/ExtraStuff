package george.sfg.characters;

import george.sfg.weapons.Weapon;

/**
 * Created by Cloud on 23/11/2014.
 */
public abstract class AbstractFighter implements Fighter {

    private String name;
    private double attack;
    private int health;
    private int speed;
    private Weapon weapon;

    public AbstractFighter(String name, int health, int speed)
    {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.weapon = null;
    }

    public String getName()
    {
        return this.name;
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
            return " No Weapon Equipped";
        }
        else
        {
            return " " + weapon.getName();
        }
    }

}
