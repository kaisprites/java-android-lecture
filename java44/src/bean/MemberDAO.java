package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//����ó�� 
//CRUD �߽� �������
//������ ���� �۾� Data Access Object: DAO
public class MemberDAO {
	String url;
	String user;
	String password;
	Connection con;
	
	public MemberDAO () throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		url = "jdbc:mysql://localhost:3366/shop";
		user = "root";
		password = "1234";
	}

	public void create(MemberVO bag) throws Exception {
		con = DriverManager.getConnection(url, user, password);
		String query = "insert into member values (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, bag.getId());
		ps.setString(2, bag.getPw());
		ps.setString(3, bag.getName());
		ps.setString(4, bag.getTel());
		System.out.println("3 SQL ���� ����");
		
		ps.executeUpdate();
		System.out.println("4 SQL ���� ����");
		con.close();
	}
	public void create(String [] argv) throws Exception {
		con = DriverManager.getConnection(url, user, password);
		String query = "insert into member values (?";
		for(int i=0; i<argv.length-1; i++) query = query.concat(", ?");
		query = query.concat(");");
		PreparedStatement ps = con.prepareStatement(query);
		for(int i=0; i<argv.length; i++) ps.setString(i+1, argv[i]);
		System.out.println("3 SQL ���� ����");
		
		ps.executeUpdate();
		System.out.println("4 SQL ���� ����");
		con.close();
	}
	
	public boolean read(String id, String pw) throws Exception {
		con = DriverManager.getConnection(url, user, password);
		String query = "select * from member where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pw);
		
		ResultSet rs = ps.executeQuery();
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
		con.close();
		return result; 
			
	}
	
	public MemberVO read(String id) throws Exception {
		con = DriverManager.getConnection(url, user, password);
		String query = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		MemberVO bag = new MemberVO();
		if(rs.next()) {	//����� �ִ��� üũ �ϴ� �޼ҵ�. ���=boolean
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
		con.close();
		return bag;
	}
	
	public boolean idCheck(String id) throws Exception {
		con = DriverManager.getConnection(url, user, password);
		String query = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		boolean result = !rs.next();
		con.close();
		return result;
	}
	
	public void update(String context, String key) throws Exception {
		String query = "update member set tel = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, context);
		ps.setString(2, key);
		
		ps.executeUpdate();
		con.close();
	}
	public void delete(String id) throws Exception {
		String query = "delete from member where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		
		ps.executeUpdate();
		con.close();
	}
}
