package array;

import java.util.Scanner;

public class ArrayQuiz4 {

	public static void main(String[] args) {
		//5개 정수배열을 만들어서 입력받아 프린트
		Scanner sc = new Scanner(System.in);
		int[] number = new int[5];
		for (int i = 0; i < number.length; i++) {
			System.out.print((i+1) + "번째 숫자: ");
			number[i] = sc.nextInt();
		}
		sc.close();
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
	}

}
