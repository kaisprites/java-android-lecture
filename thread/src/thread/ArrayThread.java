package thread;

public class ArrayThread extends Thread {
	public void run() {
		try {
			int[] array = new int[1000]; 
			for(int i=0; i<1000; i++) {
				array[i] = i;
			}
			for(int i=0; i<1000; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("스레드 1 실행종료");
		}
	}
}
