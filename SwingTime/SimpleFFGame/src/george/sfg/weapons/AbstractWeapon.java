package george.sfg.weapons;

/**
 * Created by Cloud on 23/11/2014.
 */
public abstract class AbstractWeapon implements Weapon, Cloneable {
    private final String name;
    private double bonusAttack;

    public AbstractWeapon(String name, double attack)
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
        try {
            return (Weapon) clone();
        }
        catch (CloneNotSupportedException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}

