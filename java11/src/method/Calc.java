package method;

public class Calc {

//	�Ӽ�: ������� (��������, global����, Ŭ������ü����) => �ڵ��ʱ�ȭ
	public String color; //�������� �ڵ��ʱ�ȭ : null
	public int price;
	public int size; //�⺻���� �ڵ��ʱ�ȭ: 0

//	����: �޼���(�Է°�, ��ȯ�� ����)
	
	public int plus (int a, int b) { return a + b; }
	public double plus (double a, double b) { return a + b; }
	public int minus (int a, int b) { return a - b; }
	
	public int mult(int a, int b) { return a * b; }
	public double mult(double a, double b) { return a * b; }
	public double div(double a, double b) { return a / b; }
	}