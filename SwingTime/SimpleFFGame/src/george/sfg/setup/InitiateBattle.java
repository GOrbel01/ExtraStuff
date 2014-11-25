package george.sfg.setup;

import george.sfg.characters.Battler;
import george.sfg.characters.Fighter;
import george.sfg.characters.storedCharacters.CharacterList;
import george.sfg.weapons.Weapon;
import george.sfg.weapons.storedWeapons.WeaponList;

/**
 * Created by Cloud on 23/11/2014.
 */
public class InitiateBattle {

    public static void main(String[] args)
    {
        InitiateBattle newBattle = new InitiateBattle();
        newBattle.launch();
    }

    public void launch()
    {
        CharacterList list = new CharacterList();
        CharacterSetup chs = new CharacterSetup();
        CharacterSetup chs2 = new CharacterSetup();
        Battler player = new Battler(list.getFighter("Cloud"), true);
        chs.getCombatants().add(player);
        System.out.println(chs.getCombatants().get(0).getFighter().getName());
        System.out.println(chs2.getCombatants().get(0).getFighter().getName());
        TestList quickTest = new TestList();
        quickTest.test();
    }
}
