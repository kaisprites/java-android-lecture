package collection;

import java.util.HashMap;

public class Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> phone = new HashMap<Integer, String>();
		phone.put(1, "����");
		phone.put(2, "�ƺ�");
		phone.put(3, "ģ��");
		System.out.println(phone);
		System.out.println(phone.get(1));
		phone.put(3, "��");
		System.out.println(phone);
	}

}
