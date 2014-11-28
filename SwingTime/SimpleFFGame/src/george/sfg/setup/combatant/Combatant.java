package george.sfg.setup.combatant;

import george.sfg.characters.Fighter;
import george.sfg.characters.MagicFighter;
import george.sfg.characters.StrengthFighter;
import george.sfg.characters.StrengthFighterImpl;

/**
 * Created by Cloud on 25/11/2014.
 */
public class Combatant {
    private final Fighter fighter;
    private String tag;
    private final boolean isPlayer;
    private static int playerCount = 0;
    private static int enemyCount = 0;

//    public Combatant(MagicFighter newFighter, boolean playerCheck)
//    {
//        fighter = newFighter;
//        setupTag(playerCheck);
//        isPlayer = playerCheck;
//    }

    public Combatant(Fighter newFighter, boolean playerCheck)
    {
        fighter = newFighter;
        setupTag(playerCheck);
        isPlayer = playerCheck;
    }

    public Combatant(Fighter newFighter, String newName, boolean playerCheck)
    {
        fighter = newFighter;
        fighter.setName(newName);
        setupTag(playerCheck);
        isPlayer = playerCheck;
    }

//    public Combatant(StrengthFighter newFighter, boolean playerCheck)
//    {
//        fighter = newFighter;
//        setupTag(playerCheck);
//        isPlayer = playerCheck;
//    }

    public void setupTag(boolean pCheck)
    {
        if (pCheck)
        {
            playerCount++;
            tag = "Player"+playerCount;
        }
        else
        {
            enemyCount++;
            tag = "Enemy"+enemyCount;
        }
    }

    public Fighter getFighter()
    {
        return fighter;
    }


    public String getTag()
    {
        return tag;
    }
}
