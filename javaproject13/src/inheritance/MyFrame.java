package inheritance;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	String title;
	
	public MyFrame(String title) {
		this.title = title;
		
		setSize(100,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyFrame f = new MyFrame("Title");
		System.out.println(f.title);
	}
}
