package branch;
import java.util.Scanner;
public class StickernNote {
	
	public static void main(String[] args) {
		//스캐너
		Scanner sc = new Scanner(System.in);
		String input;
		
		//스티커와 노트의 값과 개수를 입력받음
		System.out.print("스티커 개수: ");
		input = sc.next();
		int sticker_count = Integer.parseInt(input);
		System.out.print("스티커 가격: ");
		input = sc.next();
		int sticker_price = Integer.parseInt(input);
		System.out.print("노트 개수: ");
		input = sc.next();
		int note_count = Integer.parseInt(input);
		System.out.print("노트 가격: ");
		input = sc.next();
		int note_price = Integer.parseInt(input);
		
		//소계와 총계를 계산
		int sticker_total = sticker_count * sticker_price;
		int note_total = note_count * note_price;
		int total=sticker_total + note_total;
		
		//가격 출력
		System.out.println("\n스티커 총 가격: "+(sticker_total));
		System.out.println("노트 총 가격: "+(note_total));
		System.out.println("-----------------------------");
		//총계가 25000 이상이면 3000원 할인, 아니면 그냥 가격
		System.out.println("총 결제금액: "+(total>=25000?total-3000:total));	
	}
}
