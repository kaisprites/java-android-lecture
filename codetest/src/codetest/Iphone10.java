package codetest;

public class Iphone10 implements IphoneJackInterface {

	@Override
	public void charge() {
		System.out.println("아이폰10 충전됨");
	}

	@Override
	public void transferData() {
		System.out.println("아이폰10 데이터 전송함");
	}
	
}
