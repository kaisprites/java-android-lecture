package collection;

import java.util.HashSet;

public class Quiz3 {

	public static void main(String[] args) {
		//팀에 한명씩만 넣으세요
		HashSet<String> team = new HashSet<String>();
		team.add("디자이너");
		team.add("디자이너");
		team.add("DB관리자");
		team.add("디자이너");
		team.add("프로그래머");
		team.add("프로그래머");
		team.add("DB관리자");
		
		System.out.println(team);
	}

}
