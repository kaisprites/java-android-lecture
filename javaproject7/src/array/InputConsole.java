package array;

import java.util.Scanner;

public class InputConsole {

	public static void main(String[] args) {
		
		//입력의  datatype은 string
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력: ");
		String x = sc.next();
		System.out.println(x);
		
		//입력한 데이터를 형변환해주는 메소드
		System.out.print("나이를 입력: ");
		int age = sc.nextInt();
		System.out.println(age);
		
		System.out.print("현재 키 입력: ");
		double height = sc.nextDouble();
		System.out.println(height);
		System.out.println("내년 키: "+(height+20.0));
		
		System.out.print("비 오나요? ");
		boolean raining = sc.nextBoolean();
		System.out.println(raining ? "우산을 가져가자" : "우산을 두고가자");
		
		System.out.print("당신의 목표는");
		sc.nextLine();
		String purpose = sc.nextLine();
		System.out.println(purpose);
	}

}
