package george.sfg.stat;

/**
 * Created by Cloud on 25/11/2014.
 */
public class ManaImpl extends AbstractResource implements Mana {

    private static final String name = "Mana";

    private int maxValue;

    public ManaImpl()
    {
        this.maxValue = 100;
    }

    public int getMaxValue()
    {
        return maxValue;
    }

    public void setMaxValue(int newValue)
    {
        maxValue = newValue;
    }

    public String getResourceName()
    {
        return name;
    }

}
