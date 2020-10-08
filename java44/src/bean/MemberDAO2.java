package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//����ó�� 
//CRUD �߽� �������
//������ ���� �۾� Data Access Object: DAO
public class MemberDAO2 {
	String url;
	String user;
	String password;
	Connection con;
	
	public MemberDAO2 () throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		url = "jdbc:mysql://localhost:3366/shop";
		user = "root";
		password = "1234";
	}

	public boolean create(MemberVO2 bag) throws Exception {
		con = DriverManager.getConnection(url, user, password);
		String query = "insert into member2 values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, bag.getId());
		ps.setString(2, bag.getFirst_name());
		ps.setString(3, bag.getLast_name());
		ps.setString(4, bag.getEmail());
		ps.setString(5, bag.getGender());
		ps.setString(6, bag.getIp_address());
		
		boolean result = false;
		if(ps.executeUpdate() != -1) result = true;
		con.close();
		return result;
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
