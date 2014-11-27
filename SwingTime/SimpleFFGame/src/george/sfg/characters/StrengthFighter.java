package george.sfg.characters;

import george.sfg.resource.Rage;

/**
 * Created by Squall on 26/11/2014.
 */
public interface StrengthFighter extends Fighter {

    Rage getResource();

    void regenRage();

}
