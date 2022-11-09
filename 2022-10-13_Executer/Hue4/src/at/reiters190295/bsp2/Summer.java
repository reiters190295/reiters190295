package at.reiters190295.bsp2;

import java.util.concurrent.Callable;

public class Summer implements Callable<Integer>
{
    private int min;
    private int max;

    public Summer(int min, int max)
    {
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer call() throws Exception {
        int ret = 0;
        for(int i = min; i <= max; i++)
        {
            ret += i;
        }
        return ret;
    }
}
