package at.reiters190295.bsp3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberTester
{
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;

    private String fileName;


    public NumberTester(String fileName)
    {
        this.fileName = fileName;
        testFile();
    }

    public void setOddEvenTester(NumberTest oddTester)
    {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester)
    {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester)
    {
        this.palindromeTester = palindromeTester;
    }

    public void testFile()
    {
        try
        {
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            int i = Integer.parseInt(scanner.nextLine());
            for(int j = 0; j < i; j++)
            {
                String line = scanner.nextLine();
                String[] split = line.split(" ");
                switch(Integer.parseInt(split[0]))
                {
                    case 1:
                        break;

                    case 2:
                        break;

                    case 3:
                        palindromeTester.testNumber(Integer.parseInt(split[1]))
                        break;
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isEven(int number)
    {
        return
    }

    private boolean isPrime(int number)
    {

    }

    private boolean isPalindrome(int number)
    {

    }
}
