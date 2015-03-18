package Concurency;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import static org.junit.Assert.*;

public class ClientServerTest {

    private DelayQueue<Job> queue = new DelayQueue<>();
    private Random rand = new Random(System.nanoTime());

    @Test
    public void testMultipleClientProcessTasks() {
    	ExecutorService exec = Executors.newCachedThreadPool();
    	for (int i = 0; i < 5; i++) {
    		exec.submit(new Runnable() {
    			@Override
    			public void run() {
    				Client client = new Client(queue);
    				client.addTask(new Runnable() {
    					@Override
    					public void run() {
    						try {
    							TimeUnit.SECONDS.sleep(1);
    						} catch (InterruptedException e) {
    							System.err.println(Thread.currentThread().getId() + ": " + e.getMessage());
    						}
    						System.out.println(Thread.currentThread().getId());
    					}
    				}, rand.nextInt(500), TimeUnit.MILLISECONDS);
    			}
    		});
    	}
	
    	exec.submit(new Runnable() {
    		@Override
    			public void run() {
    				Server server = new Server(queue);
    				server.processTasks();
    		}
    	});
	
    	try {
    		TimeUnit.SECONDS.sleep(8);
    	} catch (InterruptedException e) {}
//    	assertTrue(queue.isEmpty(), true);
    	exec.shutdownNow();
    }
}
