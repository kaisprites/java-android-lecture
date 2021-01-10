package recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 
 * 재귀 함수는 자기 자신을 호출하는 함수이다.
 * 재귀 함수의 구조를 이해하고, 유클리드 제법을 사용하여 최대공약수를 구하는 코드를 작성한다.
 * 
 * 유클리드 제법의 알고리즘은 다음과 같다:
 * 1) x%y == 0 이면 x와 y의 최대공약수는 y이다.
 * 2) x%y != 0 이면 x와 y의 최대공약수는 y와 x%y의 최대공약수와 같다.
 * 
 * 입력 예제: 1344 2520
 * 
 * 출력 예제: 	GCD(1344, 2520)
 * 			GCD(2520, 1344)
 * 			GCD(1344, 1176)
 * 			GCD(1176, 168)
 * 			GCD(168, 0)
 * 			result = 168
 */
public class RecursionGCD {
	public static int gcd (int x, int y) {
		//TODO: 최대공약수를 구하는 재귀함수 정의
		System.out.println("gcd("+x+", "+y+")");
		if (y == 0) {
			System.out.println("div by 0 error");
			return -1;
		} else if (x % y == 0) {
			return y;
		} else {
			return gcd(y, x%y); 
		}
	}
	
	public static void gcdDriver (int x, int y) {
		//여러가지 이유로 어떤 재귀함수는 시동하기 위해 임의의 드라이버(시동자)를 필요로 한다. 
		int result = gcd(x, y);
		System.out.println(result + "\n");
	}
	
	public static void main (String[] arg) throws FileNotFoundException {
		for(int i=0; i<5; i++) {
			File file = new File("input" + i + ".txt");
			Scanner sc = new Scanner(file);
			int x = sc.nextInt();
			int y = sc.nextInt();

			gcdDriver(x, y);
			
			sc.close();
		}
	}
}
