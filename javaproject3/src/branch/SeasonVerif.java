package branch;

public class SeasonVerif {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month = 8;
		switch (month) {
		case 3: case 4: case 5:
			System.out.println("봄");
			break;
		case 6: case 7: case 8:
			System.out.println("여름");
			break;
		case 9: case 10: case 11:
			System.out.println("가을");
			break;
		case 12: case 2: case 1:
			System.out.println("겨울");
			break;
		default:
			System.out.println("?");
			break;
		}
		
		switch (month) {
		case 2:
			System.out.println("28일까지");
		case 4: case 6: case 9: case 11:
			System.out.println("30일까지");
		default:
			System.out.println("31일까지");
		}
	}

}
