package george.sfg.characters;

import george.sfg.resource.*;
import george.sfg.weapons.Weapon;

/**
 * Created by Squall on 09/12/2014.
 */
public abstract class AgilityFighterImpl extends AbstractFighter implements AgilityFighter {

    private int agility;
    private Resource energy;

    public AgilityFighterImpl(String name, int health, int speed, int agility, String res)
    {
        super(name, health, speed, res);
        this.agility = agility;
        this.energy = new EnergyImpl();
        setType("AgilityUser");
        this.setupAttack();
    }

    public AgilityFighterImpl(Fighter copyFighter)
    {
        super(copyFighter);
        AgilityFighterImpl copyAgility = (AgilityFighterImpl) copyFighter;
        this.agility = copyAgility.getPrimaryStat();
        this.energy = copyAgility.getResource();
    }

    public AgilityFighterImpl(Fighter copyFighter, String newName)
    {
        super(copyFighter, newName);
        AgilityFighterImpl copyAgility = (AgilityFighterImpl) copyFighter;
        this.agility = copyAgility.getPrimaryStat();
        this.energy = copyAgility.getResource();
    }

    public void regenEnergy()
    {

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

    public boolean isMatchingWeapon()
    {
        return this.getWeapon().getType().contains("Agility");
    }

    public int getPrimaryStat()
    {
        return agility;
    }

    public void setPrimaryStat(int newAgi)
    {
        this.agility = newAgi;
    }

    public Resource getResource()
    {
        return energy;
    }

    public void equipWeapon(Weapon weapon)
    {
        if (this.hasWeaponEquipped())
        {
            unEquipWeapon();
        }
        super.equipWeapon(weapon);
        setPrimaryStat(getPrimaryStat() + weapon.getPrimaryStatBonus());
        setupAttack();
        setAttack(getAttack() + weapon.getBonusAttack());
    }

    private void unEquipWeapon()
    {
        setPrimaryStat(getPrimaryStat() - getWeapon().getPrimaryStatBonus());
        setAttack(getAttack() - getWeapon().getBonusAttack());
    }

    private void setupAttack()
    {
        super.setAttack(30.00 + agility-20);
    }

    public String toString()
    {
        return (super.toString() + "\nStrength:" + agility + "\nEnergy:" + energy.getMaxValue() + "\n" + weaponToString());
    }

}
