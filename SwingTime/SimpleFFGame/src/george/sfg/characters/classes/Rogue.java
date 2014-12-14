package george.sfg.characters.classes;

import george.sfg.characters.AgilityFighterImpl;
import george.sfg.characters.classes.classskills.RogueSkills;
import george.sfg.characters.classes.classskills.WarriorSkills;
import george.sfg.skills.Skill;

import java.util.List;

/**
 * Created by Squall on 09/12/2014.
 */
public class Rogue extends AgilityFighterImpl {

    List<Skill> rogueSkills;

    public Rogue(String name, int health, int speed, int strength, String res)
    {
        super(name, health, speed, strength, res);
        setClassName("Rogue");
        this.rogueSkills = new RogueSkills().getList();
    }

    public List<Skill> getSkills()
    {
        return rogueSkills;
    }
}
