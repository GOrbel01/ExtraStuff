package george.sfg.setup;

import java.util.concurrent.*;

import george.sfg.setup.combatant.CombatantList;

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
        System.out.println("In Launch Method");
    }
}
