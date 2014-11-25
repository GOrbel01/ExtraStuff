package george.sfg.characters;

import george.sfg.stat.RageImpl;
import george.sfg.stat.Resource;
import george.sfg.weapons.Weapon;

/**
 * Created by Cloud on 23/11/2014.
 */
public class StrengthFighterImpl extends AbstractFighter implements Fighter {

    private int strength;
    private Resource energy;

    public StrengthFighterImpl(String name, int health, int speed, int strength)
    {
        super(name, health, speed);
        this.strength = strength;
        this.energy = new RageImpl();
        this.setupAttack();
    }

    public int getPrimaryStat()
    {
        return strength;
    }

    public void setPrimaryStat(int strength)
    {
        this.strength = strength;
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
        super.setAttack(30.00 + strength-20);
    }

    public String toString()
    {
        return (super.toString() + "\nStrength:" + strength + "\nEnergy:" + energy + weaponToString());
    }
}
