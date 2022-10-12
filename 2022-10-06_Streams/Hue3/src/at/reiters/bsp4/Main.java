package at.reiters.bsp4;

import java.util.stream.IntStream;

public class Main
{
    public static void main(String[] args)
    {
        final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(i -> i%2 != 0).map(i -> (int)Math.pow(i, 4)).reduce(0, (i1, i2) -> i1+i2);
        System.out.println(result);
    }
}
