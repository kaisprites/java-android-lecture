package collection;

import java.util.HashSet;

public class Set {

	public static void main(String[] args) {
		HashSet<String> bag = new HashSet<String>();
		bag.add("º¼Ææ");
		bag.add("ÈŞÁö");
		bag.add("ÈŞÁö");
		bag.add("¸Ş·Õ");
		
		System.out.println(bag.size());
		System.out.println(bag);
	}

}
