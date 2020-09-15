package array;

public class HundredStars {

	public static void main(String[] args) {
		int j,k;
		for(int i=0; i<100; i++) {
			System.out.print(i%10);
			if(i%10==9) System.out.println();
		}
		j=1; k=1;
		for(int i=1; i<1001; i++) {
			System.out.print(i%10);
			if(i==j) {System.out.println(); k++; j+=k;}
		}
		
		int[] l = {1,4,5,10,11,14,15,22,23,26,27,32,33,36,37};
		k = 0;
		for(int i=1; i<38; i++) {
			System.out.print(i%10);
			if(i==l[k]) {System.out.println(); k++;}
		}
	}

}
