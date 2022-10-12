package at.reiters.bsp1;

import java.util.Comparator;
import java.util.List;

public class Sorter
{
    List<Weapon> weapons;

    public Sorter(List<Weapon> weapons) {
        this.weapons = weapons;
    }


    public List<Weapon> sortDamage()
    {
        weapons.sort((w1, w2) -> w2.getDamage() - w1.getDamage());
        return weapons;
    }

    public List<Weapon> sortEnum()
    {
        weapons.sort((w1, w2) ->
        {
            int i = w1.getCombatType().toString().compareTo(w2.getCombatType().toString());
            if(i == 0)
            {
                i = w1.getDamageType().toString().compareTo(w2.getDamageType().toString());
                if(i == 0)
                {
                    i = w1.getName().compareTo(w2.getName());
                    if(i == 0)
                    {
                        return 0;
                    }
                    else if(i < 0)
                    {
                        return -1;
                    }
                    return 1;
                }
                else if(i < 0)
                {
                    return -1;
                }
                return 1;
            }
            else if(i < 0)
            {
                return -1;
            }
            return 1;
        }
        );
        return weapons;
    }


}
