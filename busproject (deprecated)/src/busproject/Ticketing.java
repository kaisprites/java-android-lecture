package busproject;

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class Ticketing {
	private static JTextField tfOrigin;
	private static JTextField tfDest;
	private static JTextField textField;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		
		frame.setSize(800,600);
		frame.getContentPane().setLayout(null);
		
		JPanel ticketType = new JPanel();
		ticketType.setBounds(46, 33, 679, 91);
		frame.getContentPane().add(ticketType);
		ticketType.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton tickettype_oneway = new JRadioButton("편도");
		tickettype_oneway.setFont(new Font("굴림", Font.PLAIN, 16));
		ticketType.add(tickettype_oneway);
		
		JRadioButton ticketType_oneway = new JRadioButton("왕복");
		ticketType_oneway.setFont(new Font("굴림", Font.PLAIN, 16));
		ticketType.add(ticketType_oneway);
		
		JPanel path = new JPanel();
		path.setBounds(46, 134, 336, 146);
		frame.getContentPane().add(path);
		
		JLabel label1 = new JLabel("출발지");
		path.add(label1);
		label1.setFont(new Font("굴림", Font.PLAIN, 16));
		
		tfOrigin = new JTextField();
		path.add(tfOrigin);
		tfOrigin.setFont(new Font("굴림", Font.PLAIN, 16));
		tfOrigin.setEditable(false);
		tfOrigin.setColumns(20);
		
		JLabel label2 = new JLabel("도착지");
		path.add(label2);
		label2.setFont(new Font("굴림", Font.PLAIN, 16));
		
		tfDest = new JTextField();
		path.add(tfDest);
		tfDest.setFont(new Font("굴림", Font.PLAIN, 16));
		tfDest.setEditable(false);
		tfDest.setColumns(20);
		
		JButton btnSelectLocation = new JButton("출발지/도착지 선택");
		path.add(btnSelectLocation);
		btnSelectLocation.setFont(new Font("굴림", Font.PLAIN, 16));
		
		JPanel date = new JPanel();
		date.setBounds(394, 134, 331, 146);
		frame.getContentPane().add(date);
		
		JLabel label1_1 = new JLabel("출발날짜");
		label1_1.setFont(new Font("굴림", Font.PLAIN, 16));
		date.add(label1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 16));
		textField.setEditable(false);
		textField.setColumns(18);
		date.add(textField);
		
		JButton btnNewButton = new JButton("출발날짜 선택");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 16));
		date.add(btnNewButton);
		
		JPanel rank = new JPanel();
		rank.setBounds(46, 290, 679, 91);
		frame.getContentPane().add(rank);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("우등");
		rdbtnNewRadioButton_2.setFont(new Font("굴림", Font.PLAIN, 16));
		rank.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("일반");
		rdbtnNewRadioButton_1_1.setFont(new Font("굴림", Font.PLAIN, 16));
		rank.add(rdbtnNewRadioButton_1_1);
		
		JButton buttonLoadList = new JButton("조회하기");
		buttonLoadList.setFont(new Font("굴림", Font.PLAIN, 16));
		buttonLoadList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonLoadList.setBounds(341, 495, 97, 23);
		frame.getContentPane().add(buttonLoadList);
		frame.setVisible(true);
	}
}
