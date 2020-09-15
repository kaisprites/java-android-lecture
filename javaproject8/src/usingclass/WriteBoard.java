package usingclass;

import classpackage.BBS;

public class WriteBoard {

	public static void main(String[] args) {
		BBS article1 = new BBS();
		BBS article2 = new BBS();
		article1.write(1, "java", "fun java", "park");
		article2.write(2, "jsp", "fun jsp", "kim");
		article1.read();
		article2.read();
		article1.modify(null, "fun fun java", null);
		article2.delete();
		article1.read();
		article2.read();
	}

}
