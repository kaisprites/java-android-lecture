package myInterface;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWindow2 extends JFrame {
	
	public MyWindow2() {
		setTitle("try interface");
		setSize(200,200);
		setLayout(new FlowLayout());
		JButton b1 = new JButton("Button1");
		JButton b2 = new JButton("Button2");
		JButton b3 = new JButton("결과버튼");
		add(b1);
		add(b2);
		add(b3);
		b1.addActionListener(new EventClass());
		b2.addActionListener(new EventClass2());
		b3.addActionListener(new EventClass2());
		setVisible(true);
	}

	public static void main(String[] args) {
		MyWindow2 mw2 = new MyWindow2();
	}

}
