package dbconnect;

import javax.swing.JOptionPane;

public class SignInUI {

	public static void main(String[] args) throws Exception {
		String id = JOptionPane.showInputDialog("id�Է�");
		String pw = JOptionPane.showInputDialog("pw�Է�");
		String name = JOptionPane.showInputDialog("name�Է�");
		String tel = JOptionPane.showInputDialog("tel�Է�");
		
		MemberDAO db = new MemberDAO();
		
		String[] argv = {id, pw, name, tel};
		db.create(argv);
	}

}
