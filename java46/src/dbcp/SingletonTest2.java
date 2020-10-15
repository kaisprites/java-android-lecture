package dbcp;

public class SingletonTest2 {

	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			DAO dao = DAO.getInstance();
			System.out.println(dao);
		}
	}

}
