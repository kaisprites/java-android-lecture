package thread;

public class StarThread extends Thread {
	
	@Override
	public void run () {
		for (int i=0; i<1000; i++) {
			System.out.print("¡Ú");
		}
	}
}
