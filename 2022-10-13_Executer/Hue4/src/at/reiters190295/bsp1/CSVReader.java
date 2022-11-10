package at.reiters190295.bsp1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader
{
    public static List<Integer> readCsvToInteger(String file)
    {
        List<Integer> intNumbers = new ArrayList<>();
        try
        {
           List<Integer[]> strings = Files.readAllLines(Paths.get(file)).stream()
                    .map(str -> str.split(":"))
                    .map(arr -> Arrays.stream(arr)
                            .filter(str -> {
                                String res = str.replaceAll(("\\D"),"");
                                if(res.length() == 0 || res.length() != str.length())
                                    return false;
                                return true;
                            })
                            .map(Integer::parseInt)
                            .toArray(Integer[]::new)
                            //test
                    )
                   .collect(Collectors.toList());

           strings.forEach(x -> Collections.addAll(intNumbers, x));
           //intNumbers.forEach(System.out::println);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return intNumbers;
    }
}
