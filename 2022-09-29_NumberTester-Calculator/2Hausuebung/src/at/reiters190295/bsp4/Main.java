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
                    main.showVector();
                    main.showCalcTypes();
                    break;

                case 3:

                    break;

                default: return;
            }
        }
    }

    private void init()
    {
        AbstractCalculator ratio = new RationalCalculator(
                (x, y) ->
                {
                    double xZ = x.getA() * y.getB();
                    double yZ = y.getA() * x.getB();
                    double n = x.getB() * y.getB();
                    return new Number(xZ+yZ, n);
                },
                (x, y) ->
                {
                    double xZ = x.getA() * y.getB();
                    double yZ = y.getA() * x.getB();
                    double n = x.getB() * y.getB();
                    return new Number(xZ-yZ, n);
                },
                (x, y) ->
                {
                    return new Number(x.getA()*y.getA(), x.getB()*y.getB());
                },
                (x, y) ->
                {
                    return new Number(x.getA()*y.getB(), x.getB()*y.getA());
                }
        );

        AbstractCalculator vector = new VectorCalculator(
                (x, y) ->
                {
                    return new Number(x.getA()+y.getA(), x.getB()+y.getB());
                },
                (x, y) ->
                {
                    return new Number(x.getA()-y.getA(), x.getB()-y.getB());
                },
                (x, y) ->
                {
                    double a = x.getA() * y.getB();
                    double b = y.getA() * x.getB();
                    return new Number(a, b);
                },
                (x, y) ->
                {
                    double a = x.getA() * x.getB();
                    double b = y.getA() * y.getB();
                    return new Number(a, b);
                }
        );
    }

    private int showUserInterface()
    {
        while(true)
        {
            System.out.println("1 ... Rational calculator");
            System.out.println("2 ... Vector calculator");
            System.out.println("3 ... Complex calculator");
            System.out.println("4 ... Exit program");
            System.out.print("> ");
            try
            {
                int i = Integer.parseInt(scanner.nextLine());
                System.out.println();
                if(i < 1 || i > 4)
                {
                    System.err.println();
                    System.err.println("Please choose a number between 1-4!");
                    System.err.println();
                    System.err.flush();
                }
                else
                {
                    return i;
                }

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
                int i = Integer.parseInt(scanner.nextLine());
                System.out.println();
                if(i < 1 || i > 4)
                {
                    System.err.println();
                    System.err.println("Please choose a number between 1-4!");
                    System.err.println();
                    System.err.flush();
                }
                else
                {
                    return;
                }
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
            xa = Integer.parseInt(scanner.nextLine());
            System.out.print("\nEnter number x b> ");
            xb = Integer.parseInt(scanner.nextLine());
            System.out.print("\nEnter number y a> ");
            ya = Integer.parseInt(scanner.nextLine());
            System.out.print("\nEnter number y b> ");
            yb = Integer.parseInt(scanner.nextLine());
            System.out.println();
            return;
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
