package collection;

import java.util.HashSet;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		Random r = new Random();
		HashSet<Integer> result = new HashSet<Integer>();
		
		//6개를 뽑아야 하므로 6개가 넣어질 때까지 반복
		//6개가 넣어지기 전에 중복이 나오면 넣어지지 않는다
		while (result.size()<6) {
			result.add(r.nextInt(45)+1);
		}
		System.out.println(result);
	}

}
