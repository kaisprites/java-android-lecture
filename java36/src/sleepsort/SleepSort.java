package sleepsort;

public class SleepSort extends Thread {
	int i;
	public SleepSort(int i) {
		this.i = i;
	}
	public void run() {
		try {
			Thread.sleep(i);
			System.out.println(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
