package stackqueue;

public class DoubleStack {
	int[] stk;
	int max;
	int ptrA;
	int ptrB;
	
	DoubleStack(int max) {
		stk = new int[max];
		this.max = max;
		ptrA = 0;
		ptrB = max-1;
	}
	public void pushA(int x) throws Exception {
		if(ptrA > ptrB) throw new Exception();
		stk[ptrA++] = x;
	}
	public void pushB(int x) throws Exception {
		if(ptrA < ptrB) throw new Exception();
		stk[ptrB--] = x;
	}
	public int popA() throws Exception {
		if(ptrA == 0) throw new Exception();
		return stk[--ptrA];
	}
	public int popB() throws Exception {
		if(ptrB == max-1) throw new Exception();
		return stk[++ptrB];
	}
}
