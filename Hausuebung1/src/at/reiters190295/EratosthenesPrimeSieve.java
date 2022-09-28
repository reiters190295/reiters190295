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
            if(!invalid[i] && isPrime(i))
            {
                invalidPrimes(i);
            }
        }
    }

    private void fillArray(int max)
    {
        invalid[0] = true;
        invalid[1] = true;
        for(int i = 2; i <= max; i++)
        {
            invalid[i] = false;
        }
    }

    @Override
    public boolean isPrime(int p)
    {
        if(invalid[p] == false)
        {
            return true;
        }
        return false;
    }

    private void invalidPrimes(int p)
    {
        int i = p+p;
        while(i < invalid.length)
        {
            invalid[i] = true;
            i = i+p;
        }
    }

    @Override
    public void printPrimes()
    {
        for(int i = 0; i < invalid.length; i++)
        {
            if(!invalid[i])
            {
                System.out.println(i);
            }
        }
        System.out.println();
    }
}
