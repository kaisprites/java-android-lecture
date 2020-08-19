package branch;

public class GenderVerif {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ssn="880115-1056512";
		//문자를 char로 받을 수는 없다. String으로 받아서 char 추출
		char gender = ssn.charAt(7);
		String sub = ssn.substring(7, 8); //7
		switch(gender) {
		case '1': case '3':
			System.out.println("남자");
			break;
		case '2': case '4':
			System.out.println("여자");
			break;
		default:
			System.out.println("잘못된 번호");
		}
	}

}
