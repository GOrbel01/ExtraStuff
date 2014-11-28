package george.sfg.characters;

import george.sfg.resource.Mana;
import george.sfg.resource.ManaImpl;
import george.sfg.resource.Resource;
import george.sfg.weapons.Weapon;

/**
 * Created by Cloud on 23/11/2014.
 */
public class MagicFighterImpl extends AbstractFighter implements MagicFighter {

    private int magic;
    private Mana mana;

    public MagicFighterImpl(String name, int health, int speed, int magic, int mana)
    {
        super(name, health, speed);
        this.magic = magic;
        this.mana = new ManaImpl();
        setType("MagicUser");
        setupAttack();
    }

    public MagicFighterImpl(Fighter copyFighter)
    {
        super(copyFighter);
        MagicFighterImpl copyMagic = (MagicFighterImpl) copyFighter;
        this.magic = copyMagic.getPrimaryStat();
        this.mana = copyMagic.getResource();
    }

    public MagicFighterImpl(Fighter copyFighter, String newName)
    {
        super(copyFighter, newName);
        MagicFighterImpl copyMagic = (MagicFighterImpl) copyFighter;
        this.magic = copyMagic.getPrimaryStat();
        this.mana = copyMagic.getResource();
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

    public int getPrimaryStat()
    {
        return magic;
    }

    public void setPrimaryStat(int stat)
    {
        this.magic = stat;
    }

    public Mana getResource()
    {
        return mana;
    }

    public void equipWeapon(Weapon weapon)
    {
        if (this.hasWeaponEquipped())
        {
            unEquipWeapon();
        }
        super.equipWeapon(weapon);
        setPrimaryStat(getPrimaryStat() + weapon.getPrimaryStatBonus());
        setAttack(getAttack() + weapon.getBonusAttack());
    }

    private void unEquipWeapon()
    {
        setPrimaryStat(getPrimaryStat() - getWeapon().getPrimaryStatBonus());
        setAttack(getAttack() - getWeapon().getBonusAttack());
    }

    private void setupAttack()
    {
        setAttack(20.00 + magic-20);
    }

    public String toString()
    {
        return (super.toString() + "\nMagic:" + magic + "\nMana:" + mana + weaponToString());
    }

}
