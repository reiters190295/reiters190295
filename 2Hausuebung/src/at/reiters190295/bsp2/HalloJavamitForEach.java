package at.reiters190295.bsp2;

import java.util.ArrayList;

public class HalloJavamitForEach
{
    private ArrayList<String> list;

    public HalloJavamitForEach()
    {
        list = new ArrayList<>();
        list.add("Hallo");
        list.add("Welt");
    }

    public void print()
    {
        for(String str : list)
        {
            System.out.println(str);
        }

        list.forEach(str -> {
            System.out.println(str);
        });

        list.forEach(System.out::println);
    }
}
