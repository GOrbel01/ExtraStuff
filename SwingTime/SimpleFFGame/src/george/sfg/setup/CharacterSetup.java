package george.sfg.setup;

import george.sfg.characters.MagicFighter;
import george.sfg.characters.StrengthFighter;
import george.sfg.characters.storedCharacters.CharacterList;
import george.sfg.setup.combatant.Combatant;
import george.sfg.setup.combatant.CombatantList;

import java.util.Scanner;

/**
 * Created by Cloud on 25/11/2014.
 */
public class CharacterSetup {

    public void setupCharacters()
    {
        charSelect();
    }

    public void charSelect()
    {
        CombatantList cbl = new CombatantList();
        CharacterList chl = new CharacterList();
        boolean isDone = false;
        String charSelect = "";
        Scanner keyboard = new Scanner(System.in);
        while (!isDone)
        {
            System.out.println("Please Enter Which Character you wish to use by name.");
            charSelect = keyboard.nextLine();
            if (chl.containsFighter(charSelect))
            {
                isDone = true;
            }
        }
        cbl.getCombatantsList().add(new Combatant(chl.getFighter(charSelect).copy(), true));
    }

}
