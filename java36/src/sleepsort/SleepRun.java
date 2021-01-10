package sleepsort;

import java.util.Random;

public class SleepRun {

	public static void main(String[] args) {
		int[] array = new int[100];
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(1000);
		}
		for(int i=0; i<100; i++) {
			SleepSort s = new SleepSort(array[i]);
			s.start();
		}
	}

}
