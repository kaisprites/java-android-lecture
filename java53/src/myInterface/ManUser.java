package myInterface;

public class ManUser {

	public static void main(String[] args) {
		Man s = new Spiderman();
		//vartype varname
		//classname can be vartype
		//interface name can be vartype
		//interface can be casted
		//autotypecast
		s.walk();
		s.eat();
		s.spiderdance();
	}
}

//casting is variable type change
//primitive casting
//derived casting: only classes and interfaces in inheritance
//manual downcasting and auto upcasting
//Car interface/class <- Truck, Taxi class
//Car<-Truck<-Taxi
