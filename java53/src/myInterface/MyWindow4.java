package myInterface;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWindow4 extends JFrame {
	JButton b1, b2, b3;

	public MyWindow4() {
		setTitle("try interface");
		setSize(200,200);
		setLayout(new FlowLayout());
		b1 = new JButton("Button1");
		b2 = new JButton("Button2");
		b3 = new JButton("button3");
		add(b1);
		add(b2);
		add(b3);
		//익명 클래스 객체를 생성
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				b3.setText("1번버튼누름");
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				b3.setText("2번버튼누름");
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				b3.setText("나를누름");
			}
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		MyWindow4 mw3 = new MyWindow4();
	}

}
