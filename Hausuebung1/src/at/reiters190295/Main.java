package at.reiters190295;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in, "Windows-1252");
        System.out.print("Prime Maximum: ");
        while(true)
        {
            try
            {
                int i = scanner.nextInt();

                EratosthenesPrimeSieve ep = new EratosthenesPrimeSieve(i);
                ep.printPrimes();
            }
            catch(InputMismatchException ex)
            {
                System.err.println("Bitte geben Sie eine ganze Zahl ein.");
            }
        }
    }
}
