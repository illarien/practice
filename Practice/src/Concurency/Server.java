package Concurency;

import java.util.concurrent.DelayQueue;

public class Server {
    
    private DelayQueue<Job> queue;

    public Server (DelayQueue<Job> queue) {
    	this.queue = queue;
    }

    public void processTasks() {
    	while(!Thread.interrupted()) {
    		try {
    			queue.take().job().run();
    		} catch (InterruptedException e) {
    			System.err.println(e.getMessage());
    		}
    	}
    }

}
