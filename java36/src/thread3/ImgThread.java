package thread3;

public class ImgThread extends Thread {
	@Override
	public void run() {
		String[] img = {"1.png", "2.png", "3.png", "4.png", "5.png"};
		for(int i=0; i<img.length; i++) {
			System.out.println("ÀÌ¹ÌÁö: " + img[i]);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
