package thread2;

public class PlusThread extends Thread {
	
	@Override
	public void run() {
		for(int i=0; i<1000; i++)
			System.out.println("����: " + (i+1));
	}
}
