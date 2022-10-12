package at.reiters.bsp3;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Main
{
    public static void main(String[] args)
    {
        final IntPredicate isEven = numb -> numb%2 == 0;
        final IntPredicate isPositive = numb -> numb >= 0;
        final IntPredicate isZero = numb -> numb == 0;
        final Predicate<String> isNull = str -> str == null;

        //isEven
        System.out.println("isEven");
        System.out.println(isEven.test(10));
        System.out.println(isEven.test(5));

        //isPositive
        System.out.println("\nisPositive");
        System.out.println(isPositive.test(10));
        System.out.println(isPositive.test(-5));

        //isZero
        System.out.println("\nisZero");
        System.out.println(isZero.test(10));
        System.out.println(isZero.test(0));

        //isNull
        System.out.println("\nisNull");
        System.out.println(isNull.test(null));
        System.out.println(isNull.test("ndNull"));

        //Combination
        System.out.println("\nCombination");
        IntPredicate pre = isPositive.and(isEven);
        System.out.println(pre.test(10));
        System.out.println(pre.test(9));
        System.out.println(pre.test(-6));
        System.out.println(pre.test(-5));

        System.out.println();
        pre = isPositive.and(isEven.negate());
        System.out.println(pre.test(10));
        System.out.println(pre.test(9));
        System.out.println(pre.test(-6));
        System.out.println(pre.test(-5));


    }
}
