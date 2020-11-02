package abstractClass;

//abstract class cannot make instance
public abstract class ApplePhone implements MegaPhone {
	//but can make variable
	String tel = "010-111-2222";
	
	//abstract class has least one abstract method
	public abstract void camera();

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println(tel + " call");

	}

	@Override
	public void text() {
		// TODO Auto-generated method stub

	}

	@Override
	public void kakao() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getGps() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void siri() {
		// TODO Auto-generated method stub

	}

	@Override
	public void internet() {
		// TODO Auto-generated method stub

	}

}
