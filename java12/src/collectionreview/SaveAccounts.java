package collectionreview;

import java.io.FileWriter;
import java.util.ArrayList;

public class SaveAccounts {

	public void save(ArrayList<Account> list) {
		for(int i=0; i<list.size(); i++) {
			try {
				FileWriter f = new FileWriter(list.get(i).name + ".txt");
				f.write(list.get(i).toString());
				f.close();
			} catch (Exception e) {
				System.out.println("FileWrite is failed");
			}
		}
	}

}
