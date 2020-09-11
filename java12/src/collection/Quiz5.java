package collection;

import java.util.HashSet;
import java.util.Random;

public class Quiz5 {

	public static void main(String[] args) {
		HashSet<String> dest = new HashSet<String>();
		String[] dest_list = {"유럽", "일본", "필리핀", "캐나다", "미국"};
		Random r = new Random();
		
		//여행지를 5번 골라 중복이면 가지 않는다
		for(int i=0; i<5; i++) {
			String temp = dest_list[r.nextInt(5)];
			dest.add(temp);
			System.out.println(temp);
		}
		
		System.out.println(dest);
	}

}
