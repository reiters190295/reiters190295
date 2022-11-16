/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.concurrent.ArrayBlockingQueue;

public class Storage { 
    private final ArrayBlockingQueue<Integer> queue;
    
    private int fetchedCounter = 0;
    private int storedCounter = 0;
    private int underflowCounter = 0;
    private int overflowCounter = 0;
    private boolean productionComplete = false;
    
    public Storage()
    {
        queue = new ArrayBlockingQueue<Integer>(10);
    }
    
    public synchronized boolean put(Integer data) throws InterruptedException {
        if(queue.remainingCapacity() > 0)
        {
            queue.put(data);
            storedCounter++;
            return true;
        }
        else
        {
            overflowCounter++;
        }
        return false;
    }
 
    public synchronized Integer get() {
        int i;
        if(queue.remainingCapacity() < 10)
        {
            fetchedCounter++;
            return queue.poll();
        }
        else
        {
            underflowCounter++;
        }
        return -1;
    }


    //TDOO: Welche methoden müssen synchronized sein
    public synchronized boolean isProductionComplete() {
        return productionComplete;
    }

    public void setProductionComplete() {
        productionComplete = true;
    }

    public int getFetchedCounter() {
        return fetchedCounter;
    }

    public int getStoredCounter() {
        return storedCounter;
    }

    public int getUnderflowCounter() {
        return underflowCounter;
    }

    public int getOverflowCounter() {
        return overflowCounter;
    }
}
