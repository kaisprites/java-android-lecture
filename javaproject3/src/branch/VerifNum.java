package branch;

import java.util.Scanner;

public class VerifNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("사원번호 입력:");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char mini = input.charAt(0);
		String num = input.substring(1);	//param을 1개만 쓰면 끝까지 따온다
		switch(mini)
		{
		case 'A': System.out.println("사원부서는 기획부입니다."); break;
		case 'B': System.out.println("사원부서는 총무부입니다."); break;
		case 'C': System.out.println("사원부서는 개발부입니다."); break;
		default: System.out.println("해당 부서 없음"); break;
		}
		System.out.println("사원고유번호는 ".concat(num).concat("입니다"));
		
	}

}
