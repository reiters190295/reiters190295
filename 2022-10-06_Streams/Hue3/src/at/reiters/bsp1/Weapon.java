package at.reiters.bsp1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Weapon
{
    private String name;
    private CombatType combatType;
    private DamageType damageType;
    private int damage;
    private int speed;
    private int strength;
    private int value;

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }

    public static Weapon deserialize(String line)
    {
        try
        {
            String[] splitted = line.split(";");
            String name = splitted[0];
            CombatType combatType = CombatType.valueOf(splitted[1]);
            DamageType damageType = DamageType.valueOf(splitted[2]);
            int damage = Integer.parseInt(splitted[3]);
            int speed = Integer.parseInt(splitted[4]);
            int strength = Integer.parseInt(splitted[5]);
            int value = Integer.parseInt(splitted[6]);
            return new Weapon(name, combatType, damageType, damage, speed, strength, value);
        }
        catch(Exception ex){}
        return null;
    }

    public List<String> getParts()
    {
        List<String> parts = new ArrayList<>();
        parts.add(name);
        parts.add(combatType.toString());
        parts.add(damageType.toString());
        parts.add(""+damage);
        parts.add(""+speed);
        parts.add(""+strength);
        parts.add(""+value);
        return parts;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", combatType=" + combatType +
                ", damageType=" + damageType +
                ", damage=" + damage +
                ", speed=" + speed +
                ", strength=" + strength +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return getDamage() == weapon.getDamage() && getSpeed() == weapon.getSpeed() && getStrength() == weapon.getStrength() && getValue() == weapon.getValue() && getName().equals(weapon.getName()) && getCombatType() == weapon.getCombatType() && getDamageType() == weapon.getDamageType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCombatType(), getDamageType(), getDamage(), getSpeed(), getStrength(), getValue());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CombatType getCombatType() {
        return combatType;
    }

    public void setCombatType(CombatType combatType) {
        this.combatType = combatType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
