package typecasting;

import java.util.ArrayList;

public class DerivedCasting {
	//Casting of derived type is only possible in the inheritance relation
	//Car(super), Truck(sub)
	
	public class Car {
		
	}
	public class Truck extends Car {
		
	}
	public static void main(String[] args) {
		ArrayList<Object> list = new ArrayList<Object>();
		//ArrayList<Object> can add every type: Object is a superclass of every classes
		list.add("짜잔~");
		list.add(1199);
		list.add(true);
		list.add('A');
		list.add(new VO());
		
		System.out.println(list);
		
		//String-upcasted-into-Object can't use String methods
		//Should cast String to use methods 
//		Object name = list.get(0);
		String name = (String)list.get(0);
		int age = (Integer)list.get(1);
		//Primitive <- (unboxing) <- Wrapper <- (downcasting) <- Object
		//Primitive -> (boxing) -> Wrapper -> (upcasting) -> Object
	}
}
