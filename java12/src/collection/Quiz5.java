package collection;

import java.util.HashSet;
import java.util.Random;

public class Quiz5 {

	public static void main(String[] args) {
		HashSet<String> dest = new HashSet<String>();
		String[] dest_list = {"����", "�Ϻ�", "�ʸ���", "ĳ����", "�̱�"};
		Random r = new Random();
		
		//�������� 5�� ��� �ߺ��̸� ���� �ʴ´�
		for(int i=0; i<5; i++) {
			String temp = dest_list[r.nextInt(5)];
			dest.add(temp);
			System.out.println(temp);
		}
		
		System.out.println(dest);
	}

}
