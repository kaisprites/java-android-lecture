package method;

import java.util.Arrays;

public class Tempclass {

	//�����˻��Ͽ� key�� ���� ���ҵ��� 
	//a: �迭, n: �迭�� ũ��, key: �˻��� ��, idx: �˻��� ���� index���� �迭
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int count = 0;				//return�� ��: idx�� ���Ҽ�
		for(int i=0; i<n; i++) {	//�����˻��� ��� ���� ��ȸ
			if(a[i] == key) {		//�迭���Ұ� key�� ������
				idx[count] = i;			//idx�� �����߰�
				count++;			//���Ҽ�+1
			}
		}
		return count; //idx�� ���Ҽ� ��ȯ
	}
	
	//�����˻��ϵ�, key�� ��ġ�ϴ� ���� ������ ������ �� �� ���� ���� index�� ��ȯ�ϴ� �˰���
	// a: �迭, n: �迭�� ũ��, key: Ű
	static int binSearchX(int[] a, int n, int key) {
		int left = 0, right = n-1;				//�����Ѱ�, �����Ѱ�
		while(left < right) {					//�����Ѱ�� �����Ѱ谡 ���ڸ��� ������ ���
			int i = (left + right) / 2;			//�����Ѱ�� �����Ѱ��� �߾ӿ� �ִ� ����
			if(a[i] == key) {					//key�� ã������...
				//�����˻����� �迭�� �̹� ���ĵǾ����Ƿ�, ���� ���� �迭�� �����ؼ� ��ġ�� �ִ�.
				//���� a[i]�� key�� �ƴ� �������� �������� �κ��� �����˻� �Ѵ�.
				while(true) {
					if(i == 0) return 0;		//a[0]�� ã�Ҵٸ� 0�� ����(a[-1]�� �����ϸ� ������ ����Ű�Ƿ�) 
					if(a[i-1] == key) i--;		//a[i]�� ���ʿ� �ִ� ���Ұ� ���� ���̶�� i�� ��������
					else return i;				//�ٸ� ���̶�� �װ��� ���� �տ� �ִ�.
				}
			}
			else if(a[i] > key) left = i+1;		//key���� ũ�� key�� ������ �κй迭 Ž��
			else if(a[i] < key) right = i-1;	//key���� ������ key�� ���� �κй迭 Ž��
		}
		return -1;
	}
	
	
	
	public static void main(String[] args) {

		int[] arr= {0,1,2};
		int key = 3;
		int idx = Arrays.binarySearch(arr, key);
		
		if(idx < 0)
			System.out.println("���� ����Ʈ�� �� " + arr[-(idx+1)] + "�� arr[" + (-(idx+1)) + "�� �ֽ��ϴ�");
		else
			System.out.println(key + "�� arr[" + idx + "]�� �ֽ��ϴ�");
			
	}

}
