package collection;

import java.util.HashMap;

public class Quiz4 {

	public static void main(String[] args) {
		HashMap<Integer, String> customer = new HashMap<Integer, String>();
		customer.put (100, "�赥��");
		customer.put (200, "�����");
		customer.put (300, "�豸��");
		customer.put (400, "���ڷ�");
		System.out.println(customer);
		
		//200���� Ż��, 300���� ����
		customer.remove(200);
		customer.put(300, "���漺");
		System.out.println(customer);
	}

}
