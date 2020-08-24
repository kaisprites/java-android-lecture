package array;

public class ArrayQuiz8 {

	public static void main(String[] args) {
		//배열의 출력
		String[] family = {"아버지", "어머니", "형", "나", "동생"};
		int[] age = {100, 88, 33, 24, 10};
		double[] height = {177.5,152.2,190.3,167.7,155.3};
		
		System.out.println("우리집 식구 정리");
		System.out.println("--------------");
		System.out.println("이름\t나이\t키");
		for(int i=0; i<family.length; i++) {
			System.out.println(family[i]+"\t"+age[i]+"\t"+height[i]);
		}
	}

}
