package george.sfg.weapons.storedWeapons;

import george.sfg.weapons.MagicWeaponImpl;
import george.sfg.weapons.StrengthWeaponImpl;
import george.sfg.weapons.Weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cloud on 23/11/2014.
 */
public class WeaponList {
    private List<Weapon> weaponList;

    public WeaponList()
    {
        weaponList = new ArrayList<>();
        addToList();
    }

    public void addToList()
    {
        add(new StrengthWeaponImpl("Simple Sword", 25, 20));
        add(new StrengthWeaponImpl("Simple Gunblade", 15, 30));
        add(new MagicWeaponImpl("Simple Tome", 25, 30));
        add(new MagicWeaponImpl("Simple Staff", 40, 10));
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
