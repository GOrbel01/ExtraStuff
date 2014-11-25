package george.sfg.weapons;

/**
 * Created by Cloud on 23/11/2014.
 */
public abstract class AbstractWeapon implements Weapon, Cloneable {
    private String name;
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

    public void testSetName(String newName)
    {
        this.name = newName;
    }

    public double getBonusAttack()
    {
        return bonusAttack;
    }

    public void testSame()
    {
        
    }

    //TestSame
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

