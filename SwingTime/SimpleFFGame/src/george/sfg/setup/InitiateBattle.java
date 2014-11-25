package george.sfg.setup;

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
        CharacterList heroSelect = new CharacterList();
        WeaponList weaponSelect = new WeaponList();
        Fighter player = heroSelect.getFighter("Cloud");

        Fighter enemy = heroSelect.getFighter("Squall");
        System.out.println(weaponSelect.getWeapon(weaponSelect.getList().size()-1).getName());
        weaponSelect.add(weaponSelect.getWeapon("Simple Sword").copy());
        System.out.println(weaponSelect.getWeapon(weaponSelect.getList().size()-1).getName());
        enemy.equipWeapon(weaponSelect.add(weaponSelect.getWeapon("Simple Sword").copy()));
        player.equipWeapon(weaponSelect.getWeapon("Simple Sword"));
        enemy.getWeapon().testSetName("King Kong");
        System.out.println("Player Wep Name: " + player.getWeapon().getName());
        System.out.println("Enemy Wep Name: " + enemy.getWeapon().getName());
    }
}
