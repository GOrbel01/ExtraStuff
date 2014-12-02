package george.sfg.weapons.storedWeapons;

import george.sfg.weapons.MagicWeaponImpl;
import george.sfg.weapons.StrengthWeaponImpl;
import george.sfg.weapons.Weapon;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cloud on 23/11/2014.
 */
public class WeaponList {
    private static List<Weapon> weaponList;

    File resDir = new File("");
    private String dirForAll = resDir.getAbsolutePath() + File.separator + "SimpleFFGame" + File.separator +
            "resource" + File.separator + "resources/weapon";

    public WeaponList()
    {
        weaponList = new ArrayList<>();
        addToList();
    }

    public void addToList()
    {
        String fileType = ".jpg";
        add(new StrengthWeaponImpl("Brotherhood", 25, 20, dirForAll + File.separator + "weapon0" + fileType));
        add(new StrengthWeaponImpl("Lionheart", 15, 30, dirForAll + File.separator + "weapon2" + fileType));
        add(new MagicWeaponImpl("Cage of Purity", 25, 30, dirForAll + File.separator + "weapon3" + fileType));
        add(new MagicWeaponImpl("Nirvana", 40, 10, dirForAll + File.separator + "weapon1" + fileType));
        add(new MagicWeaponImpl("Life and Death", 40, 10, dirForAll + File.separator + "LifeAndDeath" + fileType));
        add(new StrengthWeaponImpl("Masamune", 22, 24, dirForAll + File.separator + "Crisis_Core_Masamune" + fileType));
        add(new StrengthWeaponImpl("Ultimate Keyblade", 12, 35, dirForAll + File.separator + "UltimateKeyblade" + fileType));
        add(new MagicWeaponImpl("Fairy Tale", 30, 20, dirForAll + File.separator + "fairytale" + fileType));
    }

    public Weapon add(Object newWeapon)
    {
        weaponList.add((Weapon) newWeapon);
        return weaponList.get(weaponList.size()-1);
    }

    public Weapon getWeapon(int index)
    {
        return weaponList.get(index);
    }

    public Weapon getWeapon(String name)
    {
        int count = 0;
        while (count < weaponList.size())
        {
            if (weaponList.get(count).getName().equals(name))
            {
                return weaponList.get(count);
            }
            count++;
        }
        return null;
    }

    public List<Weapon> getList()
    {
        return weaponList;
    }

    public void printList()
    {
        for (int i = 0; i < weaponList.size(); i++)
        {
            System.out.println(weaponList.get(i).getName());
        }
    }

}
