package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//특정한 모델을 처리하는 클래스
public class DBProcess {
		
	public void create(String tablename, String[] argv, int argc) throws Exception {
		System.out.println("DB에저장처리");
		Class.forName("com.mysql.jdbc.Driver");
		//error가 발생할 것 같은 상황에서는 예외처리가 필요
		//네트워크연결, db연결, 파일연결, cpu연결
		
		System.out.println("1.connector 설정 성공");
		
		//1. connector 설정
		//2. db연결
		//	1) url: ip + port + db명
		//	2) username: root
		//	3) password: 1234
		String url = "jdbc:mysql://localhost:3366/shop";
		String username = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, username, password);
		System.out.println("2. shop연결성공");
		
		//?: setString으로 대체될수있는것
		//개선안: 함수 호출할 때 tablename과 가변길이 String[] param을 전달하여 어떤 insert구문에도 대응  
		String subQ = "?";
		for(int i=0; i<argc-1; i++) subQ += ", ?";
		String sql = "insert into " + tablename + " values (" + subQ + ");";
		PreparedStatement ps = con.prepareStatement(sql);
		for(int i=0; i<argc; i++) ps.setString(i+1, argv[i]);
		//PreparedStatement.setString은 index가 1부터 시작한다(중요)
		System.out.println("3. sql문생성됨");
		
		ps.executeUpdate();
		System.out.println("4. SQL문을 mySQL로 전송함");
	}
	public void read(String tablename, String[] argv, int argc) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3366/shop";
		String username = "root";
		String password = "1234";
		Connection con = DriverManager.getConnection(url, username, password);
		
		String subString = argv[0];
		for(int i=1; i<argc; i++) subString += ", " + argv[i]; 
		String sql = "select " + subString + " from " + tablename;
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int index = 1;
			System.out.print(rs.getString(index++) + "\t");
			System.out.print(rs.getString(index++) + "\t");
			System.out.print(rs.getString(index++) + "\t");
			System.out.print(rs.getString(index++) + "\n");
		}
	}
	public void update() {
		JOptionPane.showMessageDialog(null, "DB수정");
	}
	public void delete() {
		JOptionPane.showMessageDialog(null, "DB삭제");
	}
}
