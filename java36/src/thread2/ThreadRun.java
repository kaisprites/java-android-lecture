package thread2;

public class ThreadRun {

	public static void main(String[] args) {
		MinusThread m = new MinusThread();
		PlusThread p = new PlusThread();
		p.start();
		m.start();
	}

}
