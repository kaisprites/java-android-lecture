package DBConnect;

import javax.swing.JOptionPane;

public class DBinputBBS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String title = JOptionPane.showInputDialog("TITLE입력: ");
		String content = JOptionPane.showInputDialog("CONTENT입력: ");
		String author = JOptionPane.showInputDialog("AUTHOR입력: ");
		DBProcess db = new DBProcess();
		String[] argv = {null, title, content, author};
		db.create("bbs", argv, argv.length);
	}

}
