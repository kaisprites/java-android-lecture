package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BBSDAO {
	String url;
	String user;
	String password;
	Connection con;
	
	public BBSDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		url = "jdbc:mysql://localhost:3366/shop1";
		user = "root";
		password = "1234";
		
		con = DriverManager.getConnection(url, user, password);
	}
	
	public void finalize() throws Exception {
		con.close();
	}

	public List<BBSVO> all() throws Exception {
		String query = "select * from bbs";
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		List<BBSVO> bag = new ArrayList<BBSVO> ();
		while(rs.next()) {
			//Object(vo) Relational DB(row) Mapping(ORM)
			BBSVO b = new BBSVO();
			b.setNo(Integer.parseInt(rs.getString("no")));
			b.setTitle(rs.getString("title"));
			b.setWriter(rs.getString("writer"));
			b.setContent(rs.getString("content"));
			bag.add(b);
		}
		return bag;
	}
	public List<BBSVO> search(String title, String content) throws Exception {
		String query = "select * from bbs";
		if(!title.isEmpty() || !content.isEmpty()) query = query.concat(" where");
		if(!title.isEmpty()) {
			query = query.concat(" title like '%" + title + "%'");
			if(!content.isEmpty()) query = query.concat(" and");
		}
		if(!content.isEmpty()) {
			query = query.concat(" content like '%" + content + "%'");
		}
		System.out.println(query);
		PreparedStatement ps = con.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		
		List<BBSVO> bag = new ArrayList<BBSVO> ();
		while(rs.next()) {
			//Object(vo) Relational DB(row) Mapping(ORM)
			BBSVO b = new BBSVO();
			b.setNo(Integer.parseInt(rs.getString("no")));
			b.setTitle(rs.getString("title"));
			b.setWriter(rs.getString("writer"));
			b.setContent(rs.getString("content"));
			bag.add(b);
		}
		return bag;
	}
}
