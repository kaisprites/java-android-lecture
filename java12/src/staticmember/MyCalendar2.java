package staticmember;

import collectionreview.Day;

public class MyCalendar2 {

	public static void main(String[] args) {
		//static variable�� �ν��Ͻ� �̸��� �ƴ� Ŭ���� �̸����� �����Ѵ�.
		Day d1 = new Day("�ڹٰ���", 10, "����");
		System.out.println(Day.count);
		System.out.println(Day.timesum);
		Day d2 = new Day("����", 15, "������");
		System.out.println(Day.count);
		System.out.println(Day.timesum);
		Day d3 = new Day("�", 11, "��Ʈ�Ͻ�");
		System.out.println(Day.count);
		System.out.println(Day.timesum);
		
		System.out.println("��� �ð��� " + Day.timesum/Day.count);
	}

}
