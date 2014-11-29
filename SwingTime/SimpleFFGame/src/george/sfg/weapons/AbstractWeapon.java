package george.sfg.weapons;

/**
 * Created by Cloud on 23/11/2014.
 */
public abstract class AbstractWeapon implements Weapon, Cloneable {
    private final String name;
    private double bonusAttack;
    private WeaponImage wepImage;
    private String type;

    public AbstractWeapon(String name, double attack)
    {
        this.name = name;
        this.bonusAttack = attack;
    }

    public AbstractWeapon(String name, double attack, String imagePath)
    {
        this.name = name;
        this.bonusAttack = attack;
        this.wepImage = new WeaponImage(imagePath);
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

    public WeaponImage getWepImage()
    {
        return wepImage;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}

