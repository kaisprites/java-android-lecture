package thread;

public class ThreadMain4 {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<1000; i++) {
					System.out.println("*" + i);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<1000; i++) {
					System.out.println("$" + i);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} 
		});
		
		thread1.start();
		thread2.start();
	}
}
