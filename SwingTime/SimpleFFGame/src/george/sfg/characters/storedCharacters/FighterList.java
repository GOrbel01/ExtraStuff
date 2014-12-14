package george.sfg.characters.storedCharacters;

import george.sfg.characters.Fighter;
import george.sfg.characters.MagicFighterImpl;
import george.sfg.characters.StrengthFighter;
import george.sfg.characters.StrengthFighterImpl;
import george.sfg.characters.classes.Mage;
import george.sfg.characters.classes.Rogue;
import george.sfg.characters.classes.Warrior;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cloud on 23/11/2014.
 */
public class FighterList {
    private List<Fighter> fighterList;

    public FighterList()
    {
        fighterList = new ArrayList<>();
        populateList();
    }

    private void populateList()
    {
        fighterList.add(new Warrior("Cloud", 1500, 40, 50, "Pic0.jpg"));
        fighterList.add(new Warrior("Squall", 1450, 45, 60, "Pic1.jpg"));
        fighterList.add(new Rogue("Tidus", 1400, 50, 60, "TidusPic.jpg"));
        fighterList.add(new Mage("Kuja", 1400, 50, 65, 100, "Pic2.jpg"));
        fighterList.add(new Mage("Edea", 1350, 60, 70, 100, "Pic3.jpg"));
        fighterList.add(new Warrior("Tifa", 1400, 55, 45, "Pic4.jpg"));
        fighterList.add(new Mage("Aeris", 1100, 65, 55, 120, "Pic5.jpg"));
        fighterList.add(new Rogue("Zidane", 1200, 65, 70, "ZidanePic.jpg"));
        fighterList.add(new Warrior("Auron", 1400, 40, 50, "Pic6.jpg"));
        fighterList.add(new Mage("Yuna", 1150, 60, 60, 120, "Pic7.jpg"));
        fighterList.add(new Warrior("Sephiroth", 1100, 70, 55, "Pic8.jpg"));
    }

    public Fighter getFighter(String name)
    {
        int count = 0;
        while (count < fighterList.size())
        {
            if (fighterList.get(count).getName().equals(name))
            {
                return fighterList.get(count);
            }
            count++;
        }
        return null;
    }

    public boolean containsFighter(String name)
    {
        for (int i = 0; i < fighterList.size(); i++)
        {
            if (getFighter(name) != null)
            {
                return true;
            }
        }
        return false;
    }

    public List<Fighter> getList()
    {
        return fighterList;
    }

}
