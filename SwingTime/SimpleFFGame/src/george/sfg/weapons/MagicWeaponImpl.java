package george.sfg.weapons;

/**
 * Created by Cloud on 23/11/2014.
 */
public class MagicWeaponImpl extends WeaponImpl implements Weapon {

    private int bonusMagic;

    public MagicWeaponImpl(String name, double bonusAttack, int bonusMagic)
    {
        super(name, bonusAttack);
        this.bonusMagic = bonusMagic;
    }

    public int getPrimaryStatBonus()
    {
        return bonusMagic;
    }
}
