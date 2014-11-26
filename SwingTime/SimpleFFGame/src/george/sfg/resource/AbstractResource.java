package george.sfg.resource;

/**
 * Created by Cloud on 25/11/2014.
 */
public abstract class AbstractResource implements Resource {

    private int currentValue;

    public AbstractResource()
    {

    }

    public int getCurrentValue()
    {
        return currentValue;
    }

    public void setCurrentValue(int newValue)
    {
        this.currentValue = newValue;
    }

    public void spendResource(int placeholder)
    {

    }

}
