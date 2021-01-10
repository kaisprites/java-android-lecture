package codetest;

import java.util.Scanner;

public class Byte80Printer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력: ");
		char[] c = sc.nextLine().toCharArray();
		int size = 0;
		for(int i=0; i<c.length; i++) {
			if(c[i] >= '가' && c[i] <= '힣') size+=2;
			else size+=1;
			if(size >= 80) {
				System.out.println("80byte 넘었습니다! " + String.valueOf(c));
				break;
			}
		}
	}
}
