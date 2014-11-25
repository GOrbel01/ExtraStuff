package george.sfg.characters;

/**
 * Created by Cloud on 25/11/2014.
 */
public class Battler {
    private final Fighter fighter;
    private final boolean isPlayer;

    public Battler(Fighter newFighter, boolean playerCheck)
    {
        fighter = newFighter;
        isPlayer = playerCheck;
    }

    public Fighter getFighter()
    {
        return fighter;
    }
}
