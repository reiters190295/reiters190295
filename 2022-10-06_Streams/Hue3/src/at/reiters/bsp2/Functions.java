package at.reiters.bsp2;

import at.reiters.bsp1.CSVReader;
import at.reiters.bsp1.DamageType;
import at.reiters.bsp1.Weapon;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Functions
{
    public static int[] reandomIntArray(int max)
    {
        int[] arr = new int[max];
        Random random = new Random();
        for(int i = 0; i < max; i++)
        {
            arr[i] = random.nextInt(max);
        }
        return arr;
    }

    public static double average(int[] numbers)
    {
         return Arrays.stream(numbers).average().getAsDouble(); //UNIT TEST
    }
    public static String[] reandomStringArray(int max)
    {
        String[] arr = new String[max];
        Random random = new Random();
        for(int i = 0; i < max; i++)
        {
            int ran = random.nextInt(57) +65;
            if(ran >96 || ran <91)
            {
                arr[i] = String.valueOf((char) ran);
            }
            else
            {
                i--;
            }
        }
        return arr;
    }

    public static List<String> upperCase(String[] strings)
    {
        return Arrays.stream(strings).map(String::toUpperCase).collect((Collectors.toList())); // UNIT TEST
    }

    public static void search()
    {
        List<Weapon> weapons = CSVReader.readCSV("weapons.csv");

        System.out.println("Geringster damage:");
        Optional<Weapon> opt = weapons.stream().min((w1, w2) -> w1.getDamage()-w2.getDamage());
        System.out.println(opt.get());

        System.out.println("\nHöchste strength:");
        opt = weapons.stream().max((w1, w2) -> w1.getStrength()-w2.getStrength());
        System.out.println(opt.get());

        System.out.println("\nDamageType:");
        List<Weapon> list = weapons.stream().filter((w -> w.getDamageType().equals(DamageType.MISSILE))).collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("\nLängster name:");
        opt = weapons.stream().max((w1, w2) -> w1.getName().length()-w2.getName().length());
        System.out.println(opt.get());

        System.out.println("\nListe String name:");
        List<String> names = weapons.stream().map(w -> w.getName()).collect(Collectors.toList());
        names.forEach(System.out::println);

        System.out.println("\nint Array:");
        List<Integer> speeds = weapons.stream().map(w -> w.getSpeed()).collect(Collectors.toList());
        Integer[] intArray = speeds.toArray(new Integer[speeds.size()]);
        Arrays.stream(intArray).forEach(i -> System.out.print(i + "; "));
        System.out.println();

        System.out.println("\nsumme values:");
        int valueSum = weapons.stream().map(w -> w.getValue()).reduce(0, (v1, v2) -> v1+v2);
        System.out.println(valueSum);

        System.out.println("\nhash summe:");
        int hashSum = weapons.stream().map(w -> w.hashCode()).reduce(0, (h1, h2) -> h1+h2);
        System.out.println(hashSum);

        System.out.println("\nDuplikates entfernen:");
        List<Weapon> list1 = weapons.stream().distinct().collect(Collectors.toList());
        list1.forEach(System.out::println);

        System.out.println("\nValue um 10% erhoehen:");
        weapons.stream().forEach(w -> w.setValue((int) (w.getValue()*1.1)));
        weapons.forEach(System.out::println);
    }
}
