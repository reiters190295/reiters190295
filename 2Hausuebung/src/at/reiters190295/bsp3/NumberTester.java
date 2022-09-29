package at.reiters190295.bsp3;

public class NumberTester
{
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;


    public NumberTester(String fileName)
    {

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

    }
}
