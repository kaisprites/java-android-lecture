package thread;

public class ThreadMain {

	public static void main(String[] args) {
		AdderThread a = new AdderThread();
		SubtracterThread s = new SubtracterThread();
		
		a.start();
		s.start();
		
	}
}
