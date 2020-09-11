package crawl;

import java.io.FileWriter;

public class CrawlFinanceUI {

	public static void main(String[] args) {
		String[] codes = {"005930", "293490", "019170", "253840", };
		String[] names = {"�Ｚ����", "īī��������", "��ǳ����", "������", };
		
		CrawlFinance cf = new CrawlFinance();
		
		for(int i=0; i<codes.length; i++) {
			String[] result = cf.crawl(codes[i]);
			
			try {
				FileWriter file = new FileWriter(result[0] + ".txt");
				file.write("ȸ���: " + result[0] + "\n");
				file.write("�ڵ�: " + result[1] + "\n");
				file.write("���簡: " + result[2] + "\n");
				file.write("���ϴ��: " + result[3] + "\n");
				file.write("������: " + result[4] + "\n");
				file.write("����: " + result[5] + "\n");
				file.write("��: " + result[6] + "\n");
				file.write("�ð�: " + result[7] + "\n");
				file.write("����: " + result[8] + "\n");
				file.close();
			} catch (Exception e) {
				System.out.println("file write failed");
			}
		}
	}

}
