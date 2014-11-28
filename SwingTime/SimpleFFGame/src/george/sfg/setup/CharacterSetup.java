package george.sfg.setup;

import george.sfg.characters.Fighter;
import george.sfg.characters.MagicFighterImpl;
import george.sfg.characters.StrengthFighterImpl;
import george.sfg.characters.storedCharacters.FighterList;
import george.sfg.setup.combatant.Combatant;
import george.sfg.setup.combatant.CombatantList;
import george.sfg.userinterface.CharacterSelectFrame;

import javax.swing.*;
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

    private CharacterSelectFrame frame;

    public CharacterSetup(CharacterSelectFrame frame)
    {
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent event)
    {
        boolean confirmation = false;
        String nameOfPressedButton = event.getActionCommand();
        int indexOfSpace = nameOfPressedButton.indexOf(" ");
        String selectedChar = nameOfPressedButton.substring(indexOfSpace+1, nameOfPressedButton.length());
        System.out.println(selectedChar);
        confirmation = frame.showDialog("Confirm Choice");
        if (confirmation)
        {
            setSelection(selectedChar);
        }
    }

    public void setSelection(String name)
    {
        Scanner keyboard = new Scanner(System.in);
        Fighter temp = fList.getFighter(name);
        boolean isDone = false;
        String type = temp.getType();
        String newName = "";
        System.out.println("Rename your Character?");
        if (frame.showDialog("Rename?"))
        {
            while (!isDone)
            {
                System.out.println("Enter new Name");
                newName = frame.showNewNameDialog();
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
        }
        else
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
        cList.printCombatants();
        System.out.println(cList.getCombatantByTag("Player1").getFighter());
    }

//    public void setupCharacters()
//    {
//        charSelect();
//    }
//
//    public void charSelect()
//    {
//        boolean isDone = false;
//        String charSelect = "";
//        Scanner keyboard = new Scanner(System.in);
//        while (!isDone)
//        {
//            System.out.println("Please Enter Which Character you wish to use by name.");
//            charSelect = keyboard.next();
//            if (fList.containsFighter(charSelect))
//            {
//                isDone = true;
//            }
//        }
//        isDone = false;
//        if (renameOption())
//        {
//            String newName = "";
//            System.out.println("Enter a new name for your Fighter");
//            while(!isDone)
//            {
//                newName = keyboard.next();
//                if (isValidName(newName))
//                {
//                    isDone = true;
//                }
//                else
//                {
//                    System.out.println("Invalid Name. Try Again!");
//                }
//            }
//            cList.getCombatantsList().add(new Combatant(fList.getFighter(charSelect).copy(), newName, true));
//        }
//        else
//        {
//            cList.getCombatantsList().add(new Combatant(fList.getFighter(charSelect).copy(), true));
//        }
//    }
//

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
//
//    public boolean renameOption()
//    {
//        String rename = "";
//        boolean isDone = false;
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Would you like to Rename your Character? Y/N");
//        while (!isDone)
//        {
//            try {
//                rename = keyboard.next();
//                if (isValidRenameSelect(rename))
//                {
//                    isDone = true;
//                }
//                else
//                {
//                    System.out.println("Invalid Selection: Try Again");
//                }
//            }
//            catch (InputMismatchException ex)
//            {
//                ex.printStackTrace();
//                System.out.println("Input Mismatch Enter Letters Y/N Only");
//            }
//        }
//        if (rename.equalsIgnoreCase("y"))
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }
//
//    public boolean isValidRenameSelect(String str)
//    {
//        if (str.equalsIgnoreCase("y") || str.equalsIgnoreCase("n"))
//        {
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }

    public FighterList getFighterList()
    {
        return fList;
    }

    public CombatantList getCombatantList()
    {
        return cList;
    }

}
