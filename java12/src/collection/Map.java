package collection;

import java.util.HashMap;

public class Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> phone = new HashMap<Integer, String>();
		phone.put(1, "엄마");
		phone.put(2, "아빠");
		phone.put(3, "친구");
		System.out.println(phone);
		System.out.println(phone.get(1));
		phone.put(3, "형");
		System.out.println(phone);
	}

}
