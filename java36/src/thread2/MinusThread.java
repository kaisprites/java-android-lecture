package thread2;

public class MinusThread extends Thread {

	@Override
	public void run() {
		for(int i=0; i<1000; i++)
			System.out.println("����: " + (1000-i));
	}
}
