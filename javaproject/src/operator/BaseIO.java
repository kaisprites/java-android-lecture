package operator;

import javax.swing.JOptionPane;

public class BaseIO {

	public static void main(String[] args) {
		// 자주 사용하는 것은 부품의 대문자를 그대로 쓴다(클래스명)
		// 특정한 일을 전담하는 부품을 만들어 처리할때 부품을 지정함(클래스)
		String name = JOptionPane.showInputDialog("당신의 이름은");			
		System.out.println(name);
		//"당신의 이름은"이라는 문자열을 포함하는 input 대화상자를 출력하여 입력값을 함수 반환값으로서 name에 대입 후 name 출력
		
		String age = JOptionPane.showInputDialog("당신의 나이는");			//
		System.out.println(age);										//
		//키보드로 입력한 문자열은 String
		//int형의 숫자를 받기 위해서는 일단 String을 받아 int로 변환할 필요가 있다
		int age2 = Integer.parseInt(age);
		int lastAge = age2 - 1; //int형으로 형변환이 이루어졌음을 확인하기 위한 int연산
		System.out.println("당신 작년 나이는: " + lastAge);
		
	}

}
