package collection;

import java.util.ArrayList;

public class Quiz1 {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ArrayList ski = new ArrayList();
		
		//������� ����ֱ�
		ski.add("�ڽ�Ű");
		ski.add("�۽�Ű");
		ski.add("�轺Ű");
		ski.add("����Ű");
		for (int i = 0; i < ski.size(); i++) {
			System.out.println((i+1) + "��: " + ski.get(i));
		}
		System.out.println("2���� ��Ģ�ؼ� Ż��");
		ski.remove(1);	//����Ʈ���� �����
		for (int i = 0; i < ski.size(); i++) {
			System.out.println((i+1) + "��: " + ski.get(i));
		}
	}
}
