package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//예외처리 
//CRUD 중심 기능정의
//데이터 관련 작업 Data Access Object: DAO
public class MemberDAO {
	//DB 절차에 맞추어 코 딩
	//1 connector 설정
	//2 db연결
	//3 SQL문 작성하여 전송
	//4 
	
	public void create(MemberVO bag) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공");
		
		//String url = "연결하는방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");
		
		String query = "insert into member values (?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, bag.getId());
		ps.setString(2, bag.getPw());
		ps.setString(3, bag.getName());
		ps.setString(4, bag.getTel());
		System.out.println("3 SQL 생성 성공");
		
		ps.executeUpdate();
		System.out.println("4 SQL 전송 성공");
	}
	public void create(String [] argv) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공");
		
		//String url = "연결하는방법://ip:port/db명";
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");
		
		String query = "insert into member values (?";
		for(int i=0; i<argv.length-1; i++) query = query.concat(", ?");
		query = query.concat(");");
		PreparedStatement ps = con.prepareStatement(query);
		for(int i=0; i<argv.length; i++) ps.setString(i+1, argv[i]);
		System.out.println("3 SQL 생성 성공");
		
		ps.executeUpdate();
		System.out.println("4 SQL 전송 성공");
	}
	
	public boolean read(String id, String pw) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");
		
		String query = "select * from member where id = ? and pw = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pw);
		System.out.println("3 SQL 생성 성공");
		
		ResultSet rs = ps.executeQuery();
		System.out.println("4 SQL 전송 성공");
		boolean result = false;
		if(rs.next()) {	//결과가 있는지 체크 하는 메소드. 결과=boolean
			System.out.println("검색결과 있음");
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
			System.out.println("검색결과 없음");
		}
		
		return result; 
			
	}
	
	public MemberVO read(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");
		
		String query = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		System.out.println("3 SQL 생성 성공");
		
		ResultSet rs = ps.executeQuery();
		MemberVO bag = new MemberVO();
		System.out.println("4 SQL 전송 성공");
		if(rs.next()) {	//결과가 있는지 체크 하는 메소드. 결과=boolean
			System.out.println("검색결과 있음");
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
			System.out.println("검색결과 없음");
		}
		return bag;
	}
	public void update(String context, String key) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");
		
		String query = "update member set tel = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, context);
		ps.setString(2, key);
		System.out.println("3 SQL 생성 성공");
		
		ps.executeUpdate();
		System.out.println("4 SQL 전송 성공");
		
	}
	public void delete(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1. connector 연결 성공");
		
		String url = "jdbc:mysql://localhost:3366/shop1";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("2. db연결 성공");
		
		String query = "delete from member where id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		System.out.println("3 SQL 생성 성공");
		
		ps.executeUpdate();
		System.out.println("4 SQL 전송 성공");
		
	}
}
