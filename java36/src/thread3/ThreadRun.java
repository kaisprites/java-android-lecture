package thread3;

public class ThreadRun {

	public static void main(String[] args) {
		CounterThread c = new CounterThread();
		ImgThread i = new ImgThread();
		TimerThread t = new TimerThread();
		c.start();
		i.start();
		t.start();
	}

}
