package george.sfg.characters.classes.classskills;

import george.sfg.skills.Skill;
import george.sfg.skills.SkillImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Squall on 04/12/2014.
 */
public class WarriorSkills {
    private List<Skill> warriorSkillSet;
    private final String path = "Warrior" + File.separator;

    public WarriorSkills()
    {
        warriorSkillSet = new ArrayList<>();
        addToList();
    }

    public void addToList()
    {
        warriorSkillSet.add(new SkillImpl("Rend", 43, 23, path + "rend.jpg"));
        warriorSkillSet.add(new SkillImpl("Heroic Strike", 43, 23, path + "heroicstrike.jpg"));
    }

    public List<Skill> getList()
    {
        return warriorSkillSet;
    }
}
