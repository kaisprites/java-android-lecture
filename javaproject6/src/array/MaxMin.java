package array;

import java.util.Random;

public class MaxMin {

	public static void main(String[] args) {
		// max, min, max위치, max개수 찾기
		Random r = new Random();
		int[] number = new int[100];
		int max = 0, min = number.length, maxidx = 0, count = 0;
		
		for(int i=0; i<number.length; i++) {
			//배열만들기와 max min 찾기를 한꺼번에
			number[i] = r.nextInt((int)(number.length*(10)));
			
			//만들어진 숫자가 max보다 크면 idx재지정, count를 1로
			if(number[i]>max) {
				max = number[i];
				maxidx = i;
				count = 1;
			}
			
			//만들어진 숫자가 max와 같으면 count 증가(max의 갯수가 늘어남)
			else if(number[i]==max) count++;
			
			//min판정
			if(number[i]<min) min = number[i];
		}
		//결과출력
		System.out.println("max: "+max+" maxidx: "+maxidx+" maxcount: "+count+"\nmin: "+min);
	}

}
