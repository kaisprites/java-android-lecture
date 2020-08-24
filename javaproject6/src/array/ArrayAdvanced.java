package array;

import java.util.Scanner;

public class ArrayAdvanced {

	public static void main(String[] args) {
		// 숫자 5개를 받아서 평균을 구하는 예제
		// 사실 평균을 구하는 것뿐이라면 배열을 굳이 쓸 필요도 없다는데
		Scanner sc = new Scanner(System.in);
		int[] input = new int[5];
		int sum = 0;
		
		for (int i=0; i<input.length; i++) {
			System.out.print((i+1)+"th number: ");
			input[i] = sc.nextInt();
			sum += input[i];
		}
		
		sc.close();
		System.out.println(sum/5);
	}

}
