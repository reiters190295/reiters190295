package at.reiters190295.bsp2;

public class Main
{
    public static void main(String[] args)
    {
        int number = Functions.askUser();
        int result = Functions.calc(number);
        System.out.println("Check:\t" + result);
        System.out.println("Gauss:\t" + Functions.gausCalc(number));
    }
}
