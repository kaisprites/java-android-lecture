package classpackage;

import java.awt.Color;

public class MyRoom {

	public static void main(String[] args) {
		Phone p1 = new Phone();
		p1.color = Color.white;
		p1.size = 7;
		p1.compnay = "Samsung";
		System.out.println(p1.color + " " + p1.size + " " + p1.compnay);
		
		Phone p2 = new Phone ();
		p2.color = Color.red;
		p2.size = 100;
		p2.compnay = "LG";
		
		p2.call();
		
		Dog puppy = new Dog();
		puppy.size = 10;
		puppy.type = "Shih tzu";
		System.out.println(puppy.size + " " + puppy.type);
		puppy.bark();
		
		Dog puppy2 = new Dog ();
		puppy2.size = 100;
		puppy2.sneeze();
		return;
	}

}
