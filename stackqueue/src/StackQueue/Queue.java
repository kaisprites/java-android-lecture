package StackQueue;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Queue 구조는 FIFO(선입선출구조)로, 먼저 들어가는 자료가 먼저 빠져나오는 구조이다.
 * Queue 구조를 만들어보고, 요구사항으로 주어진 메서드들을 구현해보자.
 * 
 * 메서드는 다음과 같다.
 * push x:	정수 x를 입력받아 큐에 넣는다. 만약 큐가 꽉 차서 정수를 못 넣었다면 push failed를 출력한다.
 * pop: 	큐에서 정수를 뽑는다. 뽑을 정수가 없다면 -1을 반환한다.
 * size:	큐에 들어 있는 정수의 숫자를 출력한다.
 * dump:	큐에 들어 있는 정수들을 출력한다.
 * front:	큐에 들어 있는 가장 앞의 정수를 출력한다. 정수가 없다면 -1을 반환한다.
 * rear:	큐에 들어 있는 가장 뒤의 정수를 출력한다. 정수가 없다면 -1을 반환한다.
 * isEmpty:	큐가 비어있는지 판단하여 boolean 값을 출력한다. 
 * clear:	큐를 비운다.
 * 
 * 메서드 이름으로 된 명령어 문자열 배열 op[]을 입력값으로 받아, 명령어 문자열을 해석하여 적절한 메서드를 실행한다.
 * 실행 결과를 한 줄에 하나씩 출력한다. 
 * 
 * 입력값 예시: {	'push 1', 'push 2', 'front', 'back', 'size',
 * 			  	'isEmpty', 'dump', 'pop', 'pop', 'pop', 'size',
 * 				'isEmpty', 'pop', 'push 3', 'isEmpty', 'front', 'clear'}
 * 
 * 출력 예시:	push 1
 * 			push 2
 * 			1
 * 			2
 * 			2
 * 			false
 * 			[1, 2]
 * 			1
 * 			2
 * 			-1
 * 			0
 * 			true
 * 			-1
 * 			push 3
 * 			false
 * 			3
 * 			clear
 * 
 * (출처: 백준 https://www.acmicpc.net/problem/10845 에서 약간 변형)
 */
public class Queue {
	//TODO: 큐 구조에 필요한 변수 선언
	final static int MAX_QUEUE_LENGTH = 10;
	int[] queue;
	int front;
	int rear;
	boolean isEmpty;
	
	public Queue(){
		//TODO: 큐 구조의 적절한 생성자 정의하기
		queue = new int[MAX_QUEUE_LENGTH];
		front = 0;
		rear = 0;
		isEmpty = true;
	}
	
	public void push(int x) {
		//TODO: 큐 구조의 push 메서드 정의하기
		//front와 rear가 같고 empty가 아니라면=꽉차 있지 않으면
		if(!(front == rear && !isEmpty)) {	
			queue[rear] = x;
			rear = (rear + 1) % MAX_QUEUE_LENGTH;
			isEmpty = false;
		}
		else {
			System.out.println("push failed");
		}
	}
	
	public int pop() {
		//TODO: 큐 구조의 pop 메서드 정의하기
		//비어 있지 않으면
		if(!isEmpty) {
			int result = queue[front];
			front = (front + 1) % MAX_QUEUE_LENGTH;
			if(front == rear) isEmpty = true;
			return result;
		}
		return -1;
	}
	
	public int size() {
		//TODO: 큐에 들어간 정수의 숫자를 출력하는 size 메서드 정의하기
		if (front == rear && !isEmpty) return MAX_QUEUE_LENGTH;
		else return (MAX_QUEUE_LENGTH - front + rear) % MAX_QUEUE_LENGTH;
	}
	
	public String dump() {
		//TODO: 큐에 들어간 정수들을 모두 출력하는 dump 메서드 정의하기
		int i = front;
		String result = "[";
		if(isEmpty) return "[]";
		else {
			do {
				result = result + queue[i] + ", ";
				i = (i + 1) % MAX_QUEUE_LENGTH;
			} while (i != rear);
		}
		result = result + "]";
		return result;
	}
	
	public int front () {
		if(isEmpty) return -1;
		else return queue[front];
	}
	
	public int rear () {
		if(isEmpty) return -1;
		else return queue[(rear-1+MAX_QUEUE_LENGTH)%MAX_QUEUE_LENGTH];
	}
	
	public boolean isEmpty() {
		//TODO: 큐에 정수가 들어있으면 true를 아니면 false를 출력하는 isEmpty 메서드 정의하기
		return isEmpty;
	}
	
	public void clear() {
		//TODO: 큐를 비우는 clear 메서드 정의하기
		queue = new int[MAX_QUEUE_LENGTH];
		front = 0;
		rear = 0;
		isEmpty = true;
	}
	
	public static void queueDriver (String[] ops) {
		//TODO: 명령어 문자열을 입력받아 메서드를 실행하고 결과를 출력하기
		Queue q = new Queue();
		System.out.println(Arrays.toString(ops));
		for (String op : ops) {
			switch(op) {
			case "pop":
				System.out.println(op + ": " + q.pop());
				break;
			case "size":
				System.out.println(op + ": " + q.size());
				break;
			case "dump":
				System.out.println(op + ": " + q.dump());
				break;
			case "front":
				System.out.println(op + ": " + q.front());
				break;
			case "back":
			case "rear":
				System.out.println(op + ": " + q.rear());
				break;
			case "isEmpty":
				System.out.println(op + ": " + q.isEmpty());
				break;
			case "clear":
				q.clear();
				System.out.println(op + ": " + "clear");
				break;
			default:
				int num = Integer.parseInt(op.substring(5));
				q.push(num);
				System.out.println(op + ": " + op);
				break;
			}
		}
	}
//	 * push x:	정수 x를 입력받아 큐에 넣는다. 만약 큐가 꽉 차서 정수를 못 넣었다면 push failed를 출력한다.
//	 * pop: 	큐에서 정수를 뽑는다. 뽑을 정수가 없다면 -1을 반환한다.
//	 * size:	큐에 들어 있는 정수의 숫자를 출력한다.
//	 * dump:	큐에 들어 있는 정수들을 출력한다.
//	 * front:	큐에 들어 있는 가장 앞의 정수를 출력한다. 정수가 없다면 -1을 반환한다.
//	 * rear:	큐에 들어 있는 가장 뒤의 정수를 출력한다. 정수가 없다면 -1을 반환한다.
//	 * isEmpty:	큐가 비어있는지 판단하여 boolean 값을 출력한다. 
//	 * clear:	큐를 비운다.
	
	public static void main(String[] args) throws Exception {
		for(int i=5; i<8; i++) {
			File file = new File("input" + i + ".txt");
			Scanner sc = new Scanner(file);
			int length = sc.nextInt();
			String[] op = new String[length];
			sc.nextLine();
			for(int j=0; j<length; j++) {
				op[j] = sc.nextLine();
			}
			queueDriver(op);
			
			sc.close();
		}
	}
}
