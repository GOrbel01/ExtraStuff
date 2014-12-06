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
    private final String path = "mage/";

    public MageSkills()
    {
        mageSkillSet = new ArrayList<>();
        addToList();
    }

    public void addToList()
    {
        mageSkillSet.add(new SkillImpl("Fireball", 50, 20, "A fiery mass of destruction hurled at the enemy", path + "fireball.jpg"));
        mageSkillSet.add(new SkillImpl("Arcane Blast", 50, 20, "A blast of pure arcane energy", path + "arcaneblast.jpg"));
        mageSkillSet.add(new SkillImpl("Arcane Barrage", 50, 20, "A barrage of arcane bolts", path + "arcanebarrage.jpg"));
        mageSkillSet.add(new SkillImpl("Cone of Cold", 50, 20, "A cone of bitterly cold energy", path + "coneofcold.jpg"));
    }

    public List<Skill> getList()
    {
        return mageSkillSet;
    }
}
