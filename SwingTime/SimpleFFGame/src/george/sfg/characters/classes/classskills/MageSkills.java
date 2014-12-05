package george.sfg.characters.classes.classskills;

import george.sfg.skills.Skill;
import george.sfg.skills.SkillImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Squall on 04/12/2014.
 */
public class MageSkills {
    private List<Skill> mageSkillSet;
    private final String path = "Mage" + File.separator;

    public MageSkills()
    {
        mageSkillSet = new ArrayList<>();
        addToList();
    }

    public void addToList()
    {
        mageSkillSet.add(new SkillImpl("Fireball", 50, 20, path + "fireball.jpg"));
        mageSkillSet.add(new SkillImpl("Arcane Blast", 50, 20, path + "arcaneblast.jpg"));
    }

    public List<Skill> getList()
    {
        return mageSkillSet;
    }
}
