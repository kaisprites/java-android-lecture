package collection;

import java.util.HashSet;

public class Set {

	public static void main(String[] args) {
		HashSet<String> bag = new HashSet<String>();
		bag.add("����");
		bag.add("����");
		bag.add("����");
		bag.add("�޷�");
		
		System.out.println(bag.size());
		System.out.println(bag);
	}

}
