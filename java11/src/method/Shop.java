package method;

public class Shop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc cal = new Calc();
		cal.color = "red";
		cal.price = 5000;
		cal.size = 11;
		int jcount = 5;
		int ccount = 3;
		int sum = cal.plus(jcount, ccount);
		int sum2 = cal.mult(sum, 3000);
		System.out.println("���ұݾ�: " + sum2 + "��");
		
		int jprice = cal.mult(5, 3000);
		int cprice = cal.mult(3, 2000);
		System.out.println("�꽺������ " + jprice + "��");
		System.out.println("Ŀ�ǰ����� " + cprice + "��");
		
		int interval = cal.minus(jprice, cprice);
		System.out.println("�������̴� " + interval + "��");
	}

}
