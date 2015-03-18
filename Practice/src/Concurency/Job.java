package Concurency;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Job implements Delayed {

	private Runnable job;
    private TimeUnit timeUnit;
    private long delay;
    private long trigger;

    public Job(Runnable job, long delay, TimeUnit timeUnit) {
	this.job = job;
	this.delay = delay;
	this.timeUnit = timeUnit;
	this.trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delay, timeUnit);
    }
	
	
	@Override
	 public int compareTo(Delayed obj) {
		Job that = (Job)obj;
		if (this.trigger - that.trigger < 0) {
		    return -1;
		} else if (this.trigger - that.trigger > 0) {
		    return 1;
		} else {
		    return 0;
		}
	 }


	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
	    }
	    
	public Runnable job() {
		return job;
	}
}
