package at.reiters190295.bsp3;

import com.sun.jdi.IntegerValue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JavaStreamsTester
{
    public static void main(String[] args)
    {
        List<String> strings = new ArrayList<>();
        strings.add("A");strings.add("BGG");strings.add("");
        strings.add("C");strings.add("");strings.add("DGGG");
        strings.add("");strings.add("");strings.add("EGG");

        System.out.println("EmptyStrings: " + getCountEmptyString(strings));
        System.out.println("Length3: " + getCountLength3(strings));
        System.out.println("deleteEmptyStrings: " + deleteEmptyStrings(strings));
        System.out.println("getMergedString: " + getMergedString(strings, "-"));

        List<Integer> ints = new ArrayList<>();
        ints.add(1);ints.add(2);ints.add(3);
        ints.add(4);ints.add(5);ints.add(6);
        System.out.println("Squares: " + getSquares(ints));
        System.out.println("max:" + getMax(ints));
        System.out.println("min:" + getMin(ints));
        System.out.println("sum:" + getSum(ints));
        System.out.println("average:" + getAverage(ints));
    }


    private static int getCountEmptyString(List<String> strings)
    {
        List<String> list = strings.stream().filter(String::isEmpty).collect(Collectors.toList());
        return list.size();
    }

    private static int getCountLength3(List<String> strings)
    {
        return strings.stream().filter(str -> str.length() == 3).collect(Collectors.toList()).size();
    }

    private static List<String> deleteEmptyStrings(List<String> strings)
    {
        return strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
    }

    private static String getMergedString(List<String> strings, String separator)
    {
        return strings.stream().reduce("", (str1, str2) -> str1+separator+str2);
    }

    private static List<Integer> getSquares(List<Integer> numbers)
    {
        return numbers.stream().map(i -> i*i).collect(Collectors.toList());
    }

    private static int getMax(List<Integer> numbers)
    {
        return numbers.stream().max(Comparator.comparingInt(i -> i)).get();
    }

    private static int getMin(List<Integer> numbers)
    {
        return numbers.stream().min(Comparator.comparingInt(i -> i)).get();
    }

    private static int getSum(List<Integer> numbers)
    {
        return numbers.stream().reduce(0, (i1, i2) -> i1 + i2);
    }

    private static int getAverage(List<Integer> numbers)
    {
        return getSum(numbers) / numbers.size();
    }
}
