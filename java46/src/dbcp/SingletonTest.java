package dbcp;

public class SingletonTest {

	public static void main(String[] args) {
		ConManager con = ConManager.getInstance();
		System.out.println(con);
		ConManager con2 = ConManager.getInstance();
		System.out.println(con2);
		int[] a = new int[5];
		System.out.println(a);
		double[] b = new double[5];
		System.out.println(b);
		boolean[] c = new boolean[5];
		System.out.println(c);
	}

}
