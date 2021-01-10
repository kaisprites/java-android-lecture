package thread3;

import java.util.Date;

public class TimerThread extends Thread {
	
	//@ : Annotation
	//@Component => create new object
	@Override
	public void run () {
		for(int i=0; i<300; i++) {
			Date date = new Date();
			System.out.println(date);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
