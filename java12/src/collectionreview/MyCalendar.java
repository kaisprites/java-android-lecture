package collectionreview;

import java.util.ArrayList;

public class MyCalendar {

	public static void main(String[] args) {
		Day d1 = new Day("�ڹٰ���", 10, "����");
		Day d2 = new Day("����", 15, "������");
		Day d3 = new Day("�", 11, "��Ʈ�Ͻ�");
		
//		System.out.println(d1);
//		System.out.println(d2);
//		System.out.println(d3);
		
		ArrayList<Day> list = new ArrayList<> () ;
		list.add(d1);
		list.add(d2);
		list.add(d3);
		
		SaveFile s = new SaveFile();
		s.save(list);
	}

}
