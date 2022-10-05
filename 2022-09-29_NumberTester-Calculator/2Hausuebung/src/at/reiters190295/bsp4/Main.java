package at.reiters190295.bsp4;

import java.util.Scanner;

public class Main
{
    private Scanner scanner = new Scanner(System.in, "Windows-1252");

    public static void main(String[] args)
    {
        Main main = new Main();


        while(true)
        {
            switch(main.showUserInterface())
            {
                case 1:


                    break;

                case 2:

                    break;

                case 3:

                    break;

                default: return;
            }
        }
    }

    private int showUserInterface()
    {
        while(true)
        {
            System.out.println("1 ... Relational calculator");
            System.out.println("2 ... Vector calculator");
            System.out.println("3 ... Complex calculator");
            System.out.println("4 ... Exit program");
            System.out.print("> ");
            try
            {
                int i = scanner.nextInt();
                System.out.println();
            }
            catch(NumberFormatException ex)
            {
                System.err.println();
                System.err.println("Please choose a number between 1-4!");
                System.err.println();
                System.err.flush();
            }

        }
    }

    private void showSolution()
    {

    }

    private void showCalcTypes()
    {
        while(true)
        {
            System.out.println("1 ... add");
            System.out.println("2 ... subtract");
            System.out.println("3 ... multiply");
            System.out.println("4 ... divide");
            System.out.print("> ");
            try
            {
                int i = scanner.nextInt();
                System.out.println();
            }
            catch(NumberFormatException ex)
            {
                System.err.println();
                System.err.println("Please choose a number between 1-4!");
                System.err.println();
                System.err.flush();
            }

        }
    }

    private void showVector()
    {
        int xa; int xb; int ya; int yb;
        try
        {
            System.out.print("Enter number x a> ");
            xa = scanner.nextInt();
            System.out.print("\nEnter number x b> ");
            xb = scanner.nextInt();
            System.out.print("\nEnter number y a> ");
            ya = scanner.nextInt();
            System.out.print("\nEnter number y b> ");
            yb = scanner.nextInt();
            System.out.println();
        }
        catch(NumberFormatException ex)
        {
            System.err.println();
            System.err.println("Please use numbers!");
            System.err.println();
            System.err.flush();
        }
    }
}
