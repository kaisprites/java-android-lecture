package collectionreview;

public class Account {
	String name;
	String field;
	int money;
	//계좌객체 생성시 name, field, money가 있어야 객체생성할 수 있게 할 것이다
	
	//입력값이 없으면서 클래스이름과 동일한 메서드 "기본생성자"
	//기본생성자는 생성자를 따로 정의하지 않으면 자동으로 정의된다.
	
	public Account () {
		System.out.println("객체생성 호출되었다.");
		System.out.println("보통은 멤버변수 초기화한다");
	}
	
	public Account(String name, String field, int money) {
		super();
		this.name = name;
		this.field = field;
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "계좌 [이름=" + name+ ", 계좌종류=" + field + ", 잔액=" + money + "]";
	}
}
