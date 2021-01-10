package thread;

import java.util.Calendar;
import java.util.Scanner;

public class Threader {
	public static void main(String[] args) {
		ArrayThread thread1 = new ArrayThread();
		
		Thread thread2 = new Thread() {
			public void run() {
				try {
					for(int i=0; i<300; i++) {
						Calendar c = Calendar.getInstance();
						System.out.printf("지금 시각은 %d시 %d분 %d초입니다\n",
								c.get(Calendar.HOUR), c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
						Thread.sleep(3000);
					}
				} catch (InterruptedException e) {
					System.out.println("스레드 2 실행 종료");
				}
			}
		};
		Thread thread3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i=0;
				Scanner sc = new Scanner(System.in);
				while(i++>-1) {
					if(i%5==0) {
						String str = sc.next();
						if(str.equals("end")) thread2.interrupt();
						else if(str.equals("exit")) {
							thread1.interrupt();
							System.out.println("스레드 3 실행 종료");
							break;
						};
						sc.nextLine();						
					}
					else {
						System.out.println("*");
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				sc.close();
			}
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
