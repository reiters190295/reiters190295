package net.eaustria;

import java.util.stream.DoubleStream;

public class Main
{
    public static void main(String[] args)
    {
        ReciprocalArraySum arrSum = new ReciprocalArraySum();
        double[] values = DoubleStream.of(1, 501).toArray();
        double result = arrSum.parManyTaskArraySum(values, 500);
        System.out.println("result: " + result);
    }
}
