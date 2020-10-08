package bean;

public class Main {
	public static void main(String[] args) {
		int[] num = {1,2,3};
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
		for(int x:num) {
			System.out.println(x);
		}
	}
}
