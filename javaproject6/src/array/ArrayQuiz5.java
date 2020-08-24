package array;

public class ArrayQuiz5 {

	public static void main(String[] args) {
		// 최대값은?
		int[] number = {66,77,88,99};
		int max = 0;
		for (int i = 0; i < number.length; i++)
			max = max < number[i] ? number[i] : max;
		
		System.out.println("최대값은: " + max);
		
		//66과 99 위치 바꾸기
		int temp = number[0];
		number[0] = number[3];
		number[3] = temp;
		
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + " ");
		}
	}

}
