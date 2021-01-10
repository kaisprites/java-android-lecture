package thread;

public class ThreadRun {

	public static void main(String[] args) {
		StarThread star = new StarThread();
		AtThread at = new AtThread();
		star.run();
		at.run();
	}

}
