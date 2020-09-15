package classpackage;

public class Computer {
	//상태정의: 멤버변수, 전역변수
	//객체 생성후 멤버변수는 객체마다 별도로 복사, 생성된 객체의 실제값이 들어간다
	//멤버변수: 실제 값이 들어가는 인스턴스 변수
	//전역변수: 클래스 전체영역에서 사용가능
	//변수의 선언 위치가 범위를 지정
	public int price;			//가격
	public String company;		//제조회사
	public int size;			//크기
	
	public void internet () {
		System.out.println("인터넷");
	}
	
	public void doc () {
		System.out.println("문서");
	}
	
	//원래 toString()는 primitive value, reference address를 찍어주는 메소드
	//Override 하면 원하는 모양으로 변경해서 사용가능
	@Override
	public String toString () {
		return "price=" + price + " company=" + company + " size=" + size;
	}
}
