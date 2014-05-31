package Threads;

public class Operations {

	static void transfer(Account acc1, Account acc2, int amount) 
			throws Exception {
		if (acc1.getBalance() < amount) throw new Exception();
		
		if (acc1.getLock().tryLock()) {
			try {
				System.out.println("Lock acc1 " + acc1);
				Thread.sleep(1000);
				if (acc2.getLock().tryLock()) {
					try {
						System.out.println("Lock acc2 " + acc2);
						// ---
						acc1.withdraw(amount);
						System.out.println("withdraw done");
						acc2.deposit(amount);
						System.out.println("deposit done");
					} finally {
						acc2.getLock().unlock();
					}
				} else {
					System.out.println("Lock for acc2 failed " + acc2);
				}
			} finally {
				acc1.getLock().unlock();
			}				
		} else {
			System.out.println("Lock for acc1 failed " + acc1);
		}
	}
	
	
	public static void main(String[] args) {
		final Account a = new Account (1000);
		final Account b = new Account (2000);
		
		new Thread ( new Runnable() {
			public void run() {
				try {
					transfer(a, b, 500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		try {
			transfer(b, a, 300);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
