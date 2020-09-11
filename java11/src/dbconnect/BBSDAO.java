package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BBSDAO {

	//DAO의 write 버튼 = create 부분 구현
	public void create(BBSVO bag) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");
		
		String query = "insert into bbs values (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, String.valueOf(bag.getNo()));
		ps.setString(2, bag.getTitle());
		ps.setString(3, bag.getContent());
		ps.setString(4, bag.getWriter());
		System.out.println("3 SQL 생성 성공");
		
		ps.executeUpdate();
		System.out.println("4 SQL 전송 성공");
	}
	
	//DAO의 search 버튼 = read 부분 구현
	public BBSVO read(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");
		
		String query = "select * from bbs where no = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		System.out.println("3 SQL 생성 성공");
		
		ResultSet rs = ps.executeQuery();
		BBSVO bag = new BBSVO();
		System.out.println("4 SQL 전송 성공");
		if(rs.next()) {	//결과가 있는지 체크 하는 메소드. 결과=boolean
			System.out.println("검색결과 있음");
			String no = rs.getString("no");
			String writer = rs.getString("writer");
			String title = rs.getString("title");
			String content = rs.getString("content");
			bag.setNo(Integer.parseInt(no));
			bag.setWriter(writer);
			bag.setTitle(title);
			bag.setContent(content);
		}
		else {
			System.out.println("검색결과 없음");
		}
		return bag;
	}
	
	//DAO의 modify 버튼 = update 구현
	public void update(BBSVO bag) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");
		
		String query = "update bbs set title = ?, content = ? where no = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, bag.getTitle());
		ps.setString(2, bag.getContent());
		ps.setString(3, String.valueOf(bag.getNo()));
		System.out.println("3 SQL 생성 성공");
		
		ps.executeUpdate();
		System.out.println("4 SQL 전송 성공");
	}
	
	//DAO의 delete 버튼 = delete 부분 구현
	public void delete(String no) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");
		
		String query = "delete from bbs where no = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, no);
		System.out.println("3 SQL 생성 성공");
		
		ps.executeUpdate();
		System.out.println("4 SQL 전송 성공");
	}
	
	public ArrayList<BBSVO> all() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String query = "select * from bbs";
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<BBSVO> result = new ArrayList<BBSVO>();
		while(rs.next()) {
			BBSVO bag = new BBSVO();
			bag.setNo(rs.getInt("no"));
			bag.setTitle(rs.getString("title"));
			bag.setContent(rs.getString("content"));
			bag.setWriter(rs.getString("writer"));
			result.add(bag);
			System.out.println(bag.getNo());
		}
		return result;
	}
}
