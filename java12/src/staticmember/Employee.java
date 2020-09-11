package staticmember;

import java.util.ArrayList;

public class Employee {
	String name;		//�̸�
	String gender;		//����
	int age;			//����
	static int agesum;	//���� �հ�
	static int count;	//������
	
	//������
	public Employee (String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		agesum += age;
		count++;
	}
	
	//��ձ��ϴ��Լ�
	public static double average() {
		return count == 0 ? 0 : (double)agesum/count;
	}
	
	//String����ȯ�Լ�
	@Override
	public String toString() {
		return name + " [���� = " + gender + ", ���� = " + age + "]";
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("������", "��", 24);
		Employee e2 = new Employee("�����", "��", 23);
		Employee e3 = new Employee("������", "��", 25);
		
		System.out.println("��ü ������: " + Employee.count);
		System.out.println("��ճ���: " + Employee.average());
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
	}
}
