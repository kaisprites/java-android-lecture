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
			System.out.println("ȸ���̸�: " + name);
			
			Elements list2 = doc.select("span.code");
			String code = list2.get(0).text();
			System.out.println("ȸ���ڵ�: " + code);
			
			Elements list3 = doc.select("div.today");
			Elements list4 = list3.select(".blind");
			String rate = list4.get(0).text();
			String dif = list4.get(1).text();
			String ratio = list4.get(2).text();
			
			System.out.println("���簡: " + rate);
			System.out.println("���ϴ��: " + dif);
			System.out.println("������: " + ratio);
			
			Elements list5 = doc.select("td.first").select(".blind");
			Elements list6 = doc.select("td.first + td").select(".blind");
			String noinfo1 = list5.get(0).text();
			String noinfo2 = list6.get(0).text();
			String noinfo3 = list5.get(1).text();
			String noinfo4 = list6.get(2).text();
			
			System.out.println("����: " + noinfo1);
			System.out.println("��: " + noinfo2);
			System.out.println("�ð�: " + noinfo3);
			System.out.println("����: " + noinfo4);
			
			result = new String[] {name, code, rate, dif, ratio, noinfo1, noinfo2, noinfo3, noinfo4};
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
