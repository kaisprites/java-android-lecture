package quiz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Quiz4 {
	static String[] nation = {"한국", "중국", "일본"};
	static String[] sports = {"피겨", "스키", "스피드스케이팅", "쇼트트랙", "스켈레톤"};
	
	//국가의 클래스: 메달개수를 기준으로 국가명을 정렬할 필요가 있음
	static public class NationMedal {
		String nation;
		int[][] medals;
		public NationMedal () {
			medals = new int[5][3];			
		}
		public void print () {
			System.out.println("국가: " + nation);
			for(int i=0; i<5; i++)
				System.out.println(sports[i]+": 금" + medals[i][0] + " 은" + medals[i][1] + " 동" + medals[i][2]);
		}
		public int score () {
			int sum = 0;
			for(int i=0; i<15; i++) sum += medals[i/3][i%3];
			return sum;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		NationMedal[] medals = new NationMedal[3];
		//입력받기 (원래는 입력받아야 하지만 0~9사이의 랜덤 자연수 추출해서 대신 입력)
		//객체 생성하여 국가명과 메달수 입력하고, 객체를 객체배열에 등록
		for(int i=0; i<3; i++) {
			int[][] medalint = new int[5][3];
			NationMedal elem = new NationMedal();
			elem.nation = nation[i];
			for(int j=0; j<5; j++) {
				System.out.print(nation[i] + "의 " + sports[j] + " 종목 금은동 입력(띄어쓰기 구분): ");
//				String input[] = sc.nextLine().split(" ");
				for(int k=0; k<3; k++) {
					medalint[j][k] = r.nextInt(10);
					System.out.print(medalint[j][k] + " ");
//					medalint[j][k] = Integer.parseInt(input[k]); 
				}
				System.out.println();
			}
			elem.medals = medalint;
			medals[i] = elem;
		}
		System.out.println("----------------------------------");
		//종목별 등수 출력: 각 종목별 금은동 우선순위로 내림차순 정렬하고 결과를 그대로 123위로 배당 
		NationMedal[] m = medals.clone();
		for(int i=0; i<5; i++)
		{
			final int idx = i;
			Arrays.sort(m, (a,b) -> {
				if(a.medals[idx][0] == b.medals[idx][0]) return b.medals[idx][0]-a.medals[idx][0];
				else if(a.medals[idx][1] == b.medals[idx][1]) return b.medals[idx][1]-a.medals[idx][1];
				else return b.medals[idx][2]-a.medals[idx][2];
			});
			System.out.println(sports[i] + " 1위: " + m[0].nation + " 2위: " + m[1].nation + " 3위: " + m[2].nation);
		}
		System.out.println("----------------------------------");
		//국가별 메달수 출력
		for(int i=0; i<3; i++){medals[i].print();}
		System.out.println("----------------------------------");
		//최종 등수 출력: 메달 합계를 내림차순 정렬하고 결과를 123위로 배당
		Arrays.sort( m, (a,b) -> {return b.score() - a.score();} );
		System.out.println("최종 1위: " + m[0].nation + " 2위 : " + m[1].nation + " 3위: " + m[2].nation);
	}

}
