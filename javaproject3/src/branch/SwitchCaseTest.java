package branch;

public class SwitchCaseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String food = "냉면";
		switch(food) {
		case "알밥":
			System.out.println("분식집으로 가요");
			break;
		case "국수":
			System.out.println("국수집으로 가요");
			break;
		case "자장면":
			System.out.println("중식집으로 가요");
			break;
		case "냉면":
			System.out.println("일식집으로 가요");
			break;
		default: //else와 비슷
			System.out.println("물마셔요");
			break;
		}
	}

}
