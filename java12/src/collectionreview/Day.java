package collectionreview;

public class Day {
	
	String doing;
	int time;
	String location;
	public static int count; //전역변수는 자동초기화
	public static int timesum;

	public Day(String doing, int time, String location) {
		this.doing = doing;
		this.time = time;
		this.location = location;
		count++;
		timesum+=time;
	}


	@Override
	public String toString() {
		return "Day [doing=" + doing + ", time=" + time + ", location=" + location + "]";
	}

}
