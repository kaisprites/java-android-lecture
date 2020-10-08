package typecasting;

public class PrimitiveCasting {

	public static void main(String[] args) {
		byte a = 100;	//-128 ~ 127
		int b = a;
		
		int c = 200;
//		byte d = c; //impossible promotion
		byte d = (byte)c; //casting may cause data lost
	}

}
