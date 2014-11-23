package george.sfg.setup;

import george.sfg.characters.Fighter;
import george.sfg.characters.storedCharacters.CharacterList;
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
        CharacterList heroSelect = new CharacterList();
        WeaponList weaponSelect = new WeaponList();
        Fighter player = heroSelect.getFighter("Cloud");
        System.out.println(player);
        System.out.println("ATTACK1: " + player.getAttack());
        player.equipWeapon(weaponSelect.getWeapon("Simple Sword"));
        System.out.println("ATTACK2: " + player.getAttack());
        System.out.println(player);
    }
}
