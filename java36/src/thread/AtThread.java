package thread;

public class AtThread extends Thread {
	@Override
	public void run() {
		for (int i=0; i<1000; i++) {
			System.out.print("@");
		}
	}
}
