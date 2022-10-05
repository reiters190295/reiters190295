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
                        if(oddTester.testNumber(Integer.parseInt(split[1])))
                        {
                            System.out.println("EVEN");
                        }
                        else
                        {
                            System.out.println("NOT EVEN");
                        }
                        break;

                    case 2:                        ;
                        if(primeTester.testNumber(Integer.parseInt(split[1])))
                        {
                            System.out.println("PRIME");
                        }
                        else
                        {
                            System.out.println("NO PRIME");
                        }
                        break;

                    case 3:
                        if(palindromeTester.testNumber(Integer.parseInt(split[1])))
                        {
                            System.out.println("PALINDROME");
                        }
                        else
                        {
                            System.out.println("NO PALINDROME");
                        }
                        break;
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
