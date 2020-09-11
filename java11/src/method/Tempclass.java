package method;

import java.util.Arrays;

public class Tempclass {

	//선형검색하여 key와 같은 원소들의 
	//a: 배열, n: 배열의 크기, key: 검색할 값, idx: 검색할 값의 index들의 배열
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int count = 0;				//return할 값: idx의 원소수
		for(int i=0; i<n; i++) {	//선형검색의 모든 원소 순회
			if(a[i] == key) {		//배열원소가 key와 같으면
				idx[count] = i;			//idx에 원소추가
				count++;			//원소수+1
			}
		}
		return count; //idx의 원소수 반환
	}
	
	//이진검색하되, key와 일치하는 값이 여러개 있으면 그 중 가장 앞의 index를 반환하는 알고리즘
	// a: 배열, n: 배열의 크기, key: 키
	static int binSearchX(int[] a, int n, int key) {
		int left = 0, right = n-1;				//좌측한계, 우측한계
		while(left < right) {					//좌측한계와 우측한계가 제자리에 있으면 계속
			int i = (left + right) / 2;			//좌측한계와 우측한계의 중앙에 있는 원소
			if(a[i] == key) {					//key를 찾았으면...
				//이진검색에서 배열은 이미 정렬되었으므로, 같은 값은 배열상에 연속해서 위치해 있다.
				//따라서 a[i]가 key가 아닌 지점까지 왼쪽으로 부분적 선형검색 한다.
				while(true) {
					if(i == 0) return 0;		//a[0]을 찾았다면 0을 리턴(a[-1]에 접근하면 에러를 일으키므로) 
					if(a[i-1] == key) i--;		//a[i]의 왼쪽에 있는 원소가 같은 값이라면 i를 왼쪽으로
					else return i;				//다른 값이라면 그것이 제일 앞에 있다.
				}
			}
			else if(a[i] > key) left = i+1;		//key보다 크면 key의 오른편 부분배열 탐색
			else if(a[i] < key) right = i-1;	//key보다 작으면 key의 왼편 부분배열 탐색
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {

		int[] arr= {0,1,2};
		int key = 3;
		int idx = Arrays.binarySearch(arr, key);
		
		if(idx < 0)
			System.out.println("삽입 포인트의 값 " + arr[-(idx+1)] + "은 arr[" + (-(idx+1)) + "에 있습니다");
		else
			System.out.println(key + "은 arr[" + idx + "]에 있습니다");
			
	}

}
