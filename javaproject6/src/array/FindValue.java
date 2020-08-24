package array;

import java.util.Random;

public class FindValue {
	public static void main(String[] args) {
		Random r = new Random();
		int[] number = new int[1000];
		//배열에 수채우기
		for(int i=0; i<number.length; i++) {
			number[i] = r.nextInt(1000); //0 부터 999 까지
		}
		
		//다찍어보기
		for (int i = 0; i < number.length; i++) {
			System.out.println(i + ": "+ number[i]);
		}
		
		//100을 찾으면 위치 알려주고 못 찾으면 없다고 알려주기
		int target = 100;
		int count = 0;
		int max=0;
		for (int i = 0; i < number.length; i++) {
			if(number[i] == target) {
				System.out.println(target + "의 위치는: " + i);
				count++;
				 
			}
			max = (max<number[i]) ? number[i] : max;                                                                                                                                                                                                                                                                                                                                                                                                  
		}
		if(count == 0) System.out.println(target + " 없음");
		else System.out.println(target +"의 수는 " + count);
		System.out.println("최대값: " + max);
	}
}
