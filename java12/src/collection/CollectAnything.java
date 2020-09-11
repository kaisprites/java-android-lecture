package collection;

import java.util.ArrayList;

public class CollectAnything {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		//�������� add(value)
		ArrayList list = new ArrayList();
		list.add(19);
		list.add("�ڹٰ���");
		list.add(25.5);
		list.add(false);
		//list�� ������ list.size()
		System.out.println(list.size() + "�� ��� ����");
		//�����ö��� get(idx)
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		//���ﶧ�� remove(idx)
		list.remove(0);
		System.out.println("���� " + list.size() + "�� ��� ����");
		System.out.println(list.get(0));
		//�߰��� ������������ add(idx, value)
		list.add(0, "ȣ�浿");
		System.out.println("���� " + list.size() + "�� ��� ����");
		System.out.println(list.get(0));
		//�ٲܶ��� set(idx, value)
		list.set(0,  "��浿");
		System.out.println(list.get(0));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ": " + list.get(i));
			
		}
	}

}
