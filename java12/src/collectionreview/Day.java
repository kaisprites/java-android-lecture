package collectionreview;

public class Day {
	
	String doing;
	int time;
	String location;
	public static int count; //���������� �ڵ��ʱ�ȭ
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
