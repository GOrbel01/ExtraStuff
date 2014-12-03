package george.sfg.weapons;

import javafx.scene.image.Image;

/**
 * Created by Cloud on 23/11/2014.
 */
public interface Weapon {

    String getName();

    int getPrimaryStatBonus();

    double getBonusAttack();

    Object copy();

    Image getWepImage();

    String getType();

}
