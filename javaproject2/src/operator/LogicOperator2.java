package operator;

public class LogicOperator2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temperature = 25;
		int wind = 100;
		
		//when temperature >= 30 or wind <= 88 I'll have an umbrella
		//or연산자: 여러 조건 중 하나가 true이면 결과는 true
		
		if (temperature>=30 || wind <= 88) {
			System.out.println("양산들고감");
		}
		else
			System.out.println("양산안들고감");
	}
	//or 연산자 ||
			// false || false == false
			// true || false == true
			// false || true == true
			// true || true == true

}
