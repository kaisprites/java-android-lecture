package myInterface;

import java.util.ArrayList;

public class Casting {

	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();
		//Object is super, extended classes are sub
		//Classes are upcasted into Object
		list.add("등산");
		list.add(new Man());
		list.add(new Superman());
		
		//Objects are downcasted into extended classes
		String l1 = (String)list.get(0);
		Man m1 = (Man)list.get(1);
		Superman m2 = (Superman)list.get(2);
		
		//Object type instances cant call extended classes method
		l1.isBlank();
		m1.eat();
		//list.get(0).isBlank();
		//list.get(1).eat();
	}

}
