package staticmember;

import collectionreview.Day;

public class MyCalendar2 {

	public static void main(String[] args) {
		//static variable은 인스턴스 이름이 아닌 클래스 이름으로 참조한다.
		Day d1 = new Day("자바공부", 10, "강남");
		System.out.println(Day.count);
		System.out.println(Day.timesum);
		Day d2 = new Day("여행", 15, "강원도");
		System.out.println(Day.count);
		System.out.println(Day.timesum);
		Day d3 = new Day("운동", 11, "피트니스");
		System.out.println(Day.count);
		System.out.println(Day.timesum);
		
		System.out.println("평균 시간은 " + Day.timesum/Day.count);
	}

}
