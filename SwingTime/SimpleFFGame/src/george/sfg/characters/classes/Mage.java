package george.sfg.characters.classes;

import george.sfg.characters.Fighter;
import george.sfg.characters.MagicFighterImpl;
import george.sfg.characters.classes.classskills.MageSkills;
import george.sfg.characters.storedCharacters.FighterList;
import george.sfg.skills.Skill;

import java.util.List;

/**
 * Created by Squall on 03/12/2014.
 */
public class Mage extends MagicFighterImpl {

    List<Skill> mageSkills;

    public Mage(String name, int health, int speed, int magic, int mana, String res)
    {
        super(name, health, speed, magic, mana, res);
        setClassName("Mage");
        this.mageSkills = new MageSkills().getList();
    }

    public List<Skill> getSkills()
    {
        return mageSkills;
    }

    public void useLambda()
    {
        //Totally pointless but, meh, practice
        AnyFunction<String, Integer> findParseAndReturn = (str) -> {
            Integer res = 0;
            String nums = "";
            for (int i = 0; i < str.length(); i++)
            {
                System.out.println("Iteration: " + i);
                if (Character.isDigit(str.charAt(i)))
                {
                    System.out.println("In If");
                    nums += str.charAt(i);
                }
            }
            System.out.println("NumString: " + nums);
            res = Integer.parseInt(nums);
            return res;
        };

        String str1 = "I41AmaString";
        String str2 = "I41H8St1ings";
        Integer res = findParseAndReturn.func((str1)) + findParseAndReturn.func((str2));
        System.out.println("Result of Adding the numbers from the two Strings: " + res);

        AnyFunction<Fighter, Warrior> convertFighterToWarrior = (fighter) -> {
            Warrior newWarrior = (Warrior) fighter;
            if (fighter.getType().contains("Magic"))
            {
                return null;
            }
            else
            {
                return newWarrior;
            }
        };

        FighterList myList = new FighterList();
        myList.getFighter("Cloud");

        Warrior convertedFighter = convertFighterToWarrior.func(myList.getFighter("Cloud"));

    }

    public void testLambdaArg(AnyFunction<Fighter, Warrior> af)
    {

    }

}
