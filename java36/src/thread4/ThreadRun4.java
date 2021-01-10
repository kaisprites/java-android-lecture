package thread4;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Date;


public class ThreadRun4 extends JFrame {
	
	JLabel top = new JLabel("1");
	JLabel bottm = new JLabel("3");
	JLabel center = new JLabel("New label");
	
	//inner class
	public class CounterThread2 extends Thread {
		@Override
		public void run() {
			for (int i=500; i>0; i--) {
				top.setText("Counter: " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generDated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public class ImgThread2 extends Thread {
		@Override
		public void run() {
			String[] img = {"1.png", "2.png", "3.png", "4.png", "5.png"};
			for(int i=0; i<img.length; i++) {
				ImageIcon imageicon = new ImageIcon(".\\" + img[i]);
				center.setIcon(imageicon);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public class TimerThread2 extends Thread {
		
		//@ : Annotation
		//@Component => create new object
		@Override
		public void run () {
			for(int i=0; i<300; i++) {
				Date date = new Date();
				bottm.setText(date.toString());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public ThreadRun4() {
		setTitle("멀티스레드");
		setSize(800, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		top.setFont(new Font("Arial Black", Font.PLAIN, 36));
		getContentPane().add(top, BorderLayout.NORTH);
		CounterThread2 counter = new CounterThread2();
		counter.start();
		
		
		bottm.setFont(new Font("Arial Black", Font.PLAIN, 36));
		getContentPane().add(bottm, BorderLayout.SOUTH);
		TimerThread2 timer = new TimerThread2();
		timer.start();
		
		getContentPane().add(center, BorderLayout.CENTER);
		ImgThread2 img = new ImgThread2();
		img.start();
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ThreadRun4 t = new ThreadRun4();
	}
}
