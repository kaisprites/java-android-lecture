package DBConnect;

public class ErrorHandle {

	public static void main(String[] args) {
		int x = 0;
		try {
			x = 10/0;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(x);
	}

}
