package thread;

public class ThreadFromInterface implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			System.out.println("add>>" + i);

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
