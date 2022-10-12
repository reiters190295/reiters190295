package at.reiters.bsp2;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        int[] ints = Functions.reandomIntArray(1000);
        System.out.println("Average:");
        Arrays.stream(ints).forEach(i -> System.out.print(i + "; "));
        System.out.println();
        System.out.println(Functions.average(ints));

        System.out.println("\nStringArray:");
        String[] strArray = Functions.reandomStringArray(10);
        Arrays.stream(strArray).forEach(s -> System.out.print(s + " "));

        System.out.println("\nStringUpperCase:");
        Functions.upperCase(strArray).stream().forEach(i -> System.out.print(i + " "));
        System.out.println("\n");

        Functions.search();
    }


}
