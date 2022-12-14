package at.reiters190295.bsp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

public class UserFunctions
{
    private static Scanner scanner = new Scanner(System.in);

    public static int[] askUser()
    {
        int[] arr = new int[2];
        System.out.print("chunks> ");
        arr[0] = Integer.parseInt(scanner.nextLine());
        System.out.print("divider> ");
        arr[1] = Integer.parseInt(scanner.nextLine());
        System.out.println();
        return arr;
    }

    public static void divideInChunks(List<Integer> list, int chunks, int divider)
    {
        List<Integer> chunkInts = new ArrayList<>();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(chunks/2);

        int amount = list.size() / chunks;
        for(int i : list)
        {
            chunkInts.add(i);
            if(chunkInts.size() == amount)
            {
                executor.execute(new Chunk(new ArrayList<Integer>(chunkInts), divider));
                chunkInts.clear();
            }
        }

        if(!chunkInts.isEmpty())
        {
            executor.execute(new Chunk(new ArrayList<Integer>(chunkInts), divider));
        }
        executor.shutdown();
    }
}
