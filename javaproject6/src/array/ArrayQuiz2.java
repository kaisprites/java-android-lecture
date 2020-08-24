package array;

import java.util.Scanner;

public class ArrayQuiz2 {

	public static void main(String[] args) {
		//String 3개 입력받아서 출력
		String[] stringArray = new String[3];
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<stringArray.length; i++) {
			stringArray[i] = sc.next();
		}
		sc.close();
		System.out.println(stringArray[0] + "보다는 " + stringArray[1]);
	}

}
