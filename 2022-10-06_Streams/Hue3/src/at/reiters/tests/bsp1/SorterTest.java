package at.reiters.tests.bsp1;

import at.reiters.bsp1.CombatType;
import at.reiters.bsp1.DamageType;
import at.reiters.bsp1.Sorter;
import at.reiters.bsp1.Weapon;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SorterTest
{

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void testSortDamage() throws Exception
    {
        List<Weapon> weapons = new ArrayList<>();
        List<Weapon> com = new ArrayList<>();
        weapons.add(new Weapon("Crom Faeyr", CombatType.MELEE, DamageType.SLASHING, 2, 5, 6, 3500));
        weapons.add(new Weapon("Tuigan Bow", CombatType.RANGED, DamageType.MISSILE, 1, 5, 6, 3500));
        weapons.add(new Weapon("Varsonca", CombatType.MELEE, DamageType.SLASHING, 11, 3, 5, 4250));
        weapons.add(new Weapon("Armer", CombatType.NONE, DamageType.MISSILE, 5, 7, 2, 2000));

        com.add(new Weapon("Varsonca", CombatType.MELEE, DamageType.SLASHING, 11, 3, 5, 4250));
        com.add(new Weapon("Armer", CombatType.NONE, DamageType.MISSILE, 5, 7, 2, 2000));
        com.add(new Weapon("Crom Faeyr", CombatType.MELEE, DamageType.SLASHING, 2, 5, 6, 3500));
        com.add(new Weapon("Tuigan Bow", CombatType.RANGED, DamageType.MISSILE, 1, 5, 6, 3500));

        Sorter s = new Sorter(weapons);
        s.sortDamage();
        boolean check = true;
        for(int i = 0; i < com.size(); i++)
        {
            if(!weapons.get(i).equals(com.get(i)))
            {
                check = false;
            }
        }
        Assert.assertEquals(check, true);
    }

    @Test
    public void testSortEnum() throws Exception
    {
        List<Weapon> weapons = new ArrayList<>();
        List<Weapon> com = new ArrayList<>();
        weapons.add(new Weapon("Varsonca", CombatType.MELEE, DamageType.SLASHING, 11, 3, 5, 4250));
        weapons.add(new Weapon("Tuigan Bow", CombatType.RANGED, DamageType.MISSILE, 1, 5, 6, 3500));
        weapons.add(new Weapon("Crom Faeyr", CombatType.MELEE, DamageType.SLASHING, 2, 5, 6, 3500));
        weapons.add(new Weapon("Armer", CombatType.NONE, DamageType.MISSILE, 5, 7, 2, 2000));

        com.add(new Weapon("Crom Faeyr", CombatType.MELEE, DamageType.SLASHING, 2, 5, 6, 3500));
        com.add(new Weapon("Varsonca", CombatType.MELEE, DamageType.SLASHING, 11, 3, 5, 4250));
        com.add(new Weapon("Armer", CombatType.NONE, DamageType.MISSILE, 5, 7, 2, 2000));
        com.add(new Weapon("Tuigan Bow", CombatType.RANGED, DamageType.MISSILE, 1, 5, 6, 3500));

        Sorter s = new Sorter(weapons);
        s.sortEnum();
        boolean check = true;
        for(int i = 0; i < com.size(); i++)
        {
            if(!weapons.get(i).equals(com.get(i)))
            {
                check = false;
            }
        }
        Assert.assertEquals(check, true);
    }
}
