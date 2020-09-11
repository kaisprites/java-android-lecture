package collection;

import java.util.HashMap;

public class Quiz4 {

	public static void main(String[] args) {
		HashMap<Integer, String> customer = new HashMap<Integer, String>();
		customer.put (100, "±èµ¥ÀÌ");
		customer.put (200, "±è»çÀü");
		customer.put (300, "±è±¸Á¶");
		customer.put (400, "±èÀÚ·á");
		System.out.println(customer);
		
		//200¹øÀº Å»Åğ, 300¹øÀº °³¸í
		customer.remove(200);
		customer.put(300, "±èÃæ¼º");
		System.out.println(customer);
	}

}
