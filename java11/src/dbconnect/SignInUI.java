package dbconnect;

import javax.swing.JOptionPane;

public class SignInUI {

	public static void main(String[] args) throws Exception {
		String id = JOptionPane.showInputDialog("id입력");
		String pw = JOptionPane.showInputDialog("pw입력");
		String name = JOptionPane.showInputDialog("name입력");
		String tel = JOptionPane.showInputDialog("tel입력");
		
		MemberDAO db = new MemberDAO();
		
		String[] argv = {id, pw, name, tel};
		db.create(argv);
	}

}
