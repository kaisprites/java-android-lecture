/*
 * 요구사항: 은행 예금 관리 프로그램을 작성하시오.
 */
package test;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	// scanner
		String[] name = new String[5];			// 입금자 이름 입력받는 array
		int[] capital = new int[5];				// 입금자 예금액 입력받는 array

		while(true) {		//5를 입력받을 때까지 무한반복
			System.out.print("1 입력 2 출력 3 수정 4 정리 5 종료 >>");
			switch(sc.nextInt()) {
			//1번을 선택하면 입금자 이름과 예금액을 5개 입력받음.
			case 1:
				for(int i=0; i<5; i++) {
					System.out.print(i+1 + "번째 입금자 이름 >>");
					name[i] = sc.next();
					System.out.print(i+1 + "번째 입금자 예금액 >>");
					capital[i] = sc.nextInt();
				}
				break;	
			//2번을 선택하면 입력된 모든 자료를 화면에 출력함.
			case 2:
				for(int i=0; i<5; i++) {
					System.out.println("1번째 입금자 이름: " + name[i] + ", 예금액: " + capital[i]);
				}
				break;
			//3번을 선택하면 입금자를 입력받아 동일하면 첫 번째 입금액을 수정.
			case 3:
				System.out.print("수정할 입금자 입력 >>");
				String mname = sc.next();
				for(int i=0; i<5; i++) {
					if(mname.equals(name[i])) {
						System.out.print("수정할 예금액 입력 >>");
						capital[i] = sc.nextInt();
						break;
					}
					//마지막 원소까지 순회 비교하여 검색하지 못하였을 경우 안내
					if(i==4) {
						System.out.println("해당하는 입금자가 없습니다.");
					}
				}
				break;
			//4번을 선택하면 입금액 합계와 평균을 출력
			case 4:
				int sum = 0;
				for(int i=0; i<5; i++) {
					sum += capital[i];
				}
				System.out.println("입금액 합계: " + sum + "\n입금액 평균: " + (sum/5));
				break;
			//5번을 선택하면 프로그램 종료
			case 5:
				System.out.println("프로그램을 종료합니다");
				sc.close();
				return;
			default:
				System.out.println("잘못된 입력값");
				break;
			}
		}
	}
}