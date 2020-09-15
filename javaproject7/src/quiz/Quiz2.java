package quiz;

import java.util.Random;
import java.util.Scanner;

public class Quiz2 {
	static public class Recruit {
		String IDnumber;
		int height;
		int weight;
		double vision;
		int disease;
		//BMI계산
		public double BMI () { return Math.round(10000.0*weight/(height*height)*10)/10.0; }
		//면제판정
		public int recruitable () {
			if(height >= 190 || height <= 150) return 1;
			if(BMI() > 30.0) return 2;
			if(vision < 0.0) return 3;
			return 0;
		}
		//점수계산
		public int score () {
			int sum=0;
			if(height >= 150 && height <= 190) sum+=20;
			if(weight >= 35 && weight <= 100) sum+=20;
			if(vision >= 1.0) sum+=30;
			else if(vision >= 0.5) sum+=20;
			else if(vision >= 0.1) sum+=10;
			switch(disease) {
			case 0: sum+=30; break;
			case 1: sum+=20; break;
			case 2: sum+=10; break;
			}
			return sum;
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		
		//인원수만 입력 받고 나머지는 랜덤수치 넣어 객체생성
		//100000~999999 + '-' + 1000000~9999999 로 출력, 중요한 정보는 아니므로 엄밀한 주민번호 조건 검사는 생략함
		//랜덤수치는 아래한계+next(위한계-아래한계 차이) 또는 아래한계+next()*(위한계-아래한계 차이)로 부여
		System.out.println("인원수를 입력하세요");
		int _MAXNUM = s.nextInt();
		Recruit[] recruits = new Recruit[_MAXNUM];
		for(int i=0; i<_MAXNUM; i++) {
			Recruit elem = new Recruit();
			elem.IDnumber = String.valueOf(100000+r.nextInt(900000)) + '-' 
							+ String.valueOf(1000000+r.nextInt(9000000));
			elem.height = 140+r.nextInt(60);
			elem.weight = 50+r.nextInt(70);
			elem.vision = Math.round((r.nextDouble()*4.0-2.0)*10)/10.0;
			elem.disease = r.nextInt(3);
			recruits[i] = elem;
		}
		
		//심사
		//점수 40점 미만인 경우 점수미달 면제, 면제사유가 있을 경우 사유 기재, 아닌 경우 현역
		int sum = 0;
		int recruitableCount = 0;
		for(int i=0; i<_MAXNUM; i++) {
			int scr = recruits[i].score(); 
			int rcb = recruits[i].recruitable();
			recruitableCount += rcb == 0 ? 1 : 0;
			sum += scr;
			System.out.print(recruits[i].IDnumber + " 대상자: " + scr + "점, ");
			if(scr < 40) System.out.println("면제(사유: 점수미달)");
			else {
				switch(rcb) {
				case 0: System.out.println("현역"); break;
				case 1: System.out.println("면제(사유: " + recruits[i].height + "cm)"); break;
				case 2: System.out.println("면제(사유: 비만도 " + recruits[i].BMI() + ")"); break;
				case 3: System.out.println("면제(사유: 시력 " + recruits[i].vision + ")"); break;
				}
			}
		}
		
		//통계
		System.out.println("점수 평균:" + String.format("%.2f", (double)sum/_MAXNUM) + "점, 현역대상자: "
						+ recruitableCount + ", 면제대상자: " + (_MAXNUM - recruitableCount));
		s.close();
	}
}
