package george.sfg.weapons;

/**
 * Created by Cloud on 23/11/2014.
 */
public abstract class WeaponImpl implements Weapon {
    private String name;
    private double bonusAttack;

    public WeaponImpl(String name, double attack)
    {
        this.name = name;
        this.bonusAttack = attack;
    }

    public String getName()
    {
        return name;
    }

    public double getBonusAttack()
    {
        return bonusAttack;
    }

}
