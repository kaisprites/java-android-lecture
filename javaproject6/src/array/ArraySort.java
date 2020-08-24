package array;

import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] age = {99,10,100,88,33,24,10,77};
//		Arrays.sort(age);
//		for (int x : age) {
//			System.out.println(x+ " ");
//		}
		
		//배열은 깊은 복사
		int[] age2 = age.clone();
		
		for(int x: age) {
			System.out.print(x + " ");
		}
		System.out.println("\n------------------------");
		for(int x: age2) {
			System.out.print(x + " ");
		}
	}

}
