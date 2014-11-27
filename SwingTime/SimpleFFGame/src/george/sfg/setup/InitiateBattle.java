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

    }

    public void launch()
    {
//        CharacterSetup chs = new CharacterSetup();
//        chs.setupCharacters();
//        System.out.println(chs.getCombatantList().getCombatantByTag("Player1").getFighter().getName());
        JFrame frame;
        CharacterSetup charSetup = new CharacterSetup();
        frame = new CharacterSelectFrame(charSetup.getFighterList().getList(), charSetup);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
//
    }
}
