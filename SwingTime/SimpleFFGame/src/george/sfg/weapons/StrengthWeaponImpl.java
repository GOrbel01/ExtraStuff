package george.sfg.weapons;

/**
 * Created by Cloud on 23/11/2014.
 */
public class StrengthWeaponImpl extends AbstractWeapon implements Weapon {

    private int bonusStrength;

    public StrengthWeaponImpl(String name, double bonusAttack, int bonusStrength)
    {
        super(name, bonusAttack);
        setType("StrengthWeapon");
        this.bonusStrength = bonusStrength;
    }

    public StrengthWeaponImpl(String name, double bonusAttack, int bonusStrength, String fileName)
    {
        super(name, bonusAttack, fileName);
        setType("StrengthWeapon");
        this.bonusStrength = bonusStrength;
    }

    public int getPrimaryStatBonus()
    {
        return bonusStrength;
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

}
