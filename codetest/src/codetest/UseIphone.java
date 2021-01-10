package codetest;

public class UseIphone {

	public static void main(String[] args) {
		IphoneJackInterface iphone10 = new Iphone10();
		IphoneJackInterface iphone11 = new Iphone11();
		iphone10.charge();
		iphone10.transferData();
		iphone11.charge();
		iphone11.transferData();
	}

}
