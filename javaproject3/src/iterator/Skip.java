package iterator;

public class Skip {
	public static void main(String[] args) {
		for(int i=0; i<100; i++) {
			if(i%3==0) continue;
			System.out.print(i + " ");
		}
	}
}
