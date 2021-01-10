package thread3;

public class CounterThread extends Thread {
	@Override
	public void run() {
		for (int i=500; i>0; i--) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generDated catch block
				e.printStackTrace();
			}
		}
	}
}
