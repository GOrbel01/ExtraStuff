package george.sfg.characters;

import george.sfg.resource.Rage;
import george.sfg.resource.Resource;
import george.sfg.weapons.Weapon;

/**
 * Created by Cloud on 23/11/2014.
 */
public interface Fighter {

    String getName();

    void setName(String str);

    Fighter copy();

    int getHealth();

    void setHealth(int health);

    int getSpeed();

    void setSpeed(int speed);

    double getAttack();

    void setAttack(double attack);

    Weapon getWeapon();

    void equipWeapon(Weapon weapon);

    int getPrimaryStat();

    Resource getResource();

    void setPrimaryStat(int amount);

    boolean hasWeaponEquipped();

    String getType();

}
