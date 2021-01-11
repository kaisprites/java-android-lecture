package dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ItemDAO {
	Connection con;
	String user;
	String url;
	String password;
	
	public ItemDAO() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		url = "jdbc:mysql://localhost:3366/jejutravel";
		user = "root";
		password = "1234";
	}
	
	public int create (ItemVO vo) throws Exception {
		con = DriverManager.getConnection(url, user, password);
		String query = "insert into item value (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, vo.getName());
		ps.setString(2, vo.getText());
		ps.setString(3, vo.getAddress());
		ps.setString(4, vo.getTel());
		ps.setString(5, vo.getLat());
		ps.setString(6, vo.getLng());
		ps.setString(7, vo.getTag());
		ps.setString(8, vo.getKeyword());
		System.out.println(vo);
		int result = -1;
		
		try {
			result = ps.executeUpdate();
		} catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {

		} finally {
			con.close();
			return result;
		}
	}
	
	public Vector<ItemVO> read () throws Exception {
		con = DriverManager.getConnection(url, user, password);
		Vector<ItemVO> bag = new Vector<ItemVO>();
		String query = "select * from item";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			ItemVO vo = new ItemVO();
			vo.setName(rs.getString("name"));
			vo.setText(rs.getString("text"));
			vo.setAddress(rs.getString("address"));
			vo.setTel(rs.getString("tel"));
			vo.setLat(rs.getString("lat"));
			vo.setLng(rs.getString("lng"));
			bag.add(vo);
			
		}
		con.close();
//		dbcp.freeConnection(con);
		return bag;
	}
}
