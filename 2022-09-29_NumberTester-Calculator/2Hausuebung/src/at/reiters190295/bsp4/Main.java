package at.reiters190295.bsp4;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main
{
    private Scanner scanner = new Scanner(System.in, "Windows-1252");

    private AbstractCalculator ratio;
    private AbstractCalculator vector;
    private AbstractCalculator complex;

    private Number num1;
    private Number num2;

    public static void main(String[] args)
    {
        Main main = new Main();
        main.init();

        while(true)
        {
            int calculator = main.showUserInterface();
            if(calculator == 4)
            {
                return;
            }
            DoubleNumber dn = main.showNumber();
            int type = main.showCalcTypes();

            switch (calculator)
            {
                case 1: main.calcRatio(calculator, dn, type);break;
                case 2: main.calcVector(calculator, dn, type);break;
                case 3: main.calcComplex(calculator, dn,type);break;
            }
        }
    }

    private void calcRatio(int calculator, DoubleNumber dn, int type)
    {
        switch (type)
        {
            case 1: showSolution(ratio.add(dn.getFirst(), dn.getSecond()), calculator);break;
            case 2: showSolution(ratio.subtract(dn.getFirst(), dn.getSecond()), calculator);break;
            case 3: showSolution(ratio.multiply(dn.getFirst(), dn.getSecond()), calculator);break;
            case 4: showSolution(ratio.divide(dn.getFirst(), dn.getSecond()), calculator);break;
        }
    }

    private void calcVector(int calculator, DoubleNumber dn, int type)
    {
        switch (type)
        {
            case 1: showSolution(vector.add(dn.getFirst(), dn.getSecond()), calculator);break;
            case 2: showSolution(vector.subtract(dn.getFirst(), dn.getSecond()), calculator);break;
            case 3: showSolution(vector.multiply(dn.getFirst(), dn.getSecond()), calculator);break;
            case 4: showSolution(vector.divide(dn.getFirst(), dn.getSecond()), calculator);break;
        }
    }

    private void calcComplex(int calculator, DoubleNumber dn, int type)
    {
        switch (type)
        {
            case 1: showSolution(complex.add(dn.getFirst(), dn.getSecond()), calculator);break;
            case 2: showSolution(complex.subtract(dn.getFirst(), dn.getSecond()), calculator);break;
            case 3: showSolution(complex.multiply(dn.getFirst(), dn.getSecond()), calculator);break;
            case 4: showSolution(complex.divide(dn.getFirst(), dn.getSecond()), calculator);break;
        }
    }

    private double kuerzen(double a, double b)
    {
        double result = a % b;
        if(result == 0)
            return b;
        return kuerzen(b, result);
    }

    private void init()
    {
        ratio = new RationalCalculator(
                (x, y) ->
                {
                    double xZ = x.getA() * y.getB();
                    double yZ = y.getA() * x.getB();
                    double n = x.getB() * y.getB();
                    xZ = xZ+yZ;
                    double kurz = kuerzen(xZ, n);
                    return new Number(xZ/kurz, n/kurz);
                },
                (x, y) ->
                {
                    double xZ = x.getA() * y.getB();
                    double yZ = y.getA() * x.getB();
                    double n = x.getB() * y.getB();
                    xZ = xZ-yZ;
                    double kurz = kuerzen(xZ, n);
                    return new Number(xZ/kurz, n/kurz);
                },
                (x, y) ->
                {
                    double a = x.getA()*y.getA();
                    double b = x.getB()*y.getB();
                    double kurz = kuerzen(a, b);
                    return new Number(a/kurz, b/kurz);
                },
                (x, y) ->
                {
                    double a = x.getA()*y.getB();
                    double b = x.getB()*y.getA();
                    double kurz = kuerzen(a, b);
                    return new Number(a/kurz, b/kurz);
                }
        );

        vector = new VectorCalculator(
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
                    double a = x.getA() * y.getA() + x.getB() * y.getB();
                    return new Number(a, 0);
                }
        );

        complex = new ComplexCalculator(
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
                    return mult(x, y);
                },
                (x, y) ->
                {
                    Number n = new Number(y.getA(), -y.getB());
                    n = mult(x, n);
                    double b = Math.pow(y.getA(), 2) + Math.pow(y.getB(), 2);
                    return new Number(n.getA() / b, n.getB() / b);
                }
        );
    }

    private Number mult(Number x, Number y)
    {
        return new Number(x.getA() * y.getA() - x.getB() * y.getB(), x.getA() * y.getB() + x.getB() * y.getA());
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
                System.err.println("Please use numbers!");
                System.err.println();
                System.err.flush();
            }

        }
    }

    private void showSolution(Number result, int calculatior)
    {
        System.out.printf("---------------------------\nSolution\n");
        switch (calculatior)
        {
            case 1:
                System.out.println(result.getA() + "\n-----\n" + result.getB()); break;
            case 2:
                System.out.println("("+ result.getA() + ")\n(" + result.getB() + ")"); break;
            case 3:
                if(result.getB() >= 0)
                {
                    System.out.println(result.getA() + " + " + result.getB() + "i");
                }
                else
                {
                    System.out.println(result.getA() + " - " + -result.getB() + "i");
                }
                break;
        }
        System.out.println("\n");
    }

    private int showCalcTypes()
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
                    System.out.flush();
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
                System.out.flush();
                System.err.println();
                System.err.println("Please use numbers!");
                System.err.println();
                System.err.flush();
            }

        }
    }

    private DoubleNumber showNumber()
    {
        int xa; int xb; int ya; int yb;
        while (true)
        {
            try
            {
                System.out.print("Enter number x a> ");
                xa = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter number x b> ");
                xb = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter number y a> ");
                ya = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter number y b> ");
                yb = Integer.parseInt(scanner.nextLine());
                System.out.println();
                return new DoubleNumber(new Number(xa, xb), new Number(ya, yb));
            }
            catch(NumberFormatException ex)
            {
                System.out.flush();
                System.err.println();
                System.err.println("Please use numbers!");
                System.err.println();
                System.err.flush();
            }
        }


    }
}
