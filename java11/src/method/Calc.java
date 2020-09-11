package method;

public class Calc {

//	속성: 멤버변수 (전역변수, global변수, 클래스전체영역) => 자동초기화
	public String color; //참조형의 자동초기화 : null
	public int price;
	public int size; //기본형의 자동초기화: 0

//	동작: 메서드(입력값, 반환값 유무)
	
	public int plus (int a, int b) { return a + b; }
	public double plus (double a, double b) { return a + b; }
	public int minus (int a, int b) { return a - b; }
	
	public int mult(int a, int b) { return a * b; }
	public double mult(double a, double b) { return a * b; }
	public double div(double a, double b) { return a / b; }
	}