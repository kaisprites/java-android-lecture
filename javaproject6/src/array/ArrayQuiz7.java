package array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayQuiz7 {

	public static void main(String[] args) {
		int[] array = new int[100];
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		for(int i=0; i<100; i++) {
			array[i] = 0;
		}
		
		for(int i=0; i<5000; i++) {
			//int input = sc.nextInt();
			int input = r.nextInt(100);
			if(input >= 0 && input < 100) {
				array[input]++;
			}
			else break;
		}
		sc.close();
		
		int TopN = 10;
		//rank와 rankidx는 함께 움직여야 하므로 RankClass로 묶어준다
		class RankClass{
			int rank;
			int rankidx;
			public RankClass() {this.rank = 0; this.rankidx = 0;}
			public RankClass(int arg_rank, int arg_rankidx) 
			{
				this.rank = arg_rank;
				this.rankidx = arg_rankidx;
			}
		}
		//RankClass 클래스의 배열을 만들어 등록하고 정렬하는 알고리즘
		RankClass[] rank = new RankClass[TopN+1];
		for(int i=0; i<TopN+1; i++) {rank[i] = new RankClass();}
		int rcount = 0;
		for (int i = 0; i < array.length-1; i++) {
			if(rcount < TopN) {
				rank[i] = new RankClass(array[i], i);
				rcount++;
				Arrays.sort(rank, (a,b) -> b.rank - a.rank);	//rank기준의 내림차순정렬
			}
			else {
				rank[TopN] = new RankClass(array[i], i);
				Arrays.sort(rank, (a,b) -> b.rank - a.rank);
			}
		}
		//출력
		for (int i=0; i<rank.length-1; i++) {
			System.out.println(i+1 + "등: " + rank[i].rankidx + " (" + rank[i].rank +"표)");
		}
	}
}
