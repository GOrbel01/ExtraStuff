package george.sfg.setup;

import george.sfg.characters.Fighter;
import george.sfg.characters.MagicFighterImpl;
import george.sfg.characters.StrengthFighterImpl;
import george.sfg.characters.storedCharacters.FighterList;
import george.sfg.setup.combatant.Combatant;
import george.sfg.setup.combatant.CombatantList;

/**
 * Created by Cloud on 25/11/2014.
 */
public class CharacterSetup {

    private FighterList fList = new FighterList();
    private CombatantList cList = new CombatantList();

    public void setFightersNoRename(Fighter temp, String type)
    {
        if (type.equals("StrengthUser"))
        {
            Fighter playerFighter = new StrengthFighterImpl(temp);
            Combatant player = new Combatant(playerFighter, true);
            cList.getCombatantsList().add(player);
        }
        else if (type.equals("MagicUser"))
        {
            Fighter playerFighter = new MagicFighterImpl(temp);
            Combatant player = new Combatant(playerFighter, true);
            cList.getCombatantsList().add(player);
        }
    }

    public FighterList getFighterList()
    {
        return fList;
    }

    public CombatantList getCombatantList()
    {
        return cList;
    }

}
