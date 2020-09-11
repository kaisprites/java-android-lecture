package crawl;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlNaverMain {

	public static void main(String[] args) {
		// crawl: web에서 정보 가져오기
		// scrap / crawl
		// 1. 사이트 연결
		// 2. 페이지 다운로드
		// 3. 원하는 위치의 정보 추출
		
		Connection con = Jsoup.connect("https://finance.naver.com/item/main.nhn?code=293490");
		System.out.println("사이트연결됨");
		
		try {
			Document doc = con.get();
			Elements list = doc.select(".info_spec > dt.step2 + dd");
			//Elements implements ArrayList
			System.out.println(list.size());
			System.out.println(list.get(0).text());
//			for(int i=0; i<list.size(); i++) {
//				Element tag = list.get(i);
//				String text = tag.text();
//				System.out.print(text + " ");
//			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
