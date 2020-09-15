package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Quiz3 {
	static class Student {
		String ID;
		String name;
		int Mid1;
		int Mid2;
		int Final1;
		int Final2;
		
		public Student() {};
		public int midF() {return Mid2 - Mid1;}
		public int finalF() {return Final2 - Final1;}
		public int sum() {return Mid1+Mid2+Final1+Final2;}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<Student>();
		while(true) {
			Student elem = new Student();
			System.out.print("(-1을 입력하면 종료) 학번: ");
			elem.ID = s.next();
			if(elem.ID.equals("-1")) break;
			System.out.print("이름: ");
			elem.name = s.next();
			System.out.print("1학기 중간고사: ");
			elem.Mid1 = s.nextInt();
			System.out.print("1학기 기말고사: ");
			elem.Final1 = s.nextInt();
			System.out.print("2학기 중간고사: ");
			elem.Mid2 = s.nextInt();
			System.out.print("2학기 기말고사: ");
			elem.Final2 = s.nextInt();
			System.out.println("중간고사 성적차: "+ Math.abs(elem.midF())+"점 "+(elem.midF()>0?"증가":"감소"));
			System.out.println("기말고사 성적차: "+ Math.abs(elem.finalF())+"점 "+(elem.finalF()>0?"증가":"감소"));
			System.out.println("학기 성적차: "+Math.abs(elem.midF()+elem.finalF())+"점 "+(elem.midF()+elem.finalF()>0?"증가":"감소"));
			students.add(elem);
		}
		s.close();
		
		Collections.sort( students, (a,b)->{ return b.sum() - a.sum(); } );
		for(int i=0; i<students.size(); i++) {
			System.out.println("점수 총합" + (i+1) + "등: "+ students.get(i).name + " (" + students.get(i).sum() + "점)");
		}
	}

}
