package at.reiters.bsp1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReader
{
    public static List<Weapon> readCSV(String file)
    {
        ArrayList<Weapon> weapons = new ArrayList<>();
        try
        {
            weapons = (ArrayList<Weapon>) Files.readAllLines(Paths.get(file)).stream().map((str) -> Weapon.deserialize(str)).filter((w) -> w != null).collect((Collectors.toList()));
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
        return weapons;
    }

    public static String getHeading(String file)
    {
        String ret = null;
        try(Scanner scanner = new Scanner(new File(file)))
        {
            String str = scanner.nextLine();
            Weapon wp = Weapon.deserialize(str);
            if(wp == null)
            {
                ret = str;
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        return ret;
    }
}
