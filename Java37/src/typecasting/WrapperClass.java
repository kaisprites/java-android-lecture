package typecasting;

public class WrapperClass {

	public static void main(String[] args) {
		// Wrapper Class: Primitive type and additional methods
		//int->Integer, double->Double, char->Character, boolean -> Boolean
		int x = 100;
		Integer y = new Integer(200);
		x = y;	//unboxing: primitive <- derived
		y = x;	//boxing: derived <- primitive;
		
	}

}
