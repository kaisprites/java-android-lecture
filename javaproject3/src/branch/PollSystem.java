package branch;
import java.util.Scanner;
public class PollSystem {

	public static void main(String[] args) {
		// 투표 시스템 (무한 루프)
		
		// 후보 득표수 변수, 스캐너(콘솔에서 입력받을수있게함) 변수
		int cand1 = 0, cand2 = 0, cand3 = 0;
		Scanner sc = new Scanner(System.in);
		for(; true ;)
		{
			System.out.println("인기투표선택해주세요 (1:아이유, 2:유재석, 3:방탄, 4:종료)");
			
			//후보 숫자를 입력받음
			String input = sc.next();
			int inputint = Integer.parseInt(input);
			
			switch(inputint) {
			//각 후보 번호를 선택하면 득표수 증가
			case 1: System.out.println("아이유 투표"); cand1++; break;
			case 2: System.out.println("유재석 투표"); cand2++; break;
			case 3: System.out.println("방탄 투표"); cand3++; break;
			
			//종료를 선택하면 지금까지 득표수 보여주고 종료
			case 4:
				System.out.println("아이유: "+cand1+"표, 유재석: "+cand2+"표, 방탄: "+cand3+"표");
				System.exit(0);
				
			default: break; 
			}
			
		}
	}

}
