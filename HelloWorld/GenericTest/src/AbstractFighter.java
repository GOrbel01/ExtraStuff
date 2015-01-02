/**
 * Created by Cloud on 01/12/2014.
 */
public class AbstractFighter<E> implements Fighter {

    String name;
    int attack;

    public String getName()
    {
        return name;
    }

    public int getAttack()
    {
        return attack;
    }
}
