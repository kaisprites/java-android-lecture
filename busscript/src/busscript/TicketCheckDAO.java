package busscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TicketCheckDAO {
	static public ArrayList<TicketCheckVO> getReservationList() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3366/bus";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		String query = "select * from bus_reservation";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<TicketCheckVO> list = new ArrayList<TicketCheckVO>();
		while(rs.next()) {
			TicketCheckVO element = new TicketCheckVO();
			element.setDeparture_date(rs.getString("departure_date"));
			element.setDeparture_point(rs.getString("departure_point"));
			element.setDestination(rs.getString("destination"));
			element.setSeat_num(rs.getString("seat_num"));
			element.setPrice(Integer.parseInt(rs.getString("price")));
			
			list.add(element);
		}
		
		return list;
	}
}
