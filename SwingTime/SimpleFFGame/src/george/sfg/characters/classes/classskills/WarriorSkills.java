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
    private final String path = "warrior/";

    public WarriorSkills()
    {
        warriorSkillSet = new ArrayList<>();
        addToList();
    }

    public void addToList()
    {
        warriorSkillSet.add(new SkillImpl("Rend", 43, 23, "A strong bleed that damages the opponent over time.", path + "rend.jpg"));
        warriorSkillSet.add(new SkillImpl("Heroic Strike", 43, 23, "A Strong  attack.", path + "heroicstrike.jpg"));
        warriorSkillSet.add(new SkillImpl("Devastate", 43, 23, "A devastating blow", path + "devastate.jpg"));
        warriorSkillSet.add(new SkillImpl("Hells Blade", 43, 23, "A horrifying strike", path + "hellsblade.jpg"));
    }

    public List<Skill> getList()
    {
        return warriorSkillSet;
    }
}
