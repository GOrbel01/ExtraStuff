package george.sfg.weapons;

/**
 * Created by Cloud on 23/11/2014.
 */
public interface Weapon {

    String getName();

    int getPrimaryStatBonus();

    double getBonusAttack();

    Object copy();

}
