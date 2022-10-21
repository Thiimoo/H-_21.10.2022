/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.concurrent.ArrayBlockingQueue;

public class Storage { 
    private final ArrayBlockingQueue<Integer> queue;
    
    private int fetchedCounter;
    private int storedCounter;
    private int underflowCounter;
    private int overflowCounter;
    private boolean productionComplete;

    public Storage(int fetchedCounter, int storedCounter, int underflowCounter, int overflowCounter, boolean productionComplete) {
        this.queue = new ArrayBlockingQueue<>(400);
        this.fetchedCounter = fetchedCounter;
        this.storedCounter = storedCounter;
        this.underflowCounter = underflowCounter;
        this.overflowCounter = overflowCounter;
        this.productionComplete = productionComplete;
    }

    public Storage()
    {
        this.queue = new ArrayBlockingQueue<>(400);
    }

    public synchronized boolean put(Integer data) throws InterruptedException {

        if (queue.offer(data))
        {
            storedCounter++;
            return true;
        }
        else
        {
            overflowCounter++;
            return true;
        }
    }
 
    public synchronized Integer get() {
        return this.queue.element();
    }

    public boolean isProductionComplete() {
        return this.productionComplete;
    }

    public void setProductionComplete() {
        this.productionComplete = true;
    }

    public int getFetchedCounter() {
        return this.fetchedCounter;
    }

    public int getStoredCounter() {
        return this.storedCounter;
    }

    public int getUnderflowCounter() {
        return this.underflowCounter;
    }

    public int getOverflowCounter() {
        return this.overflowCounter;
    }
}
