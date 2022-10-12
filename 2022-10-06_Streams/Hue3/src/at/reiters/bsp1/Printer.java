package at.reiters.bsp1;

import java.util.List;

public class Printer
{
    Printable printable;
    List<Weapon> weapons;

    public Printer(List<Weapon> weapons, Printable printable) {
        this.printable = printable;
        this.weapons = weapons;
    }

    public void print()
    {
        printable.print(weapons);
    }
}
