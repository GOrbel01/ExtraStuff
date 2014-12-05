package george.sfg.characters;

import george.sfg.resource.Rage;
import george.sfg.resource.RageImpl;
import george.sfg.weapons.Weapon;

/**
 * Created by Cloud on 23/11/2014.
 */
public abstract class StrengthFighterImpl extends AbstractFighter implements StrengthFighter {

    private int strength;
    private Rage rage;

    public StrengthFighterImpl(String name, int health, int speed, int strength, String res)
    {
        super(name, health, speed, res);
        this.strength = strength;
        this.rage = new RageImpl();
        setType("StrengthUser");
        this.setupAttack();
    }

    public StrengthFighterImpl(Fighter copyFighter)
    {
        super(copyFighter);
        StrengthFighterImpl copyStrength = (StrengthFighterImpl) copyFighter;
        this.strength = copyStrength.getPrimaryStat();
        this.rage = copyStrength.getResource();
    }

    public StrengthFighterImpl(Fighter copyFighter, String newName)
    {
        super(copyFighter, newName);
        StrengthFighterImpl copyStrength = (StrengthFighterImpl) copyFighter;
        this.strength = copyStrength.getPrimaryStat();
        this.rage = copyStrength.getResource();
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

    public void regenRage()
    {
        rage.regenerate();
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

    public int getPrimaryStat()
    {
        return strength;
    }

    public void setPrimaryStat(int strength)
    {
        this.strength = strength;
    }

    public Rage getResource()
    {
        return rage;
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
        super.setAttack(30.00 + strength-20);
    }

    public String toString()
    {
        return (super.toString() + "\nStrength:" + strength + "\nEnergy:" + rage.getMaxValue() + "\n" + weaponToString());
    }
}
