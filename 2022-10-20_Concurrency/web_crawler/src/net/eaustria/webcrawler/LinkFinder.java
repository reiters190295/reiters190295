/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eaustria.webcrawler;

/**
 *
 * @author bmayr
 */
import java.io.IOException;
import java.net.URL;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.ImageTag;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkFinder implements Runnable {

    private String url;
    private ILinkHandler linkHandler;
    private Pattern pattern;
    /**
     * Used fot statistics
     */
    private static final long t0 = System.nanoTime();

    public LinkFinder(String url, ILinkHandler handler) {
        this.url = url;
        this.linkHandler = handler;
        pattern = Pattern.compile("^http");
    }

    @Override
    public void run()
    {
        getSimpleLinks(url);
    }

    private void getSimpleLinks(String url)
    {
        // ToDo: Implement
        // 1. if url not already visited, visit url with linkHandler
        // 2. get url and Parse Website
        // 3. extract all URLs and add url to list of urls which should be visited
        //    only if link is not empty and url has not been visited before
        // 4. If size of link handler equals 500 -> print time elapsed for statistics

        if(!linkHandler.visited(url))
        {
            System.out.println(url);
            List<String> links = new ArrayList<>();
            try
            {
                Elements elements = Jsoup.connect(url).get().select("a");
                for (Element e : elements)
                {
                    String link = e.attr("abs:href").toString();
                    Matcher matcher = pattern.matcher(link);
                    if (matcher.find() && !link.isEmpty() && !linkHandler.visited(link))
                    {
                        links.add(link);
                    }
                }
            } catch (IOException e)
            {
                System.err.println("Could not handle");
            }
            print();

            for (String link : links)
            {
                try
                {
                    linkHandler.queueLink(link);
                }
                catch (Exception e)
                {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private synchronized void print()
    {
        linkHandler.addVisited(url);
        if (linkHandler.size() > 500) {
            System.out.println("Finished: " + (System.nanoTime() - t0));
        }
    }
}

