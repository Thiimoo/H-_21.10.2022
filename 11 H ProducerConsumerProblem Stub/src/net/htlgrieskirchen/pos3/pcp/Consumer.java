/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.ArrayList;
import java.util.List;


public class Consumer extends Thread {
    private final String name;
    private final Storage storage;
    private final int sleepTime;
    
    private final List<Integer> received;
    private boolean running;

    public Consumer(String name, Storage storage, int sleepTime) {
        this.name = name;
        this.storage = storage;
        this.sleepTime = sleepTime;
        received = new ArrayList<>();
    }

    @Override
    public void run()
    {
        Integer temp;
        while (!storage.isProductionComplete()|| !storage.getQueue().isEmpty())
        {
            synchronized (storage)
            {
                temp = storage.get();
            }

            if (temp!= null)
            {
                received.add(temp);
            }
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Integer> getReceived() {
        return received;
    }
}

