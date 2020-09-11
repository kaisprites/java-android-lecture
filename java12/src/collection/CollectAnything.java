package collection;

import java.util.ArrayList;

public class CollectAnything {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		//넣을때는 add(value)
		ArrayList list = new ArrayList();
		list.add(19);
		list.add("자바과정");
		list.add(25.5);
		list.add(false);
		//list의 개수는 list.size()
		System.out.println(list.size() + "개 들어 있음");
		//꺼내올때는 get(idx)
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		//지울때는 remove(idx)
		list.remove(0);
		System.out.println("이제 " + list.size() + "개 들어 있음");
		System.out.println(list.get(0));
		//중간에 끼워넣을때는 add(idx, value)
		list.add(0, "호길동");
		System.out.println("이제 " + list.size() + "개 들어 있음");
		System.out.println(list.get(0));
		//바꿀때는 set(idx, value)
		list.set(0,  "김길동");
		System.out.println(list.get(0));
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ": " + list.get(i));
			
		}
	}

}
