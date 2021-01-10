package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BBSDAO {

	//DAO�� write ��ư = create �κ� ����
	public void create(BBSVO bag) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector ���� ����");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db���� ����");
		
		String query = "insert into bbs values (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, String.valueOf(bag.getNo()));
		ps.setString(2, bag.getTitle());
		ps.setString(3, bag.getContent());
		ps.setString(4, bag.getWriter());
		System.out.println("3 SQL ���� ����");
		
		ps.executeUpdate();
		System.out.println("4 SQL ���� ����");
	}
	
	//DAO�� search ��ư = read �κ� ����
	public BBSVO read(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector ���� ����");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db���� ����");
		
		String query = "select * from bbs where no = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		System.out.println("3 SQL ���� ����");
		
		ResultSet rs = ps.executeQuery();
		BBSVO bag = new BBSVO();
		System.out.println("4 SQL ���� ����");
		if(rs.next()) {	//����� �ִ��� üũ �ϴ� �޼ҵ�. ���=boolean
			System.out.println("�˻���� ����");
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
			System.out.println("�˻���� ����");
		}
		return bag;
	}
	
	//DAO�� modify ��ư = update ����
	public void update(BBSVO bag) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector ���� ����");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db���� ����");
		
		String query = "update bbs set title = ?, content = ? where no = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, bag.getTitle());
		ps.setString(2, bag.getContent());
		ps.setString(3, String.valueOf(bag.getNo()));
		System.out.println("3 SQL ���� ����");
		
		ps.executeUpdate();
		System.out.println("4 SQL ���� ����");
	}
	
	//DAO�� delete ��ư = delete �κ� ����
	public void delete(String no) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector ���� ����");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db���� ����");
		
		String query = "delete from bbs where no = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, no);
		System.out.println("3 SQL ���� ����");
		
		ps.executeUpdate();
		System.out.println("4 SQL ���� ����");
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
