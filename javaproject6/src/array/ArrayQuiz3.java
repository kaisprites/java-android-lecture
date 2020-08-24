package array;

public class ArrayQuiz3 {

	public static void main(String[] args) {
		// 33은 몇번째 위치에?
		int[] number = {11,22,33,44};
		int target = 33;
		int idx=0;
		for (int i = 0; i < number.length; i++) {
			if(number[i] == target) idx=i;
		}
		System.out.println(target + "은 " + (idx) + "번째에");
	}

}
