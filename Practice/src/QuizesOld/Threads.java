package QuizesOld;

public class Threads extends Thread {
	
	public synchronized void run() {
		for (int i = 0; i <= 10; i++) {
        System.out.println("i::"+i);
		}
	}

public static void main(String[] args) {
    Threads obj = new Threads();

//    Thread t1 = new Thread((0, 3, 300);
 //   Thread t2 = new Thread(obj);
 //   Thread t3 = new Thread(obj);
    
    MyThread t1 = new MyThread(0, 3, 300);
    MyThread t2 = new MyThread(1, 3, 300);
    MyThread t3 = new MyThread(2, 3, 300);

    t1.start();
    t2.start();
    t3.start();
}
}

 class MyThread extends Thread
 {
   private int startIdx, nThreads, maxIdx;

   public MyThread(int s, int n, int m)
   {
      this.startIdx = s;
      this.nThreads = n;
      this.maxIdx = m;
   }

   @Override
   public void run()
   {
      for(int i = this.startIdx; i < this.maxIdx; i += this.nThreads)
      {
         System.out.println("[ID " + this.getId() + "] " + i);
      }
   }
 }