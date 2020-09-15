package inheritance;

public class Person {
	int age;
	String name;
	
	//paramless constructor는 언제나 자동생성된다
	
	public Person (int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void eat() {
		System.out.println("aasd");
	}
}
