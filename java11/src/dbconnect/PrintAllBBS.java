package dbconnect;

import java.util.ArrayList;

public class PrintAllBBS {

	public static void main(String[] args) throws Exception {
		BBSDAO dao = new BBSDAO();
		ArrayList<BBSVO> list = dao.all();
		for(int i=0; i<list.size(); i++) {
			BBSVO bag = list.get(i);
			System.out.println("NO: " + bag.getNo());
			System.out.println("TITLE: " + bag.getTitle());
			System.out.println("WRITER: " + bag.getWriter());
			System.out.println("CONTENT: " + bag.getContent());
			System.out.println();
		}
	}

}
