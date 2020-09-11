package crawl;

import java.io.FileWriter;

public class CrawlFinanceUI {

	public static void main(String[] args) {
		String[] codes = {"005930", "293490", "019170", "253840", };
		String[] names = {"삼성전자", "카카오게임즈", "신풍제약", "수젠텍", };
		
		CrawlFinance cf = new CrawlFinance();
		
		for(int i=0; i<codes.length; i++) {
			String[] result = cf.crawl(codes[i]);
			
			try {
				FileWriter file = new FileWriter(result[0] + ".txt");
				file.write("회사명: " + result[0] + "\n");
				file.write("코드: " + result[1] + "\n");
				file.write("현재가: " + result[2] + "\n");
				file.write("전일대비: " + result[3] + "\n");
				file.write("증감률: " + result[4] + "\n");
				file.write("전일: " + result[5] + "\n");
				file.write("고가: " + result[6] + "\n");
				file.write("시가: " + result[7] + "\n");
				file.write("저가: " + result[8] + "\n");
				file.close();
			} catch (Exception e) {
				System.out.println("file write failed");
			}
		}
	}

}
