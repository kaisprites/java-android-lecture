package collection;

import java.util.LinkedList;

public class Quiz2 {

	public static void main(String[] args) {
		//�Ϸ翡 ���� �Ѱ��� ���� �̹� ������ ����
		LinkedList<String> test = new LinkedList<String>();
		test.add("����");
		test.add("����");
		test.add("����");
		test.add("��ǻ��");
		System.out.print("��ü ���躼 ����: ");
		System.out.println(test);
		for(int i=0; i<3; i++) {
			test.remove();
			System.out.print((i+1) + "���� ���躻 �� ����  ����: ");
			System.out.println(test);
		}
	}

}
