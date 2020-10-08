package stackqueue;

public class Queue {
	int[] que;
	int num;
	int max;
	int front;
	int rear;
	
	public int search (int x) {
		for (int i=0; i<num; i++) {
			int idx = (front + i) % max;
			if(que[idx] == x) return i+1;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
