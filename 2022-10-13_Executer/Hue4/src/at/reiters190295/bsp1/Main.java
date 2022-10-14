package at.reiters190295.bsp1;

import java.math.BigDecimal;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        List<Integer> numbers = CSVReader.readCsvToInteger("numbers.csv");
        int[] arr = UserFunctions.askUser();
        UserFunctions.divideInChunks(numbers, arr[0], arr[1]);
    }
}
