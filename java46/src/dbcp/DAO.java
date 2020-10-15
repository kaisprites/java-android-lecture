package dbcp;

public class DAO {
	static DAO dao;

	public static DAO getInstance() {
		if(dao == null) dao = new DAO();
		return dao;
	}
}
