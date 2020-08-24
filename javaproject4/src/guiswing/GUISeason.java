package guiswing;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUISeason {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 창을 만들었다
		JFrame f = new JFrame();

		// 버튼 만들기
		JButton b1 = new JButton();
		b1.addActionListener(new ActionListener() { //버튼 액 리스너(클릭하면)
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "선선해요");
			}
		});
		//버튼의 속성
		b1.setForeground(Color.BLUE);
		b1.setBackground(Color.ORANGE);
		b1.setFont(new Font("궁서", Font.PLAIN, 90));
		JButton b2 = new JButton();
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "더워요");
			}
		});
		b2.setForeground(Color.GREEN);
		b2.setBackground(Color.PINK);
		b2.setFont(new Font("궁서", Font.PLAIN, 90));
		
		b1.setText(" 봄 ");
		b2.setText("여름");
		
		//버튼 추가
		f.getContentPane().add(b1);
		f.getContentPane().add(b2);
		
		//오브젝트 표시형식을 flow로 변경
		FlowLayout flow = new FlowLayout();
		f.getContentPane().setLayout(flow);
		
		//창 표시
		f.setSize(300,300);
		f.setVisible(true);
	}

}
