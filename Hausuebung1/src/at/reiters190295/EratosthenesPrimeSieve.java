package at.reiters190295;

import java.util.ArrayList;

public class EratosthenesPrimeSieve implements PrimeSieve
{
    private Boolean[] invalid;

    public EratosthenesPrimeSieve(int max)
    {
        invalid = new Boolean[max+1];
        fillArray(max);

        for(int i = 2; i <= max; i++)
        {
            isPrime(i);
        }
        print();
    }

    private void fillArray(int max)
    {
        for(int i = 0; i <= max; i++)
        {
            invalid[i] = false;
        }
    }

    @Override
    public boolean isPrime(int p)
    {
        boolean check = false;
        if(invalid[p] == false)
        {
            int j = p+p;
            for(int i = j; i <= invalid.length; i++)
            {
                if(check)
                {
                    i = i-1;
                }
                invalid[i] = true;
                i = i+p;
                check = true;
            }
        }
        return false;
    }

    @Override
    public void printPrimes()
    {
        for(int i = 0; i < invalid.length; i++)
        {
            if(!invalid[i])
            {
                System.out.println("[" + i + "] : " + invalid[i]);
            }
        }
    }

    private void print()
    {
        for(int i = 0; i < invalid.length; i++)
        {
            System.out.println("[" + i + "] : " + invalid[i]);
        }
    }
}
