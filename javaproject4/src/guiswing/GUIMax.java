package guiswing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIMax {

	public static void main(String[] args) {
		//창
		JFrame j = new JFrame();
		
		//텍스트 필드: 숫자1, 숫자2
		JTextField field1 = new JTextField();
		field1.setColumns(5);
		field1.setFont(new Font("궁서", Font.PLAIN, 30));
		JTextField field2 = new JTextField();
		field2.setColumns(5);
		field2.setFont(new Font("궁서", Font.PLAIN, 30));
		
		//레이블: 숫자1, 숫자2, 결과
		JLabel label1 = new JLabel();
		label1.setText("숫자1");
		label1.setFont(new Font("궁서", Font.PLAIN, 30));
		JLabel label2 = new JLabel();
		label2.setText("숫자2");
		label2.setFont(new Font("궁서", Font.PLAIN, 30));
		JLabel label3 = new JLabel();
		label3.setFont(new Font("궁서", Font.PLAIN, 30));
		
		//버튼: 큰 수를 출력
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long a = Long.parseLong(field1.getText());
				long b = Long.parseLong(field2.getText());
				label3.setText(String.valueOf(a > b ? a : b));
			}
		});
		button.setText("큰 숫자는");
		button.setFont(new Font("궁서", Font.PLAIN, 30));
		
		//플로우 레이아웃
		FlowLayout flow = new FlowLayout();
		
		//객체들 뿌려주고 창 띄우기
		j.setSize(300, 300);
		j.getContentPane().setLayout(flow);
		j.getContentPane().add(label1);
		j.getContentPane().add(field1);
		j.getContentPane().add(label2);
		j.getContentPane().add(field2);
		j.getContentPane().add(button);
		j.getContentPane().add(label3);
		j.setVisible(true);
	}

}
