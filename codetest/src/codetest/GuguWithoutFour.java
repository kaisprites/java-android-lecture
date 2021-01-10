package codetest;

public class GuguWithoutFour {

	public static void main(String[] args) {
		for(int i=1; i<10; i++) {
			if(i%4 == 0) continue;
			System.out.println("3*" + i + "=" + (3*i));
		}
	}

}
