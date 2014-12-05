package george.sfg.characters.classes;

import george.sfg.characters.MagicFighterImpl;
import george.sfg.characters.classes.classskills.MageSkills;
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

}
