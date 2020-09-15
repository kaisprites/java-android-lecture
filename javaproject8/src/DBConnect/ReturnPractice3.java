package DBConnect;

public class ReturnPractice3 {

	public static void main(String[] args) {
		String data = "A1가";
		char[] dataset = data.toCharArray();
		for (char c: dataset) {
			System.out.println(c);
		}
		System.out.println("-----------------");
		System.out.println(dataset[0]);
	}

}
