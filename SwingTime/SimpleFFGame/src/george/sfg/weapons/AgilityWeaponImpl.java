package george.sfg.weapons;

/**
 * Created by Squall on 10/12/2014.
 */
public class AgilityWeaponImpl extends AbstractWeapon {

    private int bonusAgility;

    public AgilityWeaponImpl(String name, double bonusAttack, int bonusAgility)
    {
        super(name, bonusAttack);
        setType("AgilityWeapon");
        this.bonusAgility = bonusAgility;
    }

    public AgilityWeaponImpl(String name, double bonusAttack, int bonusAgility, String imageName)
    {
        super(name, bonusAttack, imageName);
        setType("AgilityWeapon");
        this.bonusAgility = bonusAgility;
    }

    public int getPrimaryStatBonus()
    {
        return bonusAgility;
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

    public Weapon copy()
    {
        try
        {
            return (Weapon) clone();
        }
        catch (CloneNotSupportedException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }


    public String toString()
    {
        return super.toString() + "\n" + "Bonus Agility: " + bonusAgility;
    }

}
