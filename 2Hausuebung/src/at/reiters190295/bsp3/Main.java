package at.reiters190295.bsp3;

import at.reiters190295.bsp2.HalloJavamitForEach;

public class Main
{
    public static void main(String[] args)
    {
        NumberTester nt = new NumberTester("numbers.txt");
        nt.setOddEvenTester(number -> (number%2) == 0);
        nt.setPrimeTester(number -> {
            boolean flag = false;
            for (int i = 2; i <= number / 2; ++i) {
                if (number % i == 0) {
                    flag = true;
                    break;
                }
            }
            return flag;
        });
        nt.setPalindromeTester(number -> {
            int reverse = 0;
            int num = number;
            while (number != 0) {
                int remainder = num % 10;
                reverse = reverse * 10 + remainder;
                num = num / 10;
            }
            return number == reverse;
        });
    }
}
