package george.sfg.resource;

/**
 * Created by Squall on 09/12/2014.
 */
public class EnergyImpl extends AbstractResource implements Energy {

    private static final String name = "Energy";
    private int maxValue = 100;

    public EnergyImpl()
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

}
