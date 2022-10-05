package at.reiters190295.bsp3;

import at.reiters190295.bsp2.HalloJavamitForEach;

public class Main
{
    public static void main(String[] args)
    {
        NumberTester nt = new NumberTester("numbers.txt");
        nt.setOddEvenTester(number -> (number%2) == 0);
        nt.setPrimeTester(number ->
        {
            boolean flag = true;
            for (int i = 2; i < number; i++)
            {
                if ((number % i) == 0) {
                    flag = false;
                    break;
                }
            }
            return flag;
        });
        nt.setPalindromeTester(number ->
        {
            char[] arr = String.valueOf(number).toCharArray();
            boolean check = true;

            for(int i = 0; i < arr.length; i++)
            {
                if(arr[i] != arr[arr.length-1-i])
                {
                    check = false;
                }
            }
            return check;
        });

        nt.testFile();
    }
}
