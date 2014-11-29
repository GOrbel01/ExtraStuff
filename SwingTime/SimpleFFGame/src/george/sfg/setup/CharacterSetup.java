package george.sfg.setup;

import george.sfg.characters.Fighter;
import george.sfg.characters.MagicFighterImpl;
import george.sfg.characters.StrengthFighterImpl;
import george.sfg.characters.storedCharacters.FighterList;
import george.sfg.setup.combatant.Combatant;
import george.sfg.setup.combatant.CombatantList;
import george.sfg.userinterface.CharacterSelectFrame;
import george.sfg.userinterface.WeaponSelectFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Cloud on 25/11/2014.
 */
public class CharacterSetup implements ActionListener {

    private FighterList fList = new FighterList();
    private CombatantList cList = new CombatantList();

    private WeaponSelectFrame wepSelLaunch;

    private CharacterSelectFrame frame;

    public CharacterSetup(CharacterSelectFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent event)
    {
        boolean confirmation;
        String nameOfPressedButton = event.getActionCommand();
        int indexOfSpace = nameOfPressedButton.indexOf(" ");
        String selectedChar = nameOfPressedButton.substring(indexOfSpace+1, nameOfPressedButton.length());
        System.out.println(selectedChar);
        confirmation = frame.showDialog("Confirm Choice");
        if (confirmation)
        {
            setSelection(selectedChar);
        }
        wepSelLaunch = new WeaponSelectFrame();
        wepSelLaunch.launchFrame();
    }

    public void printWords()
    {

    }

    public void setSelection(String name)
    {
        Fighter temp = fList.getFighter(name);
        boolean isDone = false;
        boolean wantsRename = frame.showDialog("Rename");
        String type = temp.getType();
        String newName = "";
        System.out.println("Rename your Character?");
        while (!isDone)
        {
            System.out.println("Back Here");
            if (wantsRename)
            {
                System.out.println("Enter new Name");
                newName = frame.showNewNameDialog();
                if (newName != null)
                {
                    if (isValidName(newName))
                    {
                        if (type.equals("StrengthUser"))
                        {
                            Fighter playerFighter = new StrengthFighterImpl(temp, newName);
                            Combatant player = new Combatant(playerFighter, true);
                            cList.getCombatantsList().add(player);
                        }
                        else if (type.equals("MagicUser"))
                        {
                            Fighter playerFighter = new MagicFighterImpl(temp, newName);
                            Combatant player = new Combatant(playerFighter, true);
                            cList.getCombatantsList().add(player);
                        }
                        isDone = true;
                    }
                    else
                    {
                        frame.showNewNameDialog();
                    }
                }
                else
                {
                    System.out.println("User Canceled Rename.");
                    System.out.println("Restarting Selection");
                    wantsRename = frame.showDialog("Rename?");
                }

            }
            else
            {
                System.out.println("here");
                setFightersNoRename(temp, type);
                isDone = true;
            }
        }
        frame.setVisible(false);
        cList.printCombatants();
        System.out.println(cList.getCombatantByTag("Player1").getFighter());
    }

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

    public boolean isValidName(String selection)
    {
        boolean valid = true;
        for (int i = 0; i < selection.length(); i++)
        {
            if (!(Character.isLetter(selection.charAt(i))))
            {
                valid = false;
            }
        }
        return valid;
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
