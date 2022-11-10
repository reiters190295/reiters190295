package net.eaustria.webcrawler;

import java.util.Scanner;

public class Main implements Runnable
{
    WebCrawler7 web7;
    Scanner scanner = new Scanner(System.in);


    public static void main(String[] args)
    {
        Thread thread = new Thread(new Main());
        thread.start();
    }

    private static void userInterface()
    {

    }

    @Override
    public void run()
    {
        int numb = 0;
        do
        {
            System.out.println("1 ... Number of visited websites");
            System.out.println("2 ... add new link/url to queue");
            System.out.println("3 ... mark link/url as visited");
            System.out.println("4 ... end\n");
            try
            {
                numb = Integer.parseInt(scanner.nextLine());
                if(numb > 1 || numb < 4)
                {
                    actions(numb);
                }
                else
                {
                    System.out.println("Please enter a valid number!\n");
                }
            }
            catch (NumberFormatException ex)
            {
                System.out.println("Please choose a number!\n");
            }

        }
        while(numb != 4);
    }

    private void actions(int number)
    {
        System.out.println("\n");
        switch (number)
        {
            case 1:
                if(web7 != null){
                    System.out.println("Number of visited links: " + web7.size());
                }
                else {
                    System.out.println("Number of visited links: " + 0);
                }

            case 2:
                System.out.println("Enter link/url: ");
                String link = scanner.nextLine();
                if(web7 != null){
                    web7 = new WebCrawler7(link, 10);
                }
                else {
                    try {
                        web7.queueLink(link);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }

            case 3:
                System.out.println("Mark link as visited: ");
                String url = scanner.nextLine();
                web7.addVisited(url);
        }
        System.out.println("\n\n");
    }
}
