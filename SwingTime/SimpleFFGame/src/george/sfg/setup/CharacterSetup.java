package george.sfg.setup;

import george.sfg.characters.storedCharacters.FighterList;
import george.sfg.setup.combatant.Combatant;
import george.sfg.setup.combatant.CombatantList;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Cloud on 25/11/2014.
 */
public class CharacterSetup {

    private FighterList fList = new FighterList();
    private CombatantList cList = new CombatantList();

    public void setupCharacters()
    {
        charSelect();
    }

    public void charSelect()
    {
        boolean isDone = false;
        String charSelect = "";
        Scanner keyboard = new Scanner(System.in);
        while (!isDone)
        {
            System.out.println("Please Enter Which Character you wish to use by name.");
            charSelect = keyboard.next();
            if (fList.containsFighter(charSelect))
            {
                isDone = true;
            }
        }
        isDone = false;
        if (renameOption())
        {
            String newName = "";
            System.out.println("Enter a new name for your Fighter");
            while(!isDone)
            {
                newName = keyboard.next();
                if (isValidName(newName))
                {
                    isDone = true;
                }
                else
                {
                    System.out.println("Invalid Name. Try Again!");
                }
            }
            cList.getCombatantsList().add(new Combatant(fList.getFighter(charSelect).copy(), newName, true));
        }
        else
        {
            cList.getCombatantsList().add(new Combatant(fList.getFighter(charSelect).copy(), true));
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

    public boolean renameOption()
    {
        String rename = "";
        boolean isDone = false;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Would you like to Rename your Character? Y/N");
        while (!isDone)
        {
            try {
                rename = keyboard.next();
                if (isValidRenameSelect(rename))
                {
                    isDone = true;
                }
                else
                {
                    System.out.println("Invalid Selection: Try Again");
                }
            }
            catch (InputMismatchException ex)
            {
                ex.printStackTrace();
                System.out.println("Input Mismatch Enter Letters Y/N Only");
            }
        }
        if (rename.equalsIgnoreCase("y"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isValidRenameSelect(String str)
    {
        if (str.equalsIgnoreCase("y") || str.equalsIgnoreCase("n"))
        {
            return true;
        }
        else
        {
            return false;
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
