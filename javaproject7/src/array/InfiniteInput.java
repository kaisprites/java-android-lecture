package array;
import java.util.Scanner;
public class InfiniteInput {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int [][] seat = new int[5][10];
		while (true) {
			//좌석현황 출력
			System.out.print("  ");
			for (int i = 0; i < 10; i++) {
				System.out.print((i)+" ");
			}
			System.out.println();
			for(int j=0; j<5; j++) {
				System.out.print((char)('A'+j)+" "); //'A'+1='B', 'A'+2='C', ... 
				for (int i = 0; i < 10; i++) {
					System.out.print(seat[j][i]+" ");
				}
				System.out.println();
			}
			//좌석번호를 입력받아 유효한 숫자인지 검사
			System.out.println("\n좌석 입력? 종료:-1");
			String choice = sc.next();
			int number = -1;	//입력값 길이가 2가 아닐 때 유효하지 않은 좌석번호를 만들기 위한 임의 초기화
			if(choice.length() == 2) number = Integer.parseInt(choice.substring(1));
			
			//-1이면 종료
			if(choice.equals("-1")) {
				System.out.println("프로그램 종료");
				int sum = 0;
				for(int i = 0; i<seat.length*10; i++) sum += seat[i/10][i%10] * 10000;
				System.out.println("결제금액: "+sum+"원");
				break;
			}
			
			//유효한 좌석번호를 입력받아 0이면 1로, 1이면 이미 예약됨 메시지 출력
			else if((choice.charAt(0)>='A' && choice.charAt(0)<('A'+seat.length))
					|| (number >= 0 && number < 10)){
				if(seat[choice.charAt(0)-'A'][number] == 0)
					seat[choice.charAt(0)-'A'][number]++;
				else System.out.println("이미 예약된 좌석");
			}
			
			//유효한 좌석번호가 아닌 경우
			else System.out.println("잘못된 입력");
		}
	}

}
