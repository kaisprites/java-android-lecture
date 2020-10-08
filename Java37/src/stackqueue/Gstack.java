package stackqueue;

public class Gstack<E> {
	private int max;
	private int ptr;
	private E[] stk;
	
	public void push (E x) throws Exception {
		if(ptr == max) throw new Exception();
		stk[ptr++] = x;
	}
	
	public E pop() throws Exception {
		if(ptr == 0) throw new Exception();
		return stk[--ptr];
	}
}
