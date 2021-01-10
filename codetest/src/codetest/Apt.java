package codetest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Apt {
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		try {
			File file = new File("input.txt");
			Scanner sc = new Scanner(file);
			while (true) {	// 새로운 nextline을 받지 못하면 종료
				String str;
				try {
					str = sc.nextLine();
				} catch (NoSuchElementException e) {
					break;
				}
				String floorNum = str.substring(0, str.indexOf("(")-2); //층수 추출
				int count = 0, index = 0;
				while(true) {	//열린 창문 개수 세기: 'o'를 세기, 'o'를 찾지 못하면 종료
					index = str.indexOf("o", index+1);
					if(index != -1) count++;
					else break;
				}
				map.put(floorNum, count);
			}
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int sum = 0;
		for (String floor : map.keySet()) {
			int floorsum = map.get(floor);
			sum += floorsum;
			System.out.println(floor + "층의 열린 창문: " + floorsum + "개");
		}
		System.out.println("총 열린 창문: " + sum + "개");
	}
}
