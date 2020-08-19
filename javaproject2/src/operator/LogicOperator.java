package operator;

public class LogicOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id = "root";
		String pw = "pass";
		
		String login_id = "root";
		String login_pw = "no";
		//id == login_id 이고, pw == login_pw 일 때
		if (id.equals(login_id) && pw.equals(login_pw)) System.out.println("login ok");
		else System.out.println("login fail");
		
		//and 연산자 &&
		// false && false == false
		// false && true == false
		// true && false == false
		// true && true == true
		// x가 false이면 y 여부에 상관없이 false
		
		
	}

}
