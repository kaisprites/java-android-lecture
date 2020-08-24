package array;

public class InitializedArray2 {

	public static void main(String[] args) {
		// 초기값을 정해놓은 배열
		String[] name = {"Kim", "Jack", "Hermione"};
		int[] age = {23, 29, 331};
		char[] gender = {'M', 'F','N'};
		boolean[] breakfast = {true, true, false};
		double[] weight = {76.5, 112.7, 11245.001};
		
		for(int i=0; i<name.length; i++)
		{
			System.out.println(name[i] + ": "+ age[i] + " " + gender[i] + " " + weight[i] + "kg " + (breakfast[i] ? "had" : "hadn't"));
		}
		
		for(String x : name) System.out.print(x + "	" );
		System.out.println("");
		for(double x : weight) System.out.print(x + "	" );
	}

}
