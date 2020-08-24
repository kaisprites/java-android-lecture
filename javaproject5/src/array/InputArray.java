package array;

import javax.swing.JOptionPane;

import java.util.Scanner;

public class InputArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] data = new int[3];
		//컴파일러는 for의 조건이 처음부터 틀릴 가능성을 상정
		//data를 초기화하지 않으면 에러를 띄운다  
		for (int i=0; i<3; i++) {
			//변수선언의 위치에 따라서 변수가 유효한 지역이 있다
			data[i] = Integer.parseInt(sc.next());
		}
		for(int x : data) System.out.println(x);
	}
}
