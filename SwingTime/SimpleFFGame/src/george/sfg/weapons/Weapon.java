package george.sfg.weapons;

/**
 * Created by Cloud on 23/11/2014.
 */
public interface Weapon {

    String getName();

    int getPrimaryStatBonus();

    void testSetName(String newName);

    double getBonusAttack();

    Object copy();

}
