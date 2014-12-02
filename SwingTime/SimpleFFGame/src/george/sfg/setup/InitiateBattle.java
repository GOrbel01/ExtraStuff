package george.sfg.setup;

import java.util.concurrent.*;

import george.sfg.setup.combatant.CombatantList;
import george.sfg.userinterface.CharacterSelectFrame;

import javax.swing.*;

/**
 * Created by Cloud on 23/11/2014.
 */
public class InitiateBattle {

    public static void main(String[] args)
    {
        InitiateBattle newBattle = new InitiateBattle();
        newBattle.launch();
        System.out.println("After Launch Method");

    }

    public void launch()
    {
        CharacterSetup chs = new CharacterSetup();
        chs.runSetup();
        System.out.println("In Launch Method");
    }
}
