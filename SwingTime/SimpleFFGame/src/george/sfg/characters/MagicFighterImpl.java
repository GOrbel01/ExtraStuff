package george.sfg.characters;

import george.sfg.stat.ManaImpl;
import george.sfg.stat.Resource;
import george.sfg.weapons.Weapon;

/**
 * Created by Cloud on 23/11/2014.
 */
public class MagicFighterImpl extends AbstractFighter implements Fighter {

    private int magic;
    private Resource mana;

    public MagicFighterImpl(String name, int health, int speed, int magic, int mana)
    {
        super(name, health, speed);
        this.magic = magic;
        this.mana = new ManaImpl();
        setupAttack();
    }

    public int getPrimaryStat()
    {
        return magic;
    }

    public void setPrimaryStat(int stat)
    {
        this.magic = stat;
    }

    public Resource getResource()
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