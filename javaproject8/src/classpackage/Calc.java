package classpackage;

public class Calc {
	// 각 기능을 정의할 때에는 method
	public int add (int bucket, int flower) {
		//bucket, flower는 local variable
		//local variable은 자동초기화되지않음
		int result =  bucket + flower;
		System.out.println("The sum is " + result);
		return result;
	}

	
	public void minus () { 
		System.out.println("빼기");
		
	}
	public int mult (int a, int b) { 
		int result = a * b;
		return result;
	}
	public void div () { 
		System.out.println("나누기");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc cal = new Calc();
		
	}

}
