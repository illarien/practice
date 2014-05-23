package Quizes;

public class One {

	public class ThreadOne implements Runnable {
		int i;
		public ThreadOne( final int i){
			this.i = i;
		}
		@Override
		public void run() {
			for(int j = 1; j < 10; j++) {
				System.out.println("T" + i + ": " + j);
				try {
					//Thread.sleep(1000);
				}
				catch (Exception e) {
					System.out.println("Fail.");
				}
				
			}
		}
	}
	
	public class ThreadTwo implements Runnable {
		@Override
		public void run() {
			for(int i=0; i<20; i++) {
				System.out.println("xxxxx");
				try {
					Thread.sleep(1);
				} catch (Exception e) {}
			}
		}
	}
	
	
	public static void main(String[] args) {
		One x = new One();
		
		// Runnable,but not thread 
		(x.new ThreadOne(3)).run();
		
		// Thread w/o declaration
		new Thread(x.new ThreadTwo()).start();
		// thread with decl and inicialization
		Thread t1 = new Thread(x.new ThreadOne(1));
		Thread t2 = new Thread(x.new ThreadOne(2));
		
		
		(new Thread( new Runnable() {
			@Override
			public void run() {
				for(int j = 1; j < 10; j++) {
					System.out.println("T--------3: " + " " + j);
					try {
						//Thread.sleep(1000);
					}
					catch (Exception e) {
						System.out.println("Fail.");
					}
					
				}
				
			}
		})).start();
		
		t2.start();
		t1.start();	
			
	}

}

