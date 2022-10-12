package at.reiters.bsp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main
{
    private static final String FILE = "weapons.csv";

    public static void main(String[] args)
    {
        List<Weapon> weapons = CSVReader.readCSV(FILE);
        Sorter sorter = new Sorter(weapons);
        sorter.sortDamage();
        Printer printer = new Printer(weapons, (w) -> {
            w.forEach(System.out::println);
        });
        printer.print();
        System.out.println("\n");

        String[] splitted = CSVReader.getHeading(FILE).split(";");
        System.out.print(" ");
        Arrays.stream(splitted).forEach((str) ->
        {
            {
                String print = str;
                for(int i = 0; i < 18 - str.length(); i++)
                {
                    print += " ";
                }
                print += "| ";
                System.out.print(print);
            }
        });
        System.out.println();
        String tren = "";
        for(int j = 0; j < splitted.length; j++)
        {
            for(int i = 0; i < 19; i++)
            {
                tren += "-";
            }

            tren += "+";
        }
        System.out.println(tren);
        String line = tren;

        sorter.sortEnum();
        printer = new Printer(weapons, (w) -> {

            for(Weapon weapon : w)
            {
                System.out.print(" ");
                for(String str : weapon.getParts())
                {
                    String print = str;
                    for(int i = 0; i < 18 - str.length(); i++)
                    {
                        print += " ";
                    }
                    print += "| ";
                    System.out.print(print);
                }
                System.out.println();
                System.out.println(line);
            }
        });
        printer.print(); // noch mehr aufteilen
    }


}
