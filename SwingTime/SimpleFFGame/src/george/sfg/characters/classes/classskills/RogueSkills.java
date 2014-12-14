package george.sfg.characters.classes.classskills;

import george.sfg.skills.Skill;
import george.sfg.skills.SkillImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Squall on 04/12/2014.
 */
public class RogueSkills {
    private List<Skill> rogueSkillSet;
    private final String path = "rogue/";

    public RogueSkills()
    {
        rogueSkillSet = new ArrayList<>();
        addToList();
    }

    public void addToList()
    {
        rogueSkillSet.add(new SkillImpl("Sinister Strike", 43, 23, "A strong bleed that damages the opponent over time.", path + "sinisterstrike.jpg"));
        rogueSkillSet.add(new SkillImpl("Backstab", 43, 23, "A Strong  attack.", path + "backstab.jpg"));
        rogueSkillSet.add(new SkillImpl("Shadow Strike", 43, 23, "A devastating blow", path + "shadowstrike.jpg"));
        rogueSkillSet.add(new SkillImpl("Killing Spree", 43, 23, "A horrifying strike", path + "killingspree.jpg"));
    }

    public List<Skill> getList()
    {
        return rogueSkillSet;
    }
}
