package net.eaustria.bsp1;

import java.util.stream.IntStream;

public class Main
{
    public static void main(String[] args)
    {
        ReciprocalArraySum arrSum = new ReciprocalArraySum();

        double[] values = IntStream.range(1,20).mapToDouble(i -> (double) i).toArray();

        double result = arrSum.parManyTaskArraySum(values, 10);
        System.out.println(" The reciprocal array sum of the input array is  " + result);
    }
}
