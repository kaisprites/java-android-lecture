package stackqueue;

public class DoubleQueue {
	int[] que;
	int max;
	int num;
	int frontA;
	int rearA;
	int frontB;
	int rearB;

	DoubleQueue(int max) {
		que = new int[max];
		this.max = max;
		frontA = frontB = rearA = rearB  = 0;
	}
	public void enqueA(int x) throws Exception {
		if(num == max) throw new Exception();
		que[rearA] = x;
		num++;
		rearA = (rearA + 1) % max;
		if(num == 1) rearB = (rearB + max - 1) % max; 
	}
	public void enqueB(int x) throws Exception {
		if(num == max) throw new Exception();
		que[rearB] = x;
		num++;
		rearB = (rearB + max - 1) % max;
		if(num == 1) rearA = (rearA + 1) % max;
	}
	public int dequeA() throws Exception {
		if(ptrA == 0) throw new Exception();
		return stk[--ptrA];
	}
	public int popB() throws Exception {
		if(ptrB == max-1) throw new Exception();
		return stk[++ptrB];
	}

}
