package staticmember;

import java.util.ArrayList;

public class Employee {
	String name;		//이름
	String gender;		//성별
	int age;			//나이
	static int agesum;	//나이 합계
	static int count;	//직원수
	
	//생성자
	public Employee (String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		agesum += age;
		count++;
	}
	
	//평균구하는함수
	public static double average() {
		return count == 0 ? 0 : (double)agesum/count;
	}
	
	//String형변환함수
	@Override
	public String toString() {
		return name + " [성별 = " + gender + ", 나이 = " + age + "]";
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("임정훈", "남", 24);
		Employee e2 = new Employee("김수아", "남", 23);
		Employee e3 = new Employee("박현상", "남", 25);
		
		System.out.println("전체 직원수: " + Employee.count);
		System.out.println("평균나이: " + Employee.average());
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
	}
}
