package collection;

import java.util.LinkedList;

public class Queue {

	public static void main(String[] args) {
		LinkedList<String> milk = new LinkedList<String>();
		milk.add("惑茄快蜡");
		milk.add("教教快蜡");
		milk.add("郴老快蜡");
		
		System.out.println(milk);
		milk.remove();
		System.out.println(milk);
		milk.remove();
		System.out.println(milk);
	}

}
