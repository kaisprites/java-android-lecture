package DBConnect;
public class DBreadBBS {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DBProcess db = new DBProcess ();
		String [] argv = {"id", "title", "content", "author"};
		db.read("bbs", argv, 4); 
	}

}
