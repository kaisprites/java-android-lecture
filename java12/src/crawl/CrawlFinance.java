package crawl;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlFinance {

	public String[] crawl (String argCode) {
		Connection con = Jsoup.connect("https://finance.naver.com/item/main.nhn?code=" + argCode);
		
		String[] result = {};
		try {
			Document doc = con.get();
			Elements list = doc.select("h2>a");
			String name = list.get(0).text();
			System.out.println("회사이름: " + name);
			
			Elements list2 = doc.select("span.code");
			String code = list2.get(0).text();
			System.out.println("회사코드: " + code);
			
			Elements list3 = doc.select("div.today");
			Elements list4 = list3.select(".blind");
			String rate = list4.get(0).text();
			String dif = list4.get(1).text();
			String ratio = list4.get(2).text();
			
			System.out.println("현재가: " + rate);
			System.out.println("전일대비: " + dif);
			System.out.println("증감률: " + ratio);
			
			Elements list5 = doc.select("td.first").select(".blind");
			Elements list6 = doc.select("td.first + td").select(".blind");
			String noinfo1 = list5.get(0).text();
			String noinfo2 = list6.get(0).text();
			String noinfo3 = list5.get(1).text();
			String noinfo4 = list6.get(2).text();
			
			System.out.println("전일: " + noinfo1);
			System.out.println("고가: " + noinfo2);
			System.out.println("시가: " + noinfo3);
			System.out.println("저가: " + noinfo4);
			
			result = new String[] {name, code, rate, dif, ratio, noinfo1, noinfo2, noinfo3, noinfo4};
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
