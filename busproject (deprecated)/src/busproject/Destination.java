package busproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.UIManager;

public class Destination {
	
	final static String[] mainDest = {"서울경부", "센트럴시티", "광주", "부산", "부산사상", "동서울", "대전복합", "전주", "유성", "천안", "동대구"};
	final static String[] terminalList_all = {"터미널1", "터미널2", "터미널3", "터미널4", "터미널5", "터미널6"};
	final static String[] terminalList_seoul = {"터미널7", "터미널8", "터미널9", "터미널10", "터미널11", "터미널12"};
	final static String[] terminalList_incheon = {"터미널13", "터미널14", "터미널15", "터미널16", "터미널17", "터미널18"};
	final static String[] terminalList_kangwon = {"터미널19", "터미널20", "터미널21", "터미널22", "터미널23", "터미널24"};
	static int tfpointer = 0;
	private static JPanel rightPanel = new JPanel();
	static Color colorWhiteGray = new Color(243,244,246);

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		JLabel label3 = new JLabel();
		label3.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 18));
		label3.setBounds(20, 222, 97, 22);
		label3.setText("주요터미널");
		JLabel label4 = new JLabel();
		label4.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 18));
		label4.setText("지역별 터미널");
		label4.setBounds(22, 342, 120, 22);
		
		frame.setSize(800, 600);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(label3);
		frame.getContentPane().add(label4);
		
		JPanel panel_tofrom = new JPanel();
		panel_tofrom.setBackground(Color.WHITE);
		panel_tofrom.setBounds(2, 79, 782, 150);
		frame.getContentPane().add(panel_tofrom);
		panel_tofrom.setLayout(null);
		
		JLabel label1 = new JLabel();
		label1.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		label1.setBounds(20, 10, 64, 20);
		panel_tofrom.add(label1);
		label1.setText("출발지");
		JLabel label2 = new JLabel();
		label2.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		label2.setBounds(406, 10, 64, 20);
		panel_tofrom.add(label2);
		label2.setText("도착지");
		
		JTextField tfOrigin = new JTextField();
		tfOrigin.setFont(new Font("맑은 고딕", Font.PLAIN, 36));
		tfOrigin.setBackground(Color.WHITE);
		tfOrigin.setEditable(false);
		tfOrigin.setBounds(20, 40, 350, 100);
		tfOrigin.setBorder(BorderFactory.createLineBorder(new Color(104, 179, 206)));
		panel_tofrom.add(tfOrigin);
		
		JTextField tfDest = new JTextField();
		tfDest.setFont(new Font("맑은 고딕", Font.PLAIN, 36));
		tfDest.setBackground(colorWhiteGray);
		tfDest.setEditable(false);
		tfDest.setBounds(406, 41, 350, 100);
		tfDest.setBorder(BorderFactory.createEmptyBorder());
		panel_tofrom.add(tfDest);
		
		tfOrigin.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfOrigin.setBackground(Color.WHITE);
				tfDest.setBorder(BorderFactory.createEmptyBorder());
				tfDest.setBackground(colorWhiteGray);
				tfOrigin.setBorder(BorderFactory.createLineBorder(new Color(104, 179, 206)));
				tfpointer = 0;
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		tfDest.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tfDest.setBackground(Color.WHITE);
				tfOrigin.setBorder(BorderFactory.createEmptyBorder());
				tfOrigin.setBackground(colorWhiteGray);
				tfDest.setBorder(BorderFactory.createLineBorder(new Color(104, 179, 206)));
				tfpointer = 1;
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		
		JPanel panel_mainloc = new JPanel();
		panel_mainloc.setBackground(Color.WHITE);
		panel_mainloc.setBounds(21, 248, 738, 90);
		frame.getContentPane().add(panel_mainloc);
		panel_mainloc.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JButton[] buttons_main = new JButton[11];
		for(int i=0; i<buttons_main.length; i++) {
			buttons_main[i] = new JButton(mainDest[i]);
			buttons_main[i].setBackground(Color.WHITE);
			buttons_main[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			buttons_main[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField jtfptr; 
					if(tfpointer == 0) jtfptr = tfOrigin;
					else jtfptr = tfDest;
					String text = ((JButton) e.getSource()).getText();
					jtfptr.setText(text);
					if(tfpointer == 0) {
						jtfptr = tfDest;
						tfpointer = 1;
						tfDest.setBackground(Color.WHITE);
						tfOrigin.setBorder(BorderFactory.createEmptyBorder());
						tfOrigin.setBackground(colorWhiteGray);
						tfDest.setBorder(BorderFactory.createLineBorder(new Color(104, 179, 206)));
					}
				}
			});
			panel_mainloc.add(buttons_main[i]);
		}
		
		JPanel panel_termloc = new JPanel();
		panel_termloc.setBackground(Color.WHITE);
		panel_termloc.setBounds(22, 368, 217, 158);
		frame.getContentPane().add(panel_termloc);
		
		CardLayout card = new CardLayout(10,10);
		JPanel panel_termlist = new JPanel();
		panel_termlist.setBackground(Color.WHITE);
		panel_termlist.setBounds(251, 349, 508, 177);
		frame.getContentPane().add(panel_termlist);
		panel_termlist.setLayout(card);
		
		JButton pswitch_all = new JButton("  전체  ");
		pswitch_all.setBounds(5, 5, 100, 25);
		pswitch_all.setBackground(colorWhiteGray);
		pswitch_all.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pswitch_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_termlist, "1");
			}
		});
		panel_termloc.setLayout(null);
		
		panel_termloc.add(pswitch_all);
		
		JButton pswitch_seoul = new JButton("  서울  ");
		pswitch_seoul.setBounds(110, 5, 100, 25);
		pswitch_seoul.setBackground(colorWhiteGray);
		pswitch_seoul.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pswitch_seoul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_termlist, "2");
			}
		});
		panel_termloc.add(pswitch_seoul);
		
		JButton pswitch_incheon = new JButton("인천경기");
		pswitch_incheon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_termlist, "3");
			}
		});
		pswitch_incheon.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pswitch_incheon.setBackground(colorWhiteGray);
		pswitch_incheon.setBounds(5, 35, 100, 25);
		panel_termloc.add(pswitch_incheon);
		
		JButton pswitch_kangwon = new JButton("강원");
		pswitch_kangwon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_termlist, "4");
			}
		});
		pswitch_kangwon.setSize(new Dimension(80, 25));
		pswitch_kangwon.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pswitch_kangwon.setBackground(colorWhiteGray);
		pswitch_kangwon.setBounds(110, 35, 100, 25);
		panel_termloc.add(pswitch_kangwon);
		
		JButton pswitch_daejeon = new JButton("대전충남");
		pswitch_daejeon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_termlist, "5");
			}
		});
		pswitch_daejeon.setSize(new Dimension(80, 25));
		pswitch_daejeon.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pswitch_daejeon.setBackground(colorWhiteGray);
		pswitch_daejeon.setBounds(5, 65, 100, 25);
		panel_termloc.add(pswitch_daejeon);
		
		JButton pswitch_chungbuk = new JButton("충북");
		pswitch_chungbuk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_termlist, "6");
			}
		});
		pswitch_chungbuk.setSize(new Dimension(80, 25));
		pswitch_chungbuk.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pswitch_chungbuk.setBackground(colorWhiteGray);
		pswitch_chungbuk.setBounds(110, 65, 100, 25);
		panel_termloc.add(pswitch_chungbuk);
		
		JButton pswitch_jeonbook = new JButton("전북");
		pswitch_jeonbook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_termlist, "8");
			}
		});
		pswitch_jeonbook.setSize(new Dimension(80, 25));
		pswitch_jeonbook.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pswitch_jeonbook.setBackground(colorWhiteGray);
		pswitch_jeonbook.setBounds(110, 95, 100, 25);
		panel_termloc.add(pswitch_jeonbook);
		
		JButton pswitch_boosan = new JButton("부산경남");
		pswitch_boosan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_termlist, "9");
			}
		});
		pswitch_boosan.setSize(new Dimension(80, 25));
		pswitch_boosan.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pswitch_boosan.setBackground(colorWhiteGray);
		pswitch_boosan.setBounds(5, 125, 100, 25);
		panel_termloc.add(pswitch_boosan);
		
		JButton pswitch_gwangju = new JButton("광주전남");
		pswitch_gwangju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_termlist, "7");
			}
		});
		pswitch_gwangju.setSize(new Dimension(80, 25));
		pswitch_gwangju.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pswitch_gwangju.setBackground(colorWhiteGray);
		pswitch_gwangju.setBounds(5, 95, 100, 25);
		panel_termloc.add(pswitch_gwangju);
		
		JButton pswitch_daegu = new JButton("대구경북");
		pswitch_daegu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(panel_termlist, "10");
			}
		});
		pswitch_daegu.setSize(new Dimension(80, 25));
		pswitch_daegu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		pswitch_daegu.setBackground(colorWhiteGray);
		pswitch_daegu.setBounds(110, 125, 100, 25);
		panel_termloc.add(pswitch_daegu);
		
		JPanel panel_termlist_all = new JPanel();
		panel_termlist_all.setBackground(Color.WHITE);
		panel_termlist.add(panel_termlist_all, "1");
		panel_termlist_all.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		JButton[] buttons_term = new JButton[6];
		for(int i=0; i<buttons_term.length; i++) {
			buttons_term[i] = new JButton(terminalList_all[i]);
			buttons_term[i].setBackground(colorWhiteGray);
			buttons_term[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			buttons_term[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField jtfptr; 
					if(tfpointer == 0) jtfptr = tfOrigin;
					else jtfptr = tfDest;
					String text = ((JButton) e.getSource()).getText();
					jtfptr.setText(text);
					if(tfpointer == 0) {
						jtfptr = tfDest;
						tfpointer = 1;
						tfDest.setBackground(Color.WHITE);
						tfOrigin.setBorder(BorderFactory.createEmptyBorder());
						tfOrigin.setBackground(colorWhiteGray);
						tfDest.setBorder(BorderFactory.createLineBorder(new Color(104, 179, 206)));
					}
				}
			});
			panel_termlist_all.add(buttons_term[i]);
		}
		
		JPanel panel_termlist_seoul = new JPanel();
		panel_termlist_seoul.setBackground(Color.WHITE);
		panel_termlist.add(panel_termlist_seoul, "2");
		panel_termlist_seoul.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		for(int i=0; i<buttons_term.length; i++) {
			buttons_term[i] = new JButton(terminalList_seoul[i]);
			buttons_term[i].setBackground(colorWhiteGray);
			buttons_term[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			buttons_term[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField jtfptr; 
					if(tfpointer == 0) jtfptr = tfOrigin;
					else jtfptr = tfDest;
					String text = ((JButton) e.getSource()).getText();
					jtfptr.setText(text);
					if(tfpointer == 0) {
						jtfptr = tfDest;
						tfpointer = 1;
						tfDest.setBackground(Color.WHITE);
						tfOrigin.setBorder(BorderFactory.createEmptyBorder());
						tfOrigin.setBackground(colorWhiteGray);
						tfDest.setBorder(BorderFactory.createLineBorder(new Color(104, 179, 206)));
					}
				}
			});
			panel_termlist_seoul.add(buttons_term[i]);
		}
		
		JPanel panel_termlist_incheon = new JPanel();
		panel_termlist_incheon.setBackground(Color.WHITE);
		panel_termlist.add(panel_termlist_incheon, "3");
		panel_termlist_incheon.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		for(int i=0; i<buttons_term.length; i++) {
			buttons_term[i] = new JButton(terminalList_incheon[i]);
			buttons_term[i].setBackground(colorWhiteGray);
			buttons_term[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			buttons_term[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField jtfptr; 
					if(tfpointer == 0) jtfptr = tfOrigin;
					else jtfptr = tfDest;
					String text = ((JButton) e.getSource()).getText();
					jtfptr.setText(text);
					if(tfpointer == 0) {
						jtfptr = tfDest;
						tfpointer = 1;
						tfDest.setBackground(Color.WHITE);
						tfOrigin.setBorder(BorderFactory.createEmptyBorder());
						tfOrigin.setBackground(colorWhiteGray);
						tfDest.setBorder(BorderFactory.createLineBorder(new Color(104, 179, 206)));
					}
					
				}
			});
			panel_termlist_incheon.add(buttons_term[i]);
		}
		JPanel panel_termlist_kangwon = new JPanel();
		panel_termlist_kangwon.setBackground(Color.WHITE);
		panel_termlist.add(panel_termlist_kangwon, "4");
		panel_termlist_kangwon.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		for(int i=0; i<buttons_term.length; i++) {
			buttons_term[i] = new JButton(terminalList_kangwon[i]);
			buttons_term[i].setBackground(colorWhiteGray);
			buttons_term[i].setFont(new Font("맑은 고딕", Font.PLAIN, 15));
			buttons_term[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField jtfptr; 
					if(tfpointer == 0) jtfptr = tfOrigin;
					else jtfptr = tfDest;
					String text = ((JButton) e.getSource()).getText();
					jtfptr.setText(text);
					if(tfpointer == 0) {
						jtfptr = tfDest;
						tfpointer = 1;
						tfDest.setBackground(Color.WHITE);
						tfOrigin.setBorder(BorderFactory.createEmptyBorder());
						tfOrigin.setBackground(colorWhiteGray);
						tfDest.setBorder(BorderFactory.createLineBorder(new Color(104, 179, 206)));
					}
					
				}
			});
			panel_termlist_kangwon.add(buttons_term[i]);
		}
		
		JButton buttonConfirm = new JButton("확인");
		buttonConfirm.setBounds(273, 532, 97, 23);
		frame.getContentPane().add(buttonConfirm);
		
		JButton buttonCancel = new JButton("취소");
		buttonCancel.setBounds(392, 532, 97, 23);
		frame.getContentPane().add(buttonCancel);
		
		JPanel panel_header = new JPanel();
		panel_header.setBackground( new Color(104, 179, 206) );
		panel_header.setBounds(0, 0, 784, 57);
		frame.getContentPane().add(panel_header);
		
		JLabel lblNewLabel = new JLabel("출발지/도착지 선택");
		lblNewLabel.setForeground(Color.WHITE);
		panel_header.add(lblNewLabel);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 36));

		

		
		frame.setVisible(true);
	}
}
