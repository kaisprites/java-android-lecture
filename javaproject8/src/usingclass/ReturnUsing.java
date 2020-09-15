package usingclass;

import DBConnect.ReturnPractice;

public class ReturnUsing {

	public static void main(String[] args) {
		ReturnPractice p = new ReturnPractice();
		
		System.out.println(p.add(true));
		System.out.println(p.add(10.1,1));
		System.out.println(p.add(1, 2));
		System.out.println(p.add());
		System.out.println(p.add(100)[2]);
		System.out.println(p.add("34", 5));
	}

}
