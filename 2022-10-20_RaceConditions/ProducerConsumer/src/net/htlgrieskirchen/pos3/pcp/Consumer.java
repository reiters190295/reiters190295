/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.ArrayList;
import java.util.List;


public class Consumer implements Runnable {
    private final String name;
    private final Storage storage;
    private final int sleepTime;
    
    private final List<Integer> received;
    private boolean running;
    
    public Consumer(String name, Storage storage, int sleepTime) {
        this.name = name;
        this.storage = storage;
        this.sleepTime = sleepTime;
        this.received = new ArrayList<>();
        running = true;
    }

    public List<Integer> getReceived() {
        return received;
    }

    @Override
    public void run()
    {
        while(running)
        {
            int i = storage.get();
            if(i != -1 )
            {
                received.add(i);
            }
            else
            {
                if(storage.isProductionComplete())
                {
                    running = false;
                }
            }
            try
            {
                Thread.sleep(sleepTime);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }

        }
    }
}

