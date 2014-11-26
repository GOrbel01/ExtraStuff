package george.sfg.setup;

import george.sfg.characters.storedCharacters.CharacterList;
import george.sfg.setup.combatant.CombatantList;

/**
 * Created by Cloud on 23/11/2014.
 */
public class InitiateBattle {

    public static void main(String[] args)
    {
        InitiateBattle newBattle = new InitiateBattle();
        newBattle.launch();
    }

    public void launch()
    {
        CharacterSetup chs = new CharacterSetup();
        CombatantList cList = new CombatantList();
        chs.setupCharacters();
//        cList.getCombatantByTag("Player2");
            System.out.println(cList.getCombatantByTag("Player1").getFighter());
//
    }
}
