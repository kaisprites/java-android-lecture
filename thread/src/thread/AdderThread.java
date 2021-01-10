package thread;

public class AdderThread extends Thread{
	
	public void run () {
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
