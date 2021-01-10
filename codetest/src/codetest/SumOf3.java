package codetest;

/* 1~100 중 3의 배수만 더해서 출력*/
public class SumOf3 {

	public static void main(String[] args) {
		int sum = 0;
		int maxnum = 100;
		int multiple = 3;
		for (int i=1; i<=maxnum/multiple; i++) {
			sum += i * multiple;
		}
		System.out.println(sum);
	}

}
