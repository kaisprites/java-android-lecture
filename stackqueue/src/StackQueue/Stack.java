package StackQueue;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Stack 구조는 LIFO(후입선출구조)로, 나중에 들어온 자료가 먼저 빠져나가는 구조이다.
 * Stack을 만들어보고, Postorder 방식으로 입력받은 수식을 처리해보자.
 * 
 * 6 + ( ( ( 30 + 8 ) / ( 2 + 17 ) ) * ( ( 6 - 3 ) * 20 ) )
 * 예를 들어, Inorder 방식으로 표현한 위 수식을 Postorder 방식으로 표현하면 다음과 같다:
 * 6 30 8 + 2 17 + / 6 3 - 20 * * +   
 * 
 * 이 식을 계산하려면 다음과 같이 진행한다.
 * 1) 숫자를 입력받으면 스택에 넣는다.
 * 2) 부호를 입력받으면 스택에서 숫자 2개를 꺼낸 뒤 연산한 결과를 다시 스택에 넣는다.
 * 
 * 실제로 계산하면 다음과 같다:
 * 1: 숫자를 넣는다. [6 30 8]
 * 2: 부호 +를 만났으므로 숫자 2개를 꺼내 연산하고(30+8=38) 다시 스택에 넣는다. [6 38]
 * 3: 숫자를 넣는다. [6 38 2 17]
 * 4: 부호 +를 만났으므로 숫자 2개를 꺼내 연산하고(2+17=19) 다시 스택에 넣는다. [6 38 19]
 * 5: / : [6 2] 
 * 6: 6 3 : [6 2 6 3]
 * 7: - : [6 2 3]
 * 8: 20 : [6 2 3 20]
 * 9: * : [6 2 60]
 * 10: * : [6 120]
 * 11: + : [126]
 * 따라서 이 수식의 결과값은 126이다.
 * 
 * 입력 예시: String[] array = { "6", "30", "8", "+", "2", "17", "+", "/", "6", "3", "-", "20", "*", "*", "+" }
 * 
 * 출력 예시:
 * 		입력받은 배열: String[] array
 * 		중간과정의 스택의 모습: int[] stack.toString()
 * 		최종 결과: stack[0] 
 */

public class Stack {
	//TODO: 스택 구조를 위한 변수 선언하기 (배열의 자료형은 int입니다)
	int[] stack;
	int ptr;
	
	public Stack() {
		stack = new int[1000];
		ptr = 0;
	}
	
	public void push(int item) {
		//TODO: 스택 구조의 push 메서드 정의하기
		stack[ptr] = item;
		ptr++;
	}
	
	public int pop() {
		//TODO: 스택 구조의 pop 메서드 정의하기
		--ptr;
		return stack[ptr];
	}
	
	//기타 메서드는 필요하다면 정의하세요(핵심은 push와 pop입니다)
	@Override
	public String toString() {
		String result = "[";
		for(int i=0; i<ptr; i++) {
			result = result + stack[i] + ", ";
		}
		result = result + "]";
		return result;
	}
	
	public static void postorderCalculator(String[] array) {
		//TODO: Postorder 방식으로 표현한 String 배열 array를 처리하여 결과값을 나타낸다.
		// 1) 숫자를 입력받으면 스택에 넣는다.
		// 2) 연산자 부호를 입력받으면 스택에서 숫자 2개를 꺼내 연산한 뒤 다시 스택에 넣는다.
		// 3) 배열을 최후까지 순회했을 때, 스택에 남은 마지막 값 하나가 연산결과이다.
		System.out.println(Arrays.toString(array));
		Stack stack = new Stack();
		for(String op : array) {
			System.out.println(stack + " " + op);
			switch(op) {
			case "+" :
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a + b);
				break;
			case "-" :
				int c = stack.pop();
				int d = stack.pop();
				stack.push(d - c);
				break;
			case "*" :
				int e = stack.pop();
				int f = stack.pop();
				stack.push(e * f);
				break;
			case "/" :
				int g = stack.pop();
				int h = stack.pop();
				stack.push(h / g);
				break;
			default:
				stack.push(Integer.parseInt(op));
				break;
			}
		}
		System.out.println("result: " + stack.pop());
	}
	
	public static void main(String[] args) throws Exception {
		for(int i=0; i<5; i++) {
			File file = new File("input" + i + ".txt");
			Scanner sc = new Scanner(file);
			String str = sc.nextLine();
			String[] array = str.split(" ");
			
			postorderCalculator(array);
			
			sc.close();
		}
	}
}
