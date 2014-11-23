package george.sfg.characters;

import george.sfg.weapons.Weapon;

/**
 * Created by Cloud on 23/11/2014.
 */
public class StrengthFighterImpl extends AbstractFighter implements Fighter {

    private int strength;
    private int energy;

    public StrengthFighterImpl(String name, int health, int speed, int strength, int energy)
    {
        super(name, health, speed);
        this.strength = strength;
        this.energy = energy;
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

    public int getResource()
    {
        return energy;
    }

    public void setResource(int energy)
    {
        this.energy = energy;
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
