package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//����ó�� 
//CRUD �߽� �������
//������ ���� �۾� Data Access Object: DAO
public class MemberDAO {
	//DB ������ ���߾� �� ��
	//1 connector ����
	//2 db����
	//3 SQL�� �ۼ��Ͽ� ����
	//4 
	
	public void create(MemberVO bag) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector ���� ����");
		
		//String url = "�����ϴ¹��://ip:port/db��";
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db���� ����");
		
		String query = "insert into member values (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, bag.getId());
		ps.setString(2, bag.getPw());
		ps.setString(3, bag.getName());
		ps.setString(4, bag.getTel());
		System.out.println("3 SQL ���� ����");
		
		ps.executeUpdate();
		System.out.println("4 SQL ���� ����");
	}
	public void create(String [] argv) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector ���� ����");
		
		//String url = "�����ϴ¹��://ip:port/db��";
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db���� ����");
		
		String query = "insert into member values (?";
		for(int i=0; i<argv.length-1; i++) query = query.concat(", ?");
		query = query.concat(");");
		PreparedStatement ps = con.prepareStatement(query);
		for(int i=0; i<argv.length; i++) ps.setString(i+1, argv[i]);
		System.out.println("3 SQL ���� ����");
		
		ps.executeUpdate();
		System.out.println("4 SQL ���� ����");
	}
	
	public boolean read(String id, String pw) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector ���� ����");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db���� ����");
		
		String query = "select * from member where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pw);
		System.out.println("3 SQL ���� ����");
		
		ResultSet rs = ps.executeQuery();
		System.out.println("4 SQL ���� ����");
		boolean result = false;
		if(rs.next()) {	//����� �ִ��� üũ �ϴ� �޼ҵ�. ���=boolean
			System.out.println("�˻���� ����");
			result = true;
			String id2 = rs.getString("id");
			String pw2 = rs.getString("pw");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			System.out.println(id2);
			System.out.println(pw2);
			System.out.println(name);
			System.out.println(tel);
		}
		else {
			System.out.println("�˻���� ����");
		}
		
		return result; 
			
	}
	
	public MemberVO read(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector ���� ����");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db���� ����");
		
		String query = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		System.out.println("3 SQL ���� ����");
		
		ResultSet rs = ps.executeQuery();
		MemberVO bag = new MemberVO();
		System.out.println("4 SQL ���� ����");
		if(rs.next()) {	//����� �ִ��� üũ �ϴ� �޼ҵ�. ���=boolean
			System.out.println("�˻���� ����");
			String id2 = rs.getString("id");
			String pw2 = rs.getString("pw");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			bag.setId(id2);
			bag.setPw(pw2);
			bag.setName(name);
			bag.setTel(tel);
		}
		else {
			System.out.println("�˻���� ����");
		}
		return bag;
	}
	public void update(String context, String key) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector ���� ����");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db���� ����");
		
		String query = "update member set tel = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, context);
		ps.setString(2, key);
		System.out.println("3 SQL ���� ����");
		
		ps.executeUpdate();
		System.out.println("4 SQL ���� ����");
		
	}
	public boolean update(MemberVO vo) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector ���� ����");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String query = "update member set pw = ?, name = ?, tel = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, vo.getPw());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getTel());
		ps.setString(4, vo.getId());
		
		int row = ps.executeUpdate();
		if(row==1) return true;
		else return false;
		
	}
	public void delete(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector ���� ����");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db���� ����");
		
		String query = "delete from member where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		System.out.println("3 SQL ���� ����");
		
		ps.executeUpdate();
		System.out.println("4 SQL ���� ����");
		
	}
}
