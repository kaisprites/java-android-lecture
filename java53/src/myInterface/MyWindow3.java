package myInterface;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyWindow3 extends JFrame implements ActionListener {
	JButton b1, b2, b3;

	@Override
	public void actionPerformed(ActionEvent a) {
		String result;
		if(a.getSource() == b1)  result = "버튼1을누름";
		else if(a.getSource() == b2)  result = "버튼2를누름";
		else result = "나를누름";
		b3.setText(result);

	}
	public MyWindow3() {
		setTitle("try interface");
		setSize(200,200);
		setLayout(new FlowLayout());
		b1 = new JButton("Button1");
		b2 = new JButton("Button2");
		b3 = new JButton("button3");
		add(b1);
		add(b2);
		add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyWindow3 mw3 = new MyWindow3();
	}

}
