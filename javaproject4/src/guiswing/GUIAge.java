package guiswing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIAge {

	public static void main(String[] args) {
		//창
		JFrame j = new JFrame();
		
		//레이블: 이름, 출생년도, 결과
		JLabel label1 = new JLabel();
		label1.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		label1.setText("이름");
		JLabel label2 = new JLabel();
		label2.setText("출생년");
		label2.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		JLabel label3 = new JLabel();
		label3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		
		//텍스트 필드: 이름, 출생년도
		JTextField field1 = new JTextField();
		field1.setColumns(5);
		field1.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		JTextField field2 = new JTextField();
		field2.setColumns(5);
		field2.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		
		//버튼: 클릭할 경우 (이름)은 (출생년에 따른 조건 텍스트)입니다 출력
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int birth = Integer.parseInt(field2.getText());
				String result = field1.getText() + "은 "
								+ (2020 - birth >= 18 ? "성인" : "미성년자") + "입니다";
				label3.setText(result);
			}
		});
		button.setText("출력");
		button.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		
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
