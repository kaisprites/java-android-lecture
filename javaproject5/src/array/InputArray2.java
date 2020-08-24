package array;

import java.util.Random;

public class InputArray2 {

	public static void main(String[] args) {
		//랜덤값생성
		Random r = new Random();
		int[] data =  new int[100000];
		for(int i=0; i<100000; i++)
			data[i] = Math.abs((r.nextInt())%65536);
		for(int x : data) {
			System.out.println(x);
		}
	}

}
