package george.sfg.characters;

import george.sfg.characters.Fighter;
import george.sfg.resource.Mana;
import george.sfg.resource.Resource;

/**
 * Created by Squall on 26/11/2014.
 */
public interface MagicFighter extends Fighter {

    Mana getResource();
}
