package collection;

import java.util.HashSet;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		Random r = new Random();
		HashSet<Integer> result = new HashSet<Integer>();
		
		//6���� �̾ƾ� �ϹǷ� 6���� �־��� ������ �ݺ�
		//6���� �־����� ���� �ߺ��� ������ �־����� �ʴ´�
		while (result.size()<6) {
			result.add(r.nextInt(45)+1);
		}
		System.out.println(result);
	}

}
