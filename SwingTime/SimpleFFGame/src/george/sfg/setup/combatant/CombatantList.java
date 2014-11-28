package george.sfg.setup.combatant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Squall on 26/11/2014.
 */
public class CombatantList {
    private List<Combatant> combatants = new ArrayList<Combatant>();

    public CombatantList()
    {

    }

    public List<Combatant> getCombatantsList()
    {
        return combatants;
    }

    public Combatant getCombatantByTag(String tag)
    {
        int count = 0;
        while (count < combatants.size())
        {
            if (combatants.get(count) != null)
            {
                if (combatants.get(count).getTag().equals(tag))
                {
                    return combatants.get(count);
                }
            }
            count++;
        }
        return null;
    }

    public void printCombatants()
    {
        for (int i = 0; i < combatants.size(); i++)
        {
            System.out.println("Name of Element " + i + ":" + combatants.get(i).getFighter().getName());
        }
    }
}
