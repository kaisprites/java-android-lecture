package collection;

import java.util.LinkedList;

public class Queue {

	public static void main(String[] args) {
		LinkedList<String> milk = new LinkedList<String>();
		milk.add("���ѿ���");
		milk.add("�̽̿���");
		milk.add("���Ͽ���");
		
		System.out.println(milk);
		milk.remove();
		System.out.println(milk);
		milk.remove();
		System.out.println(milk);
	}

}
