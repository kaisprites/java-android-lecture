package collectionreview;

import java.util.ArrayList;

public class MyCalendar {

	public static void main(String[] args) {
		Day d1 = new Day("자바공부", 10, "강남");
		Day d2 = new Day("여행", 15, "강원도");
		Day d3 = new Day("운동", 11, "피트니스");
		
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
