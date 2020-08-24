package array;

import java.util.Random;

public class InputArray3 {
	public static void main(String[] args) {
		Random r = new Random();
		int[] num = new int[100];
		for(int i=0; i<100; i++) num[i] = Math.abs(r.nextInt()%300);
		for(int x : num) {
			System.out.print(x + " ");
		}
		System.out.println("\n"+(num[0]+num[99]));
	}
}
