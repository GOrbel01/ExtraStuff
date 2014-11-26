package george.sfg.resource;

/**
 * Created by Cloud on 25/11/2014.
 */
public class RageImpl extends AbstractResource implements Rage {

    private static final String name = "Rage";
    private static int maxValue = 100;

    public RageImpl()
    {

    }

    public String getResourceName()
    {
        return name;
    }

    public int getMaxValue()
    {
        return maxValue;
    }

    public void regenerate()
    {
        setCurrentValue(getCurrentValue() + 5);
    }

}
