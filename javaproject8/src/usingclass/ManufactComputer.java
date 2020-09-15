package usingclass;

import classpackage.Computer;

//다른 패키지의 클래스를 사용하기 위해 import

public class ManufactComputer {

	public static void main(String[] args) {
		//객체 생성시 클래스는 같은 패키지를 먼저 찾고 없으면 다른 패키지에서 찾아라.
		//자동import: 1) 자동완성 2) 마우스 올리(f2)선택 3) ctrl+shift+o 
		Computer com1 = new classpackage.Computer();
		//com1은 주소가 들어감, 주소로 가리키는 변수는 3개
		//new를 하면 멤버변수 복사, 자동초기화 글로벌변수는 자동초기화
		com1.price = 100;
		com1.company = "APPLE";
		com1.size = 30;
		System.out.println(com1.price + " " + com1.company + " " + com1.size);
		Computer com2 = new Computer();
		com2.price = 200;
		com2.company = "BANANA";
		com2.size = 20;
		System.out.println(com2.price + " " + com2.company + " " + com2.size);
		
	}

}
