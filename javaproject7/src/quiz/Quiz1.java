package quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		int count = 0;
		int winCPU = 0;
		int[] winHuman = {0,0,0};
		int draw = 0;
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		final String[] hand = {"가위","바위","보"};
		while(true) {
			//입력받아서 -1이면 종료
			System.out.print("-1)종료 0)가위 1)바위 2)보? >>");
			int handHuman = s.nextInt();
			int handCPU = r.nextInt(3);
			if (handHuman == -1) break;
			else if(handHuman > 2 || handHuman < 0) {System.out.println("잘못된 입력"); continue;}
			System.out.print("나: "+hand[handHuman]+"\t컴: "+hand[handCPU]+"\t");
			
			//핸드를 숫자에 매핑하면 0<1, 1<2, 2<0
			//좌측이 나, 우측이 컴퓨터라고 하면 0-1=-1, 1-2=-1, 2-0=2 이므로 3으로 나눈 나머지가 2일때 패배
			//1-0=1, 2-1, 0-2=-2 이므로 3으로 나눈 나머지 1일때 승리
			
			if(handHuman == handCPU) {
				System.out.println("비겼습니다"); count++; draw++;
			}
			else if((handHuman-handCPU+3)%3 == 1) {
				System.out.println("이겼습니다");
				count++; winHuman[handHuman]++;
			}
			else {
				System.out.println("졌습니다");
				count++; winCPU++;
			}
		}
		//결과출력
		System.out.println("전체 횟수: "+count);
		System.out.println("컴퓨터가 이긴 횟수: "+winCPU);
		System.out.println("내가 가위로 이긴 횟수: "+winHuman[0]);
		System.out.println("내가 바위로 이긴 횟수: "+winHuman[1]);
		System.out.println("내가 보로 이긴 횟수: "+winHuman[2]);
		System.out.println("비긴 횟수: "+draw);
	}

}
