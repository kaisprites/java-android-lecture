package dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ItemDAO {
	Connection con;
	DBConnectionMgr dbcp;
	
	public ItemDAO() throws Exception {
		dbcp = DBConnectionMgr.getInstance();
	}
	
	public Vector<ItemVO> read () throws Exception {
		con = dbcp.getConnection();
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
			vo.setLabel1(rs.getString("label1"));
			vo.setLabel2(rs.getString("label2"));
			
//			Connection subcon = dbcp.getConnection();
//			String subquery = "select keyword from item_keyword where name = ?";
//			PreparedStatement subps = con.prepareStatement(subquery);
//			subps.setString(1, vo.getName());
//			ResultSet subrs = subps.executeQuery();
//			Vector<String> keywords = new Vector<String>();
//			while(subrs.next()) {
//				keywords.add(subrs.getString("keyword"));
//			}
//			dbcp.freeConnection(subcon);
//			vo.setKeywords(keywords);
			
		}
		dbcp.freeConnection(con);
		return bag;
	}
}
