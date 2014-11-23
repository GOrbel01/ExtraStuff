package george.sfg.weapons;

/**
 * Created by Cloud on 23/11/2014.
 */
public class StrengthWeaponImpl extends WeaponImpl implements Weapon {

    private int bonusStrength;

    public StrengthWeaponImpl(String name, double bonusAttack, int bonusStrength)
    {
        super(name, bonusAttack);
        this.bonusStrength = bonusStrength;
    }

    public int getPrimaryStatBonus()
    {
        return bonusStrength;
    }
}
