package array;

import java.util.Random;

public class InputArrayQuiz2 {

	public static void main(String[] args) {
		//1 채점하기
		//2 문항당 오답처리
		
		//변수선언: random method, int 배열: 정답/답안, count
		Random r = new Random();
		int[] correct = new int[1000];
		int[] answer = new int[1000];
		int count=0;
		
		//정답과 답안 만들기
		for(int i=0; i<1000; i++) {
			correct[i] = Math.abs(r.nextInt()%4);
			answer[i] = Math.abs(r.nextInt()%4);
		}
		//번호, 정답, 답안, 결과 순으로 출력하고 정답이면 count가산 
		for(int i=0; i<1000; i++) {
			if(i%10==0) System.out.println("idx	correct	answer	result");
			System.out.println(i+"\t"+correct[i]+"\t"+answer[i]+"\t"
							+(correct[i]==answer[i]?"correct":"wrong"));
			if(correct[i] == answer[i]) count++;
		}
		//count 출력
		System.out.println(count);
	}

}
