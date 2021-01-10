package StackQueue;

//Customer 클래스: String으로 변환시 (m, n) 형식으로 변환됩니다.
public class Customer implements Comparable<Customer> {
	public int m;	//고객의 은행 방문 시각
	public int n;	//고객의 은행 업무 시간
	public Customer(int m, int n) {
		this.m = m; this.n = n;
	}
	@Override
	public String toString() {
		return "(" + m + ", " + n + ")";	
	}
	@Override
	public int compareTo(Customer that) {
		return this.m - that.m;
	}
}
