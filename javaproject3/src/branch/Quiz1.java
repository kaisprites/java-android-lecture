package branch;
import java.util.Scanner;
public class Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//숫자 문자열을 입력받아 int형으로 형변환
		System.out.print("int num1 = ");
		int num1 = Integer.parseInt(sc.next());
		System.out.print("int num2 = ");
		int num2 = Integer.parseInt(sc.next());
		
		//연산자 문자열을 입력받아 char형에 맞게 문자열 자르기
		System.out.println("char operator = ");
		char operator = sc.next().charAt(0);
		
		//operator의 내용을 가지고 switch
		switch (operator) {
		case '+':
			System.out.println(num1 + "" + operator + "" + num2 + "=" + (num1+num2) );
			break;
		case '-':
			System.out.println(num1 + "" + operator + "" + num2 + "=" + (num1-num2) );
			break;
		case '*':
			System.out.println(num1 + "" + operator + "" + num2 + "=" + (num1*num2) );
			break;
		case '/':
			System.out.println(num1 + "" + operator + "" + num2 + "=" + (num1/num2) );
			break;
		default:
			System.out.println("연산자 오류");
		}
	}
}
