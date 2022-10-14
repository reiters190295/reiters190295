package at.reiters190295.bsp1;

import java.util.List;
import java.util.stream.Collectors;

public class Chunk implements Runnable
{
    List<Integer> ints;
    int divider;


    public Chunk(List<Integer> ints, int divider)
    {
        this.ints = ints;
        this.divider = divider;
    }

    @Override
    public void run()
    {
        ints.stream().filter(i -> i %divider == 0).forEach(System.out::println);
    }
}
