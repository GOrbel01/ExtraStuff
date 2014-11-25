package george.sfg.setup;

import george.sfg.characters.Battler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cloud on 25/11/2014.
 */
public class CharacterSetup {
    private static List<Battler> combatants = new ArrayList<Battler>();

    public CharacterSetup()
    {

    }

    public List<Battler> getCombatants()
    {
        return combatants;
    }

}
