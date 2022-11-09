package at.reiters190295.bsp2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Functions
{
    public static int askUser()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n> ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int calc(int number)
    {
        int rest = number;
        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for(int i = 100; i <= number; i += 100)
        {
            futures.add(executor.submit(new Summer(i-99, i)));
            rest = rest -100;
        }

        if(rest != 0)
        {
            futures.add(executor.submit(new Summer(number-rest+1, number)));
        }

        return sumFutures(futures);
    }

    private static int sumFutures(List<Future<Integer>> futures)
    {
        int ret = 0;
        try
        {
            for(Future<Integer> future : futures)
            {
                ret += future.get();
            }
        }
        catch(InterruptedException ex)
        {
            throw new RuntimeException(ex);
        }
        catch (ExecutionException e)
        {
            throw new RuntimeException(e);
        }
        return ret;
    }

    public static int gausCalc(int number)
    {
        return (number * number + number) / 2;
    }
}
