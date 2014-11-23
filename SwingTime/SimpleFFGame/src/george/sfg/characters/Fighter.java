package george.sfg.characters;

import george.sfg.weapons.Weapon;

/**
 * Created by Cloud on 23/11/2014.
 */
public interface Fighter {

    String getName();

    int getHealth();

    void setHealth(int health);

    int getSpeed();

    void setSpeed(int speed);

    double getAttack();

    void setAttack(double attack);

    Weapon getWeapon();

    void equipWeapon(Weapon weapon);

    int getPrimaryStat();

    void setPrimaryStat(int amount);

    int getResource();

    void setResource(int amount);

    boolean hasWeaponEquipped();

}
