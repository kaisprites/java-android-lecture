package DBConnect;

import javax.swing.JOptionPane;

public class DBinput {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String id = JOptionPane.showInputDialog("ID입력: ");
		String pw = JOptionPane.showInputDialog("PW입력: ");
		String name = JOptionPane.showInputDialog("NAME입력: ");
		String tel = JOptionPane.showInputDialog("TEL입력: ");
		DBProcess db = new DBProcess();
		db.create(id, pw, name, tel);
	}

}
