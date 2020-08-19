package operator;

public class TypeConv2 {

	public static void main(String[] args) {
		// 4bytes<1byte 이므로 자동형변환
		byte x1 = 100;
		int y1 = x1;
		
		// 1byte<4bytes 이므로 강제형변환 필요
		int x2 = 300;
		byte y2 = (byte)x2;
		
		// 4bytes<8bytes 이므로 강제형변환 필요
		double x3 = 400;
		int y3 = (int)x3;
		
		// 8bytes<4byte 이므로 자동형변환
		int x4 = 400;
		double y4 = x4;
		
		System.out.println(y1 + " " + y2 + " " + y3 + " " + y4);
	}

}
