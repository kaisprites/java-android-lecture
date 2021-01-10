package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	String url;
	String user;
	String password;
	Connection con;
	
	public MemberDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		url = "jdbc:mysql://localhost:3366/shop1";
		user = "root";
		password = "1234";
		
		con = DriverManager.getConnection(url, user, password);
	}
	
	public void finalize() throws Exception {
		con.close();
	}
	
	public List<MemberVO> all() throws Exception {
		String query = "select * from member";
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		List<MemberVO> bag = new ArrayList<MemberVO> ();
		while(rs.next()) {
			//Object(vo) Relational DB(row) Mapping(ORM)
			MemberVO b = new MemberVO();
			b.setId(rs.getString("id"));
			b.setPw(rs.getString("pw"));
			b.setName(rs.getString("name"));
			b.setTel(rs.getString("tel"));
			bag.add(b);
		}
		return bag;
	}
	public boolean checkID(String pid) throws Exception {
		String query = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,  pid);
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
	}
	public boolean login(String id, String pw) throws Exception {
		String query = "select * from member where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
	}
	public List<MemberVO> all(String tel) throws Exception {
		String query = "select * from member where tel like '" + tel + "%'";
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		List<MemberVO> bag = new ArrayList<MemberVO> ();
		while(rs.next()) {
			//Object(vo) Relational DB(row) Mapping(ORM)
			MemberVO b = new MemberVO();
			b.setId(rs.getString("id"));
			b.setPw(rs.getString("pw"));
			b.setName(rs.getString("name"));
			b.setTel(rs.getString("tel"));
			bag.add(b);
		}
		return bag;
	}
}
