/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eaustria.webcrawler;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdk.swing.interop.SwingInterOpUtils;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.jsoup.Jsoup;
import org.jsoup.helper.ValidationException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author bmayr
 */

// Recursive Action for forkJoinFramework from Java7

public class LinkFinderAction extends RecursiveAction {

    private String url;
    private ILinkHandler cr;
    private Pattern pattern;


    /**
     * Used for statistics
     */
    private static final long t0 = System.nanoTime();

    public LinkFinderAction(String url, ILinkHandler cr)
    {
        this.url = url;
        this.cr = cr;
        pattern = Pattern.compile("^http");

    }

    @Override
    public void compute()
    {

        // ToDo:
        // 1. if crawler has not visited url yet:
        // 2. Create new list of recursiveActions
        // 3. Parse url
        // 4. extract all links from url
        // 5. add new Action for each sublink
        // 6. if size of crawler exceeds 500 -> print elapsed time for statistics
        // -> Do not forget to call ìnvokeAll on the actions!

        if(!cr.visited(url))
        {
            List<LinkFinderAction> actions = new ArrayList<>();
            System.out.println(url);
            try
            {
                Elements elements = Jsoup.connect(url).get().select("a");
                for(Element e : elements)
                {
                    String link = e.attr("abs:href").toString();
                    Matcher matcher = pattern.matcher(link);
                    if(matcher.find() && !link.isEmpty() && !cr.visited(link))
                    {
                        actions.add(new LinkFinderAction(link, cr));
                    }
                }
            }
            catch (IOException e)
            {
                System.err.println("Could not handle");
            }

            print();
            invokeAll(actions);

        }
    }

    private synchronized void print()
    {
        cr.addVisited(url);
        if(cr.size() > 500)
        {
            System.out.println("Finished: " + (System.nanoTime() - t0));
        }

    }

}


