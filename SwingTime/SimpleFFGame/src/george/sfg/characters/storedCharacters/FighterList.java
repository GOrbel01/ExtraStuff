package george.sfg.characters.storedCharacters;

import george.sfg.characters.Fighter;
import george.sfg.characters.MagicFighterImpl;
import george.sfg.characters.StrengthFighter;
import george.sfg.characters.StrengthFighterImpl;

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
        fighterList.add(new StrengthFighterImpl("Cloud", 1500, 40, 50));
        fighterList.add(new StrengthFighterImpl("Squall", 1450, 45, 60));
        fighterList.add(new MagicFighterImpl("Kuja", 1400, 50, 65, 100));
        fighterList.add(new MagicFighterImpl("Edea", 1350, 60, 70, 100));
        fighterList.add(new StrengthFighterImpl("Tifa", 1400, 55, 45));
        fighterList.add(new MagicFighterImpl("Aeris", 1100, 65, 55, 120));
        fighterList.add(new StrengthFighterImpl("Auron", 1400, 40, 50));
        fighterList.add(new MagicFighterImpl("Yuna", 1150, 60, 60, 120));
        fighterList.add(new StrengthFighterImpl("Sephiroth", 1100, 70, 55));
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
