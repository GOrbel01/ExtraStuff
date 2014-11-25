package george.sfg.stat;

/**
 * Created by Cloud on 25/11/2014.
 */
public interface Resource {

    String getResourceName();

    int getMaxValue();

    int getCurrentValue();

    void setCurrentValue(int newValue);

    void spendResource(int placeholder);
}
