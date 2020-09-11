package collectionreview;

import java.io.FileWriter;
import java.util.ArrayList;

public class SaveFile {

	public void save(ArrayList <Day> list) {
		for(int i=0; i<list.size(); i++) {
			Day day = list.get(i);
			System.out.println("���޵� �ϰ�: " + day);
			
			try {
				FileWriter w = new FileWriter(i + ".txt");
				w.write(day.doing + "\n");
				w.write(day.time + "\n");
				w.write(day.location + "\n");
				
				w.close();
			} catch (Exception e) {
				System.out.println("���� �����ϴٰ� ���� �߻�����");
			}
		}
	}

}