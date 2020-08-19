package branch;
import java.util.Scanner;
public class Bank {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("---------\n은행 입출금 시스템\n---------");
		
		//scan(콘솔상에서 입력받을 수 있게 함)
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		
		//무한루프(4를 입력할때까지)
		for (;;) {
			System.out.println("1) 입금 2) 출금 3) 잔고 4) 종료");
			
			//숫자를 입력받아 int로 변환
			String input = sc.next();
			int inputint = Integer.parseInt(input);
			
			//스위치
			switch(inputint) {
			case 1:	//'입금'을 선택하면 숫자 하나를 더 입력받아 잔고에 추가
				System.out.print("입금액 입력>>");
				input = sc.next();
				balance += Integer.parseInt(input);
				break;
			case 2: //'출금'을 선택하면 숫자 하나를 더 입력받아...
				System.out.print("출금액 입력>>");
				input = sc.next();
				inputint = Integer.parseInt(input);
				
				//숫자가 잔고보다 크면 "잔고가 부족합니다" 출력, 작으면 잔고에서 숫자만큼 차감
				if(inputint > balance) System.out.println("잔고가 부족합니다.");
				else balance -= inputint;
				break;
			case 3: //'잔고'를 선택하면 잔고 출력
				System.out.println("잔고는 " + balance);
				break;
			case 4:	//'종료'를 선택하면 시스템 종료
				System.out.println("시스템을 종료합니다");
				System.exit(0);
			default: //잘못된 값을 입력하면 아무 것도 하지 않음(다시 메뉴 출력)
			}
		}
	}

}
