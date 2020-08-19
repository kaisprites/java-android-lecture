package operator;

public class Typeconv {
	public static void main(String[] args) {
		int x = 100; // -2147483648 < int < 2147483647
		
		byte y = 120; // -128 < byte < 127
		x = y;			// type conversion with big into little can done without any notation
		System.out.println("x: " + x);
		
		int z = 127;
		byte w = (byte)z;	//little into big needs (typename) 
		System.out.println("w: " + w);
		
		int q = 1000;
		byte t = (byte)q;	//t: -24
		System.out.println("t: " + t);
	}
}
