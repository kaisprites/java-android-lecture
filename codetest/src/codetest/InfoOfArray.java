package codetest;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/* 배열의 합계, 평균, 최대값, 최소값 */
public class InfoOfArray {
	public static void info(ArrayList<Integer> arr) {
		int sum, max, min;
		sum = 0;
		max = min = arr.get(0);
		for (int a : arr) {
			sum += a;
			if (a > max) max = a;
			if (a < min) min = a;
		}
		System.out.println(arr);
		System.out.println("합계: " + sum);
		System.out.println("평균: " + ((double)sum / arr.size()));
		System.out.println("최대값: " + max);
		System.out.println("최소값: " + min);
	}
	
	public static void main(String[] args) throws Exception {
		File f = new File("InfoOfArray.txt");
		Scanner sc = new Scanner(f);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while (true) {
			try {
				arr.add(sc.nextInt());
			} catch (Exception e) {
				break;
			}
		}
		info(arr);
		sc.close();
	}
}
