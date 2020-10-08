package recursion;

public class GCD {
	static int gcd(int x, int y) {
		while(x%y!=0) {	
			int x2 = y;
			int y2 = x%y;
			x = x2;
			y = y2;
		}
		return y;
	}
	
	static int gcdArray(int[] a) {
		int result = gcd(a[0], a[1]);
		for(int i=2; i<a.length; i++) {
			gcd(result, a[i]);  
		}
		return result;
	}
}
