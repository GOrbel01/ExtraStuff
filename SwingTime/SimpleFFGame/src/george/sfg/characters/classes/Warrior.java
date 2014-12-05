package george.sfg.characters.classes;

import george.sfg.characters.StrengthFighterImpl;
import george.sfg.characters.classes.classskills.WarriorSkills;
import george.sfg.skills.Skill;
import javafx.scene.control.Button;

import java.util.List;

/**
 * Created by Squall on 03/12/2014.
 */
public class Warrior extends StrengthFighterImpl {

    List<Skill> warriorSkills;

    public Warrior(String name, int health, int speed, int strength, String res)
    {
        super(name, health, speed, strength, res);
        setClassName("Warrior");
        this.warriorSkills = new WarriorSkills().getList();
    }

    public List<Skill> getSkills()
    {
        return warriorSkills;
    }
}
