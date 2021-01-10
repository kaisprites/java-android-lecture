package codetest;

public class Iphone11 implements IphoneJackInterface{

	@Override
	public void charge() {
		System.out.println("아이폰11 충전함");
	}

	@Override
	public void transferData() {
		System.out.println("아이폰11 데이터 전송함");
	}

}
