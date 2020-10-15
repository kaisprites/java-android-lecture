package chatter;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.awt.Color;
import javax.swing.JTextArea;

public class MessengerB {
	private static JTextField chatInput;
	private JTextArea chatLog;
	InetAddress ip;
	
	public MessengerB () throws Exception {
		JFrame j = new JFrame();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ip = InetAddress.getByName("127.0.0.1");
		
		j.setSize(400, 600);
		
		chatInput = new JTextField();
		chatInput.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		chatInput.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String data = chatInput.getText();
				chatInput.setText("");
				chatLog.append("나>> " + data + "\n");
				
				try {
					DatagramSocket socket = new DatagramSocket();
					byte[] dataBytes = data.getBytes();
					DatagramPacket packet = new DatagramPacket(dataBytes, dataBytes.length, ip, 7100);
					socket.send(packet);
					socket.close();
				} catch (Exception e) {
					chatLog.append("전송에 실패했습니다.\n");;
				}
			}
			
		});
		j.getContentPane().add(chatInput, BorderLayout.SOUTH);
		chatInput.setColumns(10);
		
		chatLog = new JTextArea();
		chatLog.setFont(new Font("맑은 고딕", Font.PLAIN, 28));
		chatLog.setBackground(Color.YELLOW);
		chatLog.setEditable(false);
		j.getContentPane().add(chatLog, BorderLayout.CENTER);
		j.setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		MessengerB m = new MessengerB();
		m.process();
	}
	
	public void process() {
		while (true) {
			try {
				DatagramSocket socket = new DatagramSocket(7200);
				byte[] data = new byte[256];
				DatagramPacket packet = new DatagramPacket(data, data.length);
				socket.receive(packet);
				System.out.println("받은 데이터: " + new String(data));
				chatLog.append("당신>> " + new String(data) + "\n");
				socket.close();
			} catch (Exception e) {
				
			}
		}
	}
}
