package at.reiters190295;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in, "Windows-1252");

        while(true)
        {
            System.out.print("Prime Maximum (stop um zu Beenden): ");
            try
            {
                String str;
                if((str = scanner.nextLine().toLowerCase()).equals("stop"))
                {
                    System.out.println("Programm beendet");
                    System.exit(0);
                }
                int i = Integer.parseInt(str);

                EratosthenesPrimeSieve ep = new EratosthenesPrimeSieve(i);
                ep.printPrimes();
            }
            catch(NumberFormatException ex)
            {
                System.err.println("Bitte geben Sie eine ganze Zahl ein.");
            }
        }
    }
}
