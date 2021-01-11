package busdeviation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class DateTest {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3366/datetest";
		String user = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, user, password);
		
		String sql = "insert into DateTest values (?, null)";
		
		
		java.util.Date a = new java.util.Date();
		java.sql.Date b = new java.sql.Date(a.getTime());
		System.out.println(a);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(b));
		
		String sql1 = "insert into DateTest values (?, null);";
		PreparedStatement ps1 = con.prepareStatement(sql1);
//		ps1.setDate(1, b);
		ps1.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(b));
		
		ps1.executeUpdate();
	}

}
